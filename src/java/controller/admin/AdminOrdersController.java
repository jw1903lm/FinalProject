/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.OrderStatus;
import entity.Orders;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminOrderModel;
import model.admin.AdminOrderStatusModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminOrdersController")
public class AdminOrdersController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllOrders() {
        ModelAndView mav = new ModelAndView("admin/order/orders");
        List<Orders> listOrder = AdminOrderModel.getAllOrders();
        mav.addObject("listOrder", listOrder);
        return mav;
    }

    @RequestMapping(value = "/detail")
    public ModelAndView getAllOrdersDetail(String orderId) {
        ModelAndView mav = new ModelAndView("admin/order/orders-chitiet");
        Orders orderUpdate = AdminOrderModel.getOrderById(orderId);
        mav.addObject("orderUpdate", orderUpdate);
        return mav;
    }
    
    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String orderId) {
        ModelAndView mav = new ModelAndView("admin/order/updateOrder");
        Orders orderUpdate = AdminOrderModel.getOrderById(orderId);
        List<OrderStatus> listOrderStatus = AdminOrderStatusModel.getAllOrderStatus();
        mav.addObject("listOrderStatus",listOrderStatus);
        mav.addObject("orderUpdate", orderUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateOrder(Orders orderUpdate,HttpServletRequest request) {
        return AdminOrderModel.updateOrder(orderUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteOrder(String orderId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminOrderModel.deleteOrder(orderId) ? "redirect:getAll.htm" : "admin/error";
    }

}
