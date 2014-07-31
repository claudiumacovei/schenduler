package notebook;

import java.util.Calendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotebookCalendar {
    static Calendar calendar = Calendar.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(NotebookCalendar.class);
    
    public static void main(String[] args) {
    
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        logger.info("" + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.ALL_STYLES, Locale.ENGLISH));
        logger.info("" + calendar.get(Calendar.WEEK_OF_YEAR));
        logger.info("" + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        logger.info("" + (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY));
        
    }
}
