package system.core;
import java.util.Comparator;

/**
 * Implements Comparator for DockingStation.
 * <p>
 * Compare stations by the number of operation done in it.
 * </p>
 */
public class ComparatorByMostUsedStation implements Comparator<DockingStation>{

	@Override
	public int compare(DockingStation o1, DockingStation o2) {

		int total1 = o1.dockingStationBalance.getTotalNumberOfRent()+o1.dockingStationBalance.getTotalNumberOfReturn();
		int total2 = o2.dockingStationBalance.getTotalNumberOfRent()+o2.dockingStationBalance.getTotalNumberOfReturn();
		if (total1>total2) {return -1;}
		if (total1<total2) {return 1;}
		else{return 0;}
	}


}

