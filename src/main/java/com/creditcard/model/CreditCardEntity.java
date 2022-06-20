package com.creditcard.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "creditCardApp")
@ToString
@Getter
@Setter
@Data
public class CreditCardEntity implements Serializable {


    @Column(name = "cardName")
    private String creditCardName;

    @Column(name = "cardNumber")
    @Id
    private String cardNumber;

    @Column(name = "cardLimit")
    private String CreditLimit;




}
