/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Catagories;
import entity.ProductComments;
import entity.ProductDetail;
import entity.ProductImages;
import entity.Products;
import entity.Sizes;
import entity.Users;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.user.UserCatagoriesModel;
import model.user.UserProductCommentsModel;
import model.user.UserProductImageModel;
import model.user.UserProductModel;
import model.user.UserSalesModel;
import model.user.UserSizeModel;
import model.user.UserUsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userProductController")
public class UserProductController {

    private UserAllController allController;
    private UserProductModel productModel;
    private UserProductImageModel productImageModel;
    private UserSalesModel saleModel;
    private UserProductCommentsModel productCommentsModel;
    private UserCatagoriesModel catagoriesModel;
    private UserUsersModel usersModel;
    private UserSizeModel sizeModel;

    public UserProductController() {
        allController = new UserAllController();
        productModel = new UserProductModel();
        productImageModel = new UserProductImageModel();
        saleModel = new UserSalesModel();
        productCommentsModel = new UserProductCommentsModel();
        catagoriesModel = new UserCatagoriesModel();
        usersModel = new UserUsersModel();
        sizeModel = new UserSizeModel();
    }

    @RequestMapping(value = "/productDetail")
    public ModelAndView toProductDetail(int productId, HttpSession session){
        ModelAndView mav = new ModelAndView();
        try {
            mav = new ModelAndView("user/jsp/productDetail");
            //lay thong tin chi tiet san pham
            ProductDetail productDetail = allController.getProductDetail(productId);

            //lay danh sach san pham goi y cung catagory
            List<Products> rawListProductCatagory = productModel.getRelateCatagoryProducts(productModel.getProductById(productId).getCatagories().getCatagoryId(), productId);
            //lay danh sach san pham goi y co catagory con thuoc catagory chinh
            List<Catagories> listSubCatagories = catagoriesModel.getSubCatagoriesOfParentCatarory(productModel.getProductById(productId).getCatagories().getCatagoryId());
            for (Catagories catagory : listSubCatagories) {
                List<Products> rawListProductSubCatagory = productModel.getCatagoryProducts(catagory.getCatagoryId());
                rawListProductCatagory.addAll(rawListProductSubCatagory);
            }
            //dua ra danh sach san pham goi y
            List<ProductDetail> listProductCatagory = allController.getListProductDetailByListProduct(rawListProductCatagory);

            //lay danh sach comment
            List<ProductComments> listProductComments = productCommentsModel.getProductCommentByProductId(productId);

            //tinh rating cua san pham
            int totalRating = 0;
            for (ProductComments productComment : listProductComments) {
                totalRating += productComment.getRating();
            }
            //Lay ket qua lam tron len cua tong rating
            if (totalRating != 0) {
                if (totalRating % listProductComments.size() == 0) {
                    totalRating = totalRating / listProductComments.size();
                } else {
                    totalRating = totalRating / listProductComments.size() + 1;
                }
            }

            //lay ra size cua san pham
            List<Sizes> productSize = sizeModel.getSizeByProductId(productId);

            //dem so comment cua san pham
            int countComment = listProductComments.size();

            //tao doi tuong productComment moi
            ProductComments newComment = new ProductComments();
            
            //lay thong tin header va footer
            mav = allController.getHeaderAndFooter(mav, session);
            
            //gui thong tin ra view
            mav.addObject("productDetail", productDetail);
            mav.addObject("totalRating", totalRating);
            mav.addObject("productSize", productSize);
            mav.addObject("listProductCatagory", listProductCatagory);
            mav.addObject("listProductComments", listProductComments);
            mav.addObject("countComment", countComment);
            mav.addObject("newComment", newComment);
        } catch (NullPointerException e) {
            mav = new ModelAndView("redirect:/UserAllController/toError.htm");
        }
        return mav;
    }

    //them comment moi cho san pham
    @RequestMapping(value = "/addNewComment")
    public ModelAndView addNewComment(ProductComments newComment, int productId, HttpServletRequest request) {
        ModelAndView mav = null;
        Users commentUser = null;
        if (request.getParameter("userId") != null) {
            commentUser = usersModel.getUserById(Integer.parseInt(request.getParameter("userId")));
            newComment.setUsers(commentUser);
        }
        Products product = productModel.getProductById(productId);
        newComment.setProducts(product);
        boolean check = productCommentsModel.addNewComment(newComment);
        if (check) {
            mav = new ModelAndView("redirect:productDetail.htm?productId=" + productId);
            return mav;
        } else {
            mav = new ModelAndView("redirect:/UserAllController/toError.htm");
            return mav;
        }
    }

    //xoa comment cho san pham - chuyen ve Disable
    @RequestMapping(value = "/deleteComment")
    public ModelAndView deleteComment(int commentId, HttpServletRequest request) {
        ModelAndView mav = null;
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductComments productComment = productCommentsModel.getProductCommentById(commentId);
        productComment.setIsDisabled(true);
        boolean check = productCommentsModel.updateComment(productComment);
        if (check) {
            mav = new ModelAndView("redirect:productDetail.htm?productId=" + productId);
            return mav;
        } else {
            mav = new ModelAndView("redirect:/UserAllController/toError.htm");
            return mav;
        }
    }

    //lay danh sach anh san pham sau anh dau tien
    public List<ProductImages> getSubImage(int productId) {
        //lay ra thong tin cua product
        Products product = productModel.getProductById(productId);
        //tao danh sach anh sau anh dau tien
        List<ProductImages> rawListProductImageAfter = new ArrayList<>();
        //tao Set chua thong tin anh san pham da lay ra
        Set<ProductImages> listProductImage = new HashSet<>();
        listProductImage = product.getProductImageses();
        Iterator<ProductImages> itr = listProductImage.iterator();
        //gan thong tin vao danh sach
        while (itr.hasNext()) {
            rawListProductImageAfter.add(itr.next());
        }
        //lay tat ca cac anh tiep theo cho vao sanh sach moi
        List<ProductImages> listProductImageAfter = new ArrayList<>();
        for (int i = 1; i < rawListProductImageAfter.size(); i++) {
            listProductImageAfter.add(rawListProductImageAfter.get(i));
        }
        return listProductImageAfter;
    }
}
