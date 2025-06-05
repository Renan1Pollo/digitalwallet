package br.com.renanpollo.digitalwallet.wallet.infrastructure.persistence;

import br.com.renanpollo.digitalwallet.wallet.domain.entity.Wallet;
import br.com.renanpollo.digitalwallet.wallet.domain.exceptions.WalletNotFoundException;
import br.com.renanpollo.digitalwallet.wallet.domain.ports.IWalletRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class WalletRepository implements IWalletRepository {
    private final WalletJpaRepository walletJpaRepository;

    public WalletRepository(WalletJpaRepository walletJpaRepository) {
        this.walletJpaRepository = walletJpaRepository;
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletJpaRepository.save(wallet);
    }

    @Override
    public List<Wallet> findAll() {
        Iterable<Wallet> iterable = walletJpaRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList();
    }

    @Override
    public Wallet findById(Long id) {
        return walletJpaRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException(id));
    }
}
