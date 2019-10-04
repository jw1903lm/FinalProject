/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Products;
import entity.Sizes;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminProductModel;
import model.admin.AdminSizeModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminSizesController")
public class AdminSizesController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllSizes() {
        ModelAndView mav = new ModelAndView("admin/size/sizes");
        List<Sizes> listSize = AdminSizeModel.getAllSizes();
        mav.addObject("listSize", listSize);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/size/sizes");
        String name = request.getParameter("search");
        List<Sizes> listSize = AdminSizeModel.findSizeByName(name);
        mav.addObject("listSize", listSize);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/size/newSize");
        Sizes sizeInsert = new Sizes();
        List<Products> listProduct = AdminProductModel.getAllProducts();
        mav.addObject("listProduct", listProduct);
        mav.addObject("sizeInsert", sizeInsert);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertSize(Sizes sizeInsert, HttpServletRequest request) {
        sizeInsert.setCreated(AdminUtil.getCurrentDate());
        Products product = AdminProductModel.getProductById(request.getParameter("product"));
        sizeInsert.setProducts(product);
        return (AdminSizeModel.addSize(sizeInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String sizeId) {
        ModelAndView mav = new ModelAndView("admin/size/updateSize");
        List<Products> listProduct = AdminProductModel.getAllProducts();
        Sizes sizeUpdate = AdminSizeModel.getSizeById(sizeId);
        mav.addObject("sizeUpdate", sizeUpdate);
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateSize(Sizes sizeUpdate, HttpServletRequest request) {
        Sizes size = AdminSizeModel.getSizeById(String.valueOf(sizeUpdate.getSizeId()));
        Products product = AdminProductModel.getProductById(request.getParameter("product"));
        sizeUpdate.setCreated(size.getCreated());
        sizeUpdate.setProducts(product);
        return AdminSizeModel.updateSize(sizeUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteSize(String sizeId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminSizeModel.deleteSize(sizeId) ? "redirect:getAll.htm" : "admin/error";
    }

}
