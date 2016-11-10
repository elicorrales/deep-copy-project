package deepcopy.constructor;

public class Reservation {

	private User user;
	private CruisePackage cruisePkg;
	
	public Reservation(User u, CruisePackage p) {
		
		this.user = u;
		this.cruisePkg = p;
	}
	
	public Reservation(Reservation r) {
		
		this.user = new User(r.getUser());
		this.cruisePkg = new CruisePackage(r.getCruisePkg());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CruisePackage getCruisePkg() {
		return cruisePkg;
	}

	public void setCruisePkg(CruisePackage cruisePkg) {
		this.cruisePkg = cruisePkg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cruisePkg == null) ? 0 : cruisePkg.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (cruisePkg == null) {
			if (other.cruisePkg != null)
				return false;
		} else if (!cruisePkg.equals(other.cruisePkg))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReservationImpl ["
			   +"\tuser=" + user + ",\n"
			   +"\tcruisePkg=" + cruisePkg + "\n]";
	}
	
	
}
