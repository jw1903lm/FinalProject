/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import entity.Cart;
import entity.Cities;
import entity.OrderDetail;
import entity.OrderDetailId;
import entity.OrderInformation;
import entity.OrderStatus;
import entity.Orders;
import entity.ProductImages;
import entity.Products;
import entity.Ships;
import entity.Sizes;
import entity.Users;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;
import model.user.UserCitiesModel;
import model.user.UserOrderDetailModel;
import model.user.UserOrderStatusModel;
import model.user.UserOrdersModel;
import model.user.UserProductImageModel;
import model.user.UserProductModel;
import model.user.UserShipsModel;
import model.user.UserSizeModel;
import model.user.UserUsersModel;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhQuan
 */
@Controller
@RequestMapping(value = "/userOrderController")
public class UserOrderController extends UserAllController {

    private UserCitiesModel cityModel;
    private UserUsersModel userModel;
    private UserShipsModel shipsModel;
    private UserOrderStatusModel orderStatusModel;
    private UserOrdersModel orderModel;
    private UserOrderDetailModel orderDetailModel;
    private UserSizeModel sizeModel;
    private UserProductImageModel productImageModel;
    private UserProductModel productModel;

    public UserOrderController() {
        cityModel = new UserCitiesModel();
        userModel = new UserUsersModel();
        shipsModel = new UserShipsModel();
        orderStatusModel = new UserOrderStatusModel();
        orderModel = new UserOrdersModel();
        orderDetailModel = new UserOrderDetailModel();
        sizeModel = new UserSizeModel();
        productImageModel = new UserProductImageModel();
        productModel = new UserProductModel();
    }

    //thuc hien truoc khi checkout
    @RequestMapping(value = "/initCheckOut")
    public ModelAndView initCheckOut(int error, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        try {
            mav = new ModelAndView("user/jsp/checkout");
            //lay danh sach city
            List<Cities> listCities = cityModel.getAllCities();
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            //kiem tra co san pham trong cart hay khong
            boolean checkCart = true;
            if (listCart == null || listCart.isEmpty()) {
                checkCart = false;
            }
            //thong tin order
            Orders newOrder = new Orders();
            //thong tin user dang nhap
            Users loginCheckOutUser = new Users();
            //gui thong tin ra view
            mav.addObject("error", error);
            mav.addObject("listCities", listCities);
            mav.addObject("checkCart", checkCart);
            mav.addObject("newOrder", newOrder);
            mav.addObject("loginCheckOutUser", loginCheckOutUser);
        } catch (Exception e) {
            mav = new ModelAndView("redirect:/UserAllController/toError.htm");
        }
        mav = getHeaderAndFooter(mav, session);
        return mav;
    }

    //thuc hien luu order va order detail
    @RequestMapping(value = "/confirmCheckOut")
    public ModelAndView confirmCheckOut(Orders newOrder, HttpSession session, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        try {
            //bien xac ding loi
            int error = 0;
            //lay city
            Cities city = cityModel.getCityById(Integer.parseInt(request.getParameter("chooseCity")));
            newOrder.setCities(city);

            //lay ship
            List<Ships> listShips = shipsModel.getAllShips();
            for (Ships ship : listShips) {
                if (ship.getMinDistance() <= city.getDistance() && ship.getMaxDistance() >= city.getDistance()) {
                    newOrder.setShips(ship);
                    break;
                }
            }

            //lay gia them ship va cho vao order 
            double orderTotal = countTotalAmount(session) + (countTotalAmount(session) * 10 / 100) + newOrder.getShips().getFee();
            newOrder.setTotalPrice(orderTotal);
            //Kiem tra gio hang, neu rong thi khong thuc hien thanh toan
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            mav = new ModelAndView("user/jsp/confirmCheckout");

            //Them nguoi dung moi
            String newUserName = request.getParameter("newUserName");
            String newUserPassword = request.getParameter("newUserPassword");
            String retypePassword = request.getParameter("retypePassword");
            //truong hop nhap day du thong tin
            if (!newUserName.isEmpty() && !newUserPassword.isEmpty() && !retypePassword.isEmpty()) {
                Users newUserInformation = new Users();
                newUserInformation.setUserName(newUserName);
                newUserInformation.setUserPassword(newUserPassword);
                //kiem tra loi
                error = validateUser(newUserInformation, retypePassword);
                //thuc hien luu User moi
                if (error == 0) {
                    //tao doi tuong user moi, dien thong tin va luu
                    Users newUser = new Users();
                    newUser.setCities(city);
                    newUser.setUserName(newUserName);
                    newUser.setEmail(newOrder.getEmail());
                    newUser.setPhone(newOrder.getPhone());
                    newUser.setUserAddress(newOrder.getUserAddress());
                    newUser.setFullName(newOrder.getFullName());
                    //hashing va lay password
                    String hashingPassword = UserAllController.hashingPassword(newUserPassword);
                    newUser.setUserPassword(hashingPassword);
                    //tao doi tuong user moi, dien thong tin va luu
                    boolean check = userModel.insertUsers(newUser);
                    if (!check) {
                        mav = new ModelAndView("redirect:/UserAllController/toError.htm");
                    }
                } else {
                    mav = new ModelAndView("redirect:initCheckOut.htm?error=" + error);
                }
            }
            mav.addObject("newOrder", newOrder);
        } catch (Exception e) {
            mav = new ModelAndView("redirect:/UserAllController/toError.htm");
        }
        mav = getHeaderAndFooter(mav, session);
        return mav;
    }

    //thuc hien luu order va order detail
    @RequestMapping(value = "/checkOut")
    public ModelAndView checkOut(Orders newOrder, HttpSession session, HttpServletRequest request) {
        //bien xac ding loi
        int error = 0;
        //Kiem tra gio hang, neu rong thi khong thuc hien thanh toan
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        ModelAndView mav = new ModelAndView();
        if (listCart == null || listCart.isEmpty()) {
            mav = new ModelAndView("redirect:initCheckOut.htm?error=" + error);
        } else {
            //lay city
            newOrder.setCities(cityModel.getCityById(Integer.parseInt(request.getParameter("chooseCity"))));
            //lay ship
            newOrder.setShips(shipsModel.getShipById(Integer.parseInt(request.getParameter("ship"))));
            //lay order status
            List<OrderStatus> listOrderStatus = orderStatusModel.getAllOrderStatus();
            if (!listOrderStatus.isEmpty()) {
                newOrder.setOrderStatus(listOrderStatus.get(0));
            }
            //lay user neu co
            Users user = (Users) session.getAttribute("loginId");
            if (user != null) {
                newOrder.setUsers(user);
            }
            //them order vao CSDL
            boolean check = orderModel.insertOrder(newOrder);
            if (check) {
                //lay danh sach orderDetail
                Orders lastestOrder = orderModel.getLastestOrder();
                mav = new ModelAndView("redirect:initOrder.htm?orderId=" + lastestOrder.getOrderId());
                for (Cart cart : listCart) {
                    //kiem tra hang con trong kho hay khong
                    Sizes size = sizeModel.getSizeById(cart.getSize().getSizeId());
                    if (size.getStock() >= cart.getQuantity()) {
                        //tao orderDetailId
                        OrderDetailId orderDetailId = new OrderDetailId();
                        orderDetailId.setOrderId(lastestOrder.getOrderId());
                        orderDetailId.setSizeId(cart.getSize().getSizeId());
                        orderDetailId.setProductId(cart.getProduct().getProduct().getProductId());
                        //tao thong tin orderDetail
                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setId(orderDetailId);
                        orderDetail.setOrders(lastestOrder);
                        orderDetail.setSizes(cart.getSize());
                        orderDetail.setProducts(cart.getProduct().getProduct());
                        orderDetail.setQuantity(cart.getQuantity());
                        //lam tron gia tien
                        float bdTotalprice = cart.getTotalPrice();
                        BigDecimal roundDetailTotal = new BigDecimal(Float.toString(bdTotalprice));
                        double detailTotal = roundDetailTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        orderDetail.setTotalPrice(detailTotal);
                        //thuc hien luu orderDetail
                        if (!orderDetailModel.insertOrderDetail(orderDetail)) {
                            mav = new ModelAndView("redirect:/UserAllController/toError.htm");
                        } else {
                            //tru so luong tren CSDL sau khi xac nhan thanh toan
                            Sizes newSize = cart.getSize();
                            newSize.setStock(cart.getSize().getStock() - cart.getQuantity());
                            if (!sizeModel.updateSize(newSize)) {
                                mav = new ModelAndView("redirect:/UserAllController/toError.htm");
                            }
                            //cong them 1 vao best-selling
                            Products product = cart.getProduct().getProduct();
                            product.setBestSeller(product.getBestSeller() + 1);
                            if (!productModel.updateProduct(product)) {
                                mav = new ModelAndView("redirect:/UserAllController/toError.htm");
                            }
                            session.removeAttribute("listCart");
                        }
                    } else {
                        listCart.remove(cart);
                        error = 12;
                        mav = new ModelAndView("redirect:initCheckOut.htm?error=" + error);
                        session.setAttribute("listCart", listCart);
                        boolean checkOrder = orderModel.deleteOrder(lastestOrder);
                        if (!checkOrder) {
                            mav = new ModelAndView("redirect:/UserAllController/toError.htm");
                        }
                    }
                }
            } else {
                mav = new ModelAndView("redirect:/UserAllController/toError.htm");
            }
        }
        return mav;
    }

    //gui id order vao session
    @RequestMapping(value = "/initOrder")
    public String initOrder(int orderId, HttpSession session) {
        Orders viewOrder = (Orders) session.getAttribute("viewOrder");
        if (viewOrder == null) {
            viewOrder = new Orders();
            viewOrder.setOrderId(orderId);
        } else {
            viewOrder.setOrderId(orderId);
        }
        session.setAttribute("viewOrder", viewOrder);
        return "redirect:order.htm";
    }

    //gui ve trang thong tin order
    @RequestMapping(value = "/order")
    public ModelAndView order(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //lay id tren session
        Orders sessionOrders = (Orders) session.getAttribute("viewOrder");
        try {
            mav = new ModelAndView("user/jsp/order");
            //lay thong tin order va orderDetail
            Orders viewOrder = orderModel.getOrderByOrderId(sessionOrders.getOrderId());
            List<OrderDetail> listOrderDetail = orderDetailModel.getListByOrderId(sessionOrders.getOrderId());
            List<OrderInformation> listOrderInformation = new ArrayList<>();
            for (OrderDetail orderDetail : listOrderDetail) {
                OrderInformation orderInformation = new OrderInformation();
                //lay thong tin product
                orderInformation.setOrderDetail(orderDetail);
                //lay image
                ProductImages productImage = productImageModel.getOneProductImageByProductId(orderDetail.getProducts().getProductId());
                orderInformation.setImage(productImage);
                //lay sale price
                BigDecimal roundSalePrice = new BigDecimal(Double.toString(orderDetail.getTotalPrice() / orderDetail.getQuantity()));
                float salePrice = roundSalePrice.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                orderInformation.setSalePrice(salePrice);
                listOrderInformation.add(orderInformation);
            }
            //gui thong tin ra view
            mav.addObject("listOrderInformation", listOrderInformation);
            mav.addObject("viewOrder", viewOrder);
//            //xoa id khoi session
//            session.removeAttribute("viewOrder");
        } catch (Exception e) {
            mav = new ModelAndView("redirect:/initOrder?orderId="+sessionOrders.getOrderId());
        }
        mav = getHeaderAndFooter(mav, session);
        return mav;
    }
}
