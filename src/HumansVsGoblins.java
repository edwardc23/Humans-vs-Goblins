import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class HumansVsGoblins{
    static Humans player1= new Humans(	"\uD83D\uDEB6");
    static Goblins goblin= new Goblins("\uD83D\uDC7A");
    static ArrayList<Goblins> gobs=new ArrayList<Goblins>(Arrays.asList(goblin));
    static Goblins enemy= gobs.get(0);
    static Land grid = new Land();
    static String[] direction={"n","s","e","w"};
    static boolean inCombat=false;
    static int turns;
    static boolean inGame=true;

static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        for(int x=0;x<30;x++) {
            Goblins g=new Goblins("\uD83D\uDC7A");
            gobs.add(g);
        }
        grid.table=grid.createGrid(player1,enemy);

        Random rand = new Random();
        turns=0;
        while(inGame){
            playGame();
            if(player1.isInfected)
            {
                if(player1.currentHealth<=0)
                {
                    inGame=false;
                }
            }

        }}
        public static void playGame()
        {

            while(inGame) {
                while (!inCombat) {
                    if (turns % 2 == 0) {
                        grid.printGrid(grid.createGrid(player1,enemy),player1,enemy);
                        System.out.println("What direction do you want to go in?");
                        grid.table = player1.move(in.next(), player1.place[0], player1.place[1], in, grid, player1, enemy);

                        System.out.println("");
                    } else {

                       enemy.move(enemy.place[0], enemy.place[1], in, grid, player1, enemy);
                    }
                   if((player1.place[0]+1==goblin.place[0]&&player1.place[1]==goblin.place[1])||
                           (player1.place[0]-1==goblin.place[0]&&player1.place[1]==goblin.place[1])||
                           (player1.place[0]==goblin.place[0]&&player1.place[1]+1==goblin.place[1])||
                           (player1.place[0]==goblin.place[0]&&player1.place[1]-1==goblin.place[1])){
                       fightMe();
                   }
                    turns++;
                }

            }

        }

        public static void fightMe()
        {
            String outcome="";
            inCombat=true;
            while(inCombat){
            if(player1.currentHealth!=0||enemy.currentHealth!=0) {
                outcome=grid.Combat(player1, enemy, turns);
                turns++;
                inCombat=true;
                grid.printGrid(grid.table,player1,enemy);
                if(outcome.equals("win")) {
                    System.out.println("You defeated the goblin!!");
                    player1.killCount++;



                    //grid.printGrid(grid.table,player1,enemy);
                    grid.lootPlace[0]=enemy.place[0];
                    grid.lootPlace[1]=enemy.place[1];
                    enemy=gobs.get(player1.killCount);
                    enemy.place[0]=6;
                    enemy.place[1]=6;

                    if(player1.currentHealth<=75)
                    {
                    player1.currentHealth=player1.currentHealth+25;
                    }

                    if(player1.killCount%3==0)
                    {
                        player1.power=(player1.killCount/3)+1;
                    }
                    inCombat=false;
                    break;
                }
                else if(outcome.equals("lost"))
                {

                    inGame=false;
                    inCombat=false;
                    System.out.println("You have died");
                    break;
                }
            }
            else
            {
                inCombat=false;
            }

            }




        }

    }


