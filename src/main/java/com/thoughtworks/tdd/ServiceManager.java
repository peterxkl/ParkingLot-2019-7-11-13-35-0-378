import java.util.ArrayList;

public class ServiceManager  implements ParkiAndFetch{
    ArrayList<ParkingBoy> parkingBoys;
    private ParkingLot parkingLot;

    public ServiceManager(ArrayList<ParkingBoy> parkingBoys, ParkingLot parkingLot) {
        this.parkingBoys = parkingBoys;
        this.parkingLot = parkingLot;
    }

    public ArrayList<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void addParkingBoys(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }
    public Ticket parking(Car car) throws NoPositionException{

            if (parkingLot.getParkingCapacity()>0){
                Ticket ticket = parkingLot.park(car);
                return ticket ;
            }
            throw new NoPositionException("No enough position.");
    }
    public Ticket parkingByParkingBoy(ParkingBoy parkingBoy,Car car) throws NoPositionException, IllegalStateException {
        if (parkingBoys.contains(parkingBoy)) {
            return parkingBoy.parking(car);
        } else {
            throw new IllegalStateException("No boy is working.");
        }
    }

    public Car fetching(Ticket ticket) throws WrongTicketException , UsedTicketException , NullTicketException{
        if(ticket != null){
                if(parkingLot.getParkingCarTicket().containsKey(ticket)){
                    Car car = parkingLot.fetch(ticket);
                    return  car;
                }
                throw new WrongTicketException("Wrong parking ticket.");
        }else{
            throw new NullTicketException("Please provide your parking ticket.");
        }
    }


}
