import java.util.*;

public class SAnna extends Scene {

	public SAnna(Adventure host) {
		super(host);
		// TODO Auto-generated constructor stub
	}

	Action eisstand, eisstandInfo;
	Action klappeInfo, klappeUntersuchen, pfoertner;
	Action h0104konferenz, annaReturn;
	boolean schluessel=false, eisDabei=false, pfoertnerAngesprochen=false;
	
	@Override
	public Scene run() {
		host.tell(Messages.getString("SAnna.0")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnna.1")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnna.2")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnna.3")); //$NON-NLS-1$
		host.delay();
		host.tell(Messages.getString("SAnna.4")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnna.5")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnna.6")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnna.7")); //$NON-NLS-1$
		host.tell(Messages.getString("SAnna.8")); //$NON-NLS-1$
		
		host.map.resetActions();
		
		// Mache Annas Zimmer begehbar
		host.map.wohnheim.actions.add(new ActionWay(this, Messages.getString("SAnna.9"), host.map.vormensa)); //$NON-NLS-1$
		host.map.vormensa.actions.add(new ActionWay(this, Messages.getString("SAnna.10"), host.map.wohnheim)); //$NON-NLS-1$
		
		// Eisstand am Einsteinufer und vor der Mensa
		
		eisstandInfo=new InfoAction(this, Messages.getString("SAnna.11")); //$NON-NLS-1$
		
		eisstand=new Action(){

			@Override
			protected void play() {
				host.tell(Messages.getString("SAnna.12")); //$NON-NLS-1$
				host.tell(Messages.getString("SAnna.13")); //$NON-NLS-1$
				host.delay();
								
				if(pfoertnerAngesprochen && !eisDabei) {
					List<String> aList=new ArrayList<String>();
					aList.add(Messages.getString("SAnna.14")); //$NON-NLS-1$
					aList.add(Messages.getString("SAnna.15")); //$NON-NLS-1$
					if(host.ask(Messages.getString("SAnna.16"), aList)==0) { //$NON-NLS-1$
						host.tell(Messages.getString("SAnna.17")); //$NON-NLS-1$
						eisDabei=true;
					}
				}
			}

			@Override
			public String getDescription() {
				return Messages.getString("SAnna.18"); //$NON-NLS-1$
			}
			
		};
		
		host.map.hardenbergstrassemensa.actions.add(eisstandInfo);
		host.map.hardenbergstrassemensa.actions.add(eisstand);
		host.map.einsteinufer.actions.add(eisstandInfo);
		host.map.einsteinufer.actions.add(eisstand);
		
		// Konferenz im H 0104
		
		h0104konferenz=new InfoAction(this, Messages.getString("SAnna.19")); //$NON-NLS-1$
		host.map.h0104.actions.add(h0104konferenz);
		
		// Pförtner
		
		pfoertner = new Action() {

			@Override
			protected void play() {
				pfoertnerAngesprochen=true;
				if(eisDabei) {
					host.tell(Messages.getString("SAnna.20")); //$NON-NLS-1$
					host.tell(Messages.getString("SAnna.21")); //$NON-NLS-1$
					host.tell(Messages.getString("SAnna.22")); //$NON-NLS-1$
					host.tell(Messages.getString("SAnna.23")); //$NON-NLS-1$
					schluessel=true;
					annaReturn.enable();
					disable();
				} else {
					host.tell(Messages.getString("SAnna.24")); //$NON-NLS-1$
					host.tell(Messages.getString("SAnna.25")); //$NON-NLS-1$
					host.tell(Messages.getString("SAnna.26")); //$NON-NLS-1$
				}
			}

			@Override
			public String getDescription() {
				return Messages.getString("SAnna.27"); //$NON-NLS-1$
			}
		};
		pfoertner.disable();
		host.map.hauptgebaeude.actions.add(pfoertner);
		
		// Klappe über H 0104
		klappeInfo = new InfoAction(this, Messages.getString("SAnna.28")); //$NON-NLS-1$
		klappeUntersuchen=new Action() {

			@Override
			protected void play() {
				klappeInfo.disable();
				
				host.tell(Messages.getString("SAnna.29")); //$NON-NLS-1$
				if(schluessel) {
					host.tell(Messages.getString("SAnna.30")); //$NON-NLS-1$
					host.tell(Messages.getString("SAnna.31")); //$NON-NLS-1$
				} else {
					host.tell(Messages.getString("SAnna.32")); //$NON-NLS-1$
					host.tell(Messages.getString("SAnna.33")); //$NON-NLS-1$
					pfoertner.enable();
				}
			}

			@Override
			public String getDescription() {
				return Messages.getString("SAnna.34"); //$NON-NLS-1$
			}
		};
		host.map.hersterstock.actions.add(klappeInfo);
		host.map.hersterstock.actions.add(klappeUntersuchen);
		
		
		// Zurück in Annas Zimmer
		host.map.wohnheim.actions.add(annaReturn=new ReturnAction(this));
		annaReturn.disable();
		
		host.map.interact(true);
		
		return new SKlausurRunning(host);
	}

}
