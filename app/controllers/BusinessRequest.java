package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.BusinessPartner;
import play.mvc.Controller;

import java.util.Collection;

/**
 * Created by aleksandar on 25.6.16..
 */
public class BusinessRequest extends Controller {

    public static void show() {
        Collection<BusinessPartner> businessPartners = BusinessPartner.findAll();
        render(businessPartners);
    }

    public static void sendRequestById(Long id) throws Exception {
        BusinessPartner businessPartner = BusinessPartner.findById(id);
        ObjectMapper om = new ObjectMapper();
        String bpJSON = om.writeValueAsString(businessPartner);

        HttpInvoker.sendPOST("https://receipt-yourself.heroku.com/", bpJSON);
    }

}
