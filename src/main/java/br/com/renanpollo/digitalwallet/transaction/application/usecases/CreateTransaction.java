package br.com.renanpollo.digitalwallet.transaction.application.usecases;

import br.com.renanpollo.digitalwallet.authorization.application.usecases.AuthorizeTransaction;
import br.com.renanpollo.digitalwallet.notification.application.usecases.NotifyTransaction;
import br.com.renanpollo.digitalwallet.shared.annotations.UseCase;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import br.com.renanpollo.digitalwallet.transaction.domain.ports.ITransactionRepository;
import br.com.renanpollo.digitalwallet.wallet.application.usecases.TransferBetweenWallets;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class CreateTransaction implements CreateTransactionUseCase {
    private final ITransactionRepository transactionRepository;
    private final TransferBetweenWallets transferBetweenWallets;
    private final ValidateTransaction validateTransaction;
    private final AuthorizeTransaction authorizeTransaction;
    private final NotifyTransaction notifyTransaction;

    public CreateTransaction(ITransactionRepository transactionRepository,
                             TransferBetweenWallets transferBetweenWallets,
                             ValidateTransaction validateTransaction,
                             AuthorizeTransaction authorizeTransaction,
                             NotifyTransaction notifyTransaction) {
        this.transactionRepository = transactionRepository;
        this.transferBetweenWallets = transferBetweenWallets;
        this.validateTransaction = validateTransaction;
        this.authorizeTransaction = authorizeTransaction;
        this.notifyTransaction = notifyTransaction;
    }

    @Override
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        validateTransaction.validate(transaction);
        authorizeTransaction.authorize(transaction);

        var newTransaction = transactionRepository.save(transaction);
        transferBetweenWallets.transfer(transaction.payer(), transaction.payee(), transaction.value());
//        notifyTransaction.notify(newTransaction);

        return newTransaction;
    }
}
