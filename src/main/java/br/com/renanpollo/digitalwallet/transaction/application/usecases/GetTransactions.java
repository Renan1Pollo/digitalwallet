package br.com.renanpollo.digitalwallet.transaction.application.usecases;

import br.com.renanpollo.digitalwallet.shared.annotations.UseCase;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import br.com.renanpollo.digitalwallet.transaction.domain.ports.ITransactionRepository;

import java.util.List;

@UseCase
public class GetTransactions implements GetTransactionsUseCase {
    private final ITransactionRepository transactionRepository;

    public GetTransactions(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> findTransactionByPayee(Long payee) {
        return transactionRepository.findByPayee(payee);
    }
}
