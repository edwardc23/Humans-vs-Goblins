import java.util.Random;
import java.util.Scanner;



public class HumansVsGoblins{
    static Humans player1= new Humans(	"\uD83D\uDEB6");
    static Goblins enemy= new Goblins("\uD83D\uDC7A");
    static Land grid = new Land();
    static String[] direction={"n","s","e","w"};
    static boolean inCombat=false;
    static int turns;
    static boolean inGame=true;

static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        grid.createGrid(player1,enemy);
        Random rand = new Random();
        turns=0;
        while(inGame){
            playGame();

        }}
        public static void playGame()
        {
            while(!inCombat)
            {
                if (turns % 2 == 0)
                {
                    grid.table =player1.move(in.next(), player1.place[0], player1.place[1], in,grid,player1,enemy);
                    grid.printGrid(grid.table);
                    System.out.println("");
                }
                else{
                    int r = 3;
                    grid.printGrid(enemy.move(direction[r], enemy.place[0], enemy.place[1], in,grid,player1,enemy));
                }
                grid.Combat(player1,enemy,turns);
                turns++;
            }


        }

        public static void fightMe()
        {
            if(player1.currentHealth!=0||enemy.currentHealth!=0) {
                grid.Combat(player1, enemy, turns);
                turns++;
                inCombat=true;
            }
            else
            {
                inCombat=false;
            }
        }

    }


