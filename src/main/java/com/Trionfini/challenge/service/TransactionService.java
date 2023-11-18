package com.Trionfini.challenge.service;

import com.Trionfini.challenge.model.Transaction;
import com.Trionfini.challenge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService{
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Retrieves all transactions.
     *
     * @return List of all transactions.
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * Retrieves a transaction by ID.
     *
     * @param transactionId ID from the transaction.
     * @return Transaction found, or null.
     */
    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    /**
     * Saves a new transaction ( ID auto generated).
     *
     * @param transaction The transaction to be saved.
     * @return The saved transaction (with assigned ID).
     */
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    /**
     * Updates an existing transaction.
     *
     * @param transactionId ID to match with transaction.
     * @param updatedTransaction The transaction with the updated data.
     * @return The updated transaction, or null if the original transaction is not found.
     */
    public Transaction updateTransaction(Long transactionId, Transaction updatedTransaction) {

        Optional<Transaction> transactionOp = transactionRepository.findById(transactionId);

        return transactionOp.map(transactionRepository::save).orElse(null);
    }

    /**
     * Deletes a transaction from the system by its unique identifier.
     *
     * @param transactionId Unique identifier of the transaction to delete.
     */
    public boolean deleteTransaction(Long transactionId) {
        Optional<Transaction> transactionOp = transactionRepository.findById(transactionId);

        if(transactionOp.isPresent()){
            transactionRepository.delete(transactionOp.get());
            return true;
        }
        return false;
    }
}
