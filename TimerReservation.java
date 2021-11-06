import java.util.*;

public class TimerReservation extends TimerTask{
    private ArrayList<Table> tables;
    private ArrayList<Reservation> currentReservations;
    private int tableID;
    private Calendar reservedTillTime;
    private Calendar reservedForTime;

    public TimerReservation(ArrayList<Table> tables, ArrayList<Reservation> currentReservations, int tableID, Calendar reservedForTime, Calendar reservedTillTime){
        this.tables = tables;
        this.currentReservations = currentReservations;
        this.tableID = tableID;
        this.reservedForTime = reservedForTime;
        this.reservedTillTime = reservedTillTime;
    }
    public void run(){
        for(int i=0; i<tables.size(); i++){
			if(tables.get(i).getTableID() == tableID){
				if(tables.get(i).getStatus() == Status.AVAILABLE){
					tables.get(i).setStatus(Status.RESERVED);
					Timer timer = new Timer();
					Date time = reservedTillTime.getTime();
					timer.schedule(new TimerReserveDeadLine(tables, currentReservations, i, reservedForTime), time);
					return;
				}
				else{
					tables.get(i).setStatus(Status.OCCUPIED2RESERVED);
					Timer timer = new Timer();
					Date time = reservedTillTime.getTime();
					timer.schedule(new TimerReserveDeadLine(tables, currentReservations, i, reservedForTime), time);
					return;
				}
			}
		}
    }
}
