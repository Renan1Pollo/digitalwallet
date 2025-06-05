package br.com.renanpollo.digitalwallet.wallet.application.usecases;

import br.com.renanpollo.digitalwallet.shared.annotations.UseCase;
import br.com.renanpollo.digitalwallet.wallet.domain.ports.IWalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@UseCase
public class TransferBetweenWallets implements TransferBetweenWalletsUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferBetweenWallets.class);
    private final IWalletRepository walletRepository;

    public TransferBetweenWallets(IWalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void transfer(Long payer, Long payee, BigDecimal amount) {
        LOGGER.info("Iniciando transferência de R${} da carteira {} para {}", amount, payer, payee);

        var walletPayer = walletRepository.findById(payer);
        var walletPayee = walletRepository.findById(payee);
        walletRepository.save(walletPayer.debit(amount));
        walletRepository.save(walletPayee.credit(amount));

        LOGGER.info("Transferência concluída com sucesso: R${} de {} para {}", amount, payer, payee);
    }
}
