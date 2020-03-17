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
    public int  combat(Object h,String x) {
        int attack=0;
        if(x.equals("Goblin"))
        {
            attack = rand.nextInt(3);
        }
         else if(x.equals("Human"))
        {
            System.out.println("What would you like to do? (Pick a number)");
            System.out.println(String.format("""
                    1. Punch
                    2. Stab
                    3. Shoot
                    """));

            int y =0;

            do{
                while(!in.hasNextInt()){
                    String i=in.next();
                    System.out.printf("\"%s\" is not a valid number.\n", i);
                }
                y=in.nextInt();
            }while(y!=1&&y!=2&&y!=3);
            {

                attack = y - 1;

            }
        }

     
return attack;
    }
    public static int[] getPlace() {
        return place;
    }
}
