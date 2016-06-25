package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.sf.oval.constraint.MinLength;
import play.data.validation.Email;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by aleksandar on 20.6.16..
 */
@Entity
public class ContactCard extends Model {

    @Required
    @MinLength(8)
    @Unique
    public int pib;

    @JsonIgnore
    @OneToMany
    public List<BusinessPartner> business_partner;

    @JsonIgnore
    @OneToMany
    public List<Bank> bank;

    @Required
    public String country;

    public String state;

    @Required
    public String place;

    @Required
    public String address;

    @Required
    @Email
    public String email;

    public String fax;

    public String cellphone;

    public String website;

    public String toString() {
        return "CC-" + ((!business_partner.isEmpty()) ? "BP: " + business_partner.get(0).name : "BA: " + bank.get(0).name);
    }
}
