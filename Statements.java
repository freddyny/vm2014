package vm2014;
import java.sql.*;
public class Statements {
	
	//Virker. 
	public static int getIdKamp(Team lag1, Team lag2) throws SQLException{
		try{
			int idKamp = -1;

			Connection conn = DatabaseConnection.connect();
			PreparedStatement statement = conn.prepareStatement("SELECT idKamp FROM Kamp WHERE hjemmeL= ? and borteL = ?");
			statement.setString(1, lag1.getName());
			statement.setString(2,lag2.getName());
			ResultSet result = statement.executeQuery();
			while(result.next()){
				idKamp = result.getInt("idKamp");
			}
			DatabaseConnection.disconnect(conn);
			return idKamp;
			
		}

		catch (SQLException e) {
			System.out.println("Record couldn't be added!");
			e.printStackTrace();
		}
		return -1;

	}
	public static void updateGoals(int hjemmeM, int borteM, int kampID) throws SQLException{
		Connection conn = DatabaseConnection.connect();
		PreparedStatement statement = conn.prepareStatement("");
	}
	public static void main(String[] args) throws SQLException {
		Team lag1 = new Team("Spania");
		Team lag2 = new Team("Nederland");
		System.out.println(getIdKamp(lag1,lag2));
	}
}
