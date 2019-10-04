/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Cities;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminCityModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminCitiesController")
public class AdminCitiesController {
    
    @RequestMapping(value = "/getAll")
    public ModelAndView getAllCities() {
        ModelAndView mav = new ModelAndView("admin/city/cities");
        List<Cities> listCity = AdminCityModel.getAllCities();
        mav.addObject("listCity", listCity);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/city/cities");
        String name = request.getParameter("search");
        List<Cities> listCity = AdminCityModel.findCityByName(name);
        mav.addObject("listCity", listCity);
        return mav;
    }
    
    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/city/newCity");
        Cities cityInsert = new Cities();
        mav.addObject("cityInsert", cityInsert);
        return mav;
    }
    
    @RequestMapping(value = "/insert")
    public String insertCity(Cities cityInsert) {
        cityInsert.setCreated(AdminUtil.getCurrentDate());
        return (AdminCityModel.addCity(cityInsert)) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String cityId) {
        ModelAndView mav = new ModelAndView("admin/city/updateCity");
        Cities cityUpdate = AdminCityModel.getCityById(cityId);
        mav.addObject("cityUpdate", cityUpdate);
        return mav;
    }
    
    @RequestMapping(value = "/update")
    public String updateCity(Cities cityUpdate) {
        Cities city = AdminCityModel.getCityById(String.valueOf(cityUpdate.getCityId()));
        cityUpdate.setCreated(city.getCreated());
        return AdminCityModel.updateCity(cityUpdate) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteCity(String cityId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminCityModel.deleteCity(cityId) ? "redirect:getAll.htm" : "admin/error";
    }
    
}
