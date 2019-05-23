package com.salah.collections;

import java.util.ArrayList;
import java.util.List;
import com.salah.collections.Card;
import java.util.Scanner;

public class blackjackmain {

	public static void main(String[] args) {
		DeckOfCards first = new DeckOfCards();
		List<Card> myinitial = new ArrayList();
		List<Card> dinitial = new ArrayList();
		Hand myhand = new Hand(myinitial, first);
		Hand dhand = new Hand(dinitial, first);
		myhand.Draw();
		System.out.println("You are dealt: ");
		myhand.printHand();
		myhand.GetValue();
    	System.out.printf("%nYour score is: " + myhand.GetValue());
    	
		while(true) {
		Scanner userinput = new Scanner(System.in);  
		System.out.println();
	    System.out.println("Enter H for hit or S for stand");
	    String userdec = userinput.nextLine();
	    if(userdec.contentEquals("H")) {
	    	myhand.Hit();
	    	myhand.printHand();
	    	myhand.GetValue();
	    	System.out.printf("%nYour score is: " + myhand.GetValue());
	    	if(myhand.GetValue() > 21) {
	    		System.out.printf("%nYou Lose");
	    		break;
	    		}
	    	}
	    else if(userdec.contentEquals("S")) {
	    	dhand.Draw();
	    	System.out.println("Dealer Shows: ");
	    	dhand.showCard(0);
	    	int count = 1;
	    	while(dhand.GetValue() < 17) {
	    	dhand.Hit();
	    	dhand.GetValue();
	    	System.out.println("Dealer Hits");
	    	dhand.showCard(count);
	    	count = count + 1;
	    	}
	    	if(dhand.GetValue() > 21) {
	    		System.out.printf("%nDealer score is " + dhand.GetValue());
	    		System.out.printf("%nYou Win");
	    		break;
	    		}
	    	if((21 - dhand.GetValue()) < (21 - myhand.GetValue())) {
	    		System.out.println("Dealer Stands");
	    		System.out.printf("%nDealer score is " + dhand.GetValue());
	    		System.out.printf("%nYou Lose");
	    		break;
	    		}
	    	if((21 - dhand.GetValue()) == (21 - myhand.GetValue())) {
	    		System.out.println("Dealer Stands");
	    		System.out.printf("%nDealer score is " + dhand.GetValue());
	    		System.out.printf("%nYou Draw");
	    		break;
	    		}
	    	else  {
	    		System.out.println("Dealer Stands");
	    		System.out.printf("%nDealer score is " + dhand.GetValue());
	    		System.out.printf("%nYou Win");
	    	    break;
	    		}
	    	}
	    
	    }
	}
}
	    
		
		
		


