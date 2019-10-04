/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Catagories;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminCategoryModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminCategoriesController")
public class AdminCategoriesController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllCategories() {
        ModelAndView mav = new ModelAndView("admin/category/categories");
        List<Catagories> listCategories = AdminCategoryModel.getAllCategories();
        mav.addObject("listCategory", listCategories);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/category/categories");
        String name = request.getParameter("search");
        List<Catagories> listCategories = AdminCategoryModel.findCategoryByName(name);
        mav.addObject("listCategory", listCategories);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/category/newCategory");
        Catagories catInsert = new Catagories();
        mav.addObject("catInsert", catInsert);
        return mav;
    }

    @RequestMapping(value = "insert")
    public String insertCategory(Catagories category) {
        category.setCreated(AdminUtil.getCurrentDate());
        return (AdminCategoryModel.addCategory(category)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String categoryId) {
        ModelAndView mav = new ModelAndView("admin/category/updateCategory");
        Catagories catUpdate = AdminCategoryModel.getCategoryById(categoryId);
        mav.addObject("catUpdate", catUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateCategory(Catagories category) {
        Catagories cat = AdminCategoryModel.getCategoryById(String.valueOf(category.getCatagoryId()));
        category.setCreated(cat.getCreated());
        return (AdminCategoryModel.updateCategory(category)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteCategory(String categoryId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return (AdminCategoryModel.deleteCategory(categoryId)) ? "redirect:getAll.htm" : "admin/error";
    }
}
