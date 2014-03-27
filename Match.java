package vm2014;
import java.sql.*;


public class Match {
	private Team team1;
	private Team team2;
	private int goals1;
	private int goals2;
	public Match(Team hjemmeL, Team borteL, int hjemmeM, int borteM) throws SQLException{
		Connection conn = DatabaseConnection.connect();
		team1 = hjemmeL;
		team2 = borteL;
		this.goals1 = hjemmeM;
		this.goals2 = borteM;
		
		Statements.getIdKamp(hjemmeL,borteL);
		
		// Ikke lukk databasen før jeg har gjort noe med den.
		DatabaseConnection.disconnect(conn);
	}
	public void givePointsT1(){
		if (goals1>goals2){
			team1.setPoints(3);
		}
		else if (goals1 == goals2){
			team1.setPoints(1);
		}
		
	}
	public Team getTeam1() {
		return team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public int getGoals1() {
		return goals1;
	}
	public int getGoals2() {
		return goals2;
	}
	public void givePointsT2(){
		if (goals1<goals2){
			team2.setPoints(3);	
		}
		else if (goals1 == goals2){
			team2.setPoints(1);	
		}
		
	}
	public void giveGoalsT1(){
		team1.setGoals(goals1-goals2);
	}
	public void giveGoalsT2(){
		team2.setGoals(goals2-goals1);
	}
	public void updateSQL(){
		//Oppdaterer kampen i forhold til hva som skjer.
	}
}
