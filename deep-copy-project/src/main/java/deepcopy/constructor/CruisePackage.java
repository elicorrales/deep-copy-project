package deepcopy.constructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CruisePackage {

	private String packageId;
	private String description;
	private int days;
	private Date start;
	private List<Stop> stops;
	
	public CruisePackage( String pkgId, String descrip, int days, Date start, List<Stop> stops) {
		
		this.packageId = pkgId;
		this.description = descrip;
		this.days = days;
		this.start = start;
		this.stops = stops;
	}
	
	public CruisePackage(CruisePackage c) {

		this.packageId = new String(c.getPackageId());
		this.description = new String(c.getDescription());
		this.days = c.getDays();

		this.start = new Date(c.getStart().getTime());
		
		stops = new ArrayList<Stop>();
		
		for (Stop s : c.getStops()){
			
			stops.add(new Stop(s));
		}

	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public List<Stop> getStops() {
		return stops;
	}

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
		CruisePackage other = (CruisePackage) obj;
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
		return "CruisePackageImpl ["
				+"\tpackageId=" + packageId 
				+",\n\tdescription=" + description 
				+",\n\tdays=" + days 
				+",\n\tstart=" + start 
				+",\n\tstops=" + stops + "\n]\n";
	}

	
}
