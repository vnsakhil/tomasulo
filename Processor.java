import java.util.ArrayList;

public class Processor {
    private ArrayList<ReservationStation> reservationStations;

    public Processor() {
        reservationStations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            reservationStations.add(new ReservationStation());
        }
    }

    public void issueInstruction(Instruction instruction) {
        // Issue logic (add more logic based on Tomasulo's algorithm)
    }

    public void dispatch() {
        // Dispatch logic
    }

    public void broadcast() {
        // Broadcast logic
    }

    public ArrayList<ReservationStation> getReservationStations() {
        return reservationStations;
    }
}
