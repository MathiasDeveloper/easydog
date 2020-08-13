package fr.easydog.bo.converter;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * DateConverter Class
 * Convert date for set value in
 * database with room
 */
public class DateConverter {
    /**
     * Converter to date on timestamp
     * @param timestamp => timeStamp
     * @return Date
     */
    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }

    /**
     * Convert to timestamp on date
     * @param date => date object
     * @return
     */
    @TypeConverter
    public static Long toTimestamp(Date date){
        return date == null ? null : date.getTime();
    }
}
