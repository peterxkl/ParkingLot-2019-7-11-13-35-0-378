import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class Story2Test {
    @Test
    public void should_not_fetch_car_when_ticket_is_fake() throws NoPositionException{
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car car = new Car();


        //when
        Ticket ticket = boy.parking(car);
        Ticket ticket1 = new Ticket();
        //Car car_back = boy.fetching(ticket);
        //then
        Assertions.assertThrows(WrongTicketException.class, ()->boy.fetching(ticket1),"Unrecognized parking ticket.");
    }
    @Test
    public void should_not_fetch_car_when_ticket_is_used() throws  WrongTicketException , UsedTicketException , NoPositionException , NullTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car car = new Car();


        //when
        Ticket ticket = boy.parking(car);
        Car car_back = boy.fetching(ticket);


        //then
        Assertions.assertThrows(UsedTicketException.class, ()->boy.fetching(ticket),"Unrecognized parking ticket.");
    }
    @Test
    public void should_canot_park_car_when_no_position() throws NoPositionException{
        //given
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();

        //when
        boy.parking(car1);
        boy.parking(car2);
        boy.parking(car3);
        boy.parking(car4);
        boy.parking(car5);
        boy.parking(car6);

        //then
        Assertions.assertThrows(NoPositionException.class, ()->boy.parking(car7),"Not enough position.");
    }
    @Test
    public void fetch_car_when_not_provide_ticket() throws  NoPositionException{
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        boy.parking(car);

        //then
        Assertions.assertThrows(NullTicketException.class, ()->boy.fetching(null),"Please provide your parking ticket.");
    }
}
