package deepcopy.bytestream;

public interface User {

	String getEmailAddress();

	void setEmailAddress(String emailAddress);

	Role getRole();

	void setRole(Role role);

	Name getName();

	void setName(Name name);

	Address getAddress();

	void setAddress(Address address);

	boolean isActive();

	void setActive(boolean active);

}