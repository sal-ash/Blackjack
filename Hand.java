package com.salah.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.salah.collections.Card;
import java.util.HashMap;

public class Hand {
	public List<Card> list;
	public DeckOfCards deck;
	

	public Hand(List<Card> list, DeckOfCards deck) {
		super();
		this.list = list;
		this.deck = deck;
	}

	public List<Card> getList() {
		return list;
	}

	public void setList(List<Card> list) {
		this.list = list;
	}
	public DeckOfCards getDeckOfCards() {
		return deck;
	}

	public void setDeckOfCards(DeckOfCards deck) {
		this.deck = deck;
	}
	public void Draw() {
		Card x = getDeckOfCards().list.get(getDeckOfCards().draw);
		Card y = getDeckOfCards().list.get((getDeckOfCards().draw + 1));
		list.add(x);
		list.add(y);
		getDeckOfCards().draw += 2;
	}
	public void Hit() {
		Card x = getDeckOfCards().list.get(getDeckOfCards().draw);
		list.add(x);
		getDeckOfCards().draw += 1;
	}
	public int GetValue()  {
		int x = 0;
		int y = 21;
		Map <String, Integer> value = new HashMap<String, Integer>() 
		{
			{  put("Ace", 11);
			   put("Deuce", 2);
			   put("Three", 3);
			   put("Four", 4);
			   put("Five", 5);
			   put("Six", 6);
			   put("Seven", 7);
			   put("Eight", 8);
			   put("Nine", 9);
			   put("Ten", 10);
			   put("Jack", 10);
			   put("Queen", 10);
			   put("King", 10);
			}
		};
		for(int count = 0; count < list.size(); count++) {
			x += value.get(list.get(count).getFace().toString());
		}
		if(x > y) {
		for(Card i : list) {
				if(i.getFace().toString() == "Ace") {
					x -= 10;
				}
			}
		}
	return x;
	}
	public void printHand() {
        for (int i = 0; i < list.size(); i++) {
        	System.out.printf("%s ", list.get(i).getFace());
        }
}
	public void showCard(int card) {
		System.out.printf("%s %n", list.get(card).getFace());
	}
}