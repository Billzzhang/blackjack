/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author Bill Zhang
 */
public class Player {
    private int[] cards = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8};
    private int total, counter;
    private String name;
    Random rand = new Random();
    Player(String n, int tot) {
        this.name = n;
        this.total = tot;
        this.counter = 2;
    }
    public String getName(){
        return this.name;
    }
    public int getCounter(){
        return this.counter;
    }
    public void setCounter(int n) {
        counter = n;
    }
    public int[] getCards(){
        return this.cards;
    }
    public int getCard(int index) {
        return this.cards[index];
    }
    public void setCards(int[] n) {
        for (int j = 0; j < cards.length; j++) {
            
        }
        this.cards = n;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int n) {
        this.total = n;
    }
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    
    }
}
