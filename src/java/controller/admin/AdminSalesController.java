/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Sales;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminSaleModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminSalesController")
public class AdminSalesController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllSales() {
        ModelAndView mav = new ModelAndView("admin/sale/sales");
        List<Sales> listSale = AdminSaleModel.getAllSales();
        mav.addObject("listSale", listSale);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/sale/sales");
        String name = request.getParameter("search");
        List<Sales> listSale = AdminSaleModel.findSaleByName(name);
        mav.addObject("listSale", listSale);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/sale/newSale");
        Sales salInsert = new Sales();
        mav.addObject("salInsert", salInsert);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertSale(Sales salInsert) {
        salInsert.setCreated(AdminUtil.getCurrentDate());
        return (AdminSaleModel.addSale(salInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String saleId) {
        ModelAndView mav = new ModelAndView("admin/sale/updateSale");
        Sales salUpdate = AdminSaleModel.getSaleById(saleId);
        mav.addObject("salUpdate", salUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateSale(Sales salUpdate) {
        Sales sale = AdminSaleModel.getSaleById(String.valueOf(salUpdate.getSaleId()));
        salUpdate.setCreated(sale.getCreated());
        return AdminSaleModel.updateSale(salUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteSale(String saleId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminSaleModel.deleteSale(saleId) ? "redirect:getAll.htm" : "admin/error";
    }

}
