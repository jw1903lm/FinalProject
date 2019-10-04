/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.user;

import entity.UserFeedbacks;
import entity.Users;
import javax.servlet.http.HttpSession;
import model.user.UserUserFeedbacksModel;
import model.user.UserUsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userContactController")
public class UserContactController extends UserAllController{
    
    private UserUserFeedbacksModel userFeedbackModel;
    private UserUsersModel usersModel;

    public UserContactController() {
        userFeedbackModel = new UserUserFeedbacksModel();
        usersModel = new UserUsersModel();
    }
    
    @RequestMapping(value = "/initContact")
    public ModelAndView initContact(HttpSession session) {
        ModelAndView mav = new ModelAndView("user/jsp/contact");
        mav = getHeaderAndFooter(mav, session);
        UserFeedbacks userFeedback = new UserFeedbacks();
        Users loginUser = (Users) session.getAttribute("loginId");
        Users userInfomation = null;
        if(loginUser!=null){
            userInfomation = usersModel.getUserById(loginUser.getUserId());
        }
        mav.addObject("userInfomation",userInfomation);
        mav.addObject("userFeedback",userFeedback);
        return mav;
    }
    
    @RequestMapping(value = "/insertContact")
    public String insertContact(UserFeedbacks userFeedback, HttpSession session) {
        Users loginUser = (Users) session.getAttribute("loginId");
        if(loginUser!=null){
            Users userInfomation = usersModel.getUserById(loginUser.getUserId());
            userFeedback.setUsers(userInfomation);
        }
        boolean check = userFeedbackModel.insertFeedback(userFeedback);
        if(check){
            return "redirect:initContact.htm";
        }else{
            return "redirect:/UserAllController/toError.htm";
        }
    }
    
    
}
