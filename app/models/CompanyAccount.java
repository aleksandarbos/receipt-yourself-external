package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by aleksandar on 26.6.16..
 */
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class CompanyAccount extends Model {

    public int currency;
    public String number;

    @JsonIgnore
    @ManyToOne
    public Bank bank;

    @JsonIgnore
    @ManyToOne
    public Company company;

    @OneToMany
    public List<DailyBankStatement> daily_bank_statements;

    @Override
    public String toString() {
        return "CompanyAccount{" +
                "currency=" + currency +
                ", number='" + number + '\'' +
                '}';
    }
}
