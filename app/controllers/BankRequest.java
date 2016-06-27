package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Bank;
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
        ObjectMapper om = new ObjectMapper();

        String basicInfo = om.writeValueAsString(bank);
        String contactInfo = om.writeValueAsString(bank.contact_card);

        map.put("basicInfo", basicInfo);
        map.put("contactInfo", contactInfo);

        //HttpInvoker.sendGET("http://receipt-yourself.heroku.com/");
	    String response = HttpInvoker.sendPOST("https://receipt-yourself.heroku.com/api/banks/receivedata", map);
        //String response = HttpInvoker.sendPOST("http://localhost:3000/api/banks/receivedata", map);
        renderHtml(response);
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

        String response = HttpInvoker.sendPOST("https://receipt-yourself.heroku.com/api/banks/receviedailystatement", map);
        //String response = HttpInvoker.sendPOST("http://localhost:3000/api/banks/receviedailystatement", map);
        renderHtml(response);
    }
}
