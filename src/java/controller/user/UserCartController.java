/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Cart;
import entity.ProductDetail;
import entity.Products;
import entity.Sizes;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.user.UserProductModel;
import model.user.UserSizeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userCartController")
public class UserCartController extends UserAllController {

    private UserProductModel productModel;
    private UserSizeModel sizeModel;
    private ImageAdjust imageAdjust;

    public UserCartController() {
        productModel = new UserProductModel();
        imageAdjust = new ImageAdjust();
        sizeModel = new UserSizeModel();
    }
    
    @RequestMapping(value = "/addToCart")
    public String addToCart(int productId, HttpSession session, HttpServletRequest request) throws IOException {
        //lay thong tin product can them
        ProductDetail product = getProductDetail(productId);
        //lay size san pham
        int sizeId = 0;
        if (request.getParameter("size") != null) {
            sizeId = Integer.parseInt(request.getParameter("size"));
        }
        Sizes size = sizeModel.getSizeById(sizeId);
        //lay so luong san pham
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        //gan vao doi tuong cart de them vao gio hang
        Cart cartAdd = getCartDetail(product, quantity, size, request);

        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        if (listCart == null) {
            listCart = new ArrayList<>();
                if(cartAdd.getSize().getStock() >= quantity ){
                    listCart.add(cartAdd);
                }else{
                    if(cartAdd.getSize().getStock() != 0){
                        cartAdd.setQuantity(cartAdd.getSize().getStock());
                        listCart.add(cartAdd);
                    }
                }
        } else {
            boolean check = true;
            for (Cart cart : listCart) {
                //truong hop san pham da co trong gio hang, khac size da chon va van con stock
                if (cart.getProduct().getProduct().getProductId() == productId && cart.getSize().getSizeId() == cartAdd.getSize().getSizeId()) {
                    if (cart.getQuantity() + quantity <= cart.getSize().getStock()) {
                        cart.setQuantity(cart.getQuantity() + quantity);
                    } else {
                        cart.setQuantity(cart.getSize().getStock());
                    }
                    cart.setTotalPrice(recalculateTotalPrice(cart.getQuantity(), cart.getProduct().getSalePrice()));
                    check = false;
                }
            }
            if (check) {
                listCart.add(cartAdd);
            }
        }
        session.setAttribute("listCart", listCart);
        return "redirect:/userProductController/productDetail.htm?productId=" + productId;
    }

    @RequestMapping(value = "/toCart")
    public ModelAndView goToCart(HttpSession session) {
        ModelAndView mav = new ModelAndView("user/jsp/cart");
        mav = getHeaderAndFooter(mav, session);
        return mav;
    }
    
    //thay doi so luong san pham trong gio hang
    @RequestMapping(value = "/updateCart")
    public String updateCart(HttpSession session, HttpServletRequest request) {
        //Lay listCart trong session
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        //Lay mang quantity da cap nhat trong request
        String arrQuantity[] = request.getParameterValues("quantity");
        //Cap nhat mang quantity vao listCart
        for (int i = 0; i < listCart.size(); i++) {
            listCart.get(i).setQuantity(Integer.parseInt(arrQuantity[i]));
            listCart.get(i).setTotalPrice(recalculateTotalPrice(listCart.get(i).getQuantity(), listCart.get(i).getProduct().getSalePrice()));
        }
        //add listCart vao session
        session.setAttribute("listCart", listCart);
        return "redirect:toCart.htm";
    }
    
    //xoa san pham trong gio hang
    @RequestMapping(value = "/remove")
    public String removeCart(HttpSession session, int productId) {
        //Lay listCart trong session
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        //Xoa productId trong listCart
        for (int i = 0; i < listCart.size(); i++) {
            if (listCart.get(i).getProduct().getProduct().getProductId() == productId) {
                listCart.remove(i);
                break;
            }
        }
        //add listCart vao session
        session.setAttribute("listCart", listCart);
        return "redirect:toCart.htm";
    }

    //lay thong tin san pham cho vao gio hang
    public Cart getCartDetail(ProductDetail product, int quantity, Sizes size, HttpServletRequest request) throws IOException {
        //tao doi tuong luu tru Cart
        Cart cartAdd = new Cart();
        //lay thong tin san pham     
        cartAdd.setProduct(product);
        //lay so luong duoc chon
        cartAdd.setQuantity(quantity);
        //lay size duoc chon
        cartAdd.setSize(size);

        //lay tong so tien
        float getPrice = cartAdd.getQuantity() * cartAdd.getProduct().getSalePrice();
        //lam tron den 2 chu so
        BigDecimal roundTotalPrice = new BigDecimal(Float.toString(getPrice));
        float totalPrice = roundTotalPrice.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        cartAdd.setTotalPrice(totalPrice);

        //luu anh va lay anh
        String productImage = product.getImage() != null ? product.getImage().getLink() : null;
        cartAdd.setCartImage(productImage);
        return cartAdd;
    }

    //tinh lai tien khi thay doi so luong
    public float recalculateTotalPrice(int quantity, float price) {
        //lay tong so tien
        float totalPrice = quantity * price;
        return totalPrice;
    }

    //cap nhat quantity cho san pham sau khi them vao cart
    public boolean updateProductQuantity(Sizes size, int quantity) {
        size.setStock(size.getStock() - quantity);
        boolean check = sizeModel.updateSize(size);
        return check;
    }
}
