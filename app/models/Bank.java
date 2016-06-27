package models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by aleksandar on 20.6.16..
 */
@JsonIgnoreProperties({"id","persistent", "entityId"})
@Entity
public class Bank extends Model {

    @Required
    public String name;

    @JsonIgnore
    @ManyToOne
    public ContactCard contact_card;

    @JsonIgnore
    @OneToMany
    public List<CompanyAccount> company_accounts;

    @JsonGetter("contact_card_id")
    public Long getContactCardId() {
        return contact_card.id;
    }

    public String toString() {
        return this.name;
    }
}
