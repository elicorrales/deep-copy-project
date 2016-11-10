package deepcopy.factorymethod.impl;

import deepcopy.factorymethod.Address;
import deepcopy.factorymethod.Name;
import deepcopy.factorymethod.Role;
import deepcopy.factorymethod.User;

public class UserImpl implements User {

	private String emailAddress;
	private Role role;
	private Name name;
	private Address address;
	private boolean active;
	
	private UserImpl(String em, Role r, Name n, Address adr, boolean active) {
		this.emailAddress = em;
		this.role = r;
		this.name = n;
		this.address = adr;
		this.active = active;
	}

	private UserImpl(User u) {
		
		this.emailAddress = new String(u.getEmailAddress());
		this.role = u.getRole();
		this.name = NameImpl.newInstance(u.getName());
		this.address = AddressImpl.newInstance(u.getAddress());
		this.active = u.isActive();
	}

	public static User newInstance(String em, Role r, Name n, Address adr, boolean active) {
		
		return new UserImpl(em, r, n, adr, active);
	}

	public static User newInstance(User u) {
		
		return new UserImpl(u);
	}

	
	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#getEmailAddress()
	 */
	@Override
	public String getEmailAddress() {
		return emailAddress;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#setEmailAddress(java.lang.String)
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#getRole()
	 */
	@Override
	public Role getRole() {
		return role;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#setRole(deepcopy.factorymethod.Role)
	 */
	@Override
	public void setRole(Role role) {
		this.role = role;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#getName()
	 */
	@Override
	public Name getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#setName(deepcopy.factorymethod.Name)
	 */
	@Override
	public void setName(Name name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#getAddress()
	 */
	@Override
	public Address getAddress() {
		return address;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#setAddress(deepcopy.factorymethod.Address)
	 */
	@Override
	public void setAddress(Address address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#isActive()
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.User#setActive(boolean)
	 */
	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		UserImpl other = (UserImpl) obj;
		if (active != other.active)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserImpl [emailAddress=" + emailAddress + ", role=" + role + ", name=" + name + ", address=" + address
				+ ", active=" + active + "]";
	}

}
