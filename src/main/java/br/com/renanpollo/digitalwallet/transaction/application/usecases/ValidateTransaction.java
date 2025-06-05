package br.com.renanpollo.digitalwallet.transaction.application.usecases;

import br.com.renanpollo.digitalwallet.shared.annotations.UseCase;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import br.com.renanpollo.digitalwallet.transaction.domain.exceptions.InvalidTransactionException;
import br.com.renanpollo.digitalwallet.wallet.domain.entity.Wallet;
import br.com.renanpollo.digitalwallet.wallet.domain.entity.WalletType;
import br.com.renanpollo.digitalwallet.wallet.domain.ports.IWalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@UseCase
public class ValidateTransaction implements ValidateTransactionUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateTransaction.class);
    private final IWalletRepository walletRepository;

    public ValidateTransaction(IWalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void validate(Transaction transaction) {
        LOGGER.info("validating transaction {}...", transaction);

        Wallet payer = walletRepository.findById(transaction.payer());
        Wallet payee = walletRepository.findById(transaction.payee());

        validateTransactionAmount(transaction);
        validateDifferentWallets(payer, payee);
        validatePayerIsNotMerchant(payer);
        validateSufficientBalance(payer, transaction);
    }

    private void validateTransactionAmount(Transaction transaction) {
        if (transaction.value() == null || transaction.value().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException("Transaction amount must be greater than zero.");
        }
    }

    private void validateDifferentWallets(Wallet payer, Wallet payee) {
        if (payer.id().equals(payee.id())) {
            throw new InvalidTransactionException("Payer and payee cannot be the same wallet.");
        }
    }

    private void validatePayerIsNotMerchant(Wallet payer) {
        if (payer.type() != WalletType.COMMON.getValue()) {
            throw new InvalidTransactionException("Only common wallets can initiate transfers.");
        }
    }

    private void validateSufficientBalance(Wallet payer, Transaction transaction) {
        if (payer.balance().compareTo(transaction.value()) < 0) {
            throw new InvalidTransactionException("Insufficient balance for this transaction.");
        }
    }
}
