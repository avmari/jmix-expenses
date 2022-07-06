package com.company.jmixexpenses.exception;

public class ExceedingFundsLimitException extends RuntimeException{

    public ExceedingFundsLimitException(){
        super("Exceeds the funds limit per person per month");
    }
}
