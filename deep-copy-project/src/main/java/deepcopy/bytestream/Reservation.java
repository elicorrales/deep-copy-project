package deepcopy.bytestream;


public interface Reservation {

	User getUser();

	void setUser(User user);

	CruisePackage getCruisePkg();

	void setCruisePkg(CruisePackage cruisePkg);

}