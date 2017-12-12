package alirezasobhani.example.com.cba.ui;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import alirezasobhani.example.com.cba.utils.ViewUtils;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class ViewUtilsTest {

    @Test
    public void testDollarise() {
        assertThat(ViewUtils.dollarise(0f), is("$0.00"));
        assertThat(ViewUtils.dollarise(3.45f), is("$3.45"));
        assertThat(ViewUtils.dollarise(-3.45f), is("-$3.45"));
        assertThat(ViewUtils.dollarise(-0.01f), is("-$0.01"));
    }

    @Test
    public void testFormatTransactionGroupDate() {
        assertThat(ViewUtils.formatTransactionGroupDate(new Date("02/09/2017")), is("09 Feb 2017"));
    }

    @Test
    public void testGetTransactionDaysAgo() {
        assertThat(ViewUtils.getTransactionDaysAgo(new Date("12/10/2017"), new Date("12/10/2017")), is("Today"));
        assertThat(ViewUtils.getTransactionDaysAgo(new Date("12/09/2017"), new Date("12/10/2017")), is("Yesterday"));
        assertThat(ViewUtils.getTransactionDaysAgo(new Date("12/08/2017"), new Date("12/10/2017")), is("2 days ago"));
    }

    @Test
    public void testNumberOfDaysBetweenDates() throws Exception {
        Calendar calendar = new GregorianCalendar(2011, 2, 27, 17, 34, 25);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy", Locale.US);
        assertThat(ViewUtils.numberOfDaysBetweenDates(calendar.getTime(), formatter.parse("26/03/2011")), is(-1L));
        assertThat(ViewUtils.numberOfDaysBetweenDates(calendar.getTime(), formatter.parse("27/03/2011")), is(0L));
        assertThat(ViewUtils.numberOfDaysBetweenDates(calendar.getTime(), formatter.parse("28/03/2011")), is(1L));
        assertThat(ViewUtils.numberOfDaysBetweenDates(new Date(), null), nullValue());
        assertThat(ViewUtils.numberOfDaysBetweenDates(null, new Date()), nullValue());
    }

}