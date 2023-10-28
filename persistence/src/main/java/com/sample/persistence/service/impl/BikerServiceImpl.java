package com.sample.persistence.service.impl;

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
    @Override
    public Double getBikerRateById_Top_Bottom(Long id) {
        BikerEntity bikerEntity = bikerDAO.getReferenceById(id);
        List<FeedbackEntity> feedbacks = bikerEntity.getFeedbacks();
        double averageRate = 0;
        if (!feedbacks.isEmpty()) {
            long top = bikerEntity.getFeedbacks().stream()
                    .filter(a -> a.getRate() == RateEntity.FIVE_STAR || a.getRate() == RateEntity.FOUR_STAR).count();
            long bottom = bikerEntity.getFeedbacks().stream()
                    .filter(a -> a.getRate() == RateEntity.ONE_STAR || a.getRate() == RateEntity.TWO_STAR ||
                            a.getRate() == RateEntity.FOUR_STAR || a.getRate() == RateEntity.FIVE_STAR).count();

            averageRate = (double) ((top/bottom) * 5);
        }
        return averageRate;
    }

    @Override
    public Double getBikerRateById_withOutOutliers(Long id) {
        BikerEntity bikerEntity = bikerDAO.getReferenceById(id);
        List<FeedbackEntity> feedbacks = bikerEntity.getFeedbacks();
        double averageRate = 0;
        if (!feedbacks.isEmpty()) {
            double average = feedbacks.stream().mapToInt(a -> a.getRate().getValue()).average().orElse(0.0);
            double sumSquaredDiff = feedbacks.stream().mapToDouble(a -> Math.pow(a.getRate().getValue() - average, 2)).sum();
            double stdDev = Math.sqrt(sumSquaredDiff/feedbacks.size());
            List<Integer> filteredRatings = feedbacks.stream().mapToInt(a -> a.getRate().getValue()).filter(a -> (Math.abs(a - average) <= 2*stdDev)).boxed().toList();
            if (filteredRatings.isEmpty()) {
                return 0.0;
            }
            averageRate = filteredRatings.stream().mapToInt(a -> a).average().orElse(0.0);
        }
        return averageRate;
    }


}
