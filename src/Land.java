import java.util.ArrayList;
import java.util.Scanner;

public class Land  {
    String [][] table=new String [7][7];
    int num=0;
    String [] inventory={"1","2","3","4","5","6"};
    int inventoryIndex=-1;
    String Inserts;
    String loot="\uD83D\uDCB0"+"|";
    String lootItem;
    int[]lootPlace=new int[2];
Scanner in = new Scanner(System.in);
    ArrayList fill= new ArrayList();

    public String[][] createGrid(Humans player1, Goblins enemy)
    {

        if(num==0){
            lootPlace[0]=-1;
            lootPlace[1]=-1;

            for(int x= 0; x<7;x++)
            {

                for(int y=0;y<7;y++)
                {
                    if(x==0&&y==0)
                    {
                        table[x][y]=" "+player1.pawn1 +"|";

                        player1.place[0]=0;
                        player1.place[1]=0;
                    }
                    else if(x==6&&y==6)
                    {
                        table[x][y]=enemy.enemy1+"|";

                        enemy.place[0]=6;
                        enemy.place[1]=6;
                    }
                    else{
                        table[x][y]="  "+"|";

                    }
                }

            }
            num++;
        }
        else {
            for (int x = 0; x < 7; x++) {

                for (int y = 0; y < 7; y++) {

                    if (player1.place[0] == x && player1.place[1] == y) {
                        table[x][y] = " " + player1.pawn1 + "|";
                    } else if (enemy.place[0] == x && enemy.place[1] == y) {
                        table[x][y] = "" + enemy.enemy1 + "|";
                    } else if (lootPlace[0] == x && lootPlace[1] == y && player1.itemE) {
                        table[x][y] = loot + "";

                    } else if (lootPlace[0] == player1.place[0] && lootPlace[1] == player1.place[1]&&player1.itemE) {

                        player1.itemE = false;
                        inventoryIndex++;
                        if(!lootItem.equals("")){
                        System.out.println("Do you want this "+lootItem+"? Y or N");
                        if (in.next().toUpperCase().equals("Y")) {
                            System.out.println("Item added: " + lootItem);
                            player1.addItem(lootItem);
                            switch (lootItem) {
                                case "Sword of the Storm":
                                    inventory[inventoryIndex] = "SS";
                                    break;
                                case "Shield":
                                    inventory[inventoryIndex] = "SHH";
                                    break;
                                case "Armor of God":
                                    inventory[inventoryIndex] = "AOG";
                                    break;
                                case "AR-15":
                                    inventory[inventoryIndex] = "AR";
                                    break;
                                case "Captain America Shield":
                                    inventory[inventoryIndex] = "CAS";
                                    break;
                                case "Axe":
                                    inventory[inventoryIndex] = "AXE";
                                    break;
                                case "Bow and Arrow":
                                    inventory[inventoryIndex] = "BA";
                                    break;
                                case "Brass Knuckles":
                                    inventory[inventoryIndex] = "BK";
                                    break;


                            }
                        }

                            lootPlace[0] = -1;
                            lootPlace[1] = -1;

                        }
                    }
                    else {
                            table[x][y] = "_" + "_" + "|";
                        }

                    }

                }
            }



        return table;}
    public void printGrid(String[][] table1,Humans p,Goblins g) {
        table = table1;
        for (int x = 0; x < 7; x++) {

            for (int y = 0; y < 7; y++) {
                System.out.print("\033[4m"+table[x][y] +"\033[0m");
            }
            System.out.println("");
        }
        System.out.println("");
        if (p.currentHealth >= 100) {
            System.out.println("\033[4m"+String.format("""
            Inventory         Storage
            |%s |%s |%s |%s |%s |%s |\033[0m
            Directions
            W   North
            A   West
            S   South
            D   East
            """,inventory[0].equals("1")?" ":inventory[0],
                inventory[1].equals("2")?" ":inventory[1],
                inventory[2].equals("3")?" ":inventory[2],
                inventory[3].equals("4")?" ":inventory[3],
                inventory[4].equals("5")?" ":inventory[4],
                inventory[5].equals("6")?" ":inventory[5]
                    ));

            System.out.println(
                    String.format("\033[4m"+"""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s     |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount+"\033[0m"));

        }
        if (p.currentHealth <=99&&p.currentHealth>9) {
            System.out.println("\033[4m"+String.format("""
            Inventory         Storage
            |%s |%s |%s |%s |%s |%s |\033[0m
            Directions
            W   North
            A   West
            S   South
            D   East
            """,inventory[0].equals("1")?" ":inventory[0],
                    inventory[1].equals("2")?" ":inventory[1],
                    inventory[2].equals("3")?" ":inventory[2],
                    inventory[3].equals("4")?" ":inventory[3],
                    inventory[4].equals("5")?" ":inventory[4],
                    inventory[5].equals("6")?" ":inventory[5]
            ));
            System.out.println(
                    String.format("\033[4m"+"""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s     |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount+"\033[0m"));

        }
        if (p.currentHealth<9) {
            System.out.println("\033[4m"+String.format("""
            Inventory         Storage
            |%s |%s |%s |%s |%s |%s |\033[0m
            Directions
            W   North
            A   West
            S   South
            D   East
            """,inventory[0].equals("1")?" ":inventory[0],
                    inventory[1].equals("2")?" ":inventory[1],
                    inventory[2].equals("3")?" ":inventory[2],
                    inventory[3].equals("4")?" ":inventory[3],
                    inventory[4].equals("5")?" ":inventory[4],
                    inventory[5].equals("6")?" ":inventory[5]
            ));
            System.out.println(
                    String.format("\033[4m"+"""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s     |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount+"\033[0m"));

        }
        if (p.currentHealth <=99&&p.currentHealth>9&&g.currentHealth<10) {
            System.out.println("\033[4m"+String.format("""
            Inventory         Storage
            |%s |%s |%s |%s |%s |%s |\033[0m
            Directions
            W   North
            A   West
            S   South
            D   East
            """,inventory[0].equals("1")?" ":inventory[0],
                    inventory[1].equals("2")?" ":inventory[1],
                    inventory[2].equals("3")?" ":inventory[2],
                    inventory[3].equals("4")?" ":inventory[3],
                    inventory[4].equals("5")?" ":inventory[4],
                    inventory[5].equals("6")?" ":inventory[5]
            ));
            System.out.println(
                    String.format("\033[4m"+"""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s     |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount+"\033[0m"));

        }
        if (p.currentHealth<9&&g.currentHealth<10) {
            System.out.println("\033[4m"+String.format("""
            Inventory         Storage
            |%s |%s |%s |%s |%s |%s |\033[0m
            Directions
            W   North
            A   West
            S   South
            D   East
            """,inventory[0].equals("1")?" ":inventory[0],
                    inventory[1].equals("2")?" ":inventory[1],
                    inventory[2].equals("3")?" ":inventory[2],
                    inventory[3].equals("4")?" ":inventory[3],
                    inventory[4].equals("5")?" ":inventory[4],
                    inventory[5].equals("6")?" ":inventory[5]
            ));
            System.out.println(
                    String.format("\033[4m"+"""
                                       |%s  |%s |%s
                            |%s    |%s      |%s           |
                            |%s     |%s     |%s           |%s

                            """, "Health", "Power Level", "Kill Count", "Goblin", g.currentHealth, g.power, "Human", p.currentHealth, p.power, p.killCount+"\033[0m"));

        }

    }
    public String Combat (Humans h, Goblins g, int turns)
    {
        lootItem=g.itemEQ;
        while((h.place[0]+1==g.place[0]&&h.place[1]==g.place[1])||
                (h.place[0]-1==g.place[0]&&h.place[1]==g.place[1])||
                (h.place[0]==g.place[0]&&h.place[1]+1==g.place[1])||
                (h.place[0]==g.place[0]&&h.place[1]-1==g.place[1])
        )
        {
            if (turns%2==0) {
                h.combat(g);
                if(g.currentHealth<=0)
                {
                    lootPlace[0]=g.place[0];
                    lootPlace[1]=g.place[1];
                    h.itemE=true;
printGrid(table,h,g);
                    return "win";}
            }
            else
            {
                g.combat(h);
                if(h.currentHealth<=0)
                {
                    printGrid(table,h,g);
                    return "lost";}
            }
            turns++;
        }

        return "";
    }
}

