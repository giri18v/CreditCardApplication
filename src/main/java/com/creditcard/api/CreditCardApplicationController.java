package com.creditcard.api;

import com.creditcard.app.api.CreditCardApi;
import com.creditcard.app.model.CreditCardInformationResponse;
import com.creditcard.app.model.CreditCardRequest;
import com.creditcard.app.model.GetAllCreditCardDetails;
import com.creditcard.app.model.GetAllCreditCardDetailsCreditCardDetails;
import com.creditcard.model.CreditCardEntity;
import com.creditcard.service.CreditCardApplicationService;
import com.creditcard.util.EntityConversion;
import com.creditcard.util.RequestValidation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/public/v1")
public class CreditCardApplicationController implements CreditCardApi {

    @Autowired
    CreditCardApplicationService creditCardApplicationService;


    @Override
    public ResponseEntity<CreditCardInformationResponse> addNewCreditCard(CreditCardRequest creditCardRequest) {

        CreditCardInformationResponse creditCardInformationResponse = new CreditCardInformationResponse();
        CreditCardEntity creditCardEntity = new CreditCardEntity();
        log.info("Started adding CreditCard info");

        RequestValidation.validateRequestDTO(creditCardRequest, creditCardEntity);
        creditCardEntity = creditCardApplicationService.addNewCreditCardDetails(creditCardEntity);
        if(Objects.nonNull(creditCardEntity)) {
            creditCardInformationResponse.setStatus("SUCCESS");
        }
        log.info("End");

        return new ResponseEntity<>(creditCardInformationResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GetAllCreditCardDetails> getCreditCardDetails() {
        GetAllCreditCardDetails getAllCreditCardDetails = new GetAllCreditCardDetails();

        log.info("Started getCreditCardDetails");

        List<CreditCardEntity> creditCardEntity = creditCardApplicationService.getAllCardDetails();

        if (!creditCardEntity.isEmpty()) {
            List<GetAllCreditCardDetailsCreditCardDetails> cardDetails = EntityConversion.getListOfCards(creditCardEntity);

            getAllCreditCardDetails.setCreditCardDetails(cardDetails);
        }

        log.info("Started getCreditCardDetails");

        return new ResponseEntity<>(getAllCreditCardDetails, HttpStatus.OK);
    }
}
