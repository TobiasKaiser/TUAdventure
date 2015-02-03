
public class ActionWay extends Action {
	/**
	 * Manuelle Methode, temporäre, möglicherweise auch unidirektionale Wege auf der Karte anzulegen.
	 */
	
	String xfer_str; // bla bla naming conventions oh i dont care
	Location target;
	Scene scene;
	
	public ActionWay(Scene scene, String xfer_str, Location target) {
		this.xfer_str=xfer_str;
		this.target=target;
		this.scene=scene;
	}
	
	@Override
	protected void play() {
		scene.host.map.setLocation(target);
	}

	@Override
	public String getDescription() {
		return xfer_str;
	}

}
