/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Products;
import entity.Sliders;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminProductModel;
import model.admin.AdminSliderModel;
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
@RequestMapping(value = "/adminSlidersController")
public class AdminSlidersController {
    
    @RequestMapping(value = "/getAll")
    public ModelAndView getAllSliders() {
        ModelAndView mav = new ModelAndView("admin/slider/sliders");
        List<Sliders> listSlider = AdminSliderModel.getAllSliders();
        mav.addObject("listSlider", listSlider);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/slider/sliders");
        String name = request.getParameter("search");
        List<Sliders> listSlider = AdminSliderModel.findSliderByTitle(name);
        mav.addObject("listSlider", listSlider);
        return mav;
    }
    
    @RequestMapping(value = "/detail")
    public ModelAndView getAllSlidersDetail(String sliderId) {
        ModelAndView mav = new ModelAndView("admin/slider/sliders-chitiet");
        Sliders sliderUpdate = AdminSliderModel.getSliderById(sliderId);
        mav.addObject("sliderUpdate", sliderUpdate);
        return mav;
    }
    
    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/slider/newSlider");
        Sliders sliderInsert = new Sliders();
        List<Products> listProduct = AdminProductModel.getAllProducts();
        mav.addObject("listProduct", listProduct);
        mav.addObject("sliderInsert", sliderInsert);
        return mav;
    }
    
    @RequestMapping(value = "/insert")
    public String insertSlider(Sliders sliderInsert, HttpServletRequest request) throws Exception {
        sliderInsert.setCreated(AdminUtil.getCurrentDate());
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\slider\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                do {
                    imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                } while (AdminUtil.imageNameExist(imageName, path));
                sliderInsert.setImageLink("slider/" + imageName);
                fileItem.write(new File(path + imageName));
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("products.productId".equals(name)) {
                    Products product = AdminProductModel.getProductById(value);
                    sliderInsert.setProducts(product);
                }
                if ("title".equals(name)) {
                    sliderInsert.setTitle(value);
                }
                if ("subTitle".equals(name)) {
                    sliderInsert.setSubTitle(value);
                }
                if ("content".equals(name)) {
                    sliderInsert.setContent(value);
                }
            }
        }
        return (AdminSliderModel.addSlider(sliderInsert)) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String sliderId) {
        ModelAndView mav = new ModelAndView("admin/slider/updateSlider");
        List<Products> listProduct = AdminProductModel.getAllProducts();
        Sliders sliderUpdate = AdminSliderModel.getSliderById(sliderId);
        mav.addObject("sliderUpdate", sliderUpdate);
        mav.addObject("listProduct", listProduct);
        return mav;
    }
    
    @RequestMapping(value = "/update")
    public String updateSlider(Sliders sliderUpdate, HttpServletRequest request) throws Exception {
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\slider\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        Sliders slider = new Sliders();
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                if (imageName != null && !"".equals(imageName)) {
                    do {
                        imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                    } while (AdminUtil.imageNameExist(imageName, path));
                    sliderUpdate.setImageLink("slider/" + imageName);
                    fileItem.write(new File(path + imageName));
                }
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("products.productId".equals(name)) {
                    Products product = AdminProductModel.getProductById(value);
                    sliderUpdate.setProducts(product);
                }
                if ("title".equals(name)) {
                    sliderUpdate.setTitle(value);
                }
                if ("subTitle".equals(name)) {
                    sliderUpdate.setSubTitle(value);
                }
                if ("content".equals(name)) {
                    sliderUpdate.setContent(value);
                }
                if ("sliderId".equals(name)) {
                    sliderUpdate.setSliderId(Integer.parseInt(value));
                    slider = AdminSliderModel.getSliderById(value);
                    sliderUpdate.setCreated(slider.getCreated());
                }
                if ("isDisabled".equals(name)) {
                    sliderUpdate.setIsDisabled(Boolean.parseBoolean(value));
                }
            }
        }
        if (sliderUpdate.getImageLink() == null || "".equals(sliderUpdate.getImageLink())) {
            sliderUpdate.setImageLink(slider.getImageLink());
        }
        return AdminSliderModel.updateSlider(sliderUpdate) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteSlider(Sliders slider, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminSliderModel.deleteSlider(slider) ? "redirect:getAll.htm" : "admin/error";
    }
    
}
