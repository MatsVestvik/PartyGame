package cards;

public class RandomCard {
   public RandomCard(int scale) {
   } 
   public static Base getRandomCard(int scale) {
       int rand = (int)(Math.random() * 2);
       if (rand == 0) {
           return new BasicCreatureCard(scale);
       } else {
           return new DelinquantCreatureCard(scale);
       }
   }
}

