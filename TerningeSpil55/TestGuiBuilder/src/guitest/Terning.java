package guitest;


public class Terning {
	
	private int antalOjne;
	
	public Terning(int slag){
		antalOjne = slag;
	}
	public Terning(){}
	
	public void hit(int slag){
		antalOjne = slag;
	}
	
	public void hit(){
		double d = Math.random()*6 + 1;
		antalOjne = (int)d;
	}
	
	public int getAntalOjne(){
		return antalOjne;
	}
	
	public String toString(){
		String s;
		s = Integer.toString(antalOjne);
		return s;
	}
	

}
