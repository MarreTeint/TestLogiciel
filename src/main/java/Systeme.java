
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Systeme {

    private Processus last = null;
    private Processus current = null;
    private ArrayList<Processus> waiting = new ArrayList<Processus>();

    private static Random rand = new Random();

    public Systeme() {
    }

    public void init() {
	last = null; current = null;
	waiting = new ArrayList<Processus>();
    }

    public void add(Processus p) throws ErreurSysteme {
	if (current == null) {
		current = p;
		return;	
	}
    if (current.equals(p) || waiting.contains(p)) {
    	throw new ErreurSysteme("Processus deja existant");
    }
    waiting.add(p);
    }

    public void swap() throws ErreurSysteme {
	int size = waiting.size();
	if (size == 0) { throw new ErreurSysteme("Nothing waiting"); }
	if (size == 1) {
	    last = current;
	    current = waiting.get(0);
	    waiting.remove(current);
	    waiting.add(last);
	} else {
	    ArrayList<Processus> toChoose = (ArrayList<Processus>) waiting.clone();
	    int index;
	    if (last != null) { toChoose.remove(last); }
	    index = rand.nextInt(toChoose.size());
	    last = current;
	    current = toChoose.get(index);
	    waiting.remove(current);
	    waiting.add(last);
	}
    }

    public Collection<Processus> getWaiting() {
	return new HashSet(waiting);
    }

    public boolean isCurrent(Processus p) {
	return current == p;
    }

    public boolean isLast(Processus p) {
	return last == p;
    }
}
