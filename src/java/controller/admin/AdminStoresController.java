/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.Stores;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminStoreModel;
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
@RequestMapping(value = "/adminStoresController")
public class AdminStoresController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllStores() {
        ModelAndView mav = new ModelAndView("admin/store/stores");
        List<Stores> listStore = AdminStoreModel.getAllStores();
        mav.addObject("listStore", listStore);
        return mav;
    }
    
    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/store/stores");
        String name = request.getParameter("search");
        List<Stores> listStore = AdminStoreModel.findStoreByName(name);
        mav.addObject("listStore", listStore);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/store/newStore");
        Stores stoInsert = new Stores();
        mav.addObject("stoInsert", stoInsert);
        return mav;
    }

    @RequestMapping(value = "/insert")
    public String insertStore(Stores stoInsert, HttpServletRequest request) throws Exception {
        stoInsert.setCreated(AdminUtil.getCurrentDate());
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\store\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                do {
                    imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                } while (AdminUtil.imageNameExist(imageName, path));
                stoInsert.setStoreImage("store/" + imageName);
                fileItem.write(new File(path + imageName));
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("storeName".equals(name)) {
                    stoInsert.setStoreName(value);
                }
                if ("email".equals(name)) {
                    stoInsert.setEmail(value);
                }
                if ("phone".equals(name)) {
                    stoInsert.setPhone(value);
                }
                if ("storeAddress".equals(name)) {
                    stoInsert.setStoreAddress(value);
                }
            }
        }
        return (AdminStoreModel.addStore(stoInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String storeId) {
        ModelAndView mav = new ModelAndView("admin/store/updateStore");
        Stores stoUpdate = AdminStoreModel.getStoreById(storeId);
        mav.addObject("stoUpdate", stoUpdate);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateStore(Stores stoUpdate, HttpServletRequest request) throws Exception {
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\store\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        Stores store = new Stores();
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                if (imageName != null && !"".equals(imageName)) {
                    do {
                        imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                    } while (AdminUtil.imageNameExist(imageName, path));
                    stoUpdate.setStoreImage("store/" + imageName);
                    fileItem.write(new File(path + imageName));
                }
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("storeId".equals(name)) {
                    stoUpdate.setStoreId(Integer.parseInt(value));
                    store = AdminStoreModel.getStoreById(value);
                    stoUpdate.setCreated(store.getCreated());
                }
                if ("storeName".equals(name)) {
                    stoUpdate.setStoreName(value);
                }
                if ("email".equals(name)) {
                    stoUpdate.setEmail(value);
                }
                if ("phone".equals(name)) {
                    stoUpdate.setPhone(value);
                }
                if ("storeAddress".equals(name)) {
                    stoUpdate.setStoreAddress(value);
                }
                if ("isDisabled".equals(name)) {
                    stoUpdate.setIsDisabled(Boolean.parseBoolean(value));
                }
            }
        }
        if (stoUpdate.getStoreImage() == null || "".equals(stoUpdate.getStoreImage())) {
            stoUpdate.setStoreImage(store.getStoreImage());
        }
        return AdminStoreModel.updateStore(stoUpdate) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteStore(Stores store, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminStoreModel.deleteStore(store) ? "redirect:getAll.htm" : "admin/error";
    }

}
