import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class Story3Test {
    @Test
    public void park_car_when_not_one_parkingLot() throws  WrongTicketException , UsedTicketException , NoPositionException , NullTicketException{
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
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
}
