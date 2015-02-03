import java.io.IOException;
import java.util.*;


public class Adventure {
	public static void main(String[] args) {
		Adventure a=new Adventure();
		a.run();
	}
	
	double chars_per_minute=4800;
	
	boolean debug=false;
	
	public Adventure() {
		map=new TUMap(this);
	}
	Scanner input;
	TUMap map;
	
	public void tell(String text) {
		tell(text, true);
	}
	public void tell(String text, boolean wait) {
		tell(text, wait, 1);
	}
	
	public void tell(String text, boolean wait, double slowdown) {
		char[] tarr=(text+"\n").toCharArray();
		int i, this_line=0;
		for(i=0;i<tarr.length;i++) {
			
			if(tarr[i]=='\n' && wait) {
				if(!debug) {
					try {
						//System.out.print("(press enter)");
						//System.out.flush();
						byte somebuffer[] = new byte[100];
						System.in.read(somebuffer);
						System.out.append("\t");
					} catch (IOException e) {
						// lol.
					}
				} else {
					System.out.append("\n\t");
				}
			} else {
				System.out.append(tarr[i]);
				System.out.flush();
				if(++this_line>=70 && tarr[i]==' ') { // we have a good chance of word-aware wrapping before we reach column 81 by doing this :D
					this_line=0;
					System.out.append("\n");
				}
				try {
					if(!debug) {
					Thread.sleep((long) (1000*slowdown*60/chars_per_minute));
					}
				} catch (InterruptedException e) {
					// lol.
				}	
			}
		}	
	}
	
	public int ask(String question, List<String> answers) {
		tell(question, false);
		int i=1;
		for(String answer : answers) {
			tell("("+(i++)+" "+answer+")", false);
		}
		for(;;) {
			try {
				int ret=Integer.parseInt(input.next())-1;
				if(ret<answers.size()) return ret;
			}
			catch(NumberFormatException e) {
			}
		}
	}
	
	public Scene curScene;
	
	public void delay() {
		tell(".   .   .   ", false, 20);
	}
	
	public void run() {
		input = new Scanner(System.in);
		
		curScene=new SAnkunft(this);
		
		//curScene=new SKlausureinsicht(this);
		
		//map.setLocation(map.madritterstock);
		//curScene=new SPhysikVL(this);
		
		//map.setLocation(map.wohnheim);
		//curScene=new SKlausurRunning(this);
		//curScene=new SKlausurBefore(this);
		
		//map.currentLocation=map.wohnheim;
		//curScene=new SWohnheim(this);
	
		
		while(curScene!=null) curScene=curScene.run();
	}

}
