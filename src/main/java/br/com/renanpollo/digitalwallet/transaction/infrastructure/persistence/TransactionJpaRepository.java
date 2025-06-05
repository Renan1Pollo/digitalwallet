package br.com.renanpollo.digitalwallet.transaction.infrastructure.persistence;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TransactionJpaRepository extends ListCrudRepository<Transaction, Long> {
    List<Transaction> findByPayee(Long payee);
}
