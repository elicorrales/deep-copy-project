package deepcopy.factorymethod.impl;

import deepcopy.factorymethod.Address;
import deepcopy.factorymethod.State;

public class AddressImpl implements Address {

	private String address1;
	private String address2;
	private State state;
	private String zip;
	
	private AddressImpl(String a1, String a2, State s, String z) {
		this.address1 = a1;
		this.address2 = a2;
		this.state = s;
		this.zip = z;
	}

	private AddressImpl(Address a) {
		this.address1 = new String(a.getAddress1());
		this.address2 = new String(a.getAddress2());
		this.state = a.getState();
		this.zip = new String(a.getZip());
	}

	public static Address newInstance(String a1, String a2, State s, String z) {

		return new AddressImpl(a1, a2, s, z);

	}

	public static Address newInstance(Address s) {

		return new AddressImpl(s);

	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#getAddress1()
	 */
	@Override
	public String getAddress1() {
		return address1;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#setAddress1(java.lang.String)
	 */
	@Override
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#getAddress2()
	 */
	@Override
	public String getAddress2() {
		return address2;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#setAddress2(java.lang.String)
	 */
	@Override
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#getState()
	 */
	@Override
	public State getState() {
		return state;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#setState(deepcopy.factorymethod.State)
	 */
	@Override
	public void setState(State state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#getZip()
	 */
	@Override
	public String getZip() {
		return zip;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Address#setZip(java.lang.String)
	 */
	@Override
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		AddressImpl other = (AddressImpl) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (state != other.state)
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressImpl [address1=" + address1 + ", address2=" + address2 + ", state=" + state + ", zip=" + zip + "]";
	}
	

}
