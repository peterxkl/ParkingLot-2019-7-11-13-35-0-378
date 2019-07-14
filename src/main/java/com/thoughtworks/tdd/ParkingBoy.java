
public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parking(Car car) throws NoPositionException{
        Ticket ticket = parkingLot.park(car);
        return ticket;
    }

    public Car fetching(Ticket ticket) throws WrongTicketException , UsedTicketException , NullTicketException{
        Car car = parkingLot.fetch(ticket);
        return car;
    }
}
