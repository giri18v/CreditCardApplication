package com.creditcard.util;

import com.creditcard.app.model.CreditCardRequest;
import com.creditcard.exception.InvalidParamterException;
import com.creditcard.model.CreditCardEntity;

import java.util.Arrays;
import java.util.Objects;

public class RequestValidation {


    public static void validateRequestDTO(CreditCardRequest creditCardRequest, CreditCardEntity creditCardEntity) {
        validateRequestParameter("name", creditCardRequest.getName());
        validateRequestParameter("limit", creditCardRequest.getLimit());
        validateRequestParameter("cardNumber", creditCardRequest.getCardNumber());
        validateCardNumber(creditCardRequest.getCardNumber());
        creditCardEntity.setCreditCardName(creditCardRequest.getName());
        creditCardEntity.setCardNumber(creditCardRequest.getCardNumber());
        creditCardEntity.setCreditCardName(creditCardRequest.getLimit());


    }

    private static void validateRequestParameter(String inputKey, String inputValue) {
        if (Objects.nonNull(inputKey)) {
            return;
        }
        throw new InvalidParamterException("ERR-100", "Invalid Parameter");

    }

    public static void validateCardNumber(String cardNumber) {
        boolean validCreditCardNumber = isValidCreditCardNumber(cardNumber);

        if (validCreditCardNumber) {
            return;
        } else {
            throw new InvalidParamterException("ERR-100", "Invalid Card Number");
        }
    }



    public static boolean isValidCreditCardNumber(String cardNumber) {
        int[] cardIntArray = new int[cardNumber.length()];

        for (int i = 0; i < cardNumber.length(); i++) {
            char c = cardNumber.charAt(i);
            cardIntArray[i] = Integer.parseInt("" + c);
        }

        for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
            int num = cardIntArray[i];
            num = num * 2;
            if (num > 9) {
                num = num % 10 + num / 10;
            }
            cardIntArray[i] = num;
        }

        int sum = sumDigits(cardIntArray);

        System.out.println(sum);

        if (sum % 10 == 0) {
            return true;
        }

        return false;

    }

    public static int sumDigits(int[] arr) {
        return Arrays.stream(arr).sum();
    }


}
