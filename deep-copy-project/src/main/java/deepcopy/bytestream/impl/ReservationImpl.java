package deepcopy.bytestream.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import deepcopy.bytestream.CruisePackage;
import deepcopy.bytestream.Reservation;
import deepcopy.bytestream.User;


public class ReservationImpl implements Reservation, Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private CruisePackage cruisePkg;
	
	private ReservationImpl(User u, CruisePackage p) {
		
		this.user = u;
		this.cruisePkg = p;
	}
	

	public static Reservation newInstance(User u, CruisePackage p) {
		
		return new ReservationImpl(u, p);
	}

	public static Reservation deepClone(Reservation object) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Reservation)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public CruisePackage getCruisePkg() {
		return cruisePkg;
	}

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
		return "Reservation ["
			   +"\tuser=" + user + ",\n"
			   +"\tcruisePkg=" + cruisePkg + "\n]";
	}
	
	
}
