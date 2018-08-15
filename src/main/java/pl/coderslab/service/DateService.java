package pl.coderslab.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateService {

    public static java.sql.Timestamp dateFromDbString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            java.util.Date date1 = dateFormat.parse(dateString);
            return new java.sql.Timestamp(date1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static java.sql.Timestamp currentDateToSql() {
        java.util.Date date = new Date(Calendar.getInstance().getTimeInMillis());
        return new java.sql.Timestamp(date.getTime());
    }
}
