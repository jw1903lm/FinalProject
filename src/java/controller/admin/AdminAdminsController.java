/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Admins;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminAdminModel;
import model.admin.AdminUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminAdminsController")
public class AdminAdminsController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllAdmins() {
        ModelAndView mav = new ModelAndView("admin/admin/admins");
        List<Admins> listAdmin = AdminAdminModel.getAllAdmins();
        mav.addObject("listAdmin", listAdmin);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/admin/admins");
        String name = request.getParameter("search");
        List<Admins> listAdmin = AdminAdminModel.findAdminByName(name);
        mav.addObject("listAdmin", listAdmin);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/admin/newAdmin");
        Admins admInsert = new Admins();
        mav.addObject("admInsert", admInsert);
        return mav;
    }

    @RequestMapping(value = "insert")
    public String insertAdmin(Admins admInsert) {
        if ("".equals(admInsert.getAdminName()) || "".equals(admInsert.getAdminPassword())) {
            return "redirect:initInsert.htm";
        }
        admInsert.setCreated(AdminUtil.getCurrentDate());
        admInsert.setSalt(RandomStringUtils.randomAlphanumeric(10));
        return (AdminAdminModel.addAdmin(admInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String adminId) {
        ModelAndView mav = new ModelAndView("admin/admin/updateAdmin");
        Admins admUpdate = AdminAdminModel.getAdminById(adminId);
        mav.addObject("admUpdate", admUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateAdmin(Admins admUpdate) {
        Admins admin = AdminAdminModel.getAdminById(String.valueOf(admUpdate.getAdminId()));
        admUpdate.setCreated(admin.getCreated());
        return (AdminAdminModel.updateAdmin(admUpdate)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteAdmin(Admins admin, HttpServletRequest request) throws Exception {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return (AdminAdminModel.deleteAdmin(admin)) ? "redirect:getAll.htm" : "admin/error";
    }
}
