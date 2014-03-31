package vm2014;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Require {
	public static HashMap<String, Team> teams() throws SQLException{
		HashMap<String, Team> teams = new HashMap<String, Team>();
		
		Connection conn = DatabaseConnection.connect();
		PreparedStatement statement = conn.prepareStatement("SELECT navn FROM lag");
		ResultSet rs = statement.executeQuery();
		while (rs.next()){
			String name = rs.getString(1);
			teams.put(name, new Team(name,0,0));
		}
		rs.close();
		conn.close();
		
		return teams;
	}
	public static HashMap<Integer, Match> matches(HashMap<String,Team> teams) throws SQLException {
		HashMap<Integer,Match> matches = new HashMap<Integer,Match>();
		Connection conn = DatabaseConnection.connect();

		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Kamp");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			int homeG =rs.getInt(2);
			int awayG =rs.getInt(3);
			String home = rs.getString(4);
			String away = rs.getString(5);
			boolean played = rs.getInt(6) > 0;
			Team t1 = teams.get(home);
			Team t2 = teams.get(away);
			matches.put(id, new Match(id,t1,t2,homeG,awayG, played));
		}
		rs.close();
		conn.close();

		return matches;
	}

	public static ArrayList<User> users(HashMap<Integer,Match> matches) throws SQLException {
		ArrayList<User> users = new ArrayList<User>();

		Connection conn = DatabaseConnection.connect();

		PreparedStatement statement = conn
				.prepareStatement("SELECT brukernavn, poeng FROM Bruker");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			String name = rs.getString(1);
			int points = rs.getInt(2);
			users.add(new User(name, points));
		}
		rs.close();
		
		for (User u: users){
			statement = conn.prepareStatement("SELECT * FROM Tipper WHERE brukernavn = ?");
			statement.setString(1, u.username);
			rs = statement.executeQuery();
			while(rs.next()){
				int matchID = rs.getInt(2);
				char victor = rs.getString(3).charAt(0);
				int home = rs.getInt(4);
				int away = rs.getInt(5);
				Match m = matches.get(matchID);
				u.bets.put(m, new Bet(m,victor,home,away));
			}
		}
		
		conn.close();
		return users;
	}
	public static void updateDB(HashMap<Integer, Match> matches,
		HashMap<String, Team> teams, ArrayList<User> users) throws SQLException {
		Connection conn = DatabaseConnection.connect();
		
		PreparedStatement statement = conn.prepareStatement("UPDATE kamp SET hjemmeM = ?, borteM = ?, spilt = ? WHERE idKamp = ?");
		for (Match m :matches.values()){
			
			statement.setInt(1,m.home);
			statement.setInt(2, m.away);
			statement.setInt(3, m.played ? 1 : 0);
			statement.setInt(4, m.id);
			
			statement.executeUpdate();
			
		}
		statement = conn.prepareStatement("UPDATE Bruker SET poeng = ? WHERE brukernavn = ?");
		for(User u: users){
			
			statement.setInt(1, u.points);
			statement.setString(2, u.username);
			statement.executeUpdate();
			
		}
		statement = conn.prepareStatement("UPDATE Lag SET poeng = ?, maal = ? WHERE navn = ?");
		for(Team t: teams.values()){
			
			statement.setInt(1, t.points);
			statement.setInt(2, t.goals);
			statement.setString(3,t.name);
			statement.executeUpdate();
			
		}
	}
	
}