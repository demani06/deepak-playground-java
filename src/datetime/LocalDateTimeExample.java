package datetime;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeExample {
    static void main() {
        //Construct LocalDateTime and change to long EpochSeconds long
        LocalDateTime localDateTime = LocalDateTime.now();
        long epochSecond = localDateTime.toEpochSecond(ZoneOffset.UTC);

        System.out.println("epochSecond = " + epochSecond);

        //Construct LocalDateTime from EpochSeconds long
        LocalDateTime localDateTime1 = LocalDateTime.ofEpochSecond(1782911301L, 0, ZoneOffset.UTC );
        System.out.println("localDateTime1 = " + localDateTime1);
     }
}
