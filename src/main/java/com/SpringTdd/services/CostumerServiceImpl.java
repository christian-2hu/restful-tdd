package com.SpringTdd.services;

import com.SpringTdd.models.Costumer;
import com.SpringTdd.repository.CostumerRepository;

public class CostumerServiceImpl implements CostumerService {

    CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public Costumer save(Costumer testCostumer) {
        return costumerRepository.save(testCostumer);
    }
}
