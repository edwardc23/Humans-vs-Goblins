import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ob {

 int maxHealth=100;
 int currentHealth=100;
 int power;
 int turns=0;
 static int[] place=new int [2];
 Random rand = new Random();
 Scanner in = new Scanner(System.in);
 ArrayList <String>attacks=new ArrayList<String>();

    public  int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getPower() {
        return power;
    }
    public int  combat(Object h) {

         int attack = rand.nextInt(3);
     
return attack;
    }
    public static int[] getPlace() {
        return place;
    }
}
