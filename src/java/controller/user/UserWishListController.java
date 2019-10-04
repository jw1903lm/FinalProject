/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.CatagoryDetail;
import entity.ProductDetail;
import entity.Products;
import entity.Users;
import entity.WishList;
import entity.WishListId;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.user.UserProductModel;
import model.user.UserUsersModel;
import model.user.UserWishListModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userWishListController")
public class UserWishListController extends UserAllController {

    private UserWishListModel wishListModel;
    private UserUsersModel userModel;
    private UserProductModel productModel;

    public UserWishListController() {
        wishListModel = new UserWishListModel();
        userModel = new UserUsersModel();
        productModel = new UserProductModel();
    }

    @RequestMapping(value = "/toWishList")
    public ModelAndView initWishList(HttpSession session) {
        boolean checkLogin = checkLogin(session);
        ModelAndView mav = null;
        if (checkLogin) {
            mav = new ModelAndView("user/jsp/wishList");
            mav = getHeaderAndFooter(mav, session);
            Users loginUser = (Users) session.getAttribute("loginId");
            List<WishList> listWishList = wishListModel.getWishListByUserId(loginUser.getUserId());
            List<ProductDetail> listProduct = new ArrayList<>();
            for (WishList wishList : listWishList) {
                ProductDetail productDetail = getProductDetail(wishList.getProducts());
                listProduct.add(productDetail);
            }
            mav.addObject("listProduct", listProduct);
        } else {
            mav = new ModelAndView("redirect:/userIndexController/index.htm");
        }
        return mav;
    }
    
    //disabled wishlist
    @RequestMapping(value = "/updateWishList")
    public String updateWishList(int productId,HttpSession session) {
        boolean checkLogin = checkLogin(session);
        if (checkLogin) {
            Users loginUser = (Users) session.getAttribute("loginId");
            Users userInfomation = userModel.getUserById(loginUser.getUserId());
            WishList wishList = wishListModel.getWishListById(userInfomation.getUserId(),productId);
            wishList.setIsDisabled(true);
            return wishListModel.updateWishList(wishList)?"redirect:toWishList.htm":"redirect:/UserAllController/toError.htm";
        } else {
            return "redirect:/userIndexController/index.htm";
        }
    }
    
    //them wishlist moi
    @RequestMapping(value = "/insertWishList")
    public String insertWishList(int productId, int redirectProductId, String redirectPage, HttpSession session) {
        //lay gia tri String tra ve- mac dinh trang index
        String returnPage = "redirect:/userIndexController/index.htm";
        boolean checkLogin = checkLogin(session);
        if (checkLogin) {
            WishList newWishList = new WishList();
            //lay thong tin product va user
            Products product = productModel.getProductById(productId);
            Users loginUser = (Users) session.getAttribute("loginId");
            Users userInfomation = userModel.getUserById(loginUser.getUserId());
            //lay thong tin id
            WishListId wishlistId = new WishListId();
            wishlistId.setUserId(userInfomation.getUserId());
            wishlistId.setProductId(productId);
            //gan vao new wishlist de luu
            newWishList.setId(wishlistId);
            newWishList.setUsers(userInfomation);
            newWishList.setProducts(product);
            if (redirectPage.equals("product")) {
                returnPage = "redirect:/userProductController/productDetail.htm?productId=" + redirectProductId;
            } else if (redirectPage.equals("catagory")) {
                //lay cac thong tin loc de dan v
                CatagoryDetail catagoryDetail = (CatagoryDetail) session.getAttribute("catagoryDetail");
                int page = catagoryDetail.getPage();
                int catagoryId = catagoryDetail.getCatagoryId();
                int brandId = catagoryDetail.getBrandId();
                float min = catagoryDetail.getMin();
                float max = catagoryDetail.getMax();
                returnPage = "redirect:/userCatagoryController/toCatagory.htm?page=" + page + "&catagoryId=" + catagoryId + "&min=" + min + "&max=" + max + "&brandId=" + brandId;
            } else {
                returnPage = "redirect:/userIndexController/index.htm";
            }
            //kiem tra wishlist da co chua
            WishList wishList = wishListModel.getWishListById(newWishList.getUsers().getUserId(), newWishList.getProducts().getProductId());
            if (wishList==null) {
                //luu wishlist moi vao CSDL
                if (!wishListModel.insertWishList(newWishList)) {
                    returnPage = "redirect:/UserAllController/toError.htm";
                } 
            }else{
                if(wishList.isIsDisabled()==true){
                    wishList.setIsDisabled(false);
                    if(!wishListModel.updateWishList(wishList)){
                        returnPage = "redirect:/UserAllController/toError.htm";
                    }
                }
            }
        }
        return returnPage;
    }
}
