package vm2014;
import java.util.ArrayList;
import java.util.Collections;
public class Group {
	private final int numberOfTeams = 4;
	public int getNumberOfTeams() {
		return numberOfTeams;
	}

	private ArrayList<Team> group;
	@SuppressWarnings("unchecked")
	public Group(char bokstav, Team lag1, Team lag2, Team lag3, Team lag4){
		group = new ArrayList<Team>();
		group.add(lag1);
		group.add(lag2);
		group.add(lag3);
		group.add(lag4);
		Collections.sort(group);
		}
	public ArrayList<Team> getGroup(){
		return this.group;
	}
	@SuppressWarnings("unchecked")
	public void newMatch(Match match){
		if (group.contains(match.getTeam1()) && group.contains(match.getTeam2())){		
			match.givePointsT1();
			match.givePointsT2();
			match.giveGoalsT1();
			match.giveGoalsT2();
			Collections.sort(group);
			}
	}
	
	public Team getTeam(int position){
		return group.get(position);
		}

	}


