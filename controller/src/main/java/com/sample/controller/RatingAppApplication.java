package com.sample.controller;


import com.sample.persistence.dao.DeliveryDAO;
import com.sample.persistence.entity.FeedbackEntity;
import com.sample.persistence.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.sample"})
@EntityScan(basePackages = {"com.sample"})
@EnableJpaRepositories(basePackages = {"com.sample"})
public class RatingAppApplication/* implements CommandLineRunner*/ {

    @Autowired
    private DeliveryDAO deliveryDAO;

    @Autowired
    private FeedbackService feedbackService;


    public static void main(String[] args) {
        SpringApplication.run(RatingAppApplication.class, args);
    }

/*    @Override
    public void run(String... args) throws Exception {
        *//*BikerEntity biker = new BikerEntity();
        biker.setFirstName("another-random-first-name");
        biker.setLastName("another-random-last-name");
        biker.setPhoneNumber("09129876543");
        biker.setIdCode("0987654321");
        biker.setVehicleId("12j383-93");


        DeliveryEntity delivery = new DeliveryEntity();
        delivery.setDeliveryDate(new Date());
        delivery.setDestinationAddress("destination");
        delivery.setSourceAddress("source");
        delivery.setBiker(biker);
        biker.setDeliveries(List.of(delivery));
        deliveryDAO.save(delivery);*//*
        FeedbackEntity entity = feedbackService.getFeedbackById(1L);
        System.out.println(entity.getDelivery().getId());


    }*/
}
