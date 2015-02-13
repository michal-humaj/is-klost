package models;

import dto.Category;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
@DiscriminatorValue("TENT")
public class Tent extends Item {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tent")
    public List<Accessory> accessories = new ArrayList<>();

    public static Finder<Long, Tent> find = new Finder<>(Long.class, Tent.class);

    public Tent() {
        category = Category.TENT;
    }

    @Override
    public BigDecimal getWeight() {
        BigDecimal weight = new BigDecimal("0.00");
        for (Accessory a : accessories) {
            //String s = a.item.name; //TODO zistit problemy tu
            weight = weight.add(a.item.weight.multiply(a.amount));
        }
        return weight;
    }
}
