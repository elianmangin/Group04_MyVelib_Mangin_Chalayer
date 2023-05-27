package Group04_MyVelib_Mangin_Chalayer.system.core;
import java.util.Comparator;

/**
 * Implements Comparator for DockingStation.
 * <p>
 * Compare stations by the difference of the number of bike dropped in and rent from.
 * </p>
 */
public class ComparatorByLeastOccupiedStation implements Comparator<DockingStation>{

	@Override
	public int compare(DockingStation o1, DockingStation o2) {
		
		o1.getUniqID();
		int total1 = o1.getNumberOfSlotsOccupied();
		o2.getUniqID();
		int total2 = o2.getNumberOfSlotsOccupied();
		if (total1>total2) {return 1;}
		if (total1<total2) {return -1;}
		else{return 0;}
	}
}