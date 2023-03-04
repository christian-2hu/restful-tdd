package com.SpringTdd.services;

import java.util.Optional;
import com.SpringTdd.models.Costumer;
import com.SpringTdd.repository.CostumerRepository;
import com.SpringTdd.services.exceptions.DuplicateEmailException;

public class CostumerServiceImpl implements CostumerService {

    CostumerRepository costumerRepository;

    public CostumerServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public Costumer save(Costumer testCostumer) {
        Optional<Costumer> duplicateEmail = costumerRepository.findByEmail(testCostumer.getEmail());
        if (duplicateEmail.isPresent()) {
            throw new DuplicateEmailException();
        }

        return costumerRepository.save(testCostumer);
    }
}
