import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Goblins extends Ob{
    String enemy1;
    int[] place= getPlace();
    String[] items= {"Sword","Shield","Armor of God","AR-15","Captain America Shield"
            ,"Axe","Bow and Arrow","Brass Knuckles"};
    Random rand =new Random();
    String itemEQ;
    int inf=0;
    static String[] direction={"n","s","e","w"};
    public Goblins(String enemy)
    {place[0]=6;
    place[1]=6;

        enemy1 =  enemy;
        currentHealth=50;
        power=1;
         itemEQ=itemAdd(items);
        attacks.add(0,"Slap");
        attacks.add(1,"Bite");
        attacks.add(2,"Ambush");


    }
    public String itemAdd(String[] i)
    {
        //String[] items= {"Sword","Shield","Armor of God","AR-15","Captain America Shield"
        //            ,"Axe","Bow and Arrow","Brass Knuckles"};
        int num = rand.nextInt(16);
        inf++;
        String item = "";
        if(inf%3==0)
        {
            item = "Coronavirus";
            return item;
        }
        else {

            switch (num) {
                case 0:
                    item = items[num];
                    break;
                case 1:
                    item = items[num];
                    break;
                case 2:
                    item = items[num];
                    break;
                case 3:
                    item = items[num];
                    break;
                case 4:
                    item = items[num];
                    break;
                case 5:
                    item = items[num];
                    break;
                case 6:
                    item = items[num];
                    break;
                case 7:
                    item = items[num];
                    break;
                case 8:
                    item = "PTN";
                    break;
                case 9:
                    item = "Full";
                    break;
                case 10:
                    item = "";
                    break;



            }

            return item;
        }
    }



    public void combat(Humans h) {
        int p=super.combat(h,"Goblin");
        int damage;
        String a;
        switch (p) {
            case 0:damage=(power*rand.nextInt(50)+1);
                h.currentHealth =h.currentHealth-damage;//attack strength
                System.out.println("Goblin using "+attacks.get(p)+" and dealt "+damage+" damage");
                damage=0;
                break;
            case 1: damage=(power*rand.nextInt(60)+1);
                h.currentHealth =h.currentHealth-damage;//attack strength
                System.out.println("Goblin using "+attacks.get(p)+" and dealt "+damage+" damage");
                damage=0;
                break;
            case 2: damage=(power*rand.nextInt(70)+1);
                h.currentHealth =h.currentHealth-damage;//attack strength
                System.out.println("Goblin using "+attacks.get(p)+" and dealt "+damage+" damage");
                damage=0;
                break;

        }




    }

    public String toString(String move) {
        if(move.equals("n")||move.equals("e")||move.equals("s"))
        {return enemy1+"|";}
        else
        {return enemy1+"|";}


    }
    public String[][] move( int x, int y, Scanner in,Land a,Humans player1, Goblins enemy)
    {
        String movements="";

        if(enemy.place[0]!=player1.place[0])
        {
            if(enemy.place[0]>player1.place[0])
            {
                movements="n";
            }
            else
            {
                movements="s";
            }
        }
        else if(enemy.place[1]!=player1.place[1])
        {
            if(enemy.place[1]>player1.place[1])
            {
                movements="w";
            }
            else
            {
                movements="e";
            }
        }

        switch(movements) {
            case ("n"):
                if(x!=0)
                {
                    a.table[x - 1][y] = toString(enemy1);
                    place[0]=x-1;
                    place[1]=y;

                }

                break;
            case("s"):
                if(x!=6)
                {
                    a.table[x + 1][y] = toString(enemy1);
                    place[0]=x+1;
                    place[1]=y;
                }

                break;
            case("e"):
                if(y<6)
                {
                    a.table[x][y+1] = toString(enemy1);
                    place[0]=x;
                    place[1]=y+1;
                }

                break;
            case("w"):
                if(y>0)
                {
                    a.table[x][y - 1] = toString(enemy1);
                    place[0]=x;
                    place[1]=y-1;
                }

                break;

        }
        if(Arrays.equals(player1.place,enemy.place))
        {
            if(movements.equals("n"))
            {
                enemy.place[0]=enemy.place[0]+1;
            }
            else if(movements.equals("s"))
            {
                enemy.place[0]=enemy.place[0]-1;
            }
            else if(movements.equals("e"))
            {
                enemy.place[1]=enemy.place[1]+1;
            }
            else if(movements.equals("w"))
            {
                enemy.place[1]=enemy.place[1]-1;
            }
        }
        a.table=a.createGrid(player1,enemy);

        return a.table;}
}
