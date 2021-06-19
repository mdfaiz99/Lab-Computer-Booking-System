
import java.util.ArrayList;

public class Day {
	
	private String showDay;
	private Lab lab;
	private ArrayList<Computer> comps;
	private int freeComps;
	
	public Day(String showDay,Lab lab) {
		this.showDay = showDay;
		this.lab = lab;
	}
	
	public void loadComputer() {
		for (TimeSlot ts : lab.getTimeSlot()) {
			for (Computer comp : ts.getComputer()) {
				comps.add(comp);
			}		
		}
	}
	
	public int getFreeCompsCount() {
		for (Computer comp : comps) {
			if(!comp.getBookingStatus()) {
				
			}
		}
		return freeComps;
	}
	
	public void setShowDay(String showDay) {
		this.showDay = showDay;
	}
	
	public void setLab(Lab lab) {
		this.lab = lab;
	}
	
	public String getShowDay() {
		return showDay;
	}
	
	public Lab getLab() {
		return lab;
	}
	
	public ArrayList<Computer> getComputer(){
		return comps;
	}
	
}
