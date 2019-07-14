
public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parking(Car car) {
        Ticket ticket = parkingLot.park(car);
        return ticket;
    }

    public Car fetching(Ticket ticket) {
        Car car = parkingLot.fetch(ticket);
        return car;
    }
}
