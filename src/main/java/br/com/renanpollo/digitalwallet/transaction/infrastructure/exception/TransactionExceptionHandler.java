package br.com.renanpollo.digitalwallet.transaction.infrastructure.exception;

import br.com.renanpollo.digitalwallet.authorization.domain.exceptions.UnauthorizedTransactionException;
import br.com.renanpollo.digitalwallet.transaction.domain.exceptions.InvalidTransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class TransactionExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionExceptionHandler.class);

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<String> handleUnauthorized(UnauthorizedTransactionException ex) {
        LOGGER.warn("Unauthorized transaction attempt: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<Object> handle(InvalidTransactionException exception) {
        LOGGER.warn("Invalid transaction: {}", exception.getMessage());
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}

