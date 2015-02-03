
public class InfoAction extends AutoAction {

	private String infoText;
	Scene scene;
	
	public InfoAction(Scene scene, String infoText) {
		this.infoText=infoText;
		this.scene=scene;
	}
	
	@Override
	protected void play() {
		scene.host.tell(infoText);
	}

}
