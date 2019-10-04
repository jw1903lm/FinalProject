/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Catagories;
import entity.Cities;
import entity.Orders;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.user.UserCatagoriesModel;
import model.user.UserCitiesModel;
import model.user.UserOrdersModel;
import model.user.UserUsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userUsersController")
public class UserUsersController {

    private UserAllController allController;
    private UserUsersModel usersModel;
    private UserCitiesModel citiesModel;
    private UserCatagoriesModel catagoriesModel;
    private UserOrdersModel orderModel;

    public UserUsersController() {
        usersModel = new UserUsersModel();
        citiesModel = new UserCitiesModel();
        catagoriesModel = new UserCatagoriesModel();
        allController = new UserAllController();
        orderModel = new UserOrdersModel();
    }

    //Thuc hien truoc khi tao user moi
    @RequestMapping(value = "/initRegister")
    public ModelAndView initRegister(int error, HttpSession session) {
        //Khoi tao mot doi tuong ModelAndView
        ModelAndView mav = null;
        //kiem tra da co user nao login chua, neu chua moi chuyen sang trang register, neu roi chuyen ve trang index
        boolean checkLogin = allController.checkLogin(session);
        if (checkLogin) {
            mav = new ModelAndView("redirect:/userIndexController/index.htm");
        } else {
            mav = new ModelAndView("user/jsp/register");
            Users userInfomation = new Users();
            List<Cities> listCities = citiesModel.getAllCities();
            mav = allController.getHeaderAndFooter(mav, session);
            mav.addObject("userInfomation", userInfomation);
            mav.addObject("listCities", listCities);
            mav.addObject("error", error);
        }
        return mav;
    }

    //Thuc hien them User moi tu doi tuong newUser lay tu trang Register 
    @RequestMapping(value = "/registerUser")
    public String registerUser(Users userInfomation, HttpServletRequest request, HttpSession session) {
        //kiem tra da co user nao login chua, neu chua moi thuc hien register, neu roi chuyen ve trang index
        boolean checkLogin = allController.checkLogin(session);
        if (checkLogin) {
            return "redirect:/userIndexController/index.htm";
        } else {
            //Goi sang citiesModel de them city va cho vao doi tuong userInfomation
            Cities city = citiesModel.getCityById(Integer.parseInt(request.getParameter("chooseCity")));
            userInfomation.setCities(city);
            //tao bien ghi loi
            String retypePassword = request.getParameter("retypePassword");
            int error = allController.validateUser(userInfomation, retypePassword);
            if (error == 0) {
                //hashing va lay password
                String hashingPassword = allController.hashingPassword(userInfomation.getUserPassword());
                userInfomation.setUserPassword(hashingPassword);
                //tao doi tuong user moi, dien thong tin va luu
                boolean check = usersModel.insertUsers(userInfomation);
                //Luu nguoi dung vao CSDL
                if (check) {
                    Users loginUser = usersModel.getUserToLogin(userInfomation);
                    session.setAttribute("loginId", loginUser);
                    //Thuc hien thanh cong -tra ve trang index
                    return "redirect:/userIndexController/index.htm";
                } else {
                    //Thuc hien that bai - tra ve trang error
                    return "redirect:/UserAllController/toError.htm";
                }
            } else {
                return "redirect:initRegister.htm?error=" + error;
            }
        }
    }

    //Thuc hien truoc khi login
    @RequestMapping(value = "/initLogin")
    public ModelAndView initLogin(HttpSession session) {
        //Khoi tao mot doi tuong ModelAndView
        ModelAndView mav = null;
        //kiem tra da co user nao login chua, neu chua moi chuyen sang trang login, neu roi chuyen ve trang index
        boolean checkLogin = allController.checkLogin(session);
        if (checkLogin) {
            mav = new ModelAndView("redirect:/userIndexController/index.htm");
        } else {
            //Khoi tao mot doi tuong ModelAndView
            mav = new ModelAndView("user/jsp/login");
            Users userInfomation = new Users();
            mav = allController.getHeaderAndFooter(mav, session);
            mav.addObject("userInfomation", userInfomation);
        }
        return mav;
    }

    //Luu user da login vao session - Login
    @RequestMapping(value = "/loginUser")
    public String loginUser(Users userInfomation, HttpSession session) {
        usersModel = new UserUsersModel();
        //kiem tra da co user nao login chua, neu chua moi thuc hien login, neu roi chuyen ve trang index
        boolean checkLogin = allController.checkLogin(session);
        if (checkLogin) {
            return "redirect:/userIndexController/index.htm";
        } else {
            userInfomation.setUserPassword(UserAllController.hashingPassword(userInfomation.getUserPassword()));
            Users loginUser = usersModel.getUserToLogin(userInfomation);
            session.setAttribute("loginId", loginUser);
            return "redirect:/userIndexController/index.htm";
        }
    }

    //Luu user da login vao session - CheckOut
    @RequestMapping(value = "/loginCheckOutUser")
    public String loginCheckOutUser(Users loginCheckOutUser, HttpSession session) {
        usersModel = new UserUsersModel();
        //kiem tra da co user nao login chua, neu chua moi thuc hien login, neu roi chuyen ve trang index
        boolean checkLogin = allController.checkLogin(session);
        if (checkLogin) {
            return "redirect:/userOrderController/initCheckOut.htm";
        } else {
            loginCheckOutUser.setUserPassword(UserAllController.hashingPassword(loginCheckOutUser.getUserPassword()));
            Users loginUser = usersModel.getUserToLogin(loginCheckOutUser);
            session.setAttribute("loginId", loginUser);
            return "redirect:/userOrderController/initCheckOut.htm?error=0";
        }
    }

    //Xoa user da login khoi session - Logout
    @RequestMapping(value = "/logoutUser")
    public String logoutUser(Users userInfomation, HttpSession session) {
        boolean checkLogin = allController.checkLogin(session);
        if (checkLogin) {
            session.removeAttribute("loginId");
            return "redirect:/userIndexController/index.htm";
        } else {
            return "redirect:/userIndexController/index.htm";
        }
    }

    //Den trang chi tiet Account
    @RequestMapping(value = "/myAccount")
    public ModelAndView myAccount(HttpSession session) {
        ModelAndView mav = null;
        //kiem tra da co user nao login chua, neu chua moi chuyen sang trang myAccount, neu roi chuyen ve trang index
        boolean checkLogin = allController.checkLogin(session);
        if (checkLogin) {
            mav = new ModelAndView("user/jsp/myAccount");
            //lay thong tin user
            Users loginUser = (Users) session.getAttribute("loginId");
            Users userInformation = usersModel.getUserById(loginUser.getUserId());
            //lay danh sach order
            List<Orders> listOrder = orderModel.getOrderByUserId(userInformation.getUserId());
            //lay danh sach city
            List<Cities> listCities = citiesModel.getAllCities();
            mav = allController.getHeaderAndFooter(mav, session);
            mav.addObject("userInformation", userInformation);
            mav.addObject("listOrder", listOrder);
            mav.addObject("listCities", listCities);
        } else {
            mav = new ModelAndView("redirect:/userIndexController/index.htm");
        }
        return mav;
    }

    //Thay doi thong tin User
    @RequestMapping(value = "/updateUser")
    public String updateUser(Users userInformation, HttpSession session, HttpServletRequest request) {
        //lay thong tin user cu
        Users loginUser = (Users) session.getAttribute("loginId");
        Users oldInformation = usersModel.getUserById(loginUser.getUserId());
        String email = userInformation.getEmail();
        //kiem tra email
        Users checkUser = userInformation;
        if (userInformation.getEmail().equals(oldInformation.getEmail())) {
            checkUser.setEmail(null);
        }
        checkUser.setUserName(null);
        checkUser.setUserPassword(null);
        //kiem tra neu khong trung email moi luu lai
        if (usersModel.checkUser(checkUser).isEmpty()) {
            //lay thong tin cu gan vao thong tin thay doi
            oldInformation.setEmail(email);
            oldInformation.setFullName(userInformation.getFullName());
            oldInformation.setUserAddress(userInformation.getUserAddress());
            oldInformation.setPhone(userInformation.getPhone());
            Cities city = citiesModel.getCityById(Integer.parseInt(request.getParameter("chooseCity")));
            oldInformation.setCities(city);
            boolean check = usersModel.updateUsers(oldInformation);
            if (check) {
                return "redirect:myAccount.htm";
            } else {
                return "redirect:/UserAllController/toError.htm";
            }
        } else {
            return "redirect:myAccount.htm";
        }
    }

    //thay doi password user
    @RequestMapping(value = "/updatePassword")
    public String updatePassword(Users userInformation, HttpSession session, HttpServletRequest request) {
        String returnPage = "redirect:myAccount.htm";
        //lay thong tin user cu
        Users loginUser = (Users) session.getAttribute("loginId");
        Users oldInformation = usersModel.getUserById(loginUser.getUserId());
        if (oldInformation.getUserPassword().equals(allController.hashingPassword(request.getParameter("oldPassword")))) {
        oldInformation.setUserPassword(allController.hashingPassword(request.getParameter("newPassword")));
            if (!allController.checkRepeatValue(null, request.getParameter("newPassword"), null).contains("Password") && request.getParameter("retypePassword").equals(request.getParameter("newPassword"))) {    
                returnPage = usersModel.updateUsers(oldInformation)? "redirect:myAccount.htm" : "redirect:/userAllController/toError.htm";
            }
        }
        return returnPage;
    }
}
