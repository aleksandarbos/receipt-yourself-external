package controllers;

import models.InputInvoice;
import play.mvc.Controller;

import java.util.Collection;

/**
 * Created by aleksandar on 22.6.16..
 */
public class InputInvoiceRequest extends Controller {

    public static void show() {
        Collection<InputInvoice> invoices = InputInvoice.findAll();
        render(invoices);
    }

}
