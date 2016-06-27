package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.BusinessPartner;
import models.InputInvoice;
import play.mvc.Controller;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by aleksandar on 25.6.16..
 */
public class BusinessRequest extends Controller {

    public static void show() {
        Collection<BusinessPartner> businessPartners = BusinessPartner.findAll();
        Collection<InputInvoice> invoices = InputInvoice.findAll();
        render(businessPartners, invoices);
    }

    public static void sendRequestById(Long id) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        BusinessPartner businessPartner = BusinessPartner.findById(id);
        ObjectMapper om = new ObjectMapper();

        String basicInfo = om.writeValueAsString(businessPartner);
        String contactInfo = om.writeValueAsString(businessPartner.contact_card);

        map.put("basicInfo", basicInfo);
        map.put("contactInfo", contactInfo);

        String response = HttpInvoker.sendPOST("https://receipt-yourself.heroku.com/api/businesspartners/receivedata", map);
        //String response = HttpInvoker.sendPOST("http://localhost:3000/api/businesspartners/receivedata", map);
        renderHtml(response);
    }

    public static void sendInvoiceById(Long id) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        InputInvoice invoice = InputInvoice.findById(id);
        ObjectMapper om = new ObjectMapper();

        String basicInfo = om.writeValueAsString(invoice);
        String contactInfo = om.writeValueAsString(invoice.businessPartner);

        map.put("invoiceInfo", basicInfo);

        String response = HttpInvoker.sendPOST("https://receipt-yourself.heroku.com/api/businesspartners/receivedata", map);
        //String response = HttpInvoker.sendPOST("http://localhost:3000/api/businesspartners/acceptinvoice", map);
        renderHtml(response);
    }

}
