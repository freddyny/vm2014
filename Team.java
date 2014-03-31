package vm2014;

public class Team implements Comparable<Team> {
	String name;
	int points;
	int goals;

	public Team(String name, int points, int goals) {
		this.name = name;
		this.points = points;
		this.goals = goals;
	}

	public int compareTo(Team compTeam) {
		if (compTeam.points < this.points) {
			return 1;
		} else if (compTeam.points > this.points) {
			return -1;
		} else {
			if (compTeam.goals < this.goals) {
				return 1;
			} else if (compTeam.goals > this.goals) {
				return -1;
			}
			return this.name.compareTo(compTeam.name);
		}
	}
}