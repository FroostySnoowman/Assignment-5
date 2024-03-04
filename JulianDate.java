import java.util.Calendar;
import java.util.GregorianCalendar;

public class JulianDate {
    private int year;
    private int month;
    private int day;

    public JulianDate() {
        GregorianCalendar today = new GregorianCalendar();
        today.setGregorianChange(new java.util.Date(Long.MAX_VALUE));
        this.year = today.get(Calendar.YEAR);
        this.month = today.get(Calendar.MONTH) + 1;
        this.day = today.get(Calendar.DAY_OF_MONTH);
    }

    public JulianDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void subtractDays(int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public boolean isLeapYear() {
        return (year % 4) == 0;
    }

    public String getMonthName() {
        return getMonthName(this.month);
    }

    private String getMonthName(int month) {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return day;
    }

    @Override
    public String toString() {
        return String.format("%s %d, %d", getMonthName(month), day, year);
    }

    public void printShortDate() {
        System.out.printf("%02d/%02d/%d", this.month, this.day, this.year);
    }

    public void printLongDate() {
        System.out.printf("%s %d, %d", getMonthName(this.month), this.day, this.year);
    }
}