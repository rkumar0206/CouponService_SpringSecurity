package com.rtb.authentication.couponservice;

import com.rtb.authentication.couponservice.model.Coupon;
import com.rtb.authentication.couponservice.model.Role;
import com.rtb.authentication.couponservice.model.User;
import com.rtb.authentication.couponservice.repository.CouponRepository;
import com.rtb.authentication.couponservice.repository.RoleRepository;
import com.rtb.authentication.couponservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@SpringBootApplication
public class CouponServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

 /*   @Bean
    CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository, CouponRepository couponRepository) {

        return args -> {

            couponRepository.save(new Coupon("SUPERSALE", BigDecimal.valueOf(10.0), "12/12/2021"));

            Role role1 = new Role("ROLE_ADMIN");
            Role role2 = new Role("ROLE_USER");

            roleRepository.save(role1);
            roleRepository.save(role2);

            User user1 = new User("rohit", "kumar", "rkumar0206@gmail.com",
                    new BCryptPasswordEncoder().encode("rohit"));

            user1.addRole(role1);

            User user2 =  new User("mohit", "kumar", "mkumar0208@gmail.com",
                    new BCryptPasswordEncoder().encode("mohit"));

            user2.addRole(role2);

            userRepository.save(user1);

            userRepository.save(user2);

        };
    }*/
}
