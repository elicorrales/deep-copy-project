package deepcopy.constructor;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DeepCopyTest {

	private List<Reservation> reservations = new ArrayList<Reservation>();
	

	public void setup() {
		
		System.out.println("\n\nSTART SETUP (loading orig list)\n\n");

		Instant start = Instant.now();
		
		for (int i=0;i<100000;i++) { // >4 sec

			List<Stop> stops1 = new ArrayList<Stop>();
			
			for (int ii=0;ii<5;ii++) {
				stops1.add(new Stop("StopID"+i+"_"+ii,"some stop "+i+"_"+ii));
			}
			reservations.add(new Reservation(
					new User(
							"admin"+"_"+i+"@rccl.com",
							Role.ADMIN,
							new Name("John"+i,"Doe"+i),
							new Address("123"+i+" Some St","Apt "+i,State.AL,"12345-"+i),
							true),
					new CruisePackage("PKGID"+i,"Somewhere in "+i, i, new Date(), stops1)
							)
					);

			reservations.add(new Reservation(
					new User(
							"guest"+"_"+i+"@yahoo.com",
							Role.GUEST,
							new Name("Jane"+i,"Smith"+i),
							new Address("999"+i+" Some Ave","Bldg "+i,State.FL,"33333-"+i),
							true),
					new CruisePackage(""+i+"PKGID","Somewhere Else in "+i, i, new Date(), stops1)
							)
					);

		}

		Instant stop = Instant.now();
		
		Duration delta = Duration.between(start,stop);

		System.out.println("\n\nSTOP  SETUP (loading orig list)\n\n");

		System.out.println(
				"secs="+delta.getSeconds()
				+", millis="+delta.toMillis()
				+", nanos="+delta.toNanos()
				);
		

	}
	
	public void test() {
		
		System.out.println("\n\nSTART TEST (copy orig list)\n\n");

		Instant start = Instant.now();
		
		List<Reservation> reservations2 = new ArrayList<Reservation>();
		
		for (Reservation r : reservations) {
			reservations2.add(new Reservation(r));
		}

		Reservation  rOrig = reservations.get(0);
		Reservation  rCopy = reservations2.get(0);
		
		if (!rOrig.equals(rCopy)) {
			System.out.println(rOrig);
			System.out.println();
			System.out.println(rCopy);
		}
	
		Instant stop = Instant.now();
		
		Duration delta = Duration.between(start,stop);

		System.out.println("\n\nSTOP   TEST (copy orig list)\n\n");

		System.out.println(
				"secs="+delta.getSeconds()
				+", millis="+delta.toMillis()
				+", nanos="+delta.toNanos()
				);
		
		rCopy.getCruisePkg().getStops().add(new Stop("new","new"));
		rCopy.getCruisePkg().setPackageId("changed");
		rCopy.getUser().getAddress().setZip("changed");

		if (!rOrig.equals(rCopy)) {
			System.out.println(rOrig);
			System.out.println();
			System.out.println(rCopy);
		}
	
	}
	
	
	public static void main(String[] args) {
		
		DeepCopyTest t = new DeepCopyTest();
		
		t.setup();
		
		t.test();
	}
}
