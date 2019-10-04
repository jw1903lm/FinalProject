/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Admins;
import entity.Orders;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.admin.AdminOrderModel;
import model.admin.AdminProductModel;
import model.admin.AdminUserFeedbackModel;
import model.admin.AdminUserModel;
import model.admin.AdminUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminIndexController")
public class AdminIndexController {

    private Logger logger = LoggerFactory.getLogger(AdminIndexController.class);

    @RequestMapping(value = "/index")
    public ModelAndView toIndex() {
        ModelAndView mav = new ModelAndView("admin/index");
        Long activeUser = AdminUserModel.countActiveUsers();
        Long activeProduct = AdminProductModel.countActiveProduct();
        Long registedOrder = AdminOrderModel.countUserOrder();
        Long visitorOrder = AdminOrderModel.countVisitorOrder();
        Long feedBack = AdminUserFeedbackModel.countFeedBack();
        //lay gia tri bieu do
        List<Orders> listOrder = AdminOrderModel.getAllOrders();
        double jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;
        for (Orders orders : listOrder) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(orders.getCreated());
            switch (calendar.get(Calendar.MONTH)) {
                case 0:
                    jan+=orders.getTotalPrice();
                    break;
                case 1:
                    feb+=orders.getTotalPrice();
                    break;
                case 2:
                    mar+=orders.getTotalPrice();
                    break;
                case 3:
                    apr+=orders.getTotalPrice();
                    break;
                case 4:
                    may+=orders.getTotalPrice();
                    break;
                case 5:
                    jun+=orders.getTotalPrice();
                    break;
                case 6:
                    jul+=orders.getTotalPrice();
                    break;
                case 7:
                    aug+=orders.getTotalPrice();
                    break;
                case 8:
                    sep+=orders.getTotalPrice();
                    break;
                case 9:
                    oct+=orders.getTotalPrice();
                    break;
                case 10:
                    nov+=orders.getTotalPrice();
                    break;
                case 11:
                    dec+=orders.getTotalPrice();
                    break;
                default:
            }
        }
        
        mav.addObject("activeUser", activeUser);
        mav.addObject("activeProduct", activeProduct);
        mav.addObject("registedOrder", registedOrder);
        mav.addObject("visitorOrder", visitorOrder);
        mav.addObject("feedBack", feedBack);
        mav.addObject("jan", jan);
        mav.addObject("feb", feb);
        mav.addObject("mar", mar);
        mav.addObject("apr", apr);
        mav.addObject("may", may);
        mav.addObject("jun", jun);
        mav.addObject("jul", jul);
        mav.addObject("aug", aug);
        mav.addObject("sep", sep);
        mav.addObject("oct", oct);
        mav.addObject("nov", nov);
        mav.addObject("dec", dec);
        return mav;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("adminName", null);
        return "redirect:login.htm";
    }

    @RequestMapping(value = "/validate")
    public String validate(HttpServletRequest request) throws SQLException {
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("adminPassword");
        Session session = AdminUtil.getSession();
        Query query = session.createQuery("from Admins WHERE AdminName = :adminName AND isDisabled = 0");
        query.setParameter("adminName", adminName);
        try {
            Admins admin = (Admins) query.list().get(0);
            String hashingPassword = AdminUtil.hashingPassword(password, admin.getSalt());
            if (hashingPassword.equals(admin.getAdminPassword())) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("adminName", adminName);
                return "redirect:index.htm";
            }
        } catch (IndexOutOfBoundsException e) {
            logger.info("Wrong Amin Account!");
        }
        return "redirect:login.htm";
    }
}
