/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.OrderStatus;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminOrderStatusModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminOrderStatusController")
public class AdminOrderStatusController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllOrderStatus() {
        ModelAndView mav = new ModelAndView("admin/orderStatus/orderStatus");
        List<OrderStatus> listOrderStatus = AdminOrderStatusModel.getAllOrderStatus();
        mav.addObject("listOrderStatus", listOrderStatus);
        return mav;
    }
    
    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/orderStatus/newOrderStatus");
        OrderStatus orderStatusInsert = new OrderStatus();
        mav.addObject("orderStatusInsert", orderStatusInsert);
        return mav;
    }
    
    @RequestMapping(value = "/insert")
    public String insert(OrderStatus orderStatusInsert) {
        orderStatusInsert.setCreated(AdminUtil.getCurrentDate());
        return AdminOrderStatusModel.addOrderStatus(orderStatusInsert) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String orderStatusId) {
        ModelAndView mav = new ModelAndView("admin/orderStatus/updateOrderStatus");
        OrderStatus orderStatusUpdate = AdminOrderStatusModel.getOrderStatusById(orderStatusId);
        mav.addObject("orderStatusUpdate", orderStatusUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateOrderStatus(OrderStatus orderStatusUpdate) {
        OrderStatus orderStatus = AdminOrderStatusModel.getOrderStatusById(String.valueOf(orderStatusUpdate.getOrderStatusId()));
        orderStatusUpdate.setCreated(orderStatus.getCreated());
        return AdminOrderStatusModel.updateOrderStatus(orderStatusUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteOrderStatus(String orderStatusId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminOrderStatusModel.deleteOrderStatus(orderStatusId) ? "redirect:getAll.htm" : "admin/error";
    }

}
