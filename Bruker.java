package vm2014;
import java.sql.*;
public class Bruker {
	private String brukernavn;
	private int poengsum;
	public Bruker(String bn, int ps){
		brukernavn=bn;
		poengsum=ps;
	}
	public int checkMatchScore(){
		Connection conn= DatabaseConnection.connect();
		
		
		return 0;
	}
}
