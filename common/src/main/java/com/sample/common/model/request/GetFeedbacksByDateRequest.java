package com.sample.common.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class GetFeedbacksByDateRequest {

    private Date from;
    private Date to;

}
