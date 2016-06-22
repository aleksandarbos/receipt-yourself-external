package models;

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

    @Required
    @ManyToOne
    public BusinessPartner businessPartner;

    @Required
    @Unique
    public long invoiceNumber;

    public Number amount;

    public Number remainingAmount;

    public Date circulationDate;

    @Required
    public Date paymentDeadline;

    public Date issuanceDate;

    public String toString() {
        return "Invoice id: " + this.id + ", invoice num: " + this.invoiceNumber + ", by company: " + businessPartner.name;
    }

}
