import java.util.*;



public abstract class Map {
	public class Edge {
		public Location l1, l2;
		public String xfer_str;
		public Edge(Location l1, Location l2, String xfer_str) {
			this.l1=l1;
			this.l2=l2;
			this.xfer_str=xfer_str;
		}
	}
	
	List<Edge> edges=new ArrayList<Edge>();
	protected Location currentLocation;
	Adventure adv;
	
	
	
	protected abstract void buildEdges();
	protected abstract void buildLocations();
	protected List<Location> locations = new ArrayList<Location>();
	
	public Map(Adventure adv) {
		this.adv=adv;

		buildLocations();
		buildEdges();
	}
	
	public void resetActions() {
		for(Location l : locations) {
			l.actions.clear();
		}
	}
	
	public Location getLocation() {
		return currentLocation;
	}
	
	public void setLocation(Location l) {
		currentLocation=l;
		adv.tell(currentLocation.getDescription(), false);
		for(Action a : currentLocation.actions) {
			if(a.onEnter()) a.run();
		}
	}
	
	public void addWay(Location l1, Location l2, String l1_to_l2, String l2_to_l1) {
		edges.add(new Edge(l1, l2, l1_to_l2));
		edges.add(new Edge(l2, l1, l2_to_l1));
	}
	
	public List<Edge> findWaysFrom(Location from) {
		List<Edge> ret=new ArrayList<Edge>();
		for(Edge e : edges) {
			if(e.l1==from) ret.add(e);
		}
		return ret;
	}
	
	public void interact() {
		interact(false);
	}
	
	/**
	 * 
	 * @param pluralSubst Setze auf true, um die Action-Beschreibungen durch search&replace so anzupassen, dass sie Pluralformen enthalten.
	 */
	public void interact(boolean pluralSubst) {
		adv.curScene.interact=true; // Flag is set to false by exiting location / scene
		while(adv.curScene.interact) {
			
			List<String> aList = new ArrayList<String>();
			
			List<Action> whatCanWeDo=this.currentLocation.availActions();
			for(Action a : whatCanWeDo) aList.add(pluralSubstOrNot(pluralSubst, a.getDescription()));
			
			List<Edge> whereCanWeGo=findWaysFrom(currentLocation);
			for(Edge e : whereCanWeGo) aList.add(pluralSubstOrNot(pluralSubst, e.xfer_str));
			
			int answer=adv.ask(pluralSubst?Messages.getString("Map.0"):Messages.getString("Map.1"), aList); //$NON-NLS-1$ //$NON-NLS-2$
			
			if(answer<whatCanWeDo.size()) {
				// Entweder Action ausführen
				whatCanWeDo.get(answer).run();
			} else {
				answer-=whatCanWeDo.size();
				// Oder Ort wechseln
				setLocation(whereCanWeGo.get(answer).l2);
			}
		}
	}
	
	protected abstract String pluralSubstOrNot(boolean pluralSubst, String in);
	
	
}
