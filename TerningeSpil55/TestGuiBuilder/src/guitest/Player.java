package guitest;
import java.util.*;

public class Player {
	
	private int point;
	private Terning[] terning = new Terning[2];
	private boolean vundet = false;
	private String navn;
	private boolean xtraturn;
	
	// laver en liste der skal holde styr på terningekast
	private List<int[]> sslag = new ArrayList<int[]>();
	
	public List<int[]> getSlag(){
		return sslag;
	}
	
	public int[] getDice(){
		int[] temp = new int[2];
		for(int i = 0; i< terning.length; i++){
			temp[i] = terning[i].getAntalOjne();
		}
		return temp;
	}
	
	
	// constructor
	public Player(String navn, Terning t, Terning tt){
		this.navn = navn;
		terning[0]=t;
		terning[1]=tt;
	}
	// overloader constructor
	public Player(String navn){
		this.navn = navn;
		terning[0]= new Terning();
		terning[1] = new Terning();
	}
	
	// toString
	public String toString(){
		String s;
		s = Integer.toString(point);
		return s;
	}
	
	public String getName(){
		return navn;
	}
	
	public void rafl(){
		int[] temp = new int[2];
		for(int i = 0; i<terning.length; i++){
			
			terning[i].hit();
			
			temp[i]=terning[i].getAntalOjne();
		}
		sslag.add(temp);
		if(check())
			vundet = true;
		
	}
	public void printSlag(){
		System.out.println(terning[0].getAntalOjne());
		System.out.println(terning[1].getAntalOjne());
	}
	
	// metode der checker om der er slået to par 6'er i træk.
	private boolean check(){
		int temp=0;
		for(int[] p : sslag){
			if(p[0]==p[1]&&p[0]==6)
				++temp;
			else
				temp = 0;
			if(temp>=2)
				return true;
			else
				return false;
			
		}
		return false;
	}
	
	public void endturn(){
		xtraturn=false;
		point += terning[0].getAntalOjne()+terning[1].getAntalOjne();
		if(terning[0].getAntalOjne()==terning[1].getAntalOjne()){
			if(terning[0].getAntalOjne()==1)
				point = 0;
			xtraturn = true;
		}
		
		
		System.out.println("terninger slået:");
		for(Terning t : terning){
			System.out.printf(" "+t+ "");
		}
		System.out.println();
		System.out.println("point: \t" + point);
		// skal bruges til at sikre der er slået to ens.
		int[] hygge = sslag.get(sslag.size()-1);
		if(point >40 && hygge[0]==hygge[1]){
			System.out.println("du har over 40 point, og har vundet");
			vundet = true;
		}
	}
	
	public boolean getVundet(){
		return vundet;
	}
	
	public boolean getXtraTurn(){
		return xtraturn;
	}
	
	public int getPoint(){
		return point;
	}
	

}
