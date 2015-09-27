/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Ben
 */
public class GameRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deck theDeck = new Deck(1, true);
        Chips myChips = new Chips(100);
        
        Player me = new Player("Ben");
        Player dealer = new Player("Dealer");
        boolean continuePlay = true;
        String betAmount = null;
        //loop to keep the game running
        while(continuePlay){
            System.out.println("You have " + myChips.getNumChips() + " chips.");
            
           
                //check if you have more than 0 chips
                if (myChips.getNumChips() > 0) {
                    
                    
                    System.out.println("How many chips do you to bet?");
                    betAmount = sc.next();
                    myChips.betChips(betAmount, myChips.getNumChips());
                    

                }else{
                    System.out.println("You have run out of chips. Game Over");
                    System.exit(1);
                }
            
            
            me.addCard(theDeck.dealNextCard());
            dealer.addCard(theDeck.dealNextCard());
            me.addCard(theDeck.dealNextCard());
            dealer.addCard(theDeck.dealNextCard());

            //print intial hands
            System.out.println("cards are dealt\n");
            me.printHand(true);
            System.out.println();
            System.out.println("Your Total is " + me.getHandSum());
            dealer.printHand(false);
            System.out.println("\n");

            //flags for when each player is finshed hitting
            boolean meDone = false;
            boolean dealerDone = false;
            String ans;

            while(!meDone || !dealerDone){
                //players turn

                if (!meDone) {
                    System.out.print("Hit or Stand? (Enter H or S): ");
                    ans = sc.next();
                    System.out.println();

                    //if the player hits
                    if (ans.compareToIgnoreCase("H") == 0) {
                        //add next card in the deck and store whether they are busted
                        meDone = !me.addCard(theDeck.dealNextCard());
                        me.printHand(true);
                        System.out.println();
                        System.out.println("Your Total is " + me.getHandSum());
                    }else{
                        meDone = true;
                    }
                }

                System.out.println();
                if (!dealerDone) {
                    if (dealer.getHandSum() < 17) {
                        System.out.println("The dealer hits\n");
                        dealerDone =!dealer.addCard(theDeck.dealNextCard());
                        dealer.printHand(false);
                    }else{
                        System.out.println("The dealer stands\n");
                        dealerDone = true;
                    }
                }

                
            }
            

            me.printHand(true);
            dealer.printHand(true);

            int mySum = me.getHandSum();
            int dealerSum = dealer.getHandSum();

            if(mySum > dealerSum && mySum <= 21 || dealerSum > 21 && mySum <= 21 ){
                System.out.println();
                System.out.println("Your Total is " + me.getHandSum());
                myChips.winChips(betAmount);
                System.out.println("You win");
                
            }else if(mySum == dealerSum && mySum <= 21){
                System.out.println();
                System.out.println("Your Total is " + me.getHandSum());
                System.out.println("The Dealers Total is " + dealer.getHandSum());
                myChips.drawChips(betAmount);
                System.out.println("Draw");
            }else{
                System.out.println();
                System.out.println("The Dealers Total is " + dealer.getHandSum());
                myChips.loseChips(betAmount);
                System.out.println("Dealer wins");
            }
            me.emptyHand();
            dealer.emptyHand();
            
            String playAgain;
            System.out.println();
            System.out.print("Play Again? (Enter Y or N): ");
            playAgain = sc.next();
            if(playAgain.compareToIgnoreCase("Y") == 0){
                continuePlay = true;
            }else{
                continuePlay = false;
            }
        }
    }
}
