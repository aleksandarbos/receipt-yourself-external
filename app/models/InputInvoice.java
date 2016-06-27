package models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by aleksandar on 22.6.16..
 */
@JsonIgnoreProperties({"id", "persistent", "entityId"})
@Entity
public class InputInvoice extends Model {

    @JsonIgnore
    @Required
    @ManyToOne
    public BusinessPartner businessPartner;

    @Required
    @Unique
    public long number;	

    @Required
    public Date payment_deadline;

    public int payment_amount;

    @JsonIgnore
    public boolean accept_invoice = false;

    public int remaining_amount;

    public Date circulation_date;

    public Date issuance_date = new Date();

    @JsonGetter("business_partner_id")
    public Long getBusinessPartnerId() {
        return businessPartner.id;
    }

    public String toString() {
        return "InputInvoice id: " + this.id + ", invoice num: " + this.number + ", by company: " + businessPartner.name;
    }

}
