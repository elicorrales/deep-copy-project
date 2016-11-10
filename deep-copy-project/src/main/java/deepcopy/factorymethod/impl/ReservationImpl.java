package deepcopy.factorymethod.impl;

import deepcopy.factorymethod.CruisePackage;
import deepcopy.factorymethod.Reservation;
import deepcopy.factorymethod.User;

public class ReservationImpl implements Reservation {

	private User user;
	private CruisePackage cruisePkg;
	
	private ReservationImpl(User u, CruisePackage p) {
		
		this.user = u;
		this.cruisePkg = p;
	}
	
	private ReservationImpl(Reservation r) {
		
		this.user = UserImpl.newInstance(r.getUser());
		this.cruisePkg = CruisePackageImpl.newInstance(r.getCruisePkg());
	}

	public static Reservation newInstance(User u, CruisePackage p) {
		
		return new ReservationImpl(u, p);
	}

	public static Reservation newInstance(Reservation r) {
		
		return new ReservationImpl(r);
	}


	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Reservation#getUser()
	 */
	@Override
	public User getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Reservation#setUser(deepcopy.factorymethod.impl.UserImpl)
	 */
	@Override
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Reservation#getCruisePkg()
	 */
	@Override
	public CruisePackage getCruisePkg() {
		return cruisePkg;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Reservation#setCruisePkg(deepcopy.factorymethod.impl.CruisePackageImpl)
	 */
	@Override
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
		ReservationImpl other = (ReservationImpl) obj;
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
