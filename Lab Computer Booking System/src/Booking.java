
public class Booking {
	
	Student student;
	Day day;
	
	int computerID;
	int time;
	
	public Booking(Student student,Day day) {
		this.student = student;
		this.day = day;
	}
	
	public void setComputerID(int computerID) {
		this.computerID = computerID;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void settime(int time) {
		this.time = time;
	}
	
	public void setComp(int computerID) {
		this.computerID = computerID;
	}
	
	public boolean bookComp(int selectComp, int selecttime) {
		if (day.getLab().getTimeSlot().get(selectComp).getComputer().get(selecttime).getBookingStatus()){
			return false;
		}
		
		else {
			day.getLab().getTimeSlot().get(selectComp).getComputer().get(selecttime).booked();
			setComp(selectComp);	
			settime(selecttime);
			return true;
		}
	}
	
	public boolean unbookComp() {
		day.getLab().getTimeSlot().get(time).getComputer().get(computerID).unbooked();
		return true;
	}
	
	public Student getStudent() {
		return student;
	}

}
