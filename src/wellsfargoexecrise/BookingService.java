package wellsfargoexecrise;

public class BookingService implements IBookingService{
    @Override
    public boolean startBookingProcess(int eventId, int userId) {
        return false;
    }

    @Override
    public BookingConclusion confirmBookingStatus(int eventId, int userId) {
        return null;
    }
}
