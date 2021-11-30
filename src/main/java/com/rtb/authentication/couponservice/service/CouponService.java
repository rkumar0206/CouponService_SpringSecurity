package com.rtb.authentication.couponservice.service;

import com.rtb.authentication.couponservice.model.Coupon;

import java.util.List;

public interface CouponService {

    Coupon save(Coupon coupon);

    List<Coupon> getAllCoupons();

    Coupon getCouponByCode(String code);
}
