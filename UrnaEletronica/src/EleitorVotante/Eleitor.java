package EleitorVotante;

public class Eleitor {
	  private int id;
	    private boolean jaVotou = false;

	    public Eleitor(int id) {
	        this.id = id;
	    }

	    public int getId() {
	        return id;
	    }

	    public boolean jaVotou() {
	        return jaVotou;
	    }

	    public void setJaVotou(boolean jaVotou) {
	        this.jaVotou = jaVotou;
	    }
}