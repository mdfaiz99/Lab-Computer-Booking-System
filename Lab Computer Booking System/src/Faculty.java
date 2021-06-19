//this is the main class
// student username is student and password is student
//admin username is admin and password is admin
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

	public class Faculty{

		public static void main (String[] args){

			Scanner select = new Scanner(System.in);
			Scanner choice = new Scanner(System.in);			
			Scanner sc = new Scanner(System.in);
			
			ArrayList<Day> days = new ArrayList<Day>();
			ArrayList<Lab> labs = new ArrayList<Lab>();
			ArrayList<Booking> bookings = new ArrayList<Booking>();
			ArrayList<Student> students = new ArrayList<Student>();
			
			int option = 0;		
			int enters = 0;

			Lab testLab = new Lab(1, "Makmal Pengajaran 1");
			testLab.createRows(1, 40, 5);
			labs.add(testLab);
			days.add(new Day("Monday", labs.get(0)));
			days.add(new Day("Tuesday", labs.get(0)));
			days.add(new Day("Wednesday", labs.get(0)));
			days.add(new Day("Thursday", labs.get(0)));
			days.add(new Day("Friday", labs.get(0)));
			do {
			System.out.println("------------------------------------");
			System.out.println("Lab Computer Booking System");
			System.out.println("------------------------------------");
			System.out.println("Please Enter 1 to Login as Student");
			System.out.println("Please Enter 2 to Login as System Admin");
			System.out.println("Enter Option: ");
			option = select.nextInt();
			
					if(option==1){

						System.out.println("Student Login");
						System.out.print("-------------------------\n");
						System.out.println("Enter username : ");
						String username = sc.nextLine();
						System.out.println("Enter password : ");
						String password = sc.nextLine();
						
						if(username.equals("student") && password.equals("student")) {
						
							System.out.println("-------------------------\n");
							System.out.println("Login is successful");
							System.out.println("1. Book a computer");
							System.out.println("2. Cancel a booking");
							enters = select.nextInt();
							
							if(enters == 1) {
								System.out.println("Book a computer");
								System.out.println("-------------------------\n");
								
								Random rnd = new Random();
								int bookId = rnd.nextInt(999);
								Student std = new Student(bookId);
								students.add(std);
								
								for (int i = 0; i< days.size(); i++){
									int showNumber = i + 1;
									System.out.println("Day Number " + showNumber + " : " + days.get(i).getShowDay());				

								}
								System.out.println("-------------------------");
								System.out.println("Enter the number of day ");
								int showNumber = choice.nextInt();
								if( showNumber <5 ) {
									
								int repeat = 1;
								System.out.println();
								
								while( repeat>0){
									days.get(showNumber-1).getLab().printSeatPlan();
									System.out.print("Enter session: ");
									int selectedRow = choice.nextInt();
									System.out.print("Enter the computer ID. : ");
									int selectedSeat = choice.nextInt();
									System.out.println();
									Booking booking = new Booking(std, days.get(showNumber-1));
										if (booking.bookComp(selectedRow-1, selectedSeat-1)) {
											bookings.add(booking);
											System.out.println("The computer is booked.");
										}
										else {
											System.out.println("Sorry the computer is already been booked or under maintenance.");
										}
									System.out.println();
									System.out.print("Enter 1 to book another seat or 0 to check out: ");
									repeat = choice.nextInt();
								}			
										if(repeat == 0);{
											System.out.println();
											System.out.println("Your Booking ID");
											System.out.println("-------------------------");
											System.out.println("Book ID. : " + std.getId());	
										}
								}
								else {
									System.exit(0);
								}
							}
						

						}
						
							if(enters == 2){
								System.out.println("Cancel a booking");
								System.out.println("-------------------------\n");
								System.out.print("Enter your booking ID.: ");		

								int studentid = choice.nextInt();
								for (Student std : students) {
									if (std.getId() == studentid){
										for(Booking book : bookings){
											if (book.getStudent().getId() == std.getId()){
												if (book.unbookComp()){

												}
											}
										}
										System.out.println("Your booking has been canceled!");
									}
								}
								System.out.println();
							}
							if(enters == 3) {
								System.out.println("Logout is Successful");
								System.exit(0);
							}
					}			
					if(option==2) {
						System.out.println("System Admin Login");
						System.out.print("-------------------------\n");
						System.out.println("Enter username : ");
						String username = sc.nextLine();
						System.out.println("Enter password : ");
						String password = sc.nextLine();
						if(username.equals("admin") && password.equals("admin")) {
							
							System.out.println("-------------------------\n");
							System.out.println("Login is successful");
							System.out.println("1. Set computer's status");
							System.out.println("2. Change computer's status");
							System.out.println("3. Logout");
							enters = select.nextInt();
							
							if(enters == 1) {
								System.out.println("Set computer's status");
								System.out.println("-------------------------\n");
								
								Random rnd = new Random();
								int bookId = rnd.nextInt(999);
								Student std = new Student(bookId);
								students.add(std);
								
								for (int i = 0; i< days.size(); i++){
									int showNumber = i+1;
									System.out.println("Day Number " + showNumber+" : "+days.get(i).getShowDay());				

								}
								System.out.println("-------------------------");
								System.out.println("Enter the number of day ");
								int showNumber = choice.nextInt();
								if( showNumber <5 ) {
									
								int repeat = 1;
								System.out.println();
								
								while( repeat>0){
									days.get(showNumber-1).getLab().printSeatPlan();
									System.out.print("Enter session: ");
									int selectedRow = choice.nextInt();
									System.out.print("Enter the computer ID: ");
									int selectedSeat = choice.nextInt();
									System.out.println();
									Booking booking = new Booking(std, days.get(showNumber-1));
										if (booking.bookComp(selectedRow-1, selectedSeat-1)) {
											bookings.add(booking);
											System.out.println("The computer is now set to maintenance");
										}
									System.out.println();
									System.out.print("Enter 1 to book another seat or 0 to check out: ");
									repeat = choice.nextInt();
								}			
										if(repeat == 0);{
											System.out.println();
											System.out.println("-------------------------");
											System.out.println("Set status ID : " + std.getId());	
										}
								}
								else {
									System.exit(0);
								}
							}
						

						}
						
							if(enters == 2){
								System.out.println("Undo set computer's status");
								System.out.println("-------------------------\n");
								System.out.print("Set status ID.: ");		

								int studentid = choice.nextInt();
								for (Student std : students) {
									if (std.getId() == studentid){
										for(Booking book : bookings){
											if (book.getStudent().getId() == std.getId()){
												if (book.unbookComp()){

												}
											}
										}
										System.out.println("This computer is available");
									}
								}
								System.out.println();
							}
							if(enters == 3) {
								System.out.println("Logout is Successful");
								System.exit(0);
							}		
					}
			
			
			}
			while(true);
		}
}