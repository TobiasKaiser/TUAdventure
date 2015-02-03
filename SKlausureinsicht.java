import java.util.ArrayList;
import java.util.List;


public class SKlausureinsicht extends Scene {

	public SKlausureinsicht(Adventure host) {
		super(host);
	}

	@Override
	public Scene run() {
		host.tell(Messages.getString("SKlausureinsicht.0")); //$NON-NLS-1$
		
		host.map.resetActions();
		host.map.madritterstock.actions.add(new ReturnAction(this));

		host.map.interact();
		
		host.delay();
		host.tell(Messages.getString("SKlausureinsicht.1")); //$NON-NLS-1$
		host.tell(Messages.getString("SKlausureinsicht.2")); //$NON-NLS-1$
		
		List<String> aList=new ArrayList<String>();
		aList.add(Messages.getString("SKlausureinsicht.3")); //$NON-NLS-1$
		aList.add(Messages.getString("SKlausureinsicht.4")); //$NON-NLS-1$
		do {
			host.delay();
		} while(host.ask(Messages.getString("SKlausureinsicht.5"), aList)!=1); //$NON-NLS-1$
		
		return new SPhysikVL(host);
	}

}
