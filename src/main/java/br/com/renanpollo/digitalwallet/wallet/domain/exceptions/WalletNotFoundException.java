package br.com.renanpollo.digitalwallet.wallet.domain.exceptions;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(Long id) {
        super("Wallet with id " + id + " not found.");
    }
}
