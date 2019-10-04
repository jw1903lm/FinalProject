/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.ProductComments;
import entity.Products;
import entity.Users;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminProductCommentModel;
import model.admin.AdminProductModel;
import model.admin.AdminUserModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminProductCommentsController")
public class AdminProductCommentsController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllProductComments() {
        ModelAndView mav = new ModelAndView("admin/productComment/productComments");
        List<ProductComments> listProductComment = AdminProductCommentModel.getAllProductComments();
        mav.addObject("listProductComment", listProductComment);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/productComment/newProductComment");
        ProductComments productCommentInsert = new ProductComments();
        List<Products> listProduct = AdminProductModel.getAllProducts();
        List<Users> listUser = AdminUserModel.getAllUsers();
        mav.addObject("listProduct", listProduct);
        mav.addObject("listUser", listUser);
        mav.addObject("productCommentInsert", productCommentInsert);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertProductComment(ProductComments productCommentInsert, HttpServletRequest request) {
        productCommentInsert.setCreated(AdminUtil.getCurrentDate());
        Products product = AdminProductModel.getProductById(request.getParameter("product"));
        Users user = AdminUserModel.getUserById(request.getParameter("user"));
        productCommentInsert.setProducts(product);
        productCommentInsert.setUsers(user);
        return (AdminProductCommentModel.addProductComment(productCommentInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String commentId) {
        ModelAndView mav = new ModelAndView("admin/productComment/updateProductComment");
        List<Products> listProduct = AdminProductModel.getAllProducts();
        List<Users> listUser = AdminUserModel.getAllUsers();
        ProductComments productCommentUpdate = AdminProductCommentModel.getProductCommentById(commentId);
        mav.addObject("productCommentUpdate", productCommentUpdate);
        mav.addObject("listProduct", listProduct);
        mav.addObject("listUser", listUser);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateProductComment(ProductComments productCommentUpdate, HttpServletRequest request) {
        ProductComments productComment = AdminProductCommentModel.getProductCommentById(String.valueOf(productCommentUpdate.getCommentId()));
        productCommentUpdate.setCreated(productComment.getCreated());
        return AdminProductCommentModel.updateProductComment(productCommentUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteProductComment(ProductComments productComment, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminProductCommentModel.deleteProductComment(productComment) ? "redirect:getAll.htm" : "admin/error";
    }

}
