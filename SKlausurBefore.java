
public class SKlausurBefore extends Scene {

	
	public SKlausurBefore(Adventure host) {
		super(host);
		
	}
	
	Action hauptgebaeudeInfo;

	@Override
	public Scene run() {
		
		host.tell(Messages.getString("SKlausurBefore.0")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.1")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.2")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.3")); //$NON-NLS-1$
		host.delay();
		host.tell(Messages.getString("SKlausurBefore.4")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.5")); //$NON-NLS-1$
		host.delay();
		host.tell(Messages.getString("SKlausurBefore.6")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.7")); //$NON-NLS-1$
		
		host.map.resetActions();
		
		hauptgebaeudeInfo=new InfoAction(this, Messages.getString("SKlausurBefore.8")); //$NON-NLS-1$
		
		host.map.hauptgebaeude.actions.add(hauptgebaeudeInfo);
		host.map.h0104.actions.add(new ReturnAction(this));
		host.map.interact();
		
		host.tell(Messages.getString("SKlausurBefore.9")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.10")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.11")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.12")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.13")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.14")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.15")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.16")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.17")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.18")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.19")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausurBefore.20")); //$NON-NLS-1$
		
		
		return new SWohnheim(host);
	}

}
