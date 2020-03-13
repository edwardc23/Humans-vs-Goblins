import java.util.Scanner;

public class Goblins extends Ob{
    String enemy1;
    int[] place= getPlace();

    static String[] direction={"n","s","e","w"};
    public Goblins(String enemy)
    {place[0]=4;
    place[1]=4;
        enemy1=enemy;
        currentHealth=75;
        power=1;
        attacks.add(0,"Slap");
        attacks.add(1,"Bite");
        attacks.add(2,"Ambush");


    }



    public void combat(Humans h) {
        int p=super.combat(h);
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
    public String[][] move(String movements, int x, int y, Scanner in,Land a,Humans player1, Goblins enemy)
    {

        switch(movements.toLowerCase()) {
            case ("n"):
                if(x!=0)
                {
                    a.table[x - 1][y] = toString(enemy1);
                    place[0]=x-1;
                    place[1]=y;

                }
                else
                {
                    movements=direction[rand.nextInt(4)];
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;
            case("s"):
                if(x!=4)
                {
                    a.table[x + 1][y] = toString(enemy1);
                    place[0]=x+1;
                    place[1]=y;
                }
                else
                {
                    movements=direction[rand.nextInt(4)];
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;
            case("e"):
                if(y<4)
                {
                    a.table[x][y+1] = toString(enemy1);
                    place[0]=x;
                    place[1]=y+1;
                }
                else
                {
                    movements=direction[rand.nextInt(4)];
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;
            case("w"):
                if(y>0)
                {
                    a.table[x][y - 1] = toString(enemy1);
                    place[0]=x;
                    place[1]=y-1;
                }
                else
                {
                    movements=direction[rand.nextInt(4)];
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;

        }
        a.table=a.createGrid(player1,enemy);

        return a.table;}
}
