package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Invoice;
import play.mvc.Controller;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by aleksandar on 22.6.16..
 */
public class IssueInvoice extends Controller {

    public static void show() {
        Collection<Invoice> invoices = Invoice.findAll();
        render(invoices);
    }

    public static void getInvoiceById(Long invoiceId) throws IOException {
        Invoice invoice = Invoice.findById(invoiceId);
        ObjectMapper objectMapper = new ObjectMapper();
        renderText(objectMapper.writeValueAsString(invoice));
    }

}
