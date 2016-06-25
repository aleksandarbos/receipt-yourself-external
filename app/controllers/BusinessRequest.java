package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.BusinessPartner;
import models.Invoice;
import play.mvc.Controller;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by aleksandar on 25.6.16..
 */
public class BusinessRequest extends Controller {

    public static void show() {
        Collection<BusinessPartner> businessPartners = BusinessPartner.findAll();
        render(businessPartners);
    }

    public static void sendRequestById(Long id) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        BusinessPartner businessPartner = BusinessPartner.findById(id);
        ObjectMapper om = new ObjectMapper();

        String basicInfo = om.writeValueAsString(businessPartner);
        String contactInfo = om.writeValueAsString(businessPartner.contact_card);

        map.put("basicInfo", basicInfo);
        map.put("contactInfo", contactInfo);

        HttpInvoker.sendPOST("http://receipt-yourself.heroku.com/api/businesspartners/receivedata", map);
	    //HttpInvoker.sendPOST("http://localhost:3000/api/businesspartners/receivedata", map);
    }

    public static void sendInvoiceById(Long id) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        Invoice invoice = Invoice.findById(id);
        ObjectMapper om = new ObjectMapper();

        String basicInfo = om.writeValueAsString(invoice);
        String contactInfo = om.writeValueAsString(invoice.businessPartner);

        map.put("invoiceInfo", basicInfo);
        map.put("businessPartnerInfo", contactInfo);

        HttpInvoker.sendPOST("http://receipt-yourself.heroku.com/api/businesspartners/receivedata", map);
        //HttpInvoker.sendPOST("http://localhost:3000/api/businesspartners/acceptinvoice", map);
    }

}
