package com.sample.common.model.response;

import lombok.Data;

import java.util.List;

@Data
public class GetFeedbacksByBikerResponse {

    private List<Feedback> feedbacks;
}
