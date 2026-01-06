package cards;

import cards.specificCard.Shades;
import cards.specificCard.Axe;
import cards.specificCard.Norm;
import cards.specificCard.Snoopy;

public class RandomCard {
   public RandomCard(int scale) {
   } 
   public static Base getRandomCard(int scale) {
       int rand = (int)(Math.random() * 4);
       if (rand == 0) {
           return new Norm(scale);
       } else if (rand == 1) {
           return new Snoopy(scale);
       }
       else if (rand == 2) {
           return new Axe(scale);
       }
       else if (rand == 3) {
           return new Shades(scale);
       }
       else {
           return new Norm(scale);
       }
   }
}

