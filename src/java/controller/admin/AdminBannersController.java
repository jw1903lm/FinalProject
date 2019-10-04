/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Banners;
import entity.Catagories;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminBannerModel;
import model.admin.AdminCategoryModel;
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
@RequestMapping(value = "/adminBannersController")
public class AdminBannersController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllBanners() {
        ModelAndView mav = new ModelAndView("admin/banner/banners");
        List<Banners> listBanner = AdminBannerModel.getAllBanners();
        mav.addObject("listBanner", listBanner);
        return mav;
    }

    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/banner/banners");
        String name = request.getParameter("search");
        List<Banners> listBanner = AdminBannerModel.findBanerByName(name);
        mav.addObject("listBanner", listBanner);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/banner/newBanner");
        Banners banInsert = new Banners();
        mav.addObject("banInsert", banInsert);
        List<Catagories> listCategories = AdminCategoryModel.getAllCategories();
        mav.addObject("listCategory", listCategories);
        return mav;
    }

    @RequestMapping(value = "insert")
    public String insertBanner(Banners banInsert, HttpServletRequest request) throws Exception {
        banInsert.setCreated(AdminUtil.getCurrentDate());
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\banner\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                do {
                    imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                } while (AdminUtil.imageNameExist(imageName, path));
                banInsert.setBannerImage("banner/" + imageName);
                fileItem.write(new File(path + imageName));
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("catagories.catagoryId".equals(name)) {
                    Catagories category = AdminCategoryModel.getCategoryById(value);
                    banInsert.setCatagories(category);
                }
                if ("bannerName".equals(name)) {
                    banInsert.setBannerName(value);
                }
                if ("bannerDescription".equals(name)) {
                    banInsert.setBannerDescription(value);
                }
            }
        }
        return (AdminBannerModel.addBanner(banInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String bannerId) {
        ModelAndView mav = new ModelAndView("admin/banner/updateBanner");
        Banners banUpdate = AdminBannerModel.getBannerById(bannerId);
        List<Catagories> listCategories = AdminCategoryModel.getAllCategories();
        mav.addObject("banUpdate", banUpdate);
        mav.addObject("listCategory", listCategories);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateBanner(Banners banUpdate, HttpServletRequest request) throws Exception {
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\banner\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        Banners banner = new Banners();
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                if (imageName != null && !"".equals(imageName)) {
                    do {
                        imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                    } while (AdminUtil.imageNameExist(imageName, path));
                    banUpdate.setBannerImage("banner/" + imageName);
                    fileItem.write(new File(path + imageName));
                }
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("bannerId".equals(name)) {
                    banUpdate.setBannerId(Integer.parseInt(value));
                    banner = AdminBannerModel.getBannerById(value);
                    banUpdate.setCreated(banner.getCreated());
                }
                if ("catagories.catagoryId".equals(name)) {
                    Catagories category = AdminCategoryModel.getCategoryById(value);
                    banUpdate.setCatagories(category);
                }
                if ("bannerName".equals(name)) {
                    banUpdate.setBannerName(value);
                }
                if ("bannerDescription".equals(name)) {
                    banUpdate.setBannerDescription(value);
                }
                if ("size".equals(name)) {
                    banUpdate.setSize(Boolean.parseBoolean(value));
                }
                if ("isDisabled".equals(name)) {
                    banUpdate.setIsDisabled(Boolean.parseBoolean(value));
                }
            }
        }
        if (banUpdate.getBannerImage() == null || "".equals(banUpdate.getBannerImage())) {
            banUpdate.setBannerImage(banner.getBannerImage());
        }
        return (AdminBannerModel.updateBanner(banUpdate)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteBanner(Banners banner, HttpServletRequest request) throws Exception {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return (AdminBannerModel.deleteBanner(banner)) ? "redirect:getAll.htm" : "admin/error";
    }
}
