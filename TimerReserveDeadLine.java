import java.util.*;

public class TimerReserveDeadLine extends TimerTask{
    private ArrayList<Table> tables;
    private ArrayList<Reservation> currentReservations;
    private int tableIndex;
    private Calendar reservedForTime;

    public TimerReserveDeadLine(ArrayList<Table> tables, ArrayList<Reservation> currentReservations, int tableIndex, Calendar reservedForTime){
        this.tables = tables;
        this.currentReservations = currentReservations;
        this.tableIndex = tableIndex;
        this.reservedForTime = reservedForTime;
    }
    public void run(){
        if(tables.get(tableIndex).getStatus() == Status.OCCUPIED){
            return;
        }
        else{
            tables.get(tableIndex).setStatus(Status.AVAILABLE);
            for(int i=0; i<currentReservations.size(); i++){
                if(currentReservations.get(i).getReservedForTime() == reservedForTime){
                    currentReservations.remove(i);
                }
            }
        }
    }
}
