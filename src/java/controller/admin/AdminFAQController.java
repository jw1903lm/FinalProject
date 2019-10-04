/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Faq;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminFAQModel;
import model.admin.AdminUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminFAQController")
public class AdminFAQController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllFaq() {
        ModelAndView mav = new ModelAndView("admin/faq/faq");
        List<Faq> listFaq = AdminFAQModel.getAllFaq();
        mav.addObject("listFaq", listFaq);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/faq/faq");
        String name = request.getParameter("search");
        List<Faq> listFaq = AdminFAQModel.findFaqByQuestion(name);
        mav.addObject("listFaq", listFaq);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/faq/newFaq");
        Faq faqInsert = new Faq();
        mav.addObject("faqInsert", faqInsert);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertFaq(Faq faqInsert) {
        faqInsert.setCreated(AdminUtil.getCurrentDate());
        return (AdminFAQModel.addFaq(faqInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String faqId) {
        ModelAndView mav = new ModelAndView("admin/faq/updateFaq");
        Faq faqUpdate = AdminFAQModel.getFaqById(faqId);
        mav.addObject("faqUpdate", faqUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateFaq(Faq faqUpdate) {
        Faq faq = AdminFAQModel.getFaqById(String.valueOf(faqUpdate.getFaqId()));
        faqUpdate.setCreated(faq.getCreated());
        return AdminFAQModel.updateFaq(faqUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteFaq(Faq faq, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminFAQModel.deleteFaq(faq) ? "redirect:getAll.htm" : "admin/error";
    }

}
