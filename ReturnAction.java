
public class ReturnAction extends Action {
	// Der Grund, wieso diese Klasse applicable nicht definiert, ist, dass es aus der onEnter-Aktivierung sowieso nicht wieder zurückkehrt.
	@Override
	protected void play() {
		returnTo.interact=false;
	}

	private String description;
	private Scene returnTo;
	private boolean auto;
	
	/**
	 * Über diesen Konstruktor wird eine nicht-automatische ReturnAction erstellt (mit onEnter() = false)
	 * @param returnTo
	 * @param description
	 */
	public ReturnAction(Scene returnTo, String description) {
		this.description=description;
		this.returnTo=returnTo;
		this.auto=false;
	}
	/**
	 * Über diesen Konstruktor wird eine automatische ReturnAction erstellt (mit onEnter() = true)
	 * @param returnTo
	 */
	public ReturnAction(Scene returnTo) {
		this.description=null;
		this.returnTo=returnTo;
		this.auto=true;
	}
	
	@Override
	public boolean onEnter() {
		return auto&&super.applicable();
	}
	
	@Override
	public String getDescription() {
		return description;
	}

}
