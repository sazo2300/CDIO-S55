package guitest;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Player[] player = {new Player("test", new Terning(), new Terning()), new Player("hygge", new Terning(), new Terning())};
		Scanner sc = new Scanner(System.in);
		
		
		
		while(!player[0].getVundet() && !player[1].getVundet()){
			for(Player p : player){
				if(!player[0].getVundet() && !player[1].getVundet()){
							
					do{
						System.out.println("Player:\t" + p.getName() + " turn");
						System.out.println("Write a char/String to throw dice & press enter.");
						sc.next();
					
						p.rafl();
						p.endturn();
					}while(p.getXtraTurn() && !p.getVundet());
				}
			
			}
			

			
		}
		System.out.println("spillet er slut");

	}

}
