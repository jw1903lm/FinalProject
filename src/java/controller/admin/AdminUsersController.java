/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Cities;
import entity.Users;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminCityModel;
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
@RequestMapping(value = "/adminUsersController")
public class AdminUsersController {
    
    @RequestMapping(value = "/getAll")
    public ModelAndView getAllUsers() {
        ModelAndView mav = new ModelAndView("admin/user/users");
        List<Users> listUser = AdminUserModel.getAllUsers();
        mav.addObject("listUser", listUser);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/users");
        String name = request.getParameter("search");
        List<Users> listUser = AdminUserModel.findUserByName(name);
        mav.addObject("listUser", listUser);
        return mav;
    }
    
    @RequestMapping(value = "/detail")
    public ModelAndView getAllUsersDetail(String userId) {
        ModelAndView mav = new ModelAndView("admin/user/users-chitiet");
        Users userUpdate = AdminUserModel.getUserById(userId);
        mav.addObject("userUpdate", userUpdate);
        return mav;
    }
    
    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/user/newUser");
        Users userInsert = new Users();
        List<Cities> listCity = AdminCityModel.getAllCities();
        mav.addObject("userInsert", userInsert);
        mav.addObject("listCity", listCity);
        return mav;
    }
    
    @RequestMapping(value = "/insert")
    public String insertUser(Users userInsert, HttpServletRequest request) {
        Cities city = AdminCityModel.getCityById(request.getParameter("city"));
        userInsert.setCities(city);
        userInsert.setCreated(AdminUtil.getCurrentDate());
        return (AdminUserModel.addUser(userInsert)) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String userId) {
        ModelAndView mav = new ModelAndView("admin/user/updateUser");
        Users userUpdate = AdminUserModel.getUserById(userId);
        List<Cities> listCity = AdminCityModel.getAllCities();
        mav.addObject("userUpdate", userUpdate);
        mav.addObject("listCity", listCity);
        return mav;
    }
    
    @RequestMapping(value = "/update")
    public String updateUser(Users userUpdate, HttpServletRequest request) {
        Users user = AdminUserModel.getUserById(String.valueOf(userUpdate.getUserId()));
        Cities city = AdminCityModel.getCityById(request.getParameter("city"));
        userUpdate.setCities(city);
        userUpdate.setCreated(user.getCreated());
        return AdminUserModel.updateUser(userUpdate) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteUser(String userId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminUserModel.deleteUser(userId) ? "redirect:getAll.htm" : "admin/error";
    }
    
}
