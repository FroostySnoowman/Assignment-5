import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianDate {
    private int year;
    private int month;
    private int day;

    public GregorianDate() {
        GregorianCalendar today = new GregorianCalendar();
        this.year = today.get(Calendar.YEAR);
        this.month = today.get(Calendar.MONTH) + 1;
        this.day = today.get(Calendar.DAY_OF_MONTH);
    }

    public GregorianDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        updateDate(calendar);
    }

    public void subtractDays(int days) {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        updateDate(calendar);
    }

    public boolean isLeapYear() {
        return isLeapYear(this.year);
    }

    public String getMonthName() {
        return getMonthName(this.month);
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDayOfMonth() {
        return day;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    private String getMonthName(int month) {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    private void updateDate(Calendar calendar) {
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void printShortDate() {
        System.out.printf("%02d/%02d/%d", this.month, this.day, this.year);
    }

    public void printLongDate() {
        System.out.printf("%s %d, %d", getMonthName(this.month), this.day, this.year);
    }
}