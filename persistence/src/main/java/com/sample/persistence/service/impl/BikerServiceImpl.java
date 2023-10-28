package com.sample.persistence.service.impl;

import com.sample.common.model.general.Biker;
import com.sample.persistence.converter.PersistenceMapper;
import com.sample.persistence.dao.BikerDAO;
import com.sample.persistence.entity.BikerEntity;
import com.sample.persistence.entity.FeedbackEntity;
import com.sample.persistence.entity.RateEntity;
import com.sample.persistence.service.BikerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikerServiceImpl implements BikerService {

    private final BikerDAO bikerDAO;
    private final PersistenceMapper mapper;

    @Override
    public Biker getBikerById(Long id) {
        BikerEntity bikerEntity = bikerDAO.getReferenceById(id);
        List<FeedbackEntity> feedbacks = bikerEntity.getFeedbacks();
        double averageRate = 0;
        if (feedbacks.isEmpty()) {
            long top = bikerEntity.getFeedbacks().stream()
                    .filter(a -> a.getRate() == RateEntity.FIVE_STAR || a.getRate() == RateEntity.FOUR_STAR).count();
            long bottom = bikerEntity.getFeedbacks().stream()
                    .filter(a -> a.getRate() == RateEntity.ONE_STAR || a.getRate() == RateEntity.TWO_STAR ||
                            a.getRate() == RateEntity.FOUR_STAR || a.getRate() == RateEntity.FIVE_STAR).count();

            averageRate = (double) ((top/bottom) * 5);
        }
        Biker biker = mapper.fromBikerEntity(bikerEntity);
        biker.setAverageRate(averageRate);
        return biker;
    }
}
