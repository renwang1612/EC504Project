import java.util.*;

public abstract class Subject {													//abstract subject, Bob's program should extend from this class
	private List<Observer> list = new ArrayList<Observer> ();
	public void attach (Observer observer) {
		list.add (observer);
	}
	public void detach (Observer observer) {
		list.remove (observer);
	}
	public void notify (String newmessage) {
		for (Observer observer : list) {
			observer.getMessage (newmessage);
		}
	}
}
