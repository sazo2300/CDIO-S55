package guitest;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player player = new Player("navn");
		System.out.println("her starter testen");
		while(!player.getVundet()){
			System.out.println("kast terninger");
			sc.next();
			player.rafl();
			player.printSlag();
		}
	}

}
