package models;

import dto.EventType;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by MiHu on 9.3.2015.
 */
@Entity
public class Entry extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Required
    public String eventId;

    @Required
    public EventType eventType;

    @ManyToOne
    public Item item;

    @Required
    @Column(precision = 9, scale = 2)
    public BigDecimal amount;

    public static Finder<Long, Entry> find = new Finder<>(Long.class, Entry.class);

    public BigDecimal getWeight() throws Exception {
        return amount.multiply(item.getWeight());
    }
}
