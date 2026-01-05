package cards;

public class RandomCard {
   public RandomCard(int scale) {
   } 
   public static Base getRandomCard(int scale) {
       int rand = (int)(Math.random() * 3);
       if (rand == 0) {
           return new BasicCreatureCard(scale);
       } else if (rand == 1) {
           return new DelinquantCreatureCard(scale);
       }
       else if (rand == 2) {
           return new AxeItemCard(scale);
       }
       else {
           return new BasicCreatureCard(scale);
       }
   }
}

