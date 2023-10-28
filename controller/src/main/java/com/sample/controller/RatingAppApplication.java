package com.sample.controller;


import com.sample.common.model.general.Operation;
import com.sample.common.model.general.Role;
import com.sample.common.model.general.User;
import com.sample.persistence.dao.DeliveryDAO;
import com.sample.persistence.dao.UserDAO;
import com.sample.persistence.entity.BikerEntity;
import com.sample.persistence.entity.DeliveryEntity;
import com.sample.persistence.service.FeedbackService;
import com.sample.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.Set;


@SpringBootApplication(scanBasePackages = {"com.sample"})
@EntityScan(basePackages = {"com.sample"})
@EnableJpaRepositories(basePackages = {"com.sample"})
public class RatingAppApplication implements CommandLineRunner {

    @Autowired
    private DeliveryDAO deliveryDAO;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserDAO userDAO;


    public static void main(String[] args) {
        SpringApplication.run(RatingAppApplication.class, args);
    }

    // for testing purpose
    @Override
    public void run(String... args) throws Exception {

        Operation operation = new Operation();
        operation.setName("READ");

        Role role = new Role();
        role.setName("ADMIN");
        role.setOperations(Set.of(operation));

        User user = new User();
        user.setFirstName("Alireza");
        user.setLastName("Nasirian");
        user.setUsername("a.nasirian");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode("1234"));
        user.setPhoneNumber("09121111111");
        user.setIdCode("1234567890");
        user.setRoles(Set.of(role));
        userService.save(user);
        BikerEntity biker = new BikerEntity();
        biker.setFirstName("another-random-first-name");
        biker.setLastName("another-random-last-name");
        biker.setPhoneNumber("09129876543");
        biker.setIdCode("0987654321");
        biker.setVehicleId("12j383-93");


        DeliveryEntity delivery = new DeliveryEntity();
        delivery.setDeliveryDate(new Date());
        delivery.setDestinationAddress("destination");
        delivery.setSourceAddress("source");
        delivery.setUser(userDAO.getReferenceById(1L));
        deliveryDAO.save(delivery);


    }
}
