
public class SPhysikVL extends Scene {

	public SPhysikVL(Adventure host) {
		super(host);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene run() {
		
		
		
		host.tell(Messages.getString("SPhysikVL.0")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.1")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.2")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.3")); //$NON-NLS-1$
		
		host.map.resetActions();
		host.map.vorma.actions.add(nachfragen1);
		//host.map.ergebaeude.actions.add(vorlesungAnhoeren);
		
		Action redendeStudenten=new InfoAction(this, Messages.getString("SPhysikVL.4")); //$NON-NLS-1$
		host.map.mensa.actions.add(redendeStudenten);
		host.map.engebaeude.actions.add(redendeStudenten);
		host.map.margebaeude.actions.add(redendeStudenten);
		
		host.map.er270.actions.add(new ReturnAction(this));
		host.map.ergebaeude.actions.add(enterER);
		host.map.madritterstock.actions.add(klausureinsicht);
		host.map.interact();
		
		//host.tell("Du steigst die weiten Treppen nach oben, um in den ER270 zu gelangen.");
		host.tell(Messages.getString("SPhysikVL.5")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.6")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.7")); //$NON-NLS-1$
		// TODO: Traumsequenz
		host.tell(Messages.getString("SPhysikVL.8")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.9")); //$NON-NLS-1$
		host.delay();
		host.tell(Messages.getString("SPhysikVL.10")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.11")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.12")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.13")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.14")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.15")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.16")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.17")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.18")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.19")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.20")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.21")); //$NON-NLS-1$
		host.tell(Messages.getString("SPhysikVL.22")); //$NON-NLS-1$
		
		return new STeile(host);
	}
	
	//public Action vorlesungAnhoeren = new ReturnAction(this, "Gehe in den großen Vorlesungssaal ER270, um zu sehen, welche Vorlesung dort gerade stattfindet");
	
	public Action nachfragen1 = new SingleTimeAction() {
		@Override
		public void play() {
			host.tell(Messages.getString("SPhysikVL.23")); //$NON-NLS-1$
			host.tell(Messages.getString("SPhysikVL.24")); //$NON-NLS-1$
			host.tell(Messages.getString("SPhysikVL.25")); //$NON-NLS-1$
		}

		@Override
		public String getDescription() {
			return Messages.getString("SPhysikVL.26"); //$NON-NLS-1$
		}
	};
	
	public Action klausureinsicht = new AutoAction() {
		@Override
		public void play() {
			host.tell(Messages.getString("SPhysikVL.27")); //$NON-NLS-1$
		}
	};
	
	public Action enterER = new AutoAction() {
		@Override
		public void play() {
			host.tell(Messages.getString("SPhysikVL.28")); //$NON-NLS-1$
		}
	};
	
}
