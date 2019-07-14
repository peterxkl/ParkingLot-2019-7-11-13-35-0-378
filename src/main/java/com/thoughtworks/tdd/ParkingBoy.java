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
