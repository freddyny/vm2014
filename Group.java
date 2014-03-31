package vm2014;

import java.util.ArrayList;
import java.util.Collections;

public class Group {

	ArrayList<Team> group;
	
	public Group(char bokstav, Team lag1, Team lag2, Team lag3, Team lag4) {
		group = new ArrayList<Team>();
		group.add(lag1);
		group.add(lag2);
		group.add(lag3);
		group.add(lag4);
		Collections.sort(group);
	}
}
