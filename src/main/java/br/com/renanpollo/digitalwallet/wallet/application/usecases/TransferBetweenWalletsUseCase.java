package br.com.renanpollo.digitalwallet.wallet.application.usecases;

import java.math.BigDecimal;

public interface TransferBetweenWalletsUseCase {
    void transfer(Long payerId, Long payeeId, BigDecimal amount);
}
