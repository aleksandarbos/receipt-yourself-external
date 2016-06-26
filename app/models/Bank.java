package models;

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
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class Bank extends Model {

    @Required
    public String name;

    @JsonIgnore
    @ManyToOne
    public ContactCard contact_card;

    @OneToMany
    public List<CompanyAccount> company_accounts;

    public String toString() {
        return this.name;
    }
}
