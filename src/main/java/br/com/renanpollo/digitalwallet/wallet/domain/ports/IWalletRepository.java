package br.com.renanpollo.digitalwallet.wallet.domain.ports;

import br.com.renanpollo.digitalwallet.wallet.domain.entity.Wallet;
import br.com.renanpollo.digitalwallet.wallet.domain.exceptions.WalletNotFoundException;

import java.util.List;

public interface IWalletRepository {
    List<Wallet> findAll();
    Wallet findById(Long id) throws WalletNotFoundException;
    Wallet save(Wallet wallet);
}
