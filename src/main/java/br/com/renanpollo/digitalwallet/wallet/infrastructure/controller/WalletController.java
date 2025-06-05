package br.com.renanpollo.digitalwallet.wallet.infrastructure.controller;

import br.com.renanpollo.digitalwallet.wallet.application.usecases.GetWallets;
import br.com.renanpollo.digitalwallet.wallet.domain.entity.Wallet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final GetWallets getWallets;

    public WalletController(GetWallets getWallets) {
        this.getWallets = getWallets;
    }

    @GetMapping
    public List<Wallet> getAllWallets() {
        return getWallets.findAll();
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Long id) {
        return getWallets.findWalletById(id);
    }
}
