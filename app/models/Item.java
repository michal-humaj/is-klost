package models;

import dto.Category;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ITEM_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Item extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Required
    public String name;

    @Required
    public Category category;

    public static Finder<Long, Item> find = new Finder<>(Long.class, Item.class);

    public BigDecimal getWeight(){
        return null;
    }
}