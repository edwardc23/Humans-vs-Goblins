import java.util.Scanner;

public class Humans extends Ob{
    String pawn1;
    int [] place= new int[2];
    String[] inventory= new String[6];
    int indexOfInventory=0;
    int killCount=0;
    int addOn=1;
    boolean itemE=false;
    boolean isInfected=false;
    int inf=0;
    public Humans(String pawn)
    {
       pawn1=pawn;
        power=1;
        place[0]=0;
        place[1]=0;
        attacks.add(0,"Punch");
        attacks.add(1,"Stab");
        attacks.add(2,"Shoot");

    }




    public void combat(Goblins h) {
        int p=super.combat(h,"Human");
        int damage;
        String a;
        switch (p) {
            case 0:a=attacks.get(p);
            damage=(power*rand.nextInt(25)+addOn);
                h.currentHealth =h.currentHealth-damage;//attack strength
                System.out.println("I attack using "+attacks.get(p)+" and dealt "+damage+" damage");
                damage=0;
                break;
            case 1:damage=(power*(rand.nextInt(50)+15)+addOn);
                h.currentHealth =h.currentHealth-damage;//attack strength
                System.out.println("I attack using "+attacks.get(p)+" and dealt "+damage+" damage");
                damage=0;
                break;
            case 2: damage=(power*(rand.nextInt(50)+35)+addOn);
                h.currentHealth =h.currentHealth-damage;//attack strength
                System.out.println("I attack using "+attacks.get(p)+" and dealt "+damage+" damage");
                damage=0;
                break;
    }
    }

    public String toString(String move) {
        if(move.equals("n")||move.equals("e")||move.equals("s"))
        {return pawn1 +"| ";}
        else
        {return pawn1 +" |";}
    }
    public void addItem(String item)
    {
        inventory[indexOfInventory]= item;
        indexOfInventory=indexOfInventory+1;



        switch(item){
            case "Sword":
                addOn=15;
                break;
            case "Shield":
                currentHealth=currentHealth+25;
                maxHealth=maxHealth+25;
                break;
            case "Armor of God":
               currentHealth=currentHealth+100;
               maxHealth=maxHealth+100;
                break;
            case "AR-15":
                addOn=35;
                break;
            case "Captain America Shield":
                currentHealth=currentHealth+50;
                maxHealth=maxHealth+50;
                break;
            case "Axe":
                addOn=10;
                break;
            case "Bow and Arrow":
                addOn=5;
                break;
            case "Brass Knuckles":
                addOn=7;
                break;
            case"Coronavirus":
                boolean isInfected=true;
                break;

        }




    }

    public String[][] move(String movements, int x, int y, Scanner in,Land a,Humans player1, Goblins enemy)
    {
        if(inf<=5&&isInfected)
        {currentHealth=currentHealth-5;

        }
        else
        {
            isInfected=false;
        }
        switch(movements.toLowerCase()) {
            case ("w"):
                if(x!=0)
                {
                    a.table[x - 1][y] = toString(pawn1);
                    place[0]=x-1;
                    place[1]=y;

                }
                else
                {
                    movements=in.next();
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;
            case("s"):
                if(x!=6)
                {
                    a.table[x + 1][y] = toString(pawn1);
                    place[0]=x+1;
                    place[1]=y;
                }
                else
                {
                    movements=in.next();
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;
            case("d"):
                if(y<6)
                {
                    a.table[x][y+1] = toString(pawn1);
                    place[0]=x;
                    place[1]=y+1;
                }
                else
                {
                    movements=in.next();
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;
            case("a"):
                if(y>0)
                {
                    a.table[x][y - 1] = toString(pawn1);
                    place[0]=x;
                    place[1]=y-1;
                }
                else
                {
                    movements=in.next();
                    move(movements,x,y,in,a,player1,enemy);
                }
                break;

        }
        a.table=a.createGrid(player1,enemy);

    return a.table;}
}
