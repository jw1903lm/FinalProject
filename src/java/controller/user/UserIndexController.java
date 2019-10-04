/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Banners;
import entity.Brands;
import entity.Catagories;
import entity.CatagoryDetail;
import entity.ProductComments;
import entity.ProductDetail;
import entity.ProductImages;
import entity.Products;
import entity.SearchDetail;
import entity.Sizes;
import entity.Sliders;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.user.UserBannersModel;
import model.user.UserBrandsModel;
import model.user.UserCatagoriesModel;
import model.user.UserProductCommentsModel;
import model.user.UserProductImageModel;
import model.user.UserProductModel;
import model.user.UserSalesModel;
import model.user.UserSizeModel;
import model.user.UserSlidersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userIndexController")
public class UserIndexController extends ImageAdjust {

    private UserAllController allController;
    private UserCatagoriesModel catagoriesModel;
    private UserSlidersModel slidersModel;
    private UserBannersModel bannersModel;
    private UserProductModel productModel;
    private UserProductImageModel productImageModel;
    private UserSalesModel saleModel;
    private UserBrandsModel brandModel;
    private UserProductCommentsModel productCommentsModel;
    private UserSizeModel sizeModel;

    public UserIndexController() {
        allController = new UserAllController();
        catagoriesModel = new UserCatagoriesModel();
        slidersModel = new UserSlidersModel();
        bannersModel = new UserBannersModel();
        productModel = new UserProductModel();
        productImageModel = new UserProductImageModel();
        saleModel = new UserSalesModel();
        brandModel = new UserBrandsModel();
        productCommentsModel = new UserProductCommentsModel();
        sizeModel = new UserSizeModel();
    }

    @RequestMapping(value = "/index")
    public ModelAndView toIndex(HttpServletRequest request, HttpSession session){
        ModelAndView mav = new ModelAndView("user/jsp/index");
        //Tim danh sach catagory va tach catagory lon va nho
        mav = allController.getHeaderAndFooter(mav,session);
        //Tim danh sach slider
        List<Sliders> listSliders = slidersModel.getAllSliders();
        //Tim danh sach banner nho
        List<Banners> listSmallBanners = bannersModel.getSmallBanners();
        //Tim danh sach banner lon- gan vao upperBanner va lowerBanner
        List<Banners> listBigBanners = bannersModel.getBigBanners();
        Banners upperBanner = null;
        Banners lowerBanner = null;
        if (listBigBanners.size() == 1) {
            upperBanner = listBigBanners.get(0);
        } else if (listBigBanners.size() == 2) {
            upperBanner = listBigBanners.get(0);
            lowerBanner = listBigBanners.get(1);
        }

        //tim danh sach san pham New Arrival
        List<ProductDetail> listNewArrival = getListSuggestProduct("new arrival");
        //tim danh sach san pham Sale Product
        List<ProductDetail> listSaleProduct = getListSuggestProduct("sale product");
        //tim danh sach san pham Bestseliing
        List<ProductDetail> listBestselling = getListSuggestProduct("bestselling");

        //lay danh sach brand goi y
        List<Brands> listBrands = brandModel.getThreeSuggestBrand();
        String firstBrand = "";
        String secondBrand = "";
        String thirdBrand = "";
        //gan gia tri cho cac brand goi y
        if (listBrands.size() == 1) {
            firstBrand = listBrands.get(0).getBrandName();
        } else if (listBrands.size() == 2) {
            firstBrand = listBrands.get(0).getBrandName();
            secondBrand = listBrands.get(1).getBrandName();
        } else if (listBrands.size() == 3) {
            firstBrand = listBrands.get(0).getBrandName();
            secondBrand = listBrands.get(1).getBrandName();
            thirdBrand = listBrands.get(2).getBrandName();
        }
        //tao danh sach san pham tung brand
        List<ProductDetail> listProductFirstBrand = null;
        List<ProductDetail> listProductSecondBrand = null;
        List<ProductDetail> listProductThirdBrand = null;
        int countBrand = 1;
        //gan danh sach san pham cho tung brand
        for (Brands brand : listBrands) {
            if (countBrand == 1) {
                listProductFirstBrand = allController.getListProductDetailByListProduct(productModel.getBrandProducts(brand.getBrandId()));
            } else if (countBrand == 2) {
                listProductSecondBrand = allController.getListProductDetailByListProduct(productModel.getBrandProducts(brand.getBrandId()));
            } else {
                listProductThirdBrand = allController.getListProductDetailByListProduct(productModel.getBrandProducts(brand.getBrandId()));
            }
            countBrand++;
        }

        //lay danh sach brand
        List<Brands> listBrandsShowLogo = brandModel.getBrandShowLogo();
        //gui cac thong tin ra trang index
        mav.addObject("listSliders", listSliders);
        mav.addObject("listSmallBanners", listSmallBanners);
        mav.addObject("upperBanner", upperBanner);
        mav.addObject("lowerBanner", lowerBanner);
        mav.addObject("listNewArrival", listNewArrival);
        mav.addObject("listSaleProduct", listSaleProduct);
        mav.addObject("listBestselling", listBestselling);
        mav.addObject("firstBrand", firstBrand);
        mav.addObject("secondBrand", secondBrand);
        mav.addObject("thirdBrand", thirdBrand);
        mav.addObject("listProductFirstBrand", listProductFirstBrand);
        mav.addObject("listProductSecondBrand", listProductSecondBrand);
        mav.addObject("listProductThirdBrand", listProductThirdBrand);
        mav.addObject("listBrandsShowLogo", listBrandsShowLogo);
        return mav;
    }

    public List<ProductDetail> getListSuggestProduct(String type) {
        List<Products> rawListProduct = productModel.getSuggestProducts(type);
        List<ProductDetail> listProduct = new ArrayList<>();
        for (Products product : rawListProduct) {
            ProductDetail suggestProduct = new ProductDetail();
            //lay thong tin san pham
            suggestProduct.setProduct(product);

            //lay gia sau sale cua san pham
            int saleId = 0;
            //kiem tra saleId co ton tai khong va gan gia tri
            if (product.getSales() != null) {
                saleId = product.getSales().getSaleId();
            }
            //tinh gia sau khi giam
            int salePercentage = saleModel.getPercentageBySellId(saleId);
            float salePrice = (float) product.getPrice() - ((float) product.getPrice() * salePercentage / 100);
            BigDecimal roundSalePrice = new BigDecimal(Float.toString(salePrice));
            salePrice = roundSalePrice.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
            suggestProduct.setSalePrice(salePrice);
            
            //lay 1 hinh anh cua san pham
            ProductImages productImage = productImageModel.getOneProductImageByProductId(product.getProductId());
            suggestProduct.setImage(productImage);
            
            //lay danh sach size hien co
            List<Sizes> productSize = sizeModel.getSizeByProductId(product.getProductId());
            if(productSize==null){
                suggestProduct.setAvailable(false);
            }else{
                suggestProduct.setAvailable(false);
                for (Sizes size : productSize) {
                    if(size.getStock()>0){
                        suggestProduct.setAvailable(true);
                        break;
                    }
                }
            }
            suggestProduct.setListSize(productSize);
            
            //them vao listProduct
            listProduct.add(suggestProduct);        
        }
        return listProduct;
    }
    
}
