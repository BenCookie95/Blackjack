/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class Player {
    private String name;
    
    //cards in the current hand
    private Card[] hand = new Card[10];
    
    //number of cards in the current hand
    private int numCards;
    
    public Player(String aName){
        this.name = aName;
        
        this.emptyHand();
        
    }

    public void emptyHand() {
        for (int c = 0; c < 10; c++) {
            this.hand[c] = null;
        }
        this.numCards = 0;
    }
    //adds a card to the players hand
    public boolean addCard(Card aCard){
        //prints error if you already have the maximum number of cards
        if (this.numCards == 10) {
            System.err.println(name + " already has 10 cards in their hand. Cannot add another.");
            System.exit(1);
        }
        
        //add new card in next slot and increment counter
        this.hand[this.numCards] = aCard;
        this.numCards++;
        
        return (this.getHandSum() <=21);
    }
    //get the sum of the cards in the player hand
    public int getHandSum() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;
        //calc each cards contribution to the hand sum
        for (int c = 0; c < this.numCards; c++) {
            //get the number of current card
            cardNum = this.hand[c].getMyNumber();
            
            if (cardNum == 1) {
                numAces++;
                handSum += 11;
            }else if(cardNum > 10){
                handSum += 10;
            }else{
                handSum += cardNum;
            }
        }
        
        while(handSum >21 && numAces > 0){
            handSum -= 10;
            numAces--;
        }
        
        return handSum;
    }
    
    public void printHand(boolean showFirstCard){
        System.out.println();
        System.out.println(this.name + "'s cards:");
        
        for (int c = 0; c < this.numCards; c++) {
            if (c == 0 && !showFirstCard) {
                System.out.println("   [Hidden]");
            }else{
                System.out.println(this.hand[c].toString());
                
            }
        }
    }
}
