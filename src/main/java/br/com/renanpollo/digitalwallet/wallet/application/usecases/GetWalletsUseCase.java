package br.com.renanpollo.digitalwallet.wallet.application.usecases;

import br.com.renanpollo.digitalwallet.wallet.domain.entity.Wallet;

import java.util.List;

public interface GetWalletsUseCase {
    List<Wallet> findAll();
    Wallet findWalletById(Long id);
}
