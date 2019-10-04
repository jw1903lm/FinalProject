package controller.admin;

import entity.Brands;
import entity.Catagories;
import entity.Products;
import entity.Sales;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.admin.AdminBrandModel;
import model.admin.AdminCategoryModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import model.admin.AdminProductModel;
import model.admin.AdminSaleModel;
import model.admin.AdminUtil;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NamPA
 */
@Controller
@RequestMapping(value = "/adminProductsController")
public class AdminProductsController {

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllProduct() {
        ModelAndView mav = new ModelAndView("admin/product/products");
        List<Products> listProduct = AdminProductModel.getAllProducts();
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @RequestMapping(value = "/detail")
    public ModelAndView getAllProductDetail(String productId) {
        ModelAndView mav = new ModelAndView("admin/product/products-chitiet");
        Products proUpdate = AdminProductModel.getProductById(productId);
        mav.addObject("proUpdate", proUpdate);
        return mav;
    }

    @RequestMapping(value = "/doSearch")
    public ModelAndView doSearch(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/product/products");
        String productName = request.getParameter("search");
        List<Products> listProduct = AdminProductModel.findProductByName(productName);
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsert() {
        ModelAndView mav = new ModelAndView("admin/product/newProduct");
        Products proInsert = new Products();
        List<Brands> listBrand = AdminBrandModel.getAllBrands();
        List<Catagories> listCategories = AdminCategoryModel.getAllCategories();
        List<Sales> listSale = AdminSaleModel.getAllSales();
        mav.addObject("listCategory", listCategories);
        mav.addObject("listBrand", listBrand);
        mav.addObject("listSale", listSale);
        mav.addObject("proInsert", proInsert);
        return mav;
    }

    @RequestMapping(value = "insert")
    public String insertProduct(Products proInsert, HttpServletRequest request) {
        String saleId = request.getParameter("sale");
        String brandId = request.getParameter("brand");
        String categoryId = request.getParameter("category");
        if (!"".equals(saleId) && saleId != null) {
            Sales sale = AdminSaleModel.getSaleById(saleId);
            proInsert.setSales(sale);
        }
        if (!"".equals(brandId) && brandId != null) {
            Brands brand = AdminBrandModel.getBrandById(brandId);
            proInsert.setBrands(brand);
        }
        Catagories category = AdminCategoryModel.getCategoryById(categoryId);
        proInsert.setCatagories(category);
        proInsert.setCreated(AdminUtil.getCurrentDate());
        return (AdminProductModel.addProduct(proInsert)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdate(String productId) {
        ModelAndView mav = new ModelAndView("admin/product/updateProduct");
        Products proUpdate = AdminProductModel.getProductById(productId);
        List<Brands> listBrand = AdminBrandModel.getAllBrands();
        List<Catagories> listCategories = AdminCategoryModel.getAllCategories();
        List<Sales> listSale = AdminSaleModel.getAllSales();
        mav.addObject("proUpdate", proUpdate);
        mav.addObject("listCategory", listCategories);
        mav.addObject("listBrand", listBrand);
        mav.addObject("listSale", listSale);
        return mav;
    }

    @RequestMapping(value = "/update")
    public String updateProduct(Products proUpdate, HttpServletRequest request) {
        String saleId = request.getParameter("sale");
        String categoryId = request.getParameter("category");
        String brandId = request.getParameter("brand");
        if (saleId != null && !"".equals(saleId)) {
            Sales sale = AdminSaleModel.getSaleById(saleId);
            proUpdate.setSales(sale);
        }
        if (brandId != null && !"".equals(brandId)) {
            Brands brand = AdminBrandModel.getBrandById(brandId);
            proUpdate.setBrands(brand);
        }
        Catagories category = AdminCategoryModel.getCategoryById(categoryId);
        proUpdate.setCatagories(category);

        Products product = AdminProductModel.getProductById(String.valueOf(proUpdate.getProductId()));
        proUpdate.setCreated(product.getCreated());
        return (AdminProductModel.updateProduct(proUpdate)) ? "redirect:getAll.htm" : "admin/error";
    }

    @RequestMapping(value = "/delete")
    public String deleteProduct(String productId, HttpServletRequest request) throws SQLException {
        if (request.getSession().getAttribute("adminName") == null) {
            return "redirect:/adminIndexController/login.htm";
        }
        return (AdminProductModel.deleteProduct(productId)) ? "redirect:getAll.htm" : "admin/error";
    }
}
