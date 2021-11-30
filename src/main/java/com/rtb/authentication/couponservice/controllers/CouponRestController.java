package com.rtb.authentication.couponservice.controllers;

import com.rtb.authentication.couponservice.model.Coupon;
import com.rtb.authentication.couponservice.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
@RequiredArgsConstructor
public class CouponRestController {

    private final CouponService couponService;

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon) {

        return couponService.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable String code) {

        return couponService.getCouponByCode(code);
    }
}
