/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Ships;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminShipModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminShipsController")
public class AdminShipsController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllShips() {
        ModelAndView mav = new ModelAndView("admin/ship/ships");
        List<Ships> listShip = AdminShipModel.getAllShips();
        mav.addObject("listShip", listShip);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/ship/newShip");
        Ships shipInsert = new Ships();
        mav.addObject("shipInsert", shipInsert);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertShip(Ships shipInsert) {
        shipInsert.setCreated(AdminUtil.getCurrentDate());
        return (AdminShipModel.addShip(shipInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String shipId) {
        ModelAndView mav = new ModelAndView("admin/ship/updateShip");
        Ships shipUpdate = AdminShipModel.getShipById(shipId);
        mav.addObject("shipUpdate", shipUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateShip(Ships shipUpdate) {
        Ships ship = AdminShipModel.getShipById(String.valueOf(shipUpdate.getShipId()));
        shipUpdate.setCreated(ship.getCreated());
        return AdminShipModel.updateShip(shipUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteShip(String shipId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminShipModel.deleteShip(shipId) ? "redirect:getAll.htm" : "admin/error";
    }

}
