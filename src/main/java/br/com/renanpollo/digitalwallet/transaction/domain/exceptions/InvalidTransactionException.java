package br.com.renanpollo.digitalwallet.transaction.domain.exceptions;

public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}