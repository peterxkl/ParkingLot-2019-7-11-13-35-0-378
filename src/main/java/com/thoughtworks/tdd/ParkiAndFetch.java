public interface ParkiAndFetch {

    Ticket parking(Car car) throws NoPositionException;
    Car fetching(Ticket ticket) throws WrongTicketException, UsedTicketException, NullTicketException;
}
