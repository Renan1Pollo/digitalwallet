package br.com.renanpollo.digitalwallet.wallet.application.usecases;

import br.com.renanpollo.digitalwallet.shared.annotations.UseCase;
import br.com.renanpollo.digitalwallet.wallet.domain.entity.Wallet;
import br.com.renanpollo.digitalwallet.wallet.domain.ports.IWalletRepository;

import java.util.List;

@UseCase
public class GetWallets implements GetWalletsUseCase {
    private final IWalletRepository walletRepository;

    public GetWallets(IWalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findWalletById(Long id) {
        return walletRepository.findById(id);
    }
}
