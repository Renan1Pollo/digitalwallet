package br.com.renanpollo.digitalwallet.wallet.domain.entity;

public enum WalletType {
    COMMON(1), MERCHANT(2);

    private final int value;

    WalletType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}