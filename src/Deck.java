/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author Ben
 */
public class Deck {
    
    //array of cards in the deck
    private Card[] myCards;
    
    //number of cards currently in the deck
    private int numCards;
    
    int c = 0;
    
    //default constructor
    public Deck(){
        this(1, false);
    }
    //constructor that defines the number of decks and if it's to be shuffled
    public Deck(int numDecks, boolean shuffle){
        this.numCards = numDecks * 52;
        this.myCards = new Card[numCards];
        //for each deck
        for (int i = 0; i < numDecks; i++) {
            
            //for each suit
            for (int j = 0; j < 4; j++) {
                
                
                //for each number
                for (int k = 1; k <= 13; k++) {
                    this.myCards[c] = new Card(Suit.values()[j], k);
                    c++;
                }
            }
        }
        
        //shuffle if necessary
        if (shuffle) {
            this.shuffle();
        }
    }

    //shuffle deck by randomly swapping pairs of cards
    public void shuffle() {
        Random rng = new Random();
        
        //temporary Card
        Card temp;
        
        int a;
        for (int i = 0; i < this.numCards; i++) {
            
            //get a random card
            a = rng.nextInt(this.numCards);
            
            //swap
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[a];
            this.myCards[a] = temp;
        }
    }
    //deal the card from the top of the deck
    public Card dealNextCard(){
        Card top = this.myCards[0];
        
        //shift all the subsequent cards to the left by one index
        for (int c = 1; c < this.numCards; c++) {
            this.myCards[c-1] = this.myCards[c];
        }
        
        this.myCards[this.numCards-1] = null;
        
        //derement the number of cards in the deck
        this.numCards--;
        return top;
    }
    
    public void printDeck(int numToPrint){
        for (int c = 0; c < numToPrint; c++) {
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());   
        }
        System.out.printf("\t[%d other]\n", this.numCards-numToPrint);
    }
}
