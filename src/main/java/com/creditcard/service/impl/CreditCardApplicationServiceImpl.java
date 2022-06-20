package com.creditcard.service.impl;

import com.creditcard.model.CreditCardEntity;
import com.creditcard.repository.CreditCardRepository;
import com.creditcard.service.CreditCardApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CreditCardApplicationServiceImpl implements CreditCardApplicationService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public CreditCardEntity addNewCreditCardDetails(CreditCardEntity creditCardRequest) {

        return creditCardRepository.save(creditCardRequest);
    }

    @Override
    public List<CreditCardEntity> getAllCardDetails() {
        return creditCardRepository.findAll();
    }
}
