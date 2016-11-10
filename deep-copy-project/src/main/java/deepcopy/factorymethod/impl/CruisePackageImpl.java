package deepcopy.factorymethod.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import deepcopy.factorymethod.CruisePackage;
import deepcopy.factorymethod.Stop;

public class CruisePackageImpl implements CruisePackage {

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
	
	private CruisePackageImpl(CruisePackage c) {

		this.packageId = new String(c.getPackageId());
		this.description = new String(c.getDescription());
		this.days = c.getDays();

		this.start = new Date(c.getStart().getTime());
		
		stops = new ArrayList<Stop>();
		
		for (Stop s : c.getStops()){
			
			stops.add(StopImpl.newInstance(s));
		}

	}

	public static CruisePackage newInstance(
			String pkgId, String descrip, int days, Date start, List<Stop> stops) {
		
		return new CruisePackageImpl(pkgId, descrip, days, start, stops);
	}

	public static CruisePackage newInstance(CruisePackage c) {
		
		return new CruisePackageImpl(c);
	}

	

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#getPackageId()
	 */
	@Override
	public String getPackageId() {
		return packageId;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#setPackageId(java.lang.String)
	 */
	@Override
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#getDays()
	 */
	@Override
	public int getDays() {
		return days;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#setDays(int)
	 */
	@Override
	public void setDays(int days) {
		this.days = days;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#getStart()
	 */
	@Override
	public Date getStart() {
		return start;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#setStart(java.util.Date)
	 */
	@Override
	public void setStart(Date start) {
		this.start = start;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#getStops()
	 */
	@Override
	public List<Stop> getStops() {
		return stops;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.CruisePackage#setStops(java.util.List)
	 */
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
		return "CruisePackageImpl ["
				+"\tpackageId=" + packageId 
				+",\n\tdescription=" + description 
				+",\n\tdays=" + days 
				+",\n\tstart=" + start 
				+",\n\tstops=" + stops + "\n]\n";
	}

	
}
