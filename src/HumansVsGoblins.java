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
        grid.createGrid(player1,enemy);
        Random rand = new Random();
        turns=0;
        while(inGame){
            playGame();

        }}
        public static void playGame()
        {

            while(inGame) {
                while (!inCombat) {
                    if (turns % 2 == 0) {
                        grid.table = player1.move(in.next(), player1.place[0], player1.place[1], in, grid, player1, enemy);
                        grid.printGrid(grid.table,player1,enemy);
                        System.out.println("");
                    } else {
                        int r = 3;
                        grid.printGrid(enemy.move(direction[r], enemy.place[0], enemy.place[1], in, grid, player1, enemy),player1,enemy);
                    }
                    String f=grid.Combat(player1, enemy, turns);
                    if(f.equals("Not Over")){
                        inCombat=true;}
                    turns++;
                }
                fightMe();
            }

        }

        public static void fightMe()
        {
            String outcome="";
            while(inCombat){
            if(player1.currentHealth!=0||enemy.currentHealth!=0) {
                outcome=grid.Combat(player1, enemy, turns);
                turns++;
                inCombat=true;
                if(outcome.equals("win")) {
                    System.out.println("You defeated the goblin!!");
                    player1.killCount++;
                    enemy=gobs.get(player1.killCount);
                    enemy.place[0]=4;
                    enemy.place[1]=4;
                    if(player1.currentHealth<=75)
                    {
                    player1.currentHealth=player1.currentHealth+25;
                    }
                    System.out.println("Goblin drop:"+enemy.itemEQ);
                    player1.addItem(enemy.itemEQ);
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


