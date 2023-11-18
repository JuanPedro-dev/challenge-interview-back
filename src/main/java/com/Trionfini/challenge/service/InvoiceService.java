package com.Trionfini.challenge.service;

import com.Trionfini.challenge.model.Invoice;
import com.Trionfini.challenge.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * Retrieves all invoices.
     *
     * @return List of all invoices.
     */
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    /**
     * Retrieves an invoice by ID.
     *
     * @param invoiceId ID from the invoice.
     * @return Invoice found, or null.
     */
    public Invoice getInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    /**
     * Saves a new invoice ( ID auto generated).
     *
     * @param invoice The invoice to be saved.
     * @return The saved invoice (with assigned ID).
     */
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    /**
     * Updates an existing invoice.
     *
     * @param invoiceId ID to match with invoice.
     * @param updatedInvoice The invoice with the updated data.
     * @return The updated invoice, or null if the original invoice is not found.
     */
    public Invoice updateInvoice(Long invoiceId, Invoice updatedInvoice) {

        Optional<Invoice> invoiceOp = invoiceRepository.findById(invoiceId);

        return invoiceOp.map(invoiceRepository::save).orElse(null);
    }

    /**
     * Deletes an invoice from the system by its unique identifier.
     *
     * @param invoiceId Unique identifier of the invoice to delete.
     */
    public boolean deleteInvoice(Long invoiceId) {
        Optional<Invoice> invoiceOp = invoiceRepository.findById(invoiceId);

        if(invoiceOp.isPresent()){
            invoiceRepository.delete(invoiceOp.get());
            return true;
        }
        return false;
    }
}

