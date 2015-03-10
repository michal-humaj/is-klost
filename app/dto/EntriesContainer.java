package dto;

import models.Entry;
import services.Util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiHu on 9.3.2015.
 */
public class EntriesContainer {

    public List<Entry> entries = new ArrayList();

    public String getEntriesInfo() throws Exception {
        StringBuilder s = new StringBuilder();
        if (entries.size() < 1) return s.toString();
        BigDecimal weight = BigDecimal.ZERO;
        for (Entry entry : entries) {
            weight = weight.add(entry.getWeight());
            s.append(entry.getInfo());
            s.append("; ");
        }
        s.deleteCharAt(s.length() - 2);
        s.append("► ");
        s.append(Util.df.format(weight));
        s.append("kg");
        return s.toString();
    }
}
