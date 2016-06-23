package models;

import com.fasterxml.jackson.annotation.JsonGetter;
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
@Entity
public class Invoice extends Model {

    @JsonIgnore
    @Required
    @ManyToOne
    public BusinessPartner businessPartner;

    @Required
    @Unique
    public long invoiceNumber;

    @Required
    public Date paymentDeadline;

    public int amount;

    public int remainingAmount;

    public Date circulationDate;

    public Date issuanceDate = new Date();

    public String toString() {
        return "Invoice id: " + this.id + ", invoice num: " + this.invoiceNumber + ", by company: " + businessPartner.name;
    }

    @JsonGetter("businessPartner.uid")
    public String getBusinessPartnerId() {
        return businessPartner.uid;
    }

}
