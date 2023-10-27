package com.sample.persistence.service.impl;

import com.sample.common.model.general.Biker;
import com.sample.persistence.converter.PersistenceMapper;
import com.sample.persistence.dao.BikerDAO;
import com.sample.persistence.entity.BikerEntity;
import com.sample.persistence.service.BikerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BikerServiceImpl implements BikerService {

    private final BikerDAO bikerDAO;
    private final PersistenceMapper mapper;

    @Override
    public Biker getBikerById(Long id) {
        BikerEntity bikerEntity = bikerDAO.getReferenceById(id);
        Double averageRate = bikerEntity.getFeedbacks().stream().mapToInt(a -> a.getRate().getValue()).average().orElse(0.0);
        Biker biker = mapper.fromBikerEntity(bikerEntity);
        biker.setAverageRate(averageRate);
        return biker;
    }
}
