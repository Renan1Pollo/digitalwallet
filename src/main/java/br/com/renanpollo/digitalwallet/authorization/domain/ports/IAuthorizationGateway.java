package br.com.renanpollo.digitalwallet.authorization.domain.ports;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;

public interface IAuthorizationGateway {
    boolean isAuthorized(Transaction transaction);
}
