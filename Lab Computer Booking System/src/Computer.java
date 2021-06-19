
public class Computer {
	
	private int computerID;
	private boolean isBooked;
	
	public Computer(boolean isBooked,int computerID) {
		this.isBooked = isBooked;
		this.computerID = computerID;
	}
	
	public void setComputerID(int computerID) {
		this.computerID = computerID;
	}
	
	public int getComputerID() {
		return this.computerID;
	}
	
	public boolean getBookingStatus() {
		return isBooked;
	}
	
	public void booked() {
		isBooked = true;
	}
	
	public void unbooked() {
		isBooked = false;
	}
	
}