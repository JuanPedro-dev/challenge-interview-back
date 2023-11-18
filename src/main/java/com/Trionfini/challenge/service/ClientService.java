package com.Trionfini.challenge.service;

import com.Trionfini.challenge.model.Card;
import com.Trionfini.challenge.model.Client;
import com.Trionfini.challenge.model.Transaction;
import com.Trionfini.challenge.repository.CardRepository;
import com.Trionfini.challenge.repository.ClientRepository;
import com.Trionfini.challenge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clienteRepository;
    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    private final CardService cardService;

    @Autowired
    public ClientService(ClientRepository clienteRepository,
                         CardRepository cardRepository,
                         TransactionRepository transactionRepository,
                         CardService cardService
    ) {
        this.clienteRepository = clienteRepository;
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
        this.cardService = cardService;
    }

    /**
     * Retrieves all clients.
     *
     * @return List of all clients.
     */
    public List<Client> getAllClients() {
        return clienteRepository.findAll();
    }

    /**
     * Retrieves a client by ID.
     *
     * @param clientId ID from the client.
     * @return Client found, or null.
     */
    public Client getClientById(Long clientId) {
        return clienteRepository.findById(clientId).orElse(null);
    }

    /**
     * Saves a new client ( ID auto generated).
     *
     * @param client The client to be saved.
     * @return The saved client (with assigned ID).
     */
    public Client saveClient(Client client) {
        Client savedClient = clienteRepository.save(client);


        for (Card card : client.getCards()) {
            card.setClient(savedClient);
            cardService.saveCard(card);
        }

//        for (Card card : client.getCards()) {
//            card.setClient(savedClient);
//            Card savedCard = cardRepository.save(card);
//
//            for (Transaction transaction : savedCard.getCredits()) {
//                transaction.setCard(savedCard);
//                transactionRepository.save(transaction);
//            }
//
//            for (Transaction transaction : savedCard.getDebits()) {
//                transaction.setCard(savedCard);
//                transactionRepository.save(transaction);
//            }
//        }

        return savedClient;
    }

    /**
     * Updates an existing client.
     *
     * @param clientId ID to match with client.
     * @param updatedClient The client with the updated data.
     * @return The updated client, or null if the original client is not found.
     */
    public Client updateClient(Long clientId, Client updatedClient) {

        Optional<Client> clientOp = clienteRepository.findById(clientId);

        return clientOp.map(clienteRepository::save).orElse(null);
    }

    /**
     * Deletes a client from the system by its unique identifier.
     *
     * @param clientId Unique identifier of the client to delete.
     */
    public boolean deleteClient(Long clientId) {
        Optional<Client> clientOp = clienteRepository.findById(clientId);

        if(clientOp.isPresent()){
            clienteRepository.delete(clientOp.get());
            return true;
        }
        return false;
    }
}
