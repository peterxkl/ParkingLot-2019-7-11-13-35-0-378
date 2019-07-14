import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) throws NoPositionException{
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.getParkingCapacity()>0){
                Ticket ticket = parkingLot.park(car);
                return ticket;
            }
        }
        return null;
    }

    public Car fetching(Ticket ticket) throws WrongTicketException , UsedTicketException , NullTicketException{
        for(ParkingLot parkingLot:parkingLots){
             if(parkingLot.getParkingCarTicket().containsKey(ticket)){
                 Car car = parkingLot.fetch(ticket);
                 return  car;
             }
        }

        return null;
    }
}
