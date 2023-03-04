package com.SpringTdd.repository;

import java.util.Optional;

import com.SpringTdd.models.Costumer;

public interface CostumerRepository {

    Costumer save(Costumer testCostumer);

    Optional<Costumer> findByEmail(String email);
}
