import java.util.Date;

    //Рандомим дату как умеем. Умеем плохо.
public class RandomDate {

    public static java.sql.Date getRandomDate() {

        final long startTime = Math.abs(new Date(50, 0, 1).getTime());
        final long currentTime = (new Date().getTime());

        long randomDate =(long) (Math.random() * (currentTime - startTime) + startTime);

        Date date = new Date(randomDate);

        return new java.sql.Date(date.getTime());
    }
}

