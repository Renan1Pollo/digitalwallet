package br.com.renanpollo.digitalwallet.transaction.infrastructure.persistence;

import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import br.com.renanpollo.digitalwallet.transaction.domain.ports.ITransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository implements ITransactionRepository {
    private final TransactionJpaRepository transactionJpaRepository;

    public TransactionRepository(TransactionJpaRepository transactionJpaRepository) {
        this.transactionJpaRepository = transactionJpaRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionJpaRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionJpaRepository.findAll();
    }

    @Override
    public List<Transaction> findByPayee(Long payee) {
        return transactionJpaRepository.findByPayee(payee);
    }
}
