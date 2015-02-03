import java.util.*;
public class STeile extends Scene {

	private class Teil {
		public String descSearch, descFound;
		public Teil(String descSearch, String descFound) {
			this.descSearch=descSearch;
			this.descFound=descFound;
		}
	}
	
	private Teil temporit, gehaeuse, netzkabel, kleinteile, heisenberg42;
	private List<Teil> teileBenoetigt=new ArrayList<Teil>();
	private List<Teil> teileInTasche=new ArrayList<Teil>();
	private List<Teil> teileInER270=new ArrayList<Teil>();
	
	public String listTeile(List<Teil> l, boolean found) {
		String ret=""; //$NON-NLS-1$
		for(Teil t : l) {
			if(ret.length()>0) ret+=", "; //$NON-NLS-1$
			if(found) {
				ret+=t.descFound;
			} else {
				ret+=t.descSearch;
			}
		}
		return ret;
	}
	
	public STeile(Adventure host) {
		super(host);
		
		teileBenoetigt.add(temporit=new Teil(Messages.getString("STeile.2"), Messages.getString("STeile.3"))); //$NON-NLS-1$ //$NON-NLS-2$
		teileBenoetigt.add(gehaeuse=new Teil(Messages.getString("STeile.4"), Messages.getString("STeile.5"))); //$NON-NLS-1$ //$NON-NLS-2$
		teileBenoetigt.add(netzkabel=new Teil(Messages.getString("STeile.6"), Messages.getString("STeile.7"))); //$NON-NLS-1$ //$NON-NLS-2$
		teileBenoetigt.add(kleinteile=new Teil(Messages.getString("STeile.8"), Messages.getString("STeile.9"))); //$NON-NLS-1$ //$NON-NLS-2$
		teileBenoetigt.add(heisenberg42=new Teil(Messages.getString("STeile.10"), Messages.getString("STeile.11"))); //$NON-NLS-1$ //$NON-NLS-2$
	}
	Action studentMitNotebookInfo=new InfoAction(this, Messages.getString("STeile.12")); //$NON-NLS-1$
	
	private class StudentNetzteilAusleihenAction extends SingleTimeAction {
		private boolean willBeSuccessful;
	
		public StudentNetzteilAusleihenAction(boolean willBeSuccessful) {
			this.willBeSuccessful=willBeSuccessful;
		}
		
		@Override
		public boolean applicable() {
			return super.applicable() && (!teileInER270.contains(netzkabel)) && (!teileInTasche.contains(netzkabel));
		}
		
		@Override
		protected void play() {
			host.tell(Messages.getString("STeile.13")); //$NON-NLS-1$
			host.delay();
			if(willBeSuccessful) {
				host.tell(Messages.getString("STeile.14")); //$NON-NLS-1$
				host.tell(Messages.getString("STeile.15")); //$NON-NLS-1$
				teileInTasche.add(netzkabel);
				studentMitNotebookInfo.disable();
			} else {
				host.tell(Messages.getString("STeile.16")); //$NON-NLS-1$
			}
		}

		@Override
		public String getDescription() {
			return Messages.getString("STeile.17"); //$NON-NLS-1$
		}
		
	}
	
	Action hammerFinden, hammerInfo, gesteinInfo, elektronikKastenInfo;
	
	@Override
	public Scene run() {
		host.tell(Messages.getString("STeile.18")); //$NON-NLS-1$
		
		host.map.resetActions();
		
		
		// In der Mensa gibt es das Gehäuse
		host.map.mensa.actions.add(new InfoAction(this, Messages.getString("STeile.19"))); //$NON-NLS-1$
		host.map.mensa.actions.add(new SingleTimeAction() {
			
			@Override
			protected void play() {
				host.tell(Messages.getString("STeile.20")); //$NON-NLS-1$
				
				List<String> aList=new ArrayList<String>();
				aList.add(Messages.getString("STeile.21")); //$NON-NLS-1$
				aList.add(Messages.getString("STeile.22")); //$NON-NLS-1$
				aList.add(Messages.getString("STeile.23")); //$NON-NLS-1$
				aList.add(Messages.getString("STeile.24")); //$NON-NLS-1$
				aList.add(Messages.getString("STeile.25")); //$NON-NLS-1$
				
				host.ask(Messages.getString("STeile.26"), aList); //$NON-NLS-1$
				
				host.delay();
				host.tell(Messages.getString("STeile.27")); //$NON-NLS-1$
				host.tell(Messages.getString("STeile.28")); //$NON-NLS-1$
				teileInTasche.add(gehaeuse);
				studentMitNotebookInfo.disable();
			}

			@Override
			public String getDescription() {
				return Messages.getString("STeile.29"); //$NON-NLS-1$
			}
		});
		
		// Über den Campus verstreut sitzen Studenten mit ihren Notebooks. Von einem unaufmerksamen Studenten kannst du dir das Netzkabel "ausleihen".
		
		host.map.ewgebaeude.actions.add(studentMitNotebookInfo);
		host.map.ewgebaeude.actions.add(new StudentNetzteilAusleihenAction(true));
		host.map.hauptgebaeude.actions.add(studentMitNotebookInfo);
		host.map.hauptgebaeude.actions.add(new StudentNetzteilAusleihenAction(false));
		host.map.margebaeude.actions.add(studentMitNotebookInfo);
		host.map.margebaeude.actions.add(new StudentNetzteilAusleihenAction(false));
		
		// Vor dem MA-Gebäude liegt ein Hammer, mit dem man ein bisschen was von dem Temporit-Gestein, aus dem innen die Wände des MA-Gebäudes gebaut sind, abschlagen kann.
		hammerFinden=new SingleTimeAction() {

			@Override
			protected void play() {
				host.tell(Messages.getString("STeile.30")); //$NON-NLS-1$
				host.tell(Messages.getString("STeile.31")); //$NON-NLS-1$
				hammerInfo.disable();	
			}

			@Override
			public String getDescription() {
				return Messages.getString("STeile.32"); //$NON-NLS-1$
			}
			
		};
		hammerInfo=new InfoAction(this, Messages.getString("STeile.33")); //$NON-NLS-1$
		host.map.vorma.actions.add(hammerFinden);
		host.map.vorma.actions.add(hammerInfo);
		
		
		// im MA-Gebäude
		gesteinInfo=new InfoAction(this, Messages.getString("STeile.34")); //$NON-NLS-1$
		host.map.magebaeude.actions.add(gesteinInfo);
		host.map.magebaeude.actions.add(new SingleTimeAction() {
			@Override
			public boolean applicable() {
				return super.applicable() && (!hammerFinden.isEnabled());
			}
			
			@Override
			protected void play() {
				// TODO Auto-generated method stub
				host.delay();
				host.tell(Messages.getString("STeile.35")); //$NON-NLS-1$
				host.tell(Messages.getString("STeile.36")); //$NON-NLS-1$
				host.tell(Messages.getString("STeile.37")); //$NON-NLS-1$
				teileInTasche.add(temporit);
				gesteinInfo.disable();
			}

			@Override
			public String getDescription() {
				return Messages.getString("STeile.38"); //$NON-NLS-1$
			}
			
		});
		
		// Im EN-Gebäude gibt es die elektronischen Kleinteile und die Heisenberg-42-Röhre:
		
		elektronikKastenInfo=new InfoAction(this, Messages.getString("STeile.39")); //$NON-NLS-1$
		host.map.engebaeude.actions.add(elektronikKastenInfo);
		host.map.engebaeude.actions.add(new SingleTimeAction() {

			@Override
			protected void play() {
				host.tell(Messages.getString("STeile.40")); //$NON-NLS-1$
				host.delay();
				host.tell(Messages.getString("STeile.41")); //$NON-NLS-1$
				host.tell(Messages.getString("STeile.42")); //$NON-NLS-1$
				
				teileInTasche.add(kleinteile);
				teileInTasche.add(heisenberg42);
				elektronikKastenInfo.disable();
				
			}

			@Override
			public String getDescription() {
				return Messages.getString("STeile.43"); //$NON-NLS-1$
			}
			
		});
		
		// Hier wird die Zeitmaschine zusammengesetzt
		host.map.er270.actions.add(new AutoAction() {
			@Override
			protected void play() {
				if(teileInTasche.size()>0) {
					
					host.tell(Messages.getString("STeile.44")+listTeile(teileInTasche, true)+"."); //$NON-NLS-1$ //$NON-NLS-2$
					teileInER270.addAll(teileInTasche);
					teileInTasche.clear();				
				}
				
				List<Teil> teileFehlen=new ArrayList<Teil>();
				for(Teil t : teileBenoetigt) if(!(teileInER270.contains(t))) teileFehlen.add(t);
				if(teileFehlen.size()>0) {
					host.tell(Messages.getString("STeile.46")+listTeile(teileFehlen, false)+"."); //$NON-NLS-1$ //$NON-NLS-2$
				} else {
					// terminate
					interact=false;
				}
				
				
			}
		});
		
		host.map.interact();
		
		host.tell(Messages.getString("STeile.48")); //$NON-NLS-1$
		host.tell(Messages.getString("STeile.49")); //$NON-NLS-1$
		host.delay();
		host.tell(Messages.getString("STeile.50")); //$NON-NLS-1$
		host.tell(Messages.getString("STeile.51")); //$NON-NLS-1$
		host.tell(Messages.getString("STeile.52")); //$NON-NLS-1$
		
		return new SKlausurBefore(host);
	}

}
