/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class Chips {
    
    
    private int numChips;
    
    
    
    public Chips(int numTotal){
        this.numChips = numTotal;
    }
    
   
    
    public void winChips(String betAmount){
        int betAmt = Integer.parseInt(betAmount);
        betAmt *= 2;
        
        this.numChips += betAmt;
        System.out.println("You win " + betAmt/2 + " chips.");
        
        
    }
    public void loseChips(String betAmount){
        
        System.out.println("You lose " + betAmount + " chips.");
        
    }
    public void betChips(String betAmt, int numberChips){
        int betAmt1 = Integer.parseInt(betAmt);
        
        boolean checkChips = true;
        
        while(checkChips){
            
            if (betAmt1 <= getNumChips()) {
                
                numberChips -= betAmt1 ;
                
                numChips = numberChips;
                
                checkChips = false;
                
            }else{
                System.out.println("You don't have that many chips. Try again.");
            }
            
        }
        
    }

    /**
     * @return the numChips
     */
    public int getNumChips() {
        return numChips;
    }

    public void drawChips(String betAmount) {
        int betAmt = Integer.parseInt(betAmount);
        
        
        this.numChips += betAmt;
        System.out.println("You get your " + betAmt + " chips back.");
    }

    
}
