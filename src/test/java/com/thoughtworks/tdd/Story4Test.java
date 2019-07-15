import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class Story4Test {
    @Test
    public void smart_park_car_when_not_one_parkingLot() throws NoPositionException{
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy boy = new SmartParkingBoy(parkingLots);


        //when
        boy.parking(car1);
        boy.parking(car2);


        //then
        assertSame(2,parkingLot2.getParkingCapacity());//此时每个停车场的最大容量设置为3
    }

}
