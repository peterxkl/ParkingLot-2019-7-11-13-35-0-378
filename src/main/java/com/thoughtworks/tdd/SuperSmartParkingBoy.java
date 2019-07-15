import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) throws NoPositionException{
        List<Integer> list = parkingLots.stream().map(x->x.getParkingCapacity()/x.getCapacity()).collect(Collectors.toList());
        int max = Collections.max(list);
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.getParkingCapacity() == max){
                Ticket ticket = parkingLot.park(car);
                return ticket;
            }
        }
        throw new NoPositionException("No enough position.");

    }
    public Car fetching(Ticket ticket) throws WrongTicketException , UsedTicketException , NullTicketException{
        if(ticket != null){
            for(ParkingLot parkingLot:parkingLots){
                if(parkingLot.getParkingCarTicket().containsKey(ticket)){
                    Car car = parkingLot.fetch(ticket);
                    return  car;
                }
            }
            throw new WrongTicketException("Wrong parking ticket.");
        }else{
            throw new NullTicketException("Please provide your parking ticket.");
        }
    }
}
