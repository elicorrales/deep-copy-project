package deepcopy.factorymethod;

import deepcopy.factorymethod.CruisePackage;
import deepcopy.factorymethod.User;

public interface Reservation {

	User getUser();

	void setUser(User user);

	CruisePackage getCruisePkg();

	void setCruisePkg(CruisePackage cruisePkg);

}