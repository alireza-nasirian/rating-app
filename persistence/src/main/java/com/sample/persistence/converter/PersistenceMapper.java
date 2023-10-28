package com.sample.persistence.converter;

import com.sample.common.model.enumeration.Rate;
import com.sample.common.model.general.Biker;
import com.sample.common.model.general.Delivery;
import com.sample.common.model.general.User;
import com.sample.common.model.request.Feedback;
import com.sample.persistence.entity.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {

    Delivery fromDeliveryEntity(DeliveryEntity entity);

    FeedbackEntity toFeedbackEntity(Feedback model);

    List<com.sample.common.model.response.Feedback> fromFeedbackEntityList(List<FeedbackEntity> list);

    RateEntity toRateEntity(Rate rate);

    Biker fromBikerEntity(BikerEntity entity);

    com.sample.common.model.response.Feedback fromFeedbackEntity(FeedbackEntity referenceById);

    User fromUserEntityToUser(UserEntity userEntitiesByUsername);

    UserEntity fromUserToUserEntity(User user);
}
