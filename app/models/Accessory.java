package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
public class Accessory extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    @JsonIgnore
    public Tent tent;

    @Required
    @ManyToOne
    public StoredItem item;

    @Required
    @Column(precision = 9, scale = 2)
    public BigDecimal amount;

    public static Finder<Long, Accessory> find = new Finder<>(Long.class, Accessory.class);
}
