import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class Story5Test {
    @Test
    public void super_smart_park_car_when_not_one_parkingLot() throws NoPositionException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
//        Car car3 = new Car();
//        Car car4 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy boy = new SuperSmartParkingBoy(parkingLots);


        //when
        boy.parking(car1);
        boy.parking(car2);
//        boy.superSmartParking(car3);
//        boy.superSmartParking(car4);


        //then
        assertSame(2, parkingLot1.getParkingCapacity());
    }

}
