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

}
