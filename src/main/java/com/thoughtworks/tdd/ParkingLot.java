import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket,Car> parkingCarTicket = new HashMap();


    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingCarTicket.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws WrongTicketException {
        Car car = parkingCarTicket.get(ticket);
        if(car!=null){
            return car;
        }else{
            throw new WrongTicketException("wrong parking ticket.");
        }

    }
}
