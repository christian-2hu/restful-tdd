package com.SpringTdd.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.SpringTdd.models.Costumer;
import com.SpringTdd.repository.CostumerRepository;
import com.SpringTdd.services.exceptions.DuplicateEmailException;

@DisplayName("Service layer test.")
@ExtendWith(MockitoExtension.class)
public class CostumerServiceTest {

    private CostumerService costumerService;

    @Mock
    private CostumerRepository costumerRepository;

    private Costumer testCostumer;

    private String costumerFirstName = "John";
    private String costumerLastName = "Titor";
    private String costumerEmail = "john.titor@email.com";
    private String costumerGender = "Male";
    private String costumerCC = "123321";

    @BeforeEach
    public void setup() {
        costumerService = new CostumerServiceImpl(costumerRepository);
        testCostumer = new Costumer();
        testCostumer.setFirstName(costumerFirstName);
        testCostumer.setLastName(costumerLastName);
        testCostumer.setEmail(costumerEmail);
        testCostumer.setGender(costumerGender);
        testCostumer.setCreditCard(costumerCC);
    }

    @DisplayName("Test if costumer was saved on repository")
    @Test
    public void shouldSaveCostumerOnRepository() {
        Mockito.when(this.costumerRepository.save(testCostumer)).thenReturn(testCostumer);

        costumerService.save(testCostumer);
        verify(this.costumerRepository).save(testCostumer);
    }

    @DisplayName("Test if costumer's email already exists")
    @Test
    public void shouldNotSaveTwoCostumersWithTheSameEmail() {
        Mockito.when(this.costumerRepository.findByEmail(costumerEmail)).thenReturn(Optional.of(testCostumer));
        assertThrows(DuplicateEmailException.class, () -> costumerService.save(testCostumer));
    }
}
