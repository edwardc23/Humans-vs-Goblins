import java.util.ArrayList;

public class Land  {
    String [][] table=new String [7][7];
    int num=0;
    ArrayList fill= new ArrayList();

    public String[][] createGrid(Humans player1, Goblins enemy)
    {

        if(num==0){
            for(int x= 0; x<7;x++)
            {

                for(int y=0;y<7;y++)
                {
                    if(x==0&&y==0)
                    {
                        table[x][y]=" "+player1.pawn+"| ";
                        System.out.print(table[0][0]);
                        player1.place[0]=0;
                        player1.place[1]=0;
                    }
                    else if(x==6&&y==6)
                    {
                        table[x][y]=enemy.enemy1+"|";
                        System.out.print(table[6][6]);
                        enemy.place[0]=6;
                        enemy.place[1]=6;
                    }
                    else{
                        table[x][y]=String.valueOf(x)+String.valueOf(y)+"|";
                        System.out.print(table[x][y]+" ");
                    }
                }
                System.out.println("");
            }
            num++;
        }
        else
        {
            for(int x= 0; x<7;x++)
            {

                for(int y=0;y<7;y++)
                {

                    if(player1.place[0]==x&&player1.place[1]==y)
                    {
                        table[x][y] = " "+player1.pawn+"|";
                    }
                    else if(enemy.place[0]==x&&enemy.place[1]==y)
                    {
                        table[x][y] = ""+enemy.enemy1+"|";
                    }
                    else
                    {
                        table[x][y]=String.valueOf(x)+String.valueOf(y)+"|";
                    }
                }

            }
        }



        return table;}
    public void printGrid(String[][] table1,Humans p,Goblins g) {
        this.table = table1;
        for (int x = 0; x < 7; x++) {

            for (int y = 0; y < 7; y++) {
                System.out.print(table[x][y] + "");
            }
            System.out.println("");
        }
        System.out.println("");
        if (p.currentHealth == 100) {
            System.out.println(
                    String.format("""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s     |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount));

        }
        if (p.currentHealth <=99&&p.currentHealth>9) {
            System.out.println(
                    String.format("""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s      |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount));

        }
        if (p.currentHealth<9) {
            System.out.println(
                    String.format("""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s       |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount));

        }
        if (p.currentHealth <=99&&p.currentHealth>9&&g.currentHealth<10) {
            System.out.println(
                    String.format("""
                                       |%s  |%s |%s
                            |%s    |%s       |%s           |
                            |%s     |%s      |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount));

        }
        if (p.currentHealth<9&&g.currentHealth<10) {
            System.out.println(
                    String.format("""
                                       |%s  |%s |%s
                            |%s    |%s       |%s           |
                            |%s     |%s       |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount));

        }

    }
    public String Combat (Humans h, Goblins g, int turns)
    {
        if((h.place[0]+1==g.place[0]&&h.place[1]==g.place[1])||
                (h.place[0]-1==g.place[0]&&h.place[1]==g.place[1])||
                (h.place[0]==g.place[0]&&h.place[1]+1==g.place[1])||
                (h.place[0]==g.place[0]&&h.place[1]-1==g.place[1])
        )
        {
            if (turns%2==0) {
                h.combat(g);
            }
            else
            {
                g.combat(h);
            }
        }
        if(g.currentHealth<=0)
        {
            return "win";
        }
        else if (h.currentHealth<=0)
        {
            return "lost";
        }
        else if(h.currentHealth!=h.maxHealth&&g.currentHealth!=g.maxHealth)
        {
        return "Not Over";
        }
        else{return "";}
    }
}

