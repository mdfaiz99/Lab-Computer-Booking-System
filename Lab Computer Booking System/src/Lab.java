
import java.util.ArrayList;
import java.util.Scanner;

public class Lab {
	
	private int labNum;
	private String desc;
	private ArrayList<TimeSlot> timeSlot;
	private int rowCount;
	private ArrayList<Student> student = new ArrayList<Student>();
	
	public Lab(int labNum,String desc) {
		this.labNum = labNum;
		this.desc = desc;
		timeSlot = new ArrayList<TimeSlot>();
	}

	public ArrayList<TimeSlot> getTimeSlot(){
		return timeSlot;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void createRows(int rowClass, int seatCount, int rowCount){
		for (int i = 1; i <= rowCount; i++){
			timeSlot.add(new TimeSlot(rowClass, seatCount, i));
		}
		this.rowCount += rowCount;
	}

	public ArrayList<TimeSlot> getRows(){
		return timeSlot;
	}

	public String getDescription(){
		return desc;
	}

	public void printSeatPlan(){
		System.out.println("Session \t Computer No.");
		int maxSeatsInRow = 0;
		for (TimeSlot timeSlot : getRows()){
			if (timeSlot.getComputer().size() > maxSeatsInRow){
				maxSeatsInRow = timeSlot.getComputer().size();
			}
		}
		
		for (TimeSlot timeSlot : getRows()){
			if (timeSlot.getSession()>9) {
				System.out.print(7+timeSlot.getSession() + "\t | ");
			}
			else {
				System.out.print(timeSlot.getSession() + "\t | ");
			}

			for (Computer computer : timeSlot.getComputer()){
				if (computer.getBookingStatus()) {
					System.out.print("X ");
				}
				else {
					System.out.print(computer.getComputerID() + " ");
				}
			}

			System.out.print("\n");

		}

		System.out.print("\n");

		}
}