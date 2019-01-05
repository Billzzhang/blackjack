/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;
/**
 *
 * @author Bill Zhang
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        BlackJack game = new BlackJack();
        Player dealer = new Player("Dealer", 0);
        String choice;
        
        System.out.println("Welcome to Bill Zhang's blackjack program");
        System.out.println("What is your name?");
        Player myself = new Player(keyboard.next(), 0);
        System.out.print("\033[H\033[2J");
        myself.setCards(myself.getCards());
        myself.setTotal(myself.getCard(0) + myself.getCard(1));
        System.out.println("You get a " + myself.getCard(0) + " and a " + myself.getCard(1));
        System.out.println("Your total is " + myself.getTotal());
        
        dealer.setCards(dealer.getCards());
        System.out.println("The dealer has a " + dealer.getCard(0) + " showing, and a hidden card.");
        
        do {            
            System.out.print("Would you like to \"hit\" or \"stay\"? " );
            choice = keyboard.next();
            if (!choice.equalsIgnoreCase("hit") && !choice.equalsIgnoreCase("stay"))
                System.out.println("Sorry that is not a choice");
        } while (!choice.equalsIgnoreCase("hit") && !choice.equalsIgnoreCase("stay"));
        
        while (choice.equalsIgnoreCase("hit")) {
            System.out.println("You got a " + myself.getCard(myself.getCounter()));
            game.incrementTotal(myself);
            System.out.println("Your total is " + myself.getTotal());
            myself.setCounter(myself.getCounter() + 1);
            game.checkLoss(myself);
            System.out.print("Would you like to \"hit\" or \"stay\"? " );
            choice = keyboard.next();
        }
        
        System.out.println("Okay, dealer's turn.");
        System.out.println("His hidden card was a " + dealer.getCard(1));
        dealer.setTotal(dealer.getCard(0) + dealer.getCard(1));
        System.out.println("His total is " + dealer.getTotal());
        
        while (dealer.getTotal() <= 17) {
            System.out.println("The dealer takes a hit");
            System.out.println("He drew a " + dealer.getCard(dealer.getCounter()));
            game.incrementTotal(dealer);
            System.out.println("His total is " + dealer.getTotal());
            game.checkLoss(dealer);
        }
        if(dealer.getTotal() >= myself.getTotal())
            System.out.println("Dealer wins");
        else
            System.out.println(myself.getName() + "wins");
        
    }
    public void checkLoss(Player player) {
        if (player.getTotal() > 21) {
            System.out.println(player.getName() + " went over 21, " + player.getName() + " loses. ");
            System.exit(0);
        }
    }
    
    public void incrementTotal(Player player) {
        player.setTotal(player.getTotal() + player.getCard(player.getCounter()));
    }
}
