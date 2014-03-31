package vm2014;

public class Bet {
	Match match;
	char victor;
	int home, away;
	
	public Bet(Match match, char victor, int home, int away) {
		this.match = match;
		this.victor = victor;
		this.home = home;
		this.away = away;
	}
}
