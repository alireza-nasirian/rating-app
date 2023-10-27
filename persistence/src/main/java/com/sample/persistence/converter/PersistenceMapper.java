package com.sample.persistence.converter;

import com.sample.common.model.enumeration.Rate;
import com.sample.common.model.general.Biker;
import com.sample.common.model.general.Delivery;
import com.sample.common.model.request.Feedback;
import com.sample.persistence.entity.BikerEntity;
import com.sample.persistence.entity.DeliveryEntity;
import com.sample.persistence.entity.FeedbackEntity;
import com.sample.persistence.entity.RateEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {

    Delivery fromDeliveryEntity(DeliveryEntity entity);

    FeedbackEntity toFeedbackEntity(Feedback model);

    List<com.sample.common.model.response.Feedback> fromFeedbackEntityList(List<FeedbackEntity> list);

    RateEntity toRateEntity(Rate rate);

    Biker fromBikerEntity(BikerEntity entity);
}
