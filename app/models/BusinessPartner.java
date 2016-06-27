package models;

import com.fasterxml.jackson.annotation.JsonGetter;
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
@JsonIgnoreProperties({"id", "persistent", "entityId"})
@Entity
public class BusinessPartner extends Model {

    @Required
    public String name;

    @Required
    public String category;

    @JsonIgnore
    @Required
    public String uid;

    @JsonIgnore
    @ManyToOne
    public ContactCard contact_card;

    @JsonIgnore
    @OneToMany
    public List<DailyBankStatement> daily_statements;

    @JsonIgnore
    @OneToMany
    public List<BusinessPartnerAccount> business_partner_accounts;

    @JsonIgnore
    @OneToMany
    public Collection<InputInvoice> invoices;

    @JsonGetter("contact_card_id")
    public Long getContactCardId() {
        return contact_card.id;
    }

    public String toString() {
        return this.name;
    }
}
