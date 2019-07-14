import java.util.ArrayList;
import java.util.List;

public class ServiceManager  {
    ArrayList<ParkingBoy> parkingBoys;
    ArrayList<ParkingLot> parkingLots;


    public ServiceManager(ArrayList<ParkingBoy> parkingBoys, ArrayList<ParkingLot> parkingLots) {
        this.parkingBoys = parkingBoys;
        this.parkingLots = parkingLots;
    }

    public ArrayList<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void addParkingBoys(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }
    public Ticket parking(Car car) throws NoPositionException{
        for (ParkingLot parkingLot : parkingLots){
            if (parkingLot.getParkingCapacity()>0){
                Ticket ticket = parkingLot.park(car);
                return ticket ;
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
