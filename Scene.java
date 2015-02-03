
public abstract class Scene {
	
	Adventure host;
	
	public boolean interact;
	
	public Scene(Adventure host) {
		this.host=host;
	}
	
	/**
	 * 
	 * @return Next scene
	 */
	public abstract Scene run();
	
	
}
