import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket,Car> parkingCarTicket = new HashMap();


    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingCarTicket.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws WrongTicketException , UsedTicketException {
        if (parkingCarTicket.containsKey(ticket)) {
            if (parkingCarTicket.get(ticket) != null) {
                Car car = parkingCarTicket.get(ticket);
                parkingCarTicket.put(ticket, null);
                return car;
            } else {
                throw new UsedTicketException("Used parking ticket.");
            }
        } else {
            throw new WrongTicketException("Wrong parking ticket.");
        }

    }
}
