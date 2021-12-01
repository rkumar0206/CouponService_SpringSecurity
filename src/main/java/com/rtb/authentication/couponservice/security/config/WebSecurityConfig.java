package com.rtb.authentication.couponservice.security.config;

import com.rtb.authentication.couponservice.security.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailServiceImpl userDetailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin();


        // preferred for rest APIs -
        // (
        // antMatchers have certain drawbacks like,
        // it will treat /couponsapi/coupons and /couponapi/coupons/ different while mvcMatchers treat it as same.
        // mvcMatcher support extensions
        // )
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET,
                        "/couponapi/coupons/{code:[A-Z]*$}",
                        "/index",
                        "/showGetCoupon",
                        "/getCoupon",
                        "/couponDetails"
                ) // we can use /** or use regular expressions
                .hasAnyRole("USER", "ADMIN")
                .mvcMatchers(HttpMethod.GET, "/showCreateCoupon", "/createCoupon", "/createResponse").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("USER", "ADMIN")
                .mvcMatchers(HttpMethod.POST, "/couponapi/coupons", "/saveCoupon").hasRole("ADMIN")
                .mvcMatchers("/", "/login", "/logout", "/showReg", "/registerUser").permitAll()
                .anyRequest().denyAll()
                .and()
                .csrf().disable()
                .logout()
                .logoutSuccessUrl("/");
        //.invalidateHttpSession(); // invalidate the session
        //.deleteCookies(""); // delete cookies

    }

    // this authentication manager bean has to be exposed out for our custom login form
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
