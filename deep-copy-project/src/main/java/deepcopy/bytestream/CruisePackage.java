package deepcopy.bytestream;

import java.util.Date;
import java.util.List;

public interface CruisePackage {

	String getPackageId();

	void setPackageId(String packageId);

	String getDescription();

	void setDescription(String description);

	int getDays();

	void setDays(int days);

	Date getStart();

	void setStart(Date start);

	List<Stop> getStops();

	void setStops(List<Stop> stops);

}