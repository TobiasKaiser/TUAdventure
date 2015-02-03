
public class SKlausurRunning extends Scene {

	public SKlausurRunning(Adventure host) {
		super(host);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene run() {
		// TODO Auto-generated method stub
		host.tell(Messages.getString("SKlausurRunning.0")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.1")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.2")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.3")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.4")); //$NON-NLS-1$
		
		host.map.resetActions();
		// Mache Annas Zimmer begehbar
		host.map.wohnheim.actions.add(new ActionWay(this, Messages.getString("SKlausurRunning.5"), host.map.vormensa)); //$NON-NLS-1$
		host.map.vormensa.actions.add(new ActionWay(this, Messages.getString("SKlausurRunning.6"), host.map.wohnheim)); //$NON-NLS-1$
		
		host.map.hauptgebaeude.actions.add(new InfoAction(this, Messages.getString("SKlausurRunning.7"))); //$NON-NLS-1$
		host.map.h0104.actions.add(new InfoAction(this, Messages.getString("SKlausurRunning.8"))); //$NON-NLS-1$
		host.map.hersterstock.actions.add(new ReturnAction(this));
		host.map.interact(true);
		
		host.tell(Messages.getString("SKlausurRunning.9")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.10")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.11")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.12")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurRunning.13")); //$NON-NLS-1$

		host.delay();
		host.tell(Messages.getString("SKlausurRunning.14")); //$NON-NLS-1$
		
		// Hier könnten jetzt auf dem Rückweg noch ein paar fröhliche InfoActions auftauchen
		
		host.map.resetActions();
		// Mache Annas Zimmer begehbar
		host.map.wohnheim.actions.add(new ActionWay(this, Messages.getString("SKlausurRunning.15"), host.map.vormensa)); //$NON-NLS-1$
		host.map.vormensa.actions.add(new ActionWay(this, Messages.getString("SKlausurRunning.16"), host.map.wohnheim)); //$NON-NLS-1$
		
		host.map.wohnheim.actions.add(new ReturnAction(this));
		
		host.map.interact(true);
		
		
		return new SEnde(host);
	}

}
