
public class SAnkunft extends Scene {

	public SAnkunft(Adventure host) {
		super(host);
	}

	@Override
	public Scene run() {
		host.tell(Messages.getString("SAnkunft.0")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnkunft.1")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnkunft.2")); //$NON-NLS-1$
		host.delay();
		host.tell(Messages.getString("SAnkunft.3")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnkunft.4")); //$NON-NLS-1$
		
		return new SKlausureinsicht(host);
	}

}
