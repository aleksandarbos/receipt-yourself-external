package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Bank;
import models.ContactCard;
import models.DailyBankStatement;
import models.DailyBankStatementItem;
import play.mvc.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aleksandar on 25.6.16..
 */
public class BankRequest extends Controller {

    public static void show() {
        Collection<Bank> banks = Bank.findAll();
        Collection<DailyBankStatement> dailyBankStatements = DailyBankStatement.findAll();
        render(banks, dailyBankStatements);
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
	    //HttpInvoker.sendPOST("http://receipt-yourself.heroku.com/api/banks/receivedata", map);
        HttpInvoker.sendPOST("http://localhost:3000/api/banks/receivedata", map);
    }

    public static void sendDailyRequestById(Long id) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        DailyBankStatement dailyBankStatement = DailyBankStatement.findById(id);
        List<DailyBankStatementItem> dailyBankStatementItems = dailyBankStatement.daily_statements;
        ObjectMapper om = new ObjectMapper();

        String statementInfo = om.writeValueAsString(dailyBankStatement);
        String itemsInfo = om.writeValueAsString(dailyBankStatementItems);

        map.put("statementInfo", statementInfo);
        map.put("itemsInfo", itemsInfo);

        //HttpInvoker.sendPOST("http://receipt-yourself.heroku.com/api/banks/receviedailystatement", map);
        HttpInvoker.sendPOST("http://localhost:3000/api/banks/receviedailystatement", map);
    }
}
