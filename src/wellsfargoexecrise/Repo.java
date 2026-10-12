package wellsfargoexecrise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Repo implements IRepo{

    Map<Integer, Auditorium> auditoriumMap = new ConcurrentHashMap<>();
    //Map<Integer, Auditorium> auditoriumMap = new ConcurrentHashMap<>();


    @Override
    public void registerEventInAuditorium(int auditoriumNumber, int eventId, int capacity) {
        Auditorium auditorium = new Auditorium();
        auditorium.setAuditoriumNumber(auditoriumNumber);
        auditorium.setCapacity(capacity);
        auditorium.setEventId(eventId);

        //Store auditoroium object in the map
        auditoriumMap.putIfAbsent(eventId, auditorium);
    }

    @Override
    public Auditorium getAuditoriumDetailsForEvent(int eventId) {
        if(eventId==0){
            //validation failed
            return null;
        }
        return auditoriumMap.get(eventId);
    }

    @Override
    public int getNumberOfSeatsBookedOrUnderBookingForEvent(int eventId) {
        return 0;
    }

    @Override
    public void addUnderBooking(int eventId, int userId) {

    }

    @Override
    public void removeUnderBooking(int eventId, int userId) {

    }

    @Override
    public void addSuccessfulBooking(int eventId, int userId) {

    }
}
