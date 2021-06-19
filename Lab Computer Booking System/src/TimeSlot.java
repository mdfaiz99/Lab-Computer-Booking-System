
import java.util.*;

public class TimeSlot {
	
	private ArrayList<Computer> comps;
	private int session;
	private int lab;
	private int comp;
	
	public TimeSlot (int lab, int comp, int session){
		this.session = session;
		this.lab = lab;
		this.comp = comp;
		comps = new ArrayList<Computer>();
		createSeats(this.comp);
	}
	
	public void setLabClass(int rowClass){
		this.lab = rowClass;
	}
	
	public int getLabClass(){
		return this.lab;
	}
	
	public int getSession(){
		return session;
	}
	
	public void createSeats(int comp){
		for (int i = 1; i <= comp; i++){
			comps.add(new Computer(false, i));
		}
	}
	
	public ArrayList<Computer> getComputer(){
		return comps;
	}
	
}
