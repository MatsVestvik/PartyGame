package cards;

import cards.specificCard.SunglassesItemCard;
import cards.specificCard.AxeItemCard;
import cards.specificCard.BasicCreatureCard;
import cards.specificCard.DelinquantCreatureCard;

public class RandomCard {
   public RandomCard(int scale) {
   } 
   public static Base getRandomCard(int scale) {
       int rand = (int)(Math.random() * 4);
       if (rand == 0) {
           return new BasicCreatureCard(scale);
       } else if (rand == 1) {
           return new DelinquantCreatureCard(scale);
       }
       else if (rand == 2) {
           return new AxeItemCard(scale);
       }
       else if (rand == 3) {
           return new SunglassesItemCard(scale);
       }
       else {
           return new BasicCreatureCard(scale);
       }
   }
}

