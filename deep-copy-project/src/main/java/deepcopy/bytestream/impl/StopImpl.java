package deepcopy.bytestream.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import deepcopy.bytestream.Stop;


public class StopImpl implements Stop, Serializable {

	private static final long serialVersionUID = 1L;

	private String stopId;
	private String description;

	private StopImpl(String stopId, String description) {

		this.stopId = stopId;
		this.description = description;
	}

/*
	public static Stop deepClone(Stop object) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (Stop)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
*/

	public static Stop newInstance(String stopId, String description) {

		return new StopImpl(stopId, description);

	}


	@Override
	public String getStopId() {
		return stopId;
	}

	@Override
	public void setStopId(String stopId) {
		this.stopId = stopId;
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
		return "Stop [stopId=" + stopId + ", description=" + description + "]";
	}

}
