package com.Trionfini.challenge.service;

import com.Trionfini.challenge.model.Card;
import com.Trionfini.challenge.model.Transaction;
import com.Trionfini.challenge.repository.CardRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final TransactionService transactionService;

    @Autowired
    public CardService(CardRepository cardRepository, TransactionService transactionService) {
        this.cardRepository = cardRepository;
        this.transactionService = transactionService;
    }

    /**
     * Retrieves all cards.
     *
     * @return List of all cards.
     */
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    /**
     * Retrieves a card by ID.
     *
     * @param cardId ID from the card.
     * @return Card found, or null.
     */
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElse(null);
    }

    /**
     * Saves a new card ( ID auto generated).
     *
     * @param card The card to be saved.
     * @return The saved card (with assigned ID).
     */
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    /**
     * Updates an existing card.
     *
     * @param cardId ID to match with card.
     * @param updatedCard The card with the updated data.
     * @return The updated card, or null if the original card is not found.
     */
    public Card updateCard(Long cardId, Card updatedCard) {

        Optional<Card> cardOp = cardRepository.findById(cardId);

        return cardOp.map(cardRepository::save).orElse(null);
    }

    /**
     * Deletes a card from the system by its unique identifier.
     *
     * @param cardId Unique identifier of the card to delete.
     */
    public boolean deleteCard(Long cardId) {
        Optional<Card> cardOp = cardRepository.findById(cardId);

        if(cardOp.isPresent()){
            cardRepository.delete(cardOp.get());
            return true;
        }
        return false;
    }
}

