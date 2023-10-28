package com.sample.persistence.service;

public interface BikerService {

    Double getBikerRateById_Top_Bottom (Long id);
    Double getBikerRateById_withOutOutlayers (Long id);
}
