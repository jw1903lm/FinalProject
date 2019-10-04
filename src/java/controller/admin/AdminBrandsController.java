/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Brands;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminBrandModel;
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
@RequestMapping(value = "/adminBrandsController")
public class AdminBrandsController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllBrand() {
        ModelAndView mav = new ModelAndView("admin/brand/brands");
        List<Brands> listBrand = AdminBrandModel.getAllBrands();
        mav.addObject("listBrand", listBrand);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/brand/brands");
        String name = request.getParameter("search");
        List<Brands> listBrand = AdminBrandModel.findBrandByName(name);
        mav.addObject("listBrand", listBrand);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/brand/newBrand");
        Brands braInsert = new Brands();
        mav.addObject("braInsert", braInsert);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertBrand(Brands braInsert, HttpServletRequest request) throws Exception {
        braInsert.setCreated(AdminUtil.getCurrentDate());
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\brand\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                do {
                    imageName = "logo" + RandomStringUtils.randomNumeric(20) + ".jpg";
                } while (AdminUtil.imageNameExist(imageName, path));
                braInsert.setLogo("brand/" + imageName);
                fileItem.write(new File(path + imageName));
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("brandName".equals(name)) {
                    braInsert.setBrandName(value);
                }
            }
        }
        return (AdminBrandModel.addBrand(braInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String brandId) {
        ModelAndView mav = new ModelAndView("admin/brand/updateBrand");
        Brands braUpdate = AdminBrandModel.getBrandById(brandId);
        mav.addObject("braUpdate", braUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateBrand(Brands braUpdate, HttpServletRequest request) throws Exception {
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\brand\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        Brands brand = new Brands();
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                if (imageName != null && !"".equals(imageName)) {
                    do {
                        imageName = "logo" + RandomStringUtils.randomNumeric(20) + ".jpg";
                    } while (AdminUtil.imageNameExist(imageName, path));
                    braUpdate.setLogo("brand/" + imageName);
                    fileItem.write(new File(path + imageName));
                }
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("brandId".equals(name)) {
                    brand = AdminBrandModel.getBrandById(value);
                    braUpdate.setBrandId(Integer.parseInt(value));
                    braUpdate.setCreated(brand.getCreated());
                }
                if ("brandName".equals(name)) {
                    braUpdate.setBrandName(value);
                }
                if ("isDisabled".equals(name)) {
                    braUpdate.setIsDisabled(Boolean.parseBoolean(value));
                }
            }   
        }
        if (braUpdate.getLogo() == null || "".equals(braUpdate)) {
                braUpdate.setLogo(brand.getLogo());
            }
        return (AdminBrandModel.updateBrand(braUpdate)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteBrand(Brands brand, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return (AdminBrandModel.deleteBrand(brand)) ? "redirect:getAll.htm" : "admin/error";
    }

}
