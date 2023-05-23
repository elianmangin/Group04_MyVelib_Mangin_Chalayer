package myVelibProject;

import java.util.Comparator;

public class ComparatorByIDStation implements Comparator<DockingStation> {
	@Override
	public int compare(DockingStation o1, DockingStation o2) {
		if (o1.getUniqID()>o2.getUniqID()) {return 1;}
		if (o1.getUniqID()<o2.getUniqID()) {return -1;}
		else{return 0;}
	}

}
