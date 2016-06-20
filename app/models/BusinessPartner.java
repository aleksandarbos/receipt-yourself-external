package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by aleksandar on 20.6.16..
 */
@Entity
public class BusinessPartner extends Model {

    @Required
    public String name;

    @Required
    public String type;

    @Required
    public String uid;

    @ManyToOne
    public ContactCard contactCard;

    public String toString() {
        return this.name;
    }
}
