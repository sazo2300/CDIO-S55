package guitest;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		int[] terningeArray;
		terningeArray = new int[1000];
		Terning terning = new Terning();
		for(int i = 0; i<terningeArray.length ; i++){
			terning.hit();
			terningeArray[i] = terning.getAntalOjne();
			
			
		}
		
		for(int t : terningeArray){
			System.out.println(t);
		}
	}

}
