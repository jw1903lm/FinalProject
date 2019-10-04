/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.user;

import entity.Faq;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.user.UserFaqModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userFAQController")
public class UserFAQController extends UserAllController{
    
    private UserFaqModel faqModel;

    public UserFAQController() {
        faqModel = new UserFaqModel();
    }

    @RequestMapping(value = "/toFaq")
    public ModelAndView initFAQ(HttpSession session) {
        ModelAndView mav = new ModelAndView("user/jsp/faq");
        mav = getHeaderAndFooter(mav, session);
        List<Faq> listFaq =  faqModel.getAllFaq();
        mav.addObject("listFaq", listFaq);
        return mav;
    }
}
