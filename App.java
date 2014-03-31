package vm2014;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
	private ArrayList<User> bruker = new ArrayList<User>();
	
	public static void main(String[] args) {
		App app = new App();
		try {
			app.updateMatch(1, 2, 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	HashMap<Integer, Match> matches;
	HashMap<String, Team> teams;
	ArrayList<User> users;
	
	public App() {
		try {
			teams = Require.teams();
			matches = Require.matches(teams);
			users = Require.users(matches);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateMatch(int matchID,int home, int away) throws SQLException{
		Match m = matches.get(matchID);
		m.played = true;
		m.home = home;
		m.away = away;
		
		updateUsers();
		updateTeams();
		
		Require.updateDB(matches, teams, users);
	}

	private void updateTeams() {
		for(Team t : teams.values()) {
			t.goals = 0;
			t.points = 0;
		}
		
		for (Match m : matches.values()){
			if(!m.played) continue;
			
			if (m.home > m.away)	m.homeTeam.points += 3;
			else if (m.home < m.away) m.awayTeam.points +=3;
			else{
				m.awayTeam.points += 1;
				m.homeTeam.points += 1;
			}
			m.homeTeam.goals += m.home - m.away; 
			m.awayTeam.goals +=m.away - m.home;
		}
	}

	private void updateUsers() {
		for (User u : users){
			u.points = 0;
			System.out.println(u.username);
			for(Match m : matches.values()) {
				if(!u.bets.containsKey(m) || !m.played) continue;
				Bet bet = u.bets.get(m); //Get users bet on match
				if(bet.victor == m.victor()) u.points += 1;
				if(bet.home == m.home && bet.away == m.away) u.points += 2;
			}
		}
	}
}
