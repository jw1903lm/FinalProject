/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Cart;
import entity.Catagories;
import entity.ProductComments;
import entity.ProductDetail;
import entity.ProductImages;
import entity.Products;
import entity.ShopInformation;
import entity.Sizes;
import entity.Users;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.user.UserCatagoriesModel;
import model.user.UserProductCommentsModel;
import model.user.UserProductImageModel;
import model.user.UserProductModel;
import model.user.UserSalesModel;
import model.user.UserShopInformationModel;
import model.user.UserSizeModel;
import model.user.UserUsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/UserAllController")
public class UserAllController {

    private UserProductModel productModel;
    private UserCatagoriesModel catagoriesModel;
    private UserShopInformationModel shopInformationModel;
    private UserProductImageModel productImageModel;
    private UserSalesModel saleModel;
    private UserSizeModel sizeModel;
    private UserUsersModel userModel;
    private UserProductCommentsModel productCommentsModel;

    public UserAllController() {
        catagoriesModel = new UserCatagoriesModel();
        shopInformationModel = new UserShopInformationModel();
        productImageModel = new UserProductImageModel();
        saleModel = new UserSalesModel();
        productModel = new UserProductModel();
        sizeModel = new UserSizeModel();
        userModel = new UserUsersModel();
        productCommentsModel = new UserProductCommentsModel();
    }

    public ModelAndView getHeaderAndFooter(ModelAndView mav, HttpSession session) {
        //lay thong tin login User
        Users loginId = (Users) session.getAttribute("loginId");
        Users loginUser = loginId != null ? userModel.getUserById(loginId.getUserId()) : null;
        //lay danh sach gio hang
        List<Cart> headerListCart = new ArrayList<>();
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        int cartNumber = 0;
        if (listCart != null && !(listCart.isEmpty())) {
            cartNumber = listCart.size();
            if (listCart.size() >= 2) {
                headerListCart.add(listCart.get(0));
                headerListCart.add(listCart.get(1));
            } else {
                headerListCart = listCart;
            }
        }
        List<Catagories> listParentCatagories = catagoriesModel.getAllParentCatagories();
        List<Catagories> listSubCatagories = catagoriesModel.getAllSubCatagories();
        ShopInformation shopInformation = shopInformationModel.getOneShopInformation();

        //lay tong gia ban dau
        float roundSubTotalAmount = countTotalAmount(session);
        BigDecimal bdSubTotalAmount = new BigDecimal(Float.toString(roundSubTotalAmount));
        float subTotalAmount = bdSubTotalAmount.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        //lay Vat
        BigDecimal roundVAT = new BigDecimal(Float.toString(subTotalAmount * 10 / 100));
        float vat = roundVAT.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        //lay gia sau VAT
        BigDecimal roundTotalAmount = new BigDecimal(Float.toString(subTotalAmount + (subTotalAmount * 10 / 100)));
        float totalAmount = roundTotalAmount.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

        //gui thong tin ra view
        mav.addObject("loginUser", loginUser);
        mav.addObject("listCart", listCart);
        mav.addObject("headerListCart", headerListCart);
        mav.addObject("cartNumber", cartNumber);
        mav.addObject("subTotalAmount", subTotalAmount);
        mav.addObject("vat", vat);
        mav.addObject("totalAmount", totalAmount);
        mav.addObject("listParentCatagories", listParentCatagories);
        mav.addObject("listSubCatagories", listSubCatagories);
        mav.addObject("shopInformation", shopInformation);
        return mav;
    }

    @RequestMapping(value = "/toError")
    public ModelAndView toError(HttpSession session) {
        ModelAndView mav = new ModelAndView("user/jsp/error");
        mav = getHeaderAndFooter(mav, session);
        return mav;
    }

    public int validateUser(Users userInfomation, String retypePassword) {
        int error = 0;
        ArrayList<String> repeatValue = checkRepeatValue(userInfomation.getUserName(), userInfomation.getUserPassword(), userInfomation.getEmail());
        if (repeatValue.contains("UserName")) {
            if (repeatValue.contains("Password")) {
                if (repeatValue.contains("Email")) {
                    //username, password, email bi trung
                    error = 1;
                } else {
                    //username, password bi trung
                    error = 2;
                }
            } else {
                if (repeatValue.contains("Email")) {
                    //username, email bi trung
                    error = 3;
                } else {
                    //username bi trung
                    error = 4;
                }
            }
        } else {
            if (repeatValue.contains("Password")) {
                if (repeatValue.contains("Email")) {
                    //password, email bi trung
                    error = 5;
                } else {
                    //password bi trung
                    error = 6;
                }
            } else {
                if (repeatValue.contains("Email")) {
                    //email bi trung
                    error = 7;
                }
            }
        }
        //retype password khong chinh xac
        if (!userInfomation.getUserPassword().equals(retypePassword)) {
            error = 8;
        }
        //password chua dau cach
        if (userInfomation.getUserPassword().contains(" ")) {
            error = 9;
        }
        //do dai password khong dung
        if (userInfomation.getUserPassword().length() < 6 || userInfomation.getUserPassword().length() > 15) {
            error = 10;
        }
        //do dai username khong dung
        if (userInfomation.getUserName().length() < 6 || userInfomation.getUserName().length() > 15) {
            error = 11;
        }
        return error;
    }

    public boolean checkLogin(HttpSession session) {
        boolean checkLogin = false;
        Users loginUser = (Users) session.getAttribute("loginId");
        if (loginUser != null) {
            checkLogin = true;
        }
        return checkLogin;
    }

    //lay thong tin chi tiet dua tren danh sach - toi da 10 san pham
    public List<ProductDetail> getListProductDetailByListProduct(List<Products> listProduct) {
        List<Products> rawListProduct = listProduct;
        List<ProductDetail> listBrandProduct = new ArrayList<>();
        //khai bao bien kiem tra so luong phan tu trong danh sach
        int count = 0;
        for (Products product : rawListProduct) {
            ProductDetail suggestProduct = new ProductDetail();
            //lay thong tin san pham
            suggestProduct.setProduct(product);

            //lay gia sau sale cua san pham
            int saleId = 0;
            //kiem tra saleId co ton tai khong va gan gia tri
            if (product.getSales() != null) {
                saleId = product.getSales().getSaleId();
            }
            //tinh gia sau khi giam
            int salePercentage = saleModel.getPercentageBySellId(saleId);
            float salePrice = (float) product.getPrice() - ((float) product.getPrice() * salePercentage / 100);
            BigDecimal roundSalePrice = new BigDecimal(Float.toString(salePrice));
            salePrice = roundSalePrice.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            suggestProduct.setSalePrice(salePrice);

            //lay 1 hinh anh cua san pham
            ProductImages productImage = productImageModel.getOneProductImageByProductId(product.getProductId());
            suggestProduct.setImage(productImage);

            //lay danh sach size hien co
            List<Sizes> productSize = sizeModel.getSizeByProductId(product.getProductId());
            if (productSize == null) {
                suggestProduct.setAvailable(false);
            } else {
                suggestProduct.setAvailable(false);
                for (Sizes size : productSize) {
                    if (size.getStock() > 0) {
                        suggestProduct.setAvailable(true);
                        break;
                    }
                }
            }
            suggestProduct.setListSize(productSize);
            listBrandProduct.add(suggestProduct);
            count++;
            //ngung them phan tu vao san pham khi count = 10
            if (count == 10) {
                break;
            }
        }
        return listBrandProduct;
    }

    //lay thong tin chi tiet dua tren danh sach va dem so luong
    public List<ProductDetail> getAllProductList(List<Products> listProduct) {
        List<ProductDetail> newListProduct = new ArrayList<>();
        for (Products product : listProduct) {
            ProductDetail suggestProduct = new ProductDetail();

            //lay thong tin san pham
            suggestProduct.setProduct(product);

            //lay gia sau sale cua san pham
            int saleId = 0;
            //kiem tra saleId co ton tai khong va gan gia tri
            if (product.getSales() != null) {
                saleId = product.getSales().getSaleId();
            }
            //tinh gia sau khi giam
            int salePercentage = saleModel.getPercentageBySellId(saleId);
            float salePrice = (float) product.getPrice() - ((float) product.getPrice() * salePercentage / 100);
            BigDecimal roundSalePrice = new BigDecimal(Float.toString(salePrice));
            salePrice = roundSalePrice.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            suggestProduct.setSalePrice(salePrice);

            //lay 1 hinh anh cua san pham
            ProductImages productImage = productImageModel.getOneProductImageByProductId(product.getProductId());
            suggestProduct.setImage(productImage);

            //tinh rating cua san pham
            List<ProductComments> listProductComments = productCommentsModel.getProductCommentByProductId(product.getProductId());
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
            suggestProduct.setRating(totalRating);

            //lay danh sach size hien co
            List<Sizes> productSize = sizeModel.getSizeByProductId(product.getProductId());
            if (productSize == null) {
                suggestProduct.setAvailable(false);
            } else {
                suggestProduct.setAvailable(false);
                for (Sizes size : productSize) {
                    if (size.getStock() > 0) {
                        suggestProduct.setAvailable(true);
                        break;
                    }
                }
            }
            suggestProduct.setListSize(productSize);
            newListProduct.add(suggestProduct);
        }
        return newListProduct;
    }

    // lay chi tiet san pham dua tren id
    public ProductDetail getProductDetail(int productId) {
        ProductDetail productDetail = new ProductDetail();
        Products product = productModel.getProductById(productId);
        productDetail.setProduct(product);

        //lay gia sau sale cua san pham
        int saleId = 0;
        //kiem tra saleId co ton tai khong va gan gia tri
        if (product.getSales() != null) {
            saleId = product.getSales().getSaleId();
        }
        //tinh gia sau khi giam
        int salePercentage = saleModel.getPercentageBySellId(saleId);
        float salePrice = (float) product.getPrice() - ((float) product.getPrice() * salePercentage / 100);
        BigDecimal roundSalePrice = new BigDecimal(Float.toString(salePrice));
        salePrice = roundSalePrice.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        productDetail.setSalePrice(salePrice);

        //lay 1 hinh anh cua san pham
        ProductImages productImage = productImageModel.getOneProductImageByProductId(product.getProductId());
        productDetail.setImage(productImage);

        //lay danh sach size hien co
        List<Sizes> productSize = sizeModel.getSizeByProductId(product.getProductId());
        if (productSize == null) {
            productDetail.setAvailable(false);
        } else {
            productDetail.setAvailable(false);
            for (Sizes size : productSize) {
                if (size.getStock() > 0) {
                    productDetail.setAvailable(true);
                    break;
                }
            }
        }
        productDetail.setListSize(productSize);
        return productDetail;
    }

    // lay chi tiet san pham dua tren doi tuong
    public ProductDetail getProductDetail(Products product) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);

        //lay gia sau sale cua san pham
        int saleId = 0;
        //kiem tra saleId co ton tai khong va gan gia tri
        if (product.getSales() != null) {
            saleId = product.getSales().getSaleId();
        }
        //tinh gia sau khi giam
        int salePercentage = saleModel.getPercentageBySellId(saleId);
        float salePrice = (float) product.getPrice() - ((float) product.getPrice() * salePercentage / 100);
        BigDecimal roundSalePrice = new BigDecimal(Float.toString(salePrice));
        salePrice = roundSalePrice.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        productDetail.setSalePrice(salePrice);

        //lay 1 hinh anh cua san pham
        ProductImages productImage = productImageModel.getOneProductImageByProductId(product.getProductId());
        productDetail.setImage(productImage);

        //lay danh sach size hien co
        List<Sizes> productSize = sizeModel.getSizeByProductId(product.getProductId());
        if (productSize == null) {
            productDetail.setAvailable(false);
        } else {
            productDetail.setAvailable(false);
            for (Sizes size : productSize) {
                if (size.getStock() > 0) {
                    productDetail.setAvailable(true);
                    break;
                }
            }
        }
        productDetail.setListSize(productSize);
        return productDetail;
    }

    //tinh tong gia san pham
    public float countTotalAmount(HttpSession session) {
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        float totalAmount = 0;
        if (listCart != null) {
            for (Cart cart : listCart) {
                totalAmount += (cart.getQuantity() * cart.getProduct().getSalePrice());
            }
        }
        return totalAmount;
    }

    //Tim kiem User bi trung trong CSDL
    public ArrayList<String> checkRepeatValue(String userName, String password, String email) {
        ArrayList<String> repeatValue = new ArrayList<>();
        List<Users> userList = userModel.getAllUsers();
        for (Users users : userList) {
            if (users.getUserName().equals(userName)) {
                repeatValue.add("UserName");
            }
            if (users.getUserPassword().equals(hashingPassword(password))) {
                repeatValue.add("Password");
            }
            if (users.getEmail().equals(email)) {
                repeatValue.add("Email");
            }
        }
        return repeatValue;
    }

    public static String hashingPassword(String password) {
        String algorithm = "SHA-256";
        MessageDigest md;
        byte byteData[];
        try {
            md = MessageDigest.getInstance(algorithm);
            md.update((password).getBytes("UTF-8"));
            byteData = md.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }

        return sb.toString();
    }
}
