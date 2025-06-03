package br.com.renanpollo.digitalwallet.wallet.domain;

public enum WalletType {
    COMUM(1), LOJISTA(2);

    private final int value;

    WalletType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}