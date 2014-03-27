package vm2014;

public class Team implements Comparable {
	private String name;
	private int points;
	private int goals;
	public Team(String name){
		this.name = name;
		points = 0;
		goals = 0;
	}
	public String getName(){
		return this.name;
	}
	public void setPoints(int newPoints){
		points +=newPoints;
	}
	public void setGoals(int newGoals){
		goals +=newGoals;
	}
	

	public int compareTo(Team compTeam) {
		if (compTeam.points < this.points){
			return 1;
		} 
		else if (compTeam.points > this.points){
			return -1;
		}
		else{
			if (compTeam.goals < this.goals){
				return 1;
				}
			else if (compTeam.goals> this.goals){
				return -1;
			}
			return this.name.compareTo(compTeam.name);			}
		}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	}

