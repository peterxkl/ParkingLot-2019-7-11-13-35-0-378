import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class Story1Test {
    @Test
    public void should_return_ticket_when__park_car_and_return_car_when_fetch() throws  WrongTicketException , UsedTicketException , NoPositionException , NullTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = boy.parking(car);
        Car car1 = boy.fetching(ticket);

        //then
        assertSame(car,car1);
    }
    @Test
    public void should_return_correspond_car_when_fetch_mutiple_cars() throws WrongTicketException , UsedTicketException , NoPositionException , NullTicketException{
        //given
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Car car1 = new Car();

        //when
        Ticket ticket = boy.parking(car);
        Ticket ticket1 = boy.parking(car1);
        Car car_back = boy.fetching(ticket);
        Car car1_back = boy.fetching(ticket1);

        //then
        assertSame(car_back,car);
        assertSame(car1_back,car1);
    }
    @Test
    public void should_not_fetch_car_when_ticket_is_fake() throws NoPositionException{
        //given
        ParkingLot parkingLot = new ParkingLot();
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
        ParkingLot parkingLot = new ParkingLot();
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
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
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
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy boy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        boy.parking(car);

        //then
        Assertions.assertThrows(NullTicketException.class, ()->boy.fetching(null),"Please provide your parking ticket.");
    }
    @Test
    public void park_car_when_not_one_parkingLot() throws  WrongTicketException , UsedTicketException , NoPositionException , NullTicketException{
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy boy = new ParkingBoy(parkingLots);


        //when
        boy.parking(car1);
        boy.parking(car2);
        boy.parking(car3);
        Ticket ticket = boy.parking(car4);
        Car car = boy.fetching(ticket);

        //then
        assertSame(car,car4);
    }
    @Test
    public void smart_park_car_when_not_one_parkingLot() throws NoPositionException{
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy boy = new ParkingBoy(parkingLots);


        //when
        boy.smartParking(car1);
        boy.smartParking(car2);


        //then
        assertSame(2,parkingLot2.getParkingCapacity());//此时每个停车场的最大容量设置为3
    }

}
