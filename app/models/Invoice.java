package models;

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

    @Required
    public Date issuance_date;

    public Date circulation_date;

    @Required
    public Date payment_deadline;

}
