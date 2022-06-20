package com.creditcard.service;



import com.creditcard.model.CreditCardEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditCardApplicationService {

    CreditCardEntity addNewCreditCardDetails(CreditCardEntity creditCardRequest);

    List<CreditCardEntity> getAllCardDetails();

}
