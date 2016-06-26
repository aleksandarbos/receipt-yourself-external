package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by aleksandar on 26.6.16..
 */
@JsonIgnoreProperties({"persistent", "entityId"})
@Entity
public class Company extends Model {

    public String name;

    @OneToMany
    public List<CompanyAccount> company_accounts;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", company_accounts=" + company_accounts +
                '}';
    }
}
