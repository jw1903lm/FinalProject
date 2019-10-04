/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.ShopInformation;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminShopInformationModel;
import model.admin.AdminUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminShopInformationsController")
public class AdminShopInformationsController {
    
    @RequestMapping(value = "/getAll")
    public ModelAndView getAllShopInformation() {
        ModelAndView mav = new ModelAndView("admin/shopInformation/shopInformation");
        List<ShopInformation> listShopInformation = AdminShopInformationModel.getAllShopInformations();
        mav.addObject("listShopInformation", listShopInformation);
        return mav;
    }
    
    @RequestMapping(value = "/detail")
    public ModelAndView getAllShopInformationDetail(String shopInformationId) {
        ModelAndView mav = new ModelAndView("admin/shopInformation/shopInformation-chitiet");
        ShopInformation shopInformationUpdate = AdminShopInformationModel.getShopInformationById(shopInformationId);
        mav.addObject("shiUpdate", shopInformationUpdate);
        return mav;
    }
    
    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/shopInformation/newShopInformation");
        ShopInformation shopInformationInsert = new ShopInformation();
        mav.addObject("shiInsert", shopInformationInsert);
        return mav;
    }
    
    @RequestMapping(value = "/insert")
    public String insertShopInformation(ShopInformation shiInsert, HttpServletRequest request) throws Exception {
        shiInsert.setCreated(AdminUtil.getCurrentDate());
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\shopInformation\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        for (FileItem fileItem : lst) {
            String name = fileItem.getFieldName();
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                if ("logoTop".equals(name)) {
                    imageName = createImageName("lgTop", path);
                    shiInsert.setLogoTop("shopInformartion/" + imageName);
                }
                if ("logoBottom".equals(name)) {
                    imageName = createImageName("lgBot", path);
                    shiInsert.setLogoBottom("shopInformartion/" + imageName);
                }
                if ("shopImage".equals(name)) {
                    imageName = createImageName("sImg", path);
                    shiInsert.setShopImage("shopInformartion/" + imageName);
                }
                if ("founderImage".equals(name)) {
                    imageName = createImageName("fImg", path);
                    shiInsert.setFounderImage("shopInformartion/" + imageName);
                }
                fileItem.write(new File(path + imageName));
            } else {
                String value = new String(fileItem.get(), "UTF-8");
                if ("slogan".equals(name)) {
                    shiInsert.setSlogan(value);
                }
                if ("shopDescription".equals(name)) {
                    shiInsert.setShopDescription(value);
                }
                if ("founderQuote".equals(name)) {
                    shiInsert.setFounderQuote(value);
                }
                if ("contactEmail".equals(name)) {
                    shiInsert.setContactEmail(value);
                }
                if ("contactPhone".equals(name)) {
                    shiInsert.setContactPhone(value);
                }
                if ("contactAddress".equals(name)) {
                    shiInsert.setContactAddress(value);
                }
            }
        }
        return (AdminShopInformationModel.addShopInformation(shiInsert)) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String shopInformationId) {
        ModelAndView mav = new ModelAndView("admin/shopInformation/updateShopInformation");
        ShopInformation shopInformationUpdate = AdminShopInformationModel.getShopInformationById(shopInformationId);
        mav.addObject("shiUpdate", shopInformationUpdate);
        return mav;
    }
    
    @RequestMapping(value = "/update")
    public String updateShopInformation(ShopInformation shiUpdate, HttpServletRequest request) throws Exception {
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\shopInformation\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        ShopInformation info = new ShopInformation();
        for (FileItem fileItem : lst) {
            String name = fileItem.getFieldName();
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                if (!"".equals(imageName)) {
                    if ("logoTop".equals(name)) {
                        imageName = createImageName("lgTop", path);
                        shiUpdate.setLogoTop("shopInformation/" + imageName);
                    }
                    if ("logoBottom".equals(name)) {
                        imageName = createImageName("lgBot", path);
                        shiUpdate.setLogoBottom("shopInformation/" + imageName);
                    }
                    if ("shopImage".equals(name)) {
                        imageName = createImageName("sImg", path);
                        shiUpdate.setShopImage("shopInformation/" + imageName);
                    }
                    if ("founderImage".equals(name)) {
                        imageName = createImageName("fImg", path);
                        shiUpdate.setFounderImage("shopInformation/" + imageName);
                    }
                    fileItem.write(new File(path + imageName));
                }
            } else {
                String value = new String(fileItem.get(), "UTF-8");
                if ("slogan".equals(name)) {
                    shiUpdate.setSlogan(value);
                }
                if ("shopDescription".equals(name)) {
                    shiUpdate.setShopDescription(value);
                }
                if ("founderQuote".equals(name)) {
                    shiUpdate.setFounderQuote(value);
                }
                if ("contactEmail".equals(name)) {
                    shiUpdate.setContactEmail(value);
                }
                if ("contactPhone".equals(name)) {
                    shiUpdate.setContactPhone(value);
                }
                if ("contactAddress".equals(name)) {
                    shiUpdate.setContactAddress(value);
                }
                if ("shopInformationId".equals(name)) {
                    info = AdminShopInformationModel.getShopInformationById(value);
                    shiUpdate.setCreated(info.getCreated());
                    shiUpdate.setShopInformationId(Integer.parseInt(value));
                }
                if ("isDisabled".equals(name)) {
                    shiUpdate.setIsDisabled(Boolean.parseBoolean(value));
                }
            }
        }
        if (shiUpdate.getLogoTop() == null || "".equals(shiUpdate.getLogoTop())) {
            shiUpdate.setLogoTop(info.getLogoTop());
        }
        if (shiUpdate.getLogoBottom() == null || "".equals(shiUpdate.getLogoBottom())) {
            shiUpdate.setLogoBottom(info.getLogoBottom());
        }
        if (shiUpdate.getFounderImage() == null || "".equals(shiUpdate.getFounderImage())) {
            shiUpdate.setFounderImage(info.getFounderImage());
        }
        if (shiUpdate.getShopImage() == null || "".equals(shiUpdate.getShopImage())) {
            shiUpdate.setShopImage(info.getShopImage());
        }
        return AdminShopInformationModel.updateShopInformation(shiUpdate) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteShopInformation(ShopInformation shopInformation, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminShopInformationModel.deleteShopInformation(shopInformation) ? "redirect:getAll.htm" : "admin/error";
    }
    
    private static String createImageName(String prefix, String path) {
        String imageName;
        do {
            imageName = prefix + RandomStringUtils.randomNumeric(20) + ".jpg";
        } while (AdminUtil.imageNameExist(imageName, path));
        return imageName;
    }
    
}
