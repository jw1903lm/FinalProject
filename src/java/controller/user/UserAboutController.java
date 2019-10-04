/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.user;

import entity.Stores;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.user.UserStoresModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userAboutController")
public class UserAboutController extends UserAllController{
    
    private UserStoresModel storeModel;

    public UserAboutController() {
        storeModel = new UserStoresModel();
    }
    
    @RequestMapping(value = "/toAbout")
    public ModelAndView initAbout(HttpSession session) {
        ModelAndView mav = new ModelAndView("user/jsp/about");
        mav = getHeaderAndFooter(mav, session);
        List<Stores> listStore = storeModel.getAllStore();
        mav.addObject("listStore",listStore);
        return mav;
    }
}