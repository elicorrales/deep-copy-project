package deepcopy.bytestream.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import deepcopy.bytestream.CruisePackage;
import deepcopy.bytestream.Stop;


public class CruisePackageImpl implements CruisePackage, Serializable {

	private static final long serialVersionUID = 1L;

	private String packageId;
	private String description;
	private int days;
	private Date start;
	private List<Stop> stops;
	
	private CruisePackageImpl( String pkgId, String descrip, int days, Date start, List<Stop> stops) {
		
		this.packageId = pkgId;
		this.description = descrip;
		this.days = days;
		this.start = start;
		this.stops = stops;
	}
	

	public static CruisePackage newInstance(
			String pkgId, String descrip, int days, Date start, List<Stop> stops) {
		
		return new CruisePackageImpl(pkgId, descrip, days, start, stops);
	}

/*
	public static CruisePackage deepClone(CruisePackage object) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (CruisePackage)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
*/

	

	@Override
	public String getPackageId() {
		return packageId;
	}

	@Override
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int getDays() {
		return days;
	}

	@Override
	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public Date getStart() {
		return start;
	}

	@Override
	public void setStart(Date start) {
		this.start = start;
	}

	@Override
	public List<Stop> getStops() {
		return stops;
	}

	@Override
	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + days;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((stops == null) ? 0 : stops.hashCode());
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
		CruisePackageImpl other = (CruisePackageImpl) obj;
		if (days != other.days)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (stops == null) {
			if (other.stops != null)
				return false;
		} else if (!stops.equals(other.stops))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "CruisePackage ["
				+"\tpackageId=" + packageId 
				+",\n\tdescription=" + description 
				+",\n\tdays=" + days 
				+",\n\tstart=" + start 
				+",\n\tstops=" + stops + "\n]\n";
	}

	
}
