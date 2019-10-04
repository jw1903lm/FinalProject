/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.OrderDetail;
import entity.OrderDetailId;
import entity.Orders;
import entity.Products;
import entity.Sizes;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminOrderDetailModel;
import model.admin.AdminOrderModel;
import model.admin.AdminProductModel;
import model.admin.AdminSizeModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminOrderDetailsController")
public class AdminOrderDetailsController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllOrderDetail() {
        ModelAndView mav = new ModelAndView("admin/orderDetail/orderDetail");
        List<OrderDetail> listOrderDetail = AdminOrderDetailModel.getAllOrderDetails();
        mav.addObject("listOrderDetail", listOrderDetail);
        return mav;
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String orderId, String productId, String sizeId) {
        ModelAndView mav = new ModelAndView("admin/orderDetail/updateOrderDetail");
        OrderDetail orderDetailUpdate = AdminOrderDetailModel.getOrderDetailById(orderId, productId, sizeId);
        mav.addObject("orderDetailUpdate", orderDetailUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateOrderDetail(OrderDetail orderDetailUpdate) {
        return AdminOrderDetailModel.updateOrderDetail(orderDetailUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteOrderDetail(String orderId, String productId, String sizeId, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        OrderDetail orderDetail = AdminOrderDetailModel.getOrderDetailById(orderId, productId, sizeId);
        return AdminOrderDetailModel.deleteOrderDetail(orderDetail) ? "redirect:getAll.htm" : "admin/error";
    }

}
