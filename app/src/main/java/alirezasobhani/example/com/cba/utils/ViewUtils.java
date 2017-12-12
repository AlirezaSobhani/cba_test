package alirezasobhani.example.com.cba.utils;

import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ViewUtils {

    public static String dollarise(float amount) {
        return NumberFormat.getCurrencyInstance(Locale.CANADA).format(amount);
    }

    public static String formatTransactionGroupDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        return format.format(date);
    }

    public static String getTransactionDaysAgo(Date effectiveDate, Date today) {
        long diff = numberOfDaysBetweenDates(effectiveDate, today);
        return diff > 1 ? String.format("%s days ago", diff) :
                diff == 1 ? "Yesterday" :
                        "Today";
    }

    public static Long numberOfDaysBetweenDates(Date fromDate, Date toDate) {
        if (fromDate == null || toDate == null) {
            return null;
        }

        // to date calender
        Calendar toDateCalendar = Calendar.getInstance();
        toDateCalendar.setTime(toDate);
        toDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toDateCalendar.set(Calendar.MINUTE, 0);
        toDateCalendar.set(Calendar.SECOND, 0);
        toDateCalendar.set(Calendar.MILLISECOND, 0);

        // from date calender
        Calendar fromDateCalender = Calendar.getInstance();
        fromDateCalender.setTime(fromDate);
        fromDateCalender.set(Calendar.HOUR_OF_DAY, 0);
        fromDateCalender.set(Calendar.MINUTE, 0);
        fromDateCalender.set(Calendar.SECOND, 0);
        fromDateCalender.set(Calendar.MILLISECOND, 0);

        long toDateInMillis = toDateCalendar.getTimeInMillis();
        long fromDateInMillis = fromDateCalender.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(toDateInMillis - fromDateInMillis);
    }

    public static SpannableString generatePendingText(String description) {
        String PENDING = "Pending ";
        description = String.format("%s %s", PENDING, description);
        SpannableString spannableString = new SpannableString(Html.fromHtml(description));
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, PENDING.length(), 0);
        return spannableString;
    }
}
