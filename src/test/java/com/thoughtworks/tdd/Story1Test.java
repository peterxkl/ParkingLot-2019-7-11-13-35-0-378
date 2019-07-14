import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertSame;

public class Story1Test {
    @Test
    public void should_return_ticket_when__park_car_and_return_car_when_fetch() throws  WrongTicketException , UsedTicketException , NoPositionException{
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy boy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = boy.parking(car);
        Car car1 = boy.fetching(ticket);

        //then
        assertSame(car,car1);
    }
    @Test
    public void should_return_correspond_car_when_fetch_mutiple_cars() throws WrongTicketException , UsedTicketException , NoPositionException{
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy boy = new ParkingBoy(parkingLot);
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
        ParkingBoy boy = new ParkingBoy(parkingLot);
        Car car = new Car();


        //when
        Ticket ticket = boy.parking(car);
        Ticket ticket1 = new Ticket();
        //Car car_back = boy.fetching(ticket);
        //then
        Assertions.assertThrows(WrongTicketException.class, ()->boy.fetching(ticket1),"Unrecognized parking ticket.");
    }
    @Test
    public void should_not_fetch_car_when_ticket_is_used() throws  WrongTicketException , UsedTicketException , NoPositionException{
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy boy = new ParkingBoy(parkingLot);
        Car car = new Car();


        //when
        Ticket ticket = boy.parking(car);
        Car car_back = boy.fetching(ticket);


        //then
        Assertions.assertThrows(UsedTicketException.class, ()->boy.fetching(ticket),"Used parking ticket.");
    }
    @Test
    public void should_canot_park_car_when_no_position() throws NoPositionException{
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy boy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();


        //when
        Ticket ticket = boy.parking(car);
        Ticket ticket1 = boy.parking(car1);
        Ticket ticket2 = boy.parking(car2);
        Ticket ticket3 = boy.parking(car3);
        Ticket ticket4 = boy.parking(car4);
        Ticket ticket5 = boy.parking(car5);
        Ticket ticket6 = boy.parking(car6);
        Ticket ticket7 = boy.parking(car7);
        Ticket ticket8 = boy.parking(car8);
        Ticket ticket9 = boy.parking(car9);

        //then
        Assertions.assertThrows(NoPositionException.class, ()->boy.parking(car9),"No enough position.");
    }
}
