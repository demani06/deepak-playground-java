package wellsfargoexecrise;

public interface IBookingService {
    boolean startBookingProcess(int eventId, int userId);
    BookingConclusion confirmBookingStatus(int eventId, int userId);
}
