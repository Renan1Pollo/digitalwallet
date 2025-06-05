package br.com.renanpollo.digitalwallet.transaction.infrastructure.controller;

import br.com.renanpollo.digitalwallet.transaction.application.usecases.CreateTransaction;
import br.com.renanpollo.digitalwallet.transaction.application.usecases.GetTransactions;
import br.com.renanpollo.digitalwallet.transaction.domain.entity.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final CreateTransaction createTransaction;
    private final GetTransactions getTransactions;

    public TransactionController(CreateTransaction createTransaction, GetTransactions getTransactions) {
        this.createTransaction = createTransaction;
        this.getTransactions = getTransactions;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return createTransaction.createTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> findAllTransactions() {
        return getTransactions.findAll();
    }

    @GetMapping("/payee/{payee}")
    public List<Transaction> findByPayee(@PathVariable Long payee) {
        return getTransactions.findTransactionByPayee(payee);
    }
}
