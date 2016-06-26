package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

/**
 * Created by aleksandar on 20.6.16..
 */
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class BusinessPartner extends Model {

    @Required
    public String name;

    @Required
    public String type;

    @JsonIgnore
    @Required
    public String uid;

    @JsonIgnore
    @ManyToOne
    public ContactCard contact_card;

    @OneToMany
    public List<DailyBankStatement> daily_statements;

    @OneToMany
    public List<BusinessPartnerAccount> business_partner_accounts;

    @OneToMany
    public Collection<InputInvoice> invoices;

    public String toString() {
        return this.name;
    }
}
