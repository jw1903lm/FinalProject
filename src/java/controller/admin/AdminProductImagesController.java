/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import entity.ProductImages;
import entity.Products;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminProductImageModel;
import model.admin.AdminProductModel;
import model.admin.AdminUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
@RequestMapping(value = "/adminProductImagesController")
public class AdminProductImagesController {
    
    @RequestMapping(value = "/getAll")
    public ModelAndView getAllProductImages() {
        ModelAndView mav = new ModelAndView("admin/productImage/productImages");
        List<ProductImages> listProductImage = AdminProductImageModel.getAllProductImages();
        mav.addObject("listProductImage", listProductImage);
        return mav;
    }
    
    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/productImage/newProductImage");
        ProductImages productImageInsert = new ProductImages();
        List<Products> listProduct = AdminProductModel.getAllProducts();
        mav.addObject("listProduct", listProduct);
        mav.addObject("productImageInsert", productImageInsert);
        return mav;
    }
    
    @RequestMapping(value = "/insert")
    public String insertProductImage(ProductImages productImageInsert, HttpServletRequest request) throws FileUploadException, Exception {
        productImageInsert.setCreated(AdminUtil.getCurrentDate());
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\product\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                do {
                    imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                } while (AdminUtil.imageNameExist(imageName, path));
                productImageInsert.setLink("product/" + imageName);
                fileItem.write(new File(path + imageName));
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("products.productId".equals(name)) {
                    Products product = AdminProductModel.getProductById(value);
                    productImageInsert.setProducts(product);
                }
            }
        }
        return (AdminProductImageModel.addProductImage(productImageInsert)) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String imageId
    ) {
        ModelAndView mav = new ModelAndView("admin/productImage/updateProductImage");
        List<Products> listProduct = AdminProductModel.getAllProducts();
        ProductImages productImageUpdate = AdminProductImageModel.getProductImageById(imageId);
        mav.addObject("productImageUpdate", productImageUpdate);
        mav.addObject("listProduct", listProduct);
        return mav;
    }
    
    @RequestMapping(value = "/update")
    public String updateProductImage(ProductImages productImageUpdate, HttpServletRequest request) throws Exception {
        String path = request.getRealPath("");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\view\\img\\product\\";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        List<FileItem> lst = uploader.parseRequest(request);
        ProductImages productImage = new ProductImages();
        for (FileItem fileItem : lst) {
            if (fileItem.isFormField() == false) {
                String imageName = fileItem.getName();
                if (imageName != null && !"".equals(imageName)) {
                    do {
                        imageName = "img" + RandomStringUtils.randomNumeric(20) + ".jpg";
                    } while (AdminUtil.imageNameExist(imageName, path));
                    productImageUpdate.setLink("product/" + imageName);
                    fileItem.write(new File(path + imageName));
                }
            } else {
                String name = fileItem.getFieldName();
                String value = new String(fileItem.get(), "UTF-8");
                if ("products.productId".equals(name)) {
                    Products product = AdminProductModel.getProductById(value);
                    productImageUpdate.setProducts(product);
                    
                }
                if ("imageId".equals(name)) {
                    productImage = AdminProductImageModel.getProductImageById(value);
                    productImageUpdate.setImageId(Integer.parseInt(value));
                    productImageUpdate.setCreated(productImage.getCreated());
                }
                if ("isDisabled".equals(name)) {
                    productImageUpdate.setIsDisabled(Boolean.parseBoolean(value));
                }
            }
        }
        if (productImageUpdate.getLink() == null || "".equals(productImageUpdate.getLink())) {
            productImageUpdate.setLink(productImage.getLink());
        }
        return AdminProductImageModel.updateProductImage(productImageUpdate) ? "redirect:getAll.htm" : "admin/error";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteProductImage(ProductImages productImage, HttpServletRequest request
    ) {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return AdminProductImageModel.deleteProductImage(productImage) ? "redirect:getAll.htm" : "admin/error";
    }
    
}
