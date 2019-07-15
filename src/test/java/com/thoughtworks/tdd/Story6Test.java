import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class Story6Test {
    @Test
    public void should_return_parkingBoys_when_manager_add_parkingBoy() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingLot parkingLot1 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot1);
        ParkingBoy parkingBoy =new ParkingBoy(parkingLots);
        ArrayList<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        ServiceManager manager = new ServiceManager(parkingBoys,parkingLot);
        ParkingBoy parkingBoy1 =new ParkingBoy(parkingLots);
        //when
        int x = manager.getParkingBoys().size();
        manager.addParkingBoys(parkingBoy1);
        //then
        assertSame(x+1,manager.getParkingBoys().size());
    }

    @Test
    public void manage_chose_parkingBoy_to_park_car() throws NoPositionException ,UsedTicketException,WrongTicketException,NullTicketException{
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingLot parkingLot1 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot1);
        ParkingBoy parkingBoy1 =new ParkingBoy(parkingLots);
        ArrayList<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy1);
        ServiceManager manager = new ServiceManager(parkingBoys,parkingLot);

        //when
        ParkingBoy parkingBoy = manager.getParkingBoys().get(0);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        Car car1 = parkingBoy.fetching(ticket);
        //then
        assertSame(car,car1);
    }

    @Test
    public void manage_park_car_when_not_only_one_parkingLot() throws  WrongTicketException , UsedTicketException , NoPositionException , NullTicketException{
        //given
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        ArrayList<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(boy);
        ServiceManager manager = new ServiceManager(parkingBoys,parkingLot1);


        //when
        Car car1 = new Car();
        Ticket ticket = manager.parking(car1);
        Car car = manager.fetching(ticket);

        //then
        assertSame(car1,car);
    }

    @Test
    public void should_return_wrong_message_when_parkingBoy_failed_parking_car()  throws IllegalStateException , NoPositionException , NullTicketException{
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingLot parkingLot1 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot1);
        ParkingBoy parkingBoy1 =new ParkingBoy(parkingLots);
        ArrayList<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy1);
        ServiceManager manager = new ServiceManager(parkingBoys,parkingLot);

        //when
        ArrayList<ParkingLot> parkingLots2 = new ArrayList<>();
        parkingLots2.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots2);
        //then
        Assertions.assertThrows(IllegalStateException.class, ()->manager.parkingByParkingBoy(parkingBoy, new Car()),"No boy is working.");


    }
}
