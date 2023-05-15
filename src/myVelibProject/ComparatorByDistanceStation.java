package myVelibProject;
import java.util.Comparator;

public class ComparatorByDistanceStation implements Comparator<DockingStation>{

	@Override
	public int compare(DockingStation o1, DockingStation o2) {
		 
		double distance1 = o1.ge()-o1.dockingStationBalance.getTotalNumberOfReturn();
		if (total1>total2) {return 1;}
		if (total1<total2) {return -1;}
		else{return 0;}
	}
}