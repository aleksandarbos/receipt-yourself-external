package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by aleksandar on 26.6.16..
 */
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class BusinessPartnerAccount extends Model {

    public boolean activated;
    public String number;

    @JsonIgnore
    @ManyToOne
    public BusinessPartner business_partner;

    @Override
    public String toString() {
        return "BusinessPartnerAccount{" +
                ((business_partner != null)?"business partner=" + business_partner.name: "") +
                " activated=" + activated +
                ", number='" + number + '\'' +
                '}';
    }
}


