package services;

import java.text.*;

/**
 * Created by MiHu on 14.2.2015.
 */
public class Util {

    private final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static final DecimalFormat df;

    static{
        df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
    }

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
