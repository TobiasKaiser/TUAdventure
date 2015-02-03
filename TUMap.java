
public class TUMap extends Map {
	public TUMap(Adventure adv) {
		super(adv);
		
		currentLocation=h0104;
	}
	
	public Location hauptgebaeude, vorhauptgebaeude, vorma, magebaeude, madritterstock, vorer, gruenflaeche, vormensa, wohnheim, mensa, ergebaeude, ewgebaeude, vorew, ernstreuterplatz, hardenbergstrassemensa, er270;
	
	public Location margebaeude, vormar, einsteinufer, engebaeude, voren, h0104, hersterstock;
	
	@Override
	public void buildLocations() {
		hauptgebaeude=new Location(Messages.getString("TUMap.0")); //$NON-NLS-1$
		locations.add(hauptgebaeude);
		
		vorhauptgebaeude=new Location(Messages.getString("TUMap.1")); //$NON-NLS-1$
		locations.add(vorhauptgebaeude);
		
		vorma=new Location(Messages.getString("TUMap.2")); //$NON-NLS-1$
		locations.add(vorma);
		
		magebaeude=new Location(Messages.getString("TUMap.3")); //$NON-NLS-1$
		locations.add(magebaeude);
		
		madritterstock=new Location(Messages.getString("TUMap.4")); //$NON-NLS-1$
		locations.add(madritterstock);
		
		vorer=new Location(Messages.getString("TUMap.5")); //$NON-NLS-1$
		locations.add(vorer);
		
		gruenflaeche=new Location(Messages.getString("TUMap.6")); //$NON-NLS-1$
		locations.add(gruenflaeche);
		
		vormensa=new Location(Messages.getString("TUMap.7")); //$NON-NLS-1$
		locations.add(vormensa);
		
		wohnheim=new Location(Messages.getString("TUMap.8")); //$NON-NLS-1$
		locations.add(wohnheim);
		
		mensa=new Location(Messages.getString("TUMap.9")); //$NON-NLS-1$
		locations.add(mensa);
		
		ergebaeude=new Location(Messages.getString("TUMap.10")); //$NON-NLS-1$
		locations.add(ergebaeude);
		
		ewgebaeude=new Location(Messages.getString("TUMap.11")); //$NON-NLS-1$
		locations.add(ewgebaeude);
		
		vorew=new Location(Messages.getString("TUMap.12")); //$NON-NLS-1$
		locations.add(vorew);
		
		
		locations.add(ernstreuterplatz=new Location( Messages.getString("TUMap.13"))); //$NON-NLS-1$
		locations.add(hardenbergstrassemensa=new Location(Messages.getString("TUMap.14"))); //$NON-NLS-1$
		locations.add(er270=new Location(Messages.getString("TUMap.15"))); //$NON-NLS-1$
		locations.add(margebaeude=new Location(Messages.getString("TUMap.16"))); //$NON-NLS-1$
		locations.add(vormar=new Location(Messages.getString("TUMap.17"))); //$NON-NLS-1$
		locations.add(einsteinufer=new Location(Messages.getString("TUMap.18"))); //$NON-NLS-1$
		locations.add(voren=new Location(Messages.getString("TUMap.19"))); //$NON-NLS-1$
		locations.add(engebaeude=new Location(Messages.getString("TUMap.20"))); //$NON-NLS-1$
		locations.add(h0104=new Location(Messages.getString("TUMap.21"))); //$NON-NLS-1$
		locations.add(hersterstock=new Location(Messages.getString("TUMap.22"))); //$NON-NLS-1$
	}
	
	@Override
	protected void buildEdges() {
		addWay(hauptgebaeude, vorhauptgebaeude,
				Messages.getString("TUMap.23"), //$NON-NLS-1$
				Messages.getString("TUMap.24")); //$NON-NLS-1$
		addWay(hauptgebaeude, gruenflaeche,
				Messages.getString("TUMap.25"), //$NON-NLS-1$
				Messages.getString("TUMap.26")); //$NON-NLS-1$
		addWay(gruenflaeche, vormensa,
				Messages.getString("TUMap.27"), //$NON-NLS-1$
				Messages.getString("TUMap.28")); //$NON-NLS-1$
		addWay(vormensa, mensa,
				Messages.getString("TUMap.29"), //$NON-NLS-1$
				Messages.getString("TUMap.30")); //$NON-NLS-1$
		addWay(gruenflaeche, vorer,
				Messages.getString("TUMap.31"), //$NON-NLS-1$
				Messages.getString("TUMap.32")); //$NON-NLS-1$
		addWay(vorhauptgebaeude, vorma,
				Messages.getString("TUMap.33"), //$NON-NLS-1$
				Messages.getString("TUMap.34")); //$NON-NLS-1$
		addWay(vorma, magebaeude,
				Messages.getString("TUMap.35"), //$NON-NLS-1$
				Messages.getString("TUMap.36")); //$NON-NLS-1$
		addWay(vorer, ergebaeude,
				Messages.getString("TUMap.37"), //$NON-NLS-1$
				Messages.getString("TUMap.38")); //$NON-NLS-1$
		addWay(mensa, hardenbergstrassemensa,
				Messages.getString("TUMap.39"), //$NON-NLS-1$
				Messages.getString("TUMap.40")); //$NON-NLS-1$
		addWay(hardenbergstrassemensa, vorew,
				Messages.getString("TUMap.41"), //$NON-NLS-1$
				Messages.getString("TUMap.42")); //$NON-NLS-1$
		addWay(ewgebaeude, ergebaeude,
				Messages.getString("TUMap.43"), //$NON-NLS-1$
				Messages.getString("TUMap.44")); //$NON-NLS-1$
		addWay(vorew, ewgebaeude,
				Messages.getString("TUMap.45"), //$NON-NLS-1$
				Messages.getString("TUMap.46")); //$NON-NLS-1$
		addWay(ernstreuterplatz, vorew,
				Messages.getString("TUMap.47"), //$NON-NLS-1$
				Messages.getString("TUMap.48")); //$NON-NLS-1$
		addWay(ernstreuterplatz, vorer,
				Messages.getString("TUMap.49"), //$NON-NLS-1$
				Messages.getString("TUMap.50")); //$NON-NLS-1$
		addWay(ernstreuterplatz, vorhauptgebaeude,
				Messages.getString("TUMap.51"), //$NON-NLS-1$
				Messages.getString("TUMap.52")); //$NON-NLS-1$
		addWay(magebaeude, madritterstock,
				Messages.getString("TUMap.53"), //$NON-NLS-1$
				Messages.getString("TUMap.54")); //$NON-NLS-1$
		addWay(ergebaeude, er270,
				Messages.getString("TUMap.55"), //$NON-NLS-1$
				Messages.getString("TUMap.56")); //$NON-NLS-1$
		addWay(vorma, voren,
				Messages.getString("TUMap.57"), //$NON-NLS-1$
				Messages.getString("TUMap.58")); //$NON-NLS-1$
		addWay(voren, engebaeude,
				Messages.getString("TUMap.59"), //$NON-NLS-1$
				Messages.getString("TUMap.60")); //$NON-NLS-1$
		addWay(voren, einsteinufer,
				Messages.getString("TUMap.61"), //$NON-NLS-1$
				Messages.getString("TUMap.62")); //$NON-NLS-1$
		addWay(einsteinufer, vormar,
				Messages.getString("TUMap.63"), //$NON-NLS-1$
				Messages.getString("TUMap.64")); //$NON-NLS-1$
		addWay(vormar, margebaeude,
				Messages.getString("TUMap.65"), //$NON-NLS-1$
				Messages.getString("TUMap.66")); //$NON-NLS-1$
		addWay(ernstreuterplatz, vormar,
				Messages.getString("TUMap.67"), //$NON-NLS-1$
				Messages.getString("TUMap.68")); //$NON-NLS-1$
		addWay(hauptgebaeude, h0104,
				Messages.getString("TUMap.69"), //$NON-NLS-1$
				Messages.getString("TUMap.70")); //$NON-NLS-1$
		addWay(hauptgebaeude, hersterstock,
				Messages.getString("TUMap.71"), //$NON-NLS-1$
				Messages.getString("TUMap.72")); //$NON-NLS-1$
	}
	
	protected String pluralSubstOrNot(boolean pluralSubst, String in) {
		if(pluralSubst) {
			in=in.replace(Messages.getString("TUMap.73"), Messages.getString("TUMap.74")); //$NON-NLS-1$ //$NON-NLS-2$
			in=in.replace(Messages.getString("TUMap.75"), Messages.getString("TUMap.76")); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return in;
	}

}
