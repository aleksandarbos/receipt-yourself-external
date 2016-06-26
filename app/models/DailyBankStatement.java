package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by aleksandar on 23.6.16..
 */
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class DailyBankStatement extends Model {

    public int new_amount;
    public long number;
    public int previous_amount;
    public int reserved_amount;
    public Date statement_date;
    public int total_payment;
    public int total_payout;

    @JsonIgnore
    @ManyToOne
    public BusinessPartner business_partner;

    @JsonIgnore
    @ManyToOne
    public CompanyAccount company_account;

    @OneToMany
    public List<DailyBankStatementItem> daily_statements;

    @Override
    public String toString() {
        return "DailyBankStatement{" +
                "new_amount=" + new_amount +
                ", statement_date=" + statement_date +
                ", total_payment=" + total_payment +
                ", number=" + number +
                '}';
    }
}
