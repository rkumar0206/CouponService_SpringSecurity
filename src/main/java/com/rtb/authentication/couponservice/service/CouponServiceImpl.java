package com.rtb.authentication.couponservice.service;

import com.rtb.authentication.couponservice.model.Coupon;
import com.rtb.authentication.couponservice.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;

    @Override
    public Coupon save(Coupon coupon) {

        return couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon getCouponByCode(String code) {
        return couponRepository.findByCode(code);
    }
}
