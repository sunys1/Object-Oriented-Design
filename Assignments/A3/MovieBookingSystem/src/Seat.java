public class Seat {
    private String seatId;
    private SeatStatus status;

    public Seat(String seatId, SeatStatus status)
    {
        this.seatId = seatId;
        this.status = status;
    }

    public String getSeatId()
    {
        return seatId;
    }

    public SeatStatus getStatus()
    {
        return status;
    }

    public void setStatus(SeatStatus status)
    {
        this.status = status;
    }
}
