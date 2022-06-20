package com.creditcard.app;

import com.creditcard.api.CreditCardApplicationController;
import com.creditcard.app.model.CreditCardInformationResponse;
import com.creditcard.app.model.CreditCardRequest;
import com.creditcard.app.model.GetAllCreditCardDetails;
import com.creditcard.app.model.GetAllCreditCardDetailsCreditCardDetails;
import com.creditcard.model.CreditCardEntity;
import com.creditcard.repository.CreditCardRepository;
import com.creditcard.service.CreditCardApplicationService;
import com.creditcard.service.impl.CreditCardApplicationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreditCardApplicationTests {

	@Mock
	private CreditCardRepository creditCardRepository;

	@Autowired
	CreditCardApplicationService creditCardApplicationService;


	@BeforeEach
	void setup(){
		creditCardApplicationService = new CreditCardApplicationServiceImpl(creditCardRepository);
	}

	@Test
	void shouldReturnValidResponseForAddNewCreditCard() {
		Mockito.when(creditCardRepository.save(Mockito.any())).thenReturn(getEntity());
		CreditCardRequest request = getRequest();
		ResponseEntity<CreditCardInformationResponse> actualResponse = new CreditCardApplicationController(creditCardApplicationService).addNewCreditCard(request);
		CreditCardInformationResponse creditCardInformationResponse = new CreditCardInformationResponse();
		creditCardInformationResponse.setStatus("SUCCESS");
		Assertions.assertEquals(actualResponse,new ResponseEntity<>(creditCardInformationResponse, HttpStatus.OK));
	}


	@Test
	void shouldReturnValidResponseForGetAllCreditCardDetails() {
		Mockito.when(creditCardRepository.findAll()).thenReturn(getEntityList());
		CreditCardRequest request = getRequest();
		ResponseEntity<GetAllCreditCardDetails> actualResponse = new CreditCardApplicationController(creditCardApplicationService).getCreditCardDetails();
		GetAllCreditCardDetails creditCardInformationResponse = new GetAllCreditCardDetails();
		List<GetAllCreditCardDetailsCreditCardDetails> list = new ArrayList<>();
		GetAllCreditCardDetailsCreditCardDetails details = new GetAllCreditCardDetailsCreditCardDetails();
		details.setName("HSBC");
		details.setCardNumber("1358954993914435");
		details.setLimit("10000");
		list.add(details);
		creditCardInformationResponse.setCreditCardDetails(list);
		Assertions.assertEquals(actualResponse,new ResponseEntity<>(creditCardInformationResponse, HttpStatus.OK));
	}



	private CreditCardRequest getRequest(){

		CreditCardRequest creditCardRequest = new CreditCardRequest();
		creditCardRequest.setName("HSBC");
		creditCardRequest.setCardNumber("1358954993914435");
		creditCardRequest.setLimit("10000");
		return creditCardRequest;
	}
	private CreditCardEntity getEntity(){

		CreditCardEntity creditCardRequest = new CreditCardEntity();
		creditCardRequest.setCreditCardName("HSBC");
		creditCardRequest.setCardNumber("1358954993914435");
		creditCardRequest.setCreditLimit("10000");
		return creditCardRequest;
	}

	private List<CreditCardEntity> getEntityList(){
		List<CreditCardEntity> list = new ArrayList<>();
		CreditCardEntity creditCardRequest = new CreditCardEntity();
		creditCardRequest.setCreditCardName("HSBC");
		creditCardRequest.setCardNumber("1358954993914435");
		creditCardRequest.setCreditLimit("10000");
		list.add(creditCardRequest);
		return list;
	}



}
