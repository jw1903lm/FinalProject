/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.UserFeedbacks;
import entity.Users;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminUserFeedbackModel;
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
@RequestMapping(value = "/adminUserFeedbacksController")
public class AdminUserFeedbacksController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllUserFeedbacks() {
        ModelAndView mav = new ModelAndView("admin/userFeedback/userFeedbacks");
        List<UserFeedbacks> listUserFeedback = AdminUserFeedbackModel.getAllUserFeedbacks();
        mav.addObject("listUserFeedback", listUserFeedback);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/userFeedback/newUserFeedback");
        UserFeedbacks ufbInsert = new UserFeedbacks();
        List<Users> listUser = AdminUserModel.getAllUsers();
        mav.addObject("ufbInsert", ufbInsert);
        mav.addObject("listUser", listUser);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertUserFeedback(UserFeedbacks ufbInsert, HttpServletRequest request) {
        Users user = AdminUserModel.getUserById(request.getParameter("user"));
        ufbInsert.setCreated(AdminUtil.getCurrentDate());
        ufbInsert.setUsers(user);
        return (AdminUserFeedbackModel.addFeedback(ufbInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String feedbackId) {
        ModelAndView mav = new ModelAndView("admin/userFeedback/updateUserFeedback");
        UserFeedbacks ufbUpdate = AdminUserFeedbackModel.getFeedbackById(feedbackId);
        List<Users> listUser = AdminUserModel.getAllUsers();
        mav.addObject("ufbUpdate", ufbUpdate);
        mav.addObject("listUser", listUser);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateUserFeedback(UserFeedbacks ufbUpdate) {
        UserFeedbacks userFeedback = AdminUserFeedbackModel.getFeedbackById(String.valueOf(ufbUpdate.getFeedbackId()));
        ufbUpdate.setCreated(userFeedback.getCreated());
        return AdminUserFeedbackModel.updateFeedback(ufbUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteUserFeedback(UserFeedbacks userFeedback, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminUserFeedbackModel.deleteFeedback(userFeedback) ? "redirect:getAll.htm" : "admin/error";
    }

}
