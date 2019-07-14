import java.util.ArrayList;

public class ServiceManager {
    ArrayList<ParkingBoy> parkingBoys = new ArrayList<>();
    ArrayList<ParkingLot> parkingLots;

    public ServiceManager(ArrayList<ParkingLot> parkingLots) {
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

}
