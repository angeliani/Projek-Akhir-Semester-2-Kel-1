package BookingGolfCourse;
import java.util.*;

public class Booking {
    //atribut
    private String memberName;
    private String date;
    private String time;
    private GolfCourse golfCourse; //asosiasi
    private boolean isDrivingRange;
    private static Set<String> bookedTimes = new HashSet<>(); //static collection

    //konstruktor
    public Booking(String memberName, String date, String time, GolfCourse golfCourse, boolean isDrivingRange) {
        this.memberName = memberName;
        this.date = date;
        this.time = time;
        this.golfCourse = golfCourse;
        this.isDrivingRange = isDrivingRange;

        if (bookedTimes.contains(time)) { //pake set
            throw new IllegalArgumentException("Time is already booked.");
        }
        bookedTimes.add(time); //nambah waktu ke set
    }

    public static Set<String> getBookedTimes() {
        return bookedTimes;
    }

    @Override
    public String toString() {
        return "Booking for " + memberName + " on " + date + " at " + time + " for " + (isDrivingRange ? "Driving Range" : golfCourse.getName());
    }
}