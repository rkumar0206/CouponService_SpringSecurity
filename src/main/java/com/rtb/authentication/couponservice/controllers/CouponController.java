package com.rtb.authentication.couponservice.controllers;

import com.rtb.authentication.couponservice.model.Coupon;
import com.rtb.authentication.couponservice.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CouponController {

    @Autowired
    private CouponService couponService;

//    @GetMapping("/")
//    public String index() {
//
//        return "index";
//    }

    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon() {

        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String save(Coupon coupon) {

        couponService.save(coupon);
        return "createResponse";
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon() {

        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(String code) {

        ModelAndView mv= new ModelAndView("couponDetails");
        mv.addObject(couponService.getCouponByCode(code));
        return mv;

    }

}
