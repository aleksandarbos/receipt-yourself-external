package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by aleksandar on 26.6.16..
 */
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class DailyBankStatementItem extends Model {

    public String account_city;
    public String approval_reference_number;
    public int calculation_method;
    public String creditor_account_number;
    public String creditor_model_number;
    public String creditor_reference_number;
    public Date currency_date;
    public String debtor_account_city;
    public String debtor_account_name;
    public String debtor_account_number;
    public String debtor_model_number;
    public String debtor_payment_purpose;
    public String debtor_reference_number;
    public int payment_currency;
    public Date payment_date;
    public String payment_number;
    public int priority;
    public int remaining_amount;
    public int status;
    public int transfer_amount;

    @JsonIgnore
    @ManyToOne
    public DailyBankStatement daily_bank_statement;

    @Override
    public String toString() {
        return "DailyBankStatementItem{" +
                "account_city='" + account_city + '\'' +
                ", creditor_account_number='" + creditor_account_number + '\'' +
                ", debtor_account_name='" + debtor_account_name + '\'' +
                ", payment_currency=" + payment_currency +
                '}';
    }
}
