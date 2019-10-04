/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Products;
import entity.Users;
import entity.WishList;
import entity.WishListId;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminProductModel;
import model.admin.AdminUserModel;
import model.admin.AdminWishListModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminWishListsController")
public class AdminWishListsController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllWishList() {
        ModelAndView mav = new ModelAndView("admin/wishList/wishList");
        List<WishList> listWishList = AdminWishListModel.getAllWishList();
        mav.addObject("listWishList", listWishList);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/wishList/newWishList");
        WishList wishListInsert = new WishList();
        List<Users> listUser = AdminUserModel.getAllUsers();
        List<Products> listProduct = AdminProductModel.getAllProducts();
        mav.addObject("wishListInsert", wishListInsert);
        mav.addObject("listUser", listUser);
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertWishList(WishList wishListInsert, HttpServletRequest request) {
        String userId = request.getParameter("user");
        String productId = request.getParameter("product");
        Users user = AdminUserModel.getUserById(userId);
        Products product = AdminProductModel.getProductById(productId);
        WishListId id = new WishListId(Integer.parseInt(productId), Integer.parseInt(userId));
        wishListInsert.setUsers(user);
        wishListInsert.setProducts(product);
        wishListInsert.setId(id);
        wishListInsert.setCreated(AdminUtil.getCurrentDate());
        return (AdminWishListModel.addWishList(wishListInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String productId, String userId) {
        ModelAndView mav = new ModelAndView("admin/wishList/updateWishList");
        List<Users> listUser = AdminUserModel.getAllUsers();
        List<Products> listProduct = AdminProductModel.getAllProducts();
        WishList wishListUpdate = AdminWishListModel.getWishListById(productId, userId);
        mav.addObject("wishListUpdate", wishListUpdate);
        mav.addObject("listUser", listUser);
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateWishList(WishList wishListUpdate, HttpServletRequest request) {
        String userId = request.getParameter("user");
        String productId = request.getParameter("product");
        Users user = AdminUserModel.getUserById(userId);
        Products product = AdminProductModel.getProductById(productId);
        WishListId id = new WishListId(Integer.parseInt(productId), Integer.parseInt(userId));
        WishList wishList = AdminWishListModel.getWishListById(productId, userId);
        wishListUpdate.setCreated(wishList.getCreated());
        wishListUpdate.setId(id);
        wishListUpdate.setUsers(user);
        wishListUpdate.setProducts(product);
        return AdminWishListModel.updateWishList(wishListUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteWishList(WishList wishList, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminWishListModel.deleteWishList(wishList) ? "redirect:getAll.htm" : "admin/error";
    }
}
