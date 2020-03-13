public class Land  {
    String [][] table=new String [5][5];
    int num=0;


    public String[][] createGrid(Humans player1, Goblins enemy)
    {
        if(num==0){
            for(int x= 0; x<5;x++)
            {

                for(int y=0;y<5;y++)
                {
                    if(x==0&&y==0)
                    {
                        table[x][y]=" "+player1.pawn+"| ";
                        System.out.print(table[0][0]);
                        player1.place[0]=0;
                        player1.place[1]=0;
                    }
                    else if(x==4&&y==4)
                    {
                        table[x][y]=enemy.enemy1+"|";
                        System.out.print(table[4][4]);
                        enemy.place[0]=4;
                        enemy.place[1]=4;
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
            for(int x= 0; x<5;x++)
            {

                for(int y=0;y<5;y++)
                {

                    if(player1.place[0]==x&&player1.place[1]==y)
                    {
                        table[x][y] = " "+player1.pawn+"|";
                    }
                    else if(enemy.place[0]==x&&enemy.place[1]==y)
                    {
                        table[x][y] = " "+enemy.enemy1+"|";
                    }
                    else
                    {
                        table[x][y]=String.valueOf(x)+String.valueOf(y)+"|";
                    }
                }

            }
        }



        return table;}
    public void printGrid(String[][] table1)
    {
        this.table=table1;
        for(int x= 0; x<5;x++)
        {

            for(int y=0;y<5;y++)
            {
                System.out.print(table[x][y]+" ");
            }
            System.out.println("");
        }

    }
    public void Combat (Humans h, Goblins g, int turns)
    {
        if(h.place[0]+1==g.place[0]||h.place[1]+1==g.place[1]||h.place[0]-1==g.place[0]||h.place[1]-1==g.place[1])
        {
            if (turns%2==0) {
                h.combat(g);
            }
            else
            {
                g.combat(h);
            }
        }
    }
}

