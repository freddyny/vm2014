package vm2014;

import java.util.HashMap;

public class User {
	String username;
	int points;
	HashMap<Match,Bet> bets = new HashMap<Match,Bet>();

	public User(String bn, int ps) {
		username = bn;
		points = ps;
	}

	/*
	 * Fjernes mest sanns. //Problem om laget har flere kamper mot hverandre.
	 * public void checkMatchScore(Team lag1, Team lag2) throws SQLException{
	 * Connection conn= DatabaseConnection.connect(); int resultatBorteM
	 * =Statements.getBorteM(lag1, lag2); int resultatHjemmeM =
	 * Statements.getHjemmeM(lag1, lag2); int tippetHjemmeM =
	 * Statements.getTippethjemmeM(lag1, lag2); int tippetBorteM =
	 * Statements.getTippetBorteM(lag1, lag2); String tippetSeier =
	 * Statements.getTippetSeier(lag1, lag2); int seier = resultatHjemmeM -
	 * resultatBorteM; if (resultatBorteM==tippetBorteM && resultatHjemmeM ==
	 * tippetHjemmeM){ poengsum +=2; } if (tippetSeier.equals("h") && seier >0){
	 * poengsum+=1; } else if (tippetSeier.equals("u") && seier == 0){
	 * poengsum+=1; }
	 * 
	 * DatabaseConnection.disconnect(conn);
	 * 
	 * }
	 */
}
