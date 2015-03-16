package dto;

import java.math.BigDecimal;

/**
 * Created by MiHu on 15.8.2014.
 */
public class AvailTO implements Comparable<AvailTO>{

    public Long id;
    public String name;
    public Category category;
    public BigDecimal amount;
    public BigDecimal weight;

    public BigDecimal available;
    public BigDecimal reserved;
    public BigDecimal rented;

    public AvailTO(Long id, String name, Category category, BigDecimal amount, BigDecimal weight) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.weight = weight;
        this.available = amount;
        this.reserved = BigDecimal.ZERO;
        this.rented = BigDecimal.ZERO;
    }

    public AvailTO reserve(BigDecimal a) {
        available = available.subtract(a);
        reserved = reserved.add(a);
        return this;
    }

    public AvailTO rent(BigDecimal a) {
        available = available.subtract(a);
        rented = rented.add(a);
        return this;
    }

    @Override
    public int compareTo(AvailTO o) {
        return category.compareTo(o.category);
    }
}
