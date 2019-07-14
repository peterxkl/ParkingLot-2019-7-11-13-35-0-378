import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class Story1Test {
    @Test
    public void should_return_ticket_when__park_car_and_return_car_when_fetch(){
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
    public void should_return_correspond_car_when_fetch_mutiple_cars(){
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
}
