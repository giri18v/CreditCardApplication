package com.creditcard.util;

import com.creditcard.app.model.GetAllCreditCardDetailsCreditCardDetails;
import com.creditcard.model.CreditCardEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EntityConversion {

    public static List<GetAllCreditCardDetailsCreditCardDetails> getListOfCards(List<CreditCardEntity> creditCardEntities){

        List<GetAllCreditCardDetailsCreditCardDetails> listOfDetails = new ArrayList<>();

        GetAllCreditCardDetailsCreditCardDetails getAllCreditCardDetailsCreditCardDetails = new GetAllCreditCardDetailsCreditCardDetails();

        for(CreditCardEntity entity : creditCardEntities){
            getAllCreditCardDetailsCreditCardDetails.setName(entity.getCreditCardName());
            getAllCreditCardDetailsCreditCardDetails.setCardNumber(entity.getCardNumber());
            getAllCreditCardDetailsCreditCardDetails.setLimit(entity.getCreditLimit());
            listOfDetails.add(getAllCreditCardDetailsCreditCardDetails);
        }
        return listOfDetails;
    }


}
