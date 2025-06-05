package br.com.renanpollo.digitalwallet.wallet.infrastructure.persistence;

import br.com.renanpollo.digitalwallet.wallet.domain.entity.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletJpaRepository extends CrudRepository<Wallet, Long> {
}

