/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Brands;
import entity.CatagoryDetail;
import entity.ProductDetail;
import entity.SearchDetail;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.user.UserBrandsModel;
import model.user.UserProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userCatagoryController")
public class UserCatagoryController extends UserAllController {

    private UserProductModel productModel;
    private UserBrandsModel brandModel;

    public UserCatagoryController() {
        productModel = new UserProductModel();
        brandModel = new UserBrandsModel();
    }

    //lay catagory dua theo page va thong tin loc
    @RequestMapping(value = "/toCatagory")
    public String initCatagory(int page, int catagoryId, float min, float max, int brandId, HttpServletRequest request, HttpSession session) {
        CatagoryDetail catagoryDetail = (CatagoryDetail) session.getAttribute("catagoryDetail");
        //xoa session cu 
        if (catagoryDetail == null) {
            catagoryDetail = new CatagoryDetail();
        } else {
            catagoryDetail.setPage(page);
            catagoryDetail.setCatagoryId(catagoryId);
            catagoryDetail.setBrandId(brandId);
            catagoryDetail.setMin(min);
            catagoryDetail.setMax(max);
        }
        session.setAttribute("catagoryDetail", catagoryDetail);
        return "redirect:redirectCatagory.htm";
    }

    //lay catagory dua theo catagoryId
    @RequestMapping(value = "/toCatagoryId")
    public String toCatagoryId(int catagoryId, HttpSession session) {
        CatagoryDetail catagoryDetail = (CatagoryDetail) session.getAttribute("catagoryDetail");
        //xoa session cu 
        if (catagoryDetail != null) {
            session.removeAttribute("catagoryDetail");
        }
        catagoryDetail = new CatagoryDetail();
        //luu thong tin cua catagoryDetail
        catagoryDetail.setName(null);
        catagoryDetail.setPage(1);
        catagoryDetail.setCatagoryId(catagoryId);
        catagoryDetail.setBrandId(0);
        catagoryDetail.setMin(0);
        catagoryDetail.setMax(0);
        session.setAttribute("catagoryDetail", catagoryDetail);
        return "redirect:redirectCatagory.htm";
    }

    //lay thong tin catagory dua theo ten
    @RequestMapping(value = "/toSearch")
    public String toSearch(HttpServletRequest request, HttpSession session) {
        CatagoryDetail catagoryDetail = (CatagoryDetail) session.getAttribute("catagoryDetail");
        //xoa session cu 
        if (catagoryDetail != null) {
            session.removeAttribute("catagoryDetail");
        }
        catagoryDetail = new CatagoryDetail();
        //luu thong tin cua catagoryDetail
        catagoryDetail.setName(request.getParameter("name"));
        catagoryDetail.setPage(Integer.parseInt(request.getParameter("page")));
        catagoryDetail.setCatagoryId(0);
        catagoryDetail.setBrandId(0);
        catagoryDetail.setMin(0);
        catagoryDetail.setMax(0);
        session.setAttribute("catagoryDetail", catagoryDetail);
        return "redirect:redirectCatagory.htm";
    }

    @RequestMapping(value = "/redirectCatagory")
    public ModelAndView redirectCatagory(HttpSession session) {
        ModelAndView mav = new ModelAndView("user/jsp/catagory");
        mav = getHeaderAndFooter(mav, session);
        //lay thong tin catagory
        CatagoryDetail catagoryDetail = (CatagoryDetail) session.getAttribute("catagoryDetail");
        //lay so san pham cua tung trang
        int pageSize = 9;
        int position = (catagoryDetail.getPage() - 1) * pageSize;
        List<ProductDetail> catagoryInformation = null;
        List<ProductDetail> listAllProduct = null;
        //loc theo gia ban va dem so luong san pham
        int totalRecords = 0;
        List<ProductDetail> listProduct = new ArrayList<>();
        //truong hop loc theo ten
        if (catagoryDetail.getName() == null) {

        }
        //truong hop loc khong theo gia
        if (catagoryDetail.getMax() == 0 && catagoryDetail.getMin() == 0) {
            //listAllProduct = getAllProductList(productModel.getShopProductPage(position, pageSize, catagoryDetail.getCatagoryId(), catagoryDetail.getBrandId()));
            listAllProduct = getAllProductList(productModel.getShopProductPage(position, pageSize, catagoryDetail.getCatagoryId(), catagoryDetail.getBrandId(), catagoryDetail.getName()));
            //cho vao danh sach
            listProduct = listAllProduct;
            totalRecords = (int) productModel.countTotalRecords(catagoryDetail.getCatagoryId(), catagoryDetail.getBrandId(), catagoryDetail.getName());
        } //truong hop loc theo gia
        else {
            //dung vong lap de dem so san pham dat yeu cau va lay id dau tien cho trang sau
            listAllProduct = getAllProductList(productModel.getAllShopProduct(catagoryDetail.getCatagoryId(), catagoryDetail.getBrandId(), catagoryDetail.getName()));
            int startId = 0;
            int startIdCount = 0;
            if (!listAllProduct.isEmpty()) {
                startId = listAllProduct.get(0).getProduct().getProductId();
                for (int i = 0; i < listAllProduct.size(); i++) {
                    if (listAllProduct.get(i).getSalePrice() >= catagoryDetail.getMin() && listAllProduct.get(i).getSalePrice() <= catagoryDetail.getMax()) {
                        totalRecords++;
                        //khi san pham da den index cua trang
                        if (startIdCount == ((catagoryDetail.getPage() - 1) * pageSize)) {
                            startId = listAllProduct.get(i).getProduct().getProductId();
                        }
                        startIdCount++;
                    }
                }
            }
            //dung vong lap de lay san pham dat yeu cau theo trang
            int count = 1;
            List<ProductDetail> listProductPage = getAllProductList(productModel.getAllShopProductStartId(catagoryDetail.getCatagoryId(), catagoryDetail.getBrandId(), catagoryDetail.getName(), startId));
            if (!listProductPage.isEmpty()) {
                for (int i = 0; i < listProductPage.size(); i++) {
                    if (listProductPage.get(i).getSalePrice() >= catagoryDetail.getMin() && listProductPage.get(i).getSalePrice() <= catagoryDetail.getMax()) {
                        if (count <= pageSize) {
                            listProduct.add(listProductPage.get(i));
                            count++;
                        }
                    }
                }
            }
        }

        //lay danh sach trang va tong so trang
        int totalPages = 0;
        if (totalRecords % pageSize == 0) {
            totalPages = (int) totalRecords / pageSize;
        } else {
            totalPages = (int) (totalRecords / pageSize) + 1;
        }
        List<Integer> listPage = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            listPage.add(i);
        }
        //lay danh sach brand
        List<Brands> listBrand = brandModel.getAllBrand();
        //gui thong tin ra view
        mav.addObject("listProduct", listProduct);
        mav.addObject("listBrand", listBrand);
        mav.addObject("listPage", listPage);
        mav.addObject("listPage", listPage);
        mav.addObject("totalPages", totalPages);
        mav.addObject("totalRecords", totalRecords);
        return mav;
    }
}
