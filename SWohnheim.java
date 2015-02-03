
public class SWohnheim extends Scene {

	public SWohnheim(Adventure host) {
		super(host);
		// TODO Auto-generated constructor stub
	}

	Action fenster, smartphone;
	
	@Override
	public Scene run() {
		host.delay();
		host.tell(Messages.getString("SWohnheim.0")); //$NON-NLS-1$
		host.tell(Messages.getString("SWohnheim.1")); //$NON-NLS-1$
		host.tell(Messages.getString("SWohnheim.2")); //$NON-NLS-1$
		
		/*
		 * Hier muss geklärt werden:
		 * * Du bist am selben Tag, an dem du deine Reise gestartet hast, wieder angekommen <= indem du auf die Uhr guckst
		 * * Es ist jetzt nachmittags <= indem du aus dem fenster guckst
		 * * Du bist erneut durch deine Prüfung durchgefallen, diesmal aber mit noch weniger Punkten <= indem du dein smartphone checkst
		 * * Du bist im Wohnheim <= indem du aus dem fenster guckst
		 * * Dieses Zimmer gehört wahrscheinlich einer Physik-Studentin <= indem du dich umsiehst (nachdem du aus dem fenster guckst)
		 */
		
		host.map.resetActions();
		host.map.currentLocation=host.map.wohnheim;
		//host.map.wohnheim.actions.add(new ReturnAction(this, "Sieh dich ein bisschen um"));
		
		host.map.wohnheim.actions.add(fenster=new Action() {
			@Override
			protected void play() {
				// TODO Auto-generated method stub
				host.tell(Messages.getString("SWohnheim.3")); //$NON-NLS-1$
				host.tell(Messages.getString("SWohnheim.4")); //$NON-NLS-1$
				host.tell(Messages.getString("SWohnheim.5")); //$NON-NLS-1$
				host.tell(Messages.getString("SWohnheim.6")); //$NON-NLS-1$
				
				disable();
				if(!fenster.isEnabled() && !smartphone.isEnabled()) interact=false;
			}

			@Override
			public String getDescription() {
				return Messages.getString("SWohnheim.7"); //$NON-NLS-1$
			}
			
		});
		host.map.wohnheim.actions.add(smartphone=new Action() {
			@Override
			protected void play() {
				// TODO Auto-generated method stub
				host.tell(Messages.getString("SWohnheim.8")); //$NON-NLS-1$
				host.tell(Messages.getString("SWohnheim.9")); //$NON-NLS-1$
				host.tell(Messages.getString("SWohnheim.10")); //$NON-NLS-1$
				host.tell(Messages.getString("SWohnheim.11")); //$NON-NLS-1$
				
				
				disable();
				if(!fenster.isEnabled() && !smartphone.isEnabled()) interact=false;
			}

			@Override
			public String getDescription() {
				return Messages.getString("SWohnheim.12"); //$NON-NLS-1$
			}
			
		});
		
		host.map.interact();
		
		return new SAnna(host);
	}

}