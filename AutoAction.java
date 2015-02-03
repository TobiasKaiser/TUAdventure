
public abstract class AutoAction extends Action {

	public boolean applicable() {
		return false;
	}
	
	public boolean onEnter() {
		return enabled;
	}

	@Override
	public String getDescription() {
		return null; // shall not be called on AutoAction.
	}

}
