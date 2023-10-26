package com.sample.persistence.service.impl;

import com.sample.common.model.general.Delivery;
import com.sample.persistence.converter.PersistenceMapper;
import com.sample.persistence.dao.DeliveryDAO;
import com.sample.persistence.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryDAO deliveryDAO;
    private final PersistenceMapper mapper;

}
