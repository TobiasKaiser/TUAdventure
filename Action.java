
public abstract class Action {
	protected boolean enabled=true;
	
	/**
	 * 
	 * @return true, wenn dem Benutzer in der Location die Möglichkeit gegeben werden soll, die Action auszuführen.
	 */
	public boolean applicable() {
		return enabled;
	}
	/**
	 * 
	 * @return true, wenn die Action beim Betreten einer Location automatisch ausgeführt werden soll. applicable wird dabei nicht beachtet!
	 */
	public boolean onEnter() {
		return false;
	}
	
	public final void run() {
		play();
		done();
	}
	
	protected abstract void play();
	
	/**
	 * Für SingleTimeAction
	 */
	protected void done() {
		
	}
	
	public void enable() {
		this.enabled=true;
	}
	
	public void disable() {
		this.enabled=false;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	
	public abstract String getDescription();
}
