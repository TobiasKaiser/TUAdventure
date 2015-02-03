import java.util.*;

public class Location {
	Map map;
	String description;
	protected List<Action> actions=new ArrayList<Action>();
	public Location(String description) {
		this.description=description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<Action> availActions() {
		List<Action> ret=new ArrayList<Action>();
		for(Action a : actions) if(a.applicable()) ret.add(a);
		return ret;
	}
}
