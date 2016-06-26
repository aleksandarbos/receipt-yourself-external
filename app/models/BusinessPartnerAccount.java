package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by aleksandar on 26.6.16..
 */
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class BusinessPartnerAccount extends Model {

    public boolean activated;
    public String number;

    @Override
    public String toString() {
        return "BusinessPartnerAccount{" +
                "activated=" + activated +
                ", number='" + number + '\'' +
                '}';
    }
}


