package br.com.renanpollo.digitalwallet.authorization.application.usecases;

import br.com.renanpollo.digitalwallet.authorization.domain.exceptions.UnauthorizedTransactionException;
import br.com.renanpollo.digitalwallet.authorization.domain.ports.IAuthorizationGateway;
import br.com.renanpollo.digitalwallet.shared.annotations.UseCase;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

@UseCase
public class AuthorizeTransaction implements AuthorizeTransactionUseCase {
    private final IAuthorizationGateway authorizationGateway;

    public AuthorizeTransaction(IAuthorizationGateway authorizationGateway) {
        this.authorizationGateway = authorizationGateway;
    }

    @Override
    public void authorize(Transaction transaction) {
        if (!authorizationGateway.isAuthorized(transaction)) {
            throw new UnauthorizedTransactionException("Transaction is not authorized by external service");
        }
    }
}
