package com.sample.persistence.converter;

import com.sample.common.model.general.Delivery;
import com.sample.common.model.general.Feedback;
import com.sample.persistence.entity.DeliveryEntity;
import com.sample.persistence.entity.FeedbackEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PersistenceMapper {

    Delivery fromDeliveryEntity(DeliveryEntity entity);

    FeedbackEntity toFeedbackEntity(Feedback model);
}
