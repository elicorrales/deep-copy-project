package deepcopy.factorymethod.impl;

import deepcopy.factorymethod.Stop;

public class StopImpl implements Stop {

	private String stopId;
	private String description;
	
	private StopImpl(String stopId, String description) {
		
		this.stopId = stopId;
		this.description = description;
	}
	
	private StopImpl(Stop s) {
		this.stopId = new String(s.getStopId());
		this.description = new String(s.getDescription());
	}

	public static Stop newInstance(String stopId, String description) {

		return new StopImpl(stopId, description);

	}

	public static Stop newInstance(Stop s) {

		return new StopImpl(s);

	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Stop#getStopId()
	 */
	@Override
	public String getStopId() {
		return stopId;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Stop#setStopId(java.lang.String)
	 */
	@Override
	public void setStopId(String stopId) {
		this.stopId = stopId;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Stop#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Stop#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((stopId == null) ? 0 : stopId.hashCode());
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
		StopImpl other = (StopImpl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (stopId == null) {
			if (other.stopId != null)
				return false;
		} else if (!stopId.equals(other.stopId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StopImpl [stopId=" + stopId + ", description=" + description + "]";
	}
	
	
}
