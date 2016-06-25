package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Bank;
import models.ContactCard;
import play.mvc.Controller;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by aleksandar on 25.6.16..
 */
public class BankRequest extends Controller {

    public static void show() {
        Collection<Bank> banks = Bank.findAll();
        render(banks);
    }

    public static void sendRequestById(Long id) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        Bank bank = Bank.findById(id);
        ContactCard contactCard = ContactCard.findById(bank.contact_card.id);
        ObjectMapper om = new ObjectMapper();

        String basicInfo = om.writeValueAsString(bank);
        String contactInfo = om.writeValueAsString(contactCard);

        map.put("basicInfo", basicInfo);
        map.put("contactInfo", contactInfo);

        //HttpInvoker.sendGET("http://receipt-yourself.heroku.com/");
	    HttpInvoker.sendPOST("http://receipt-yourself.heroku.com/api/banks/receivedata", map);
        //HttpInvoker.sendPOST("http://localhost:3000/api/banks/receivedata", map);
    }
}