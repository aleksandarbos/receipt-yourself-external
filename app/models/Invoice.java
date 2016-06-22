package models;

import controllers.CRUD;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by aleksandar on 22.6.16..
 */
@Entity
public class Invoice extends Model {

    @Required
    public BusinessPartner businessPartner;

    @Required
    public long invoiceNumber;

    @Required
    public Number amount;

    public Number remainingAmount;

    @CRUD.Hidden
    public Date issuanceDate = new Date();

    public Date circulationDate;

    @Required
    public Date paymentDeadline;


    public String toString() {
        return "Invoice id: " + this.invoiceNumber;
    }
}
