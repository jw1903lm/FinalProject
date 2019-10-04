/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Admins;
import model.user.UserAdminModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userAdminController")
public class UserAdminsController {

    private UserAdminModel adminModel;

    public UserAdminsController() {
        adminModel = new UserAdminModel();
    }

    //Thuc hien truoc khi tao 1
    @RequestMapping(value = "/initInsertAdmin")
    public ModelAndView initInsertUser() {
        //Khoi tao mot doi tuong ModelAndView - Sau khi thuc hien xong se goi view login.jsp trong thu muc jsp
        ModelAndView mav = new ModelAndView("newAdmin");
        Admins newAdmin = new Admins();
        mav.addObject("newAdmin", newAdmin);
        return mav;
    }

    //Thuc hien them User moi tu doi tuong newUser lay tu trang login
    @RequestMapping(value = "/insertAdmin")
    public String insertAdmin(Admins newAdmin) {
        adminModel = new UserAdminModel();
        //Goi sang UserModel de them User 
        boolean check = adminModel.insertAdmin(newAdmin);
        newAdmin.setIsDisabled(false);
        newAdmin.setCreated(null);
        if (check) {
            //Thuc hien thanh cong -tra ve trang login.jsp
            return "redirect:initInsertAdmin.htm";
        } else {
            //Thuc hien that bai - tra ve trang error.jsp
            return "error";
        }
    }
}
