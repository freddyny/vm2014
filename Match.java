package vm2014;

public class Match {
	Team homeTeam, awayTeam;
	int home, away, id;
	boolean played;


	public Match(int id,Team homeTeam, Team awayTeam, int home, int away, boolean played) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.home = home;
		this.away = away;
		this.id=id;
		this.played=played;
	}

	public void updateScore(int home, int away){
		this.away = away;
		this.home = home;
	}
	public char victor(){
		int result = home - away;
		if (result >0) return 'h';
		else if (result<0) return 'a';
		else return 'd';

	}
}
