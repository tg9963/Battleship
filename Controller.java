/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import battleship.Board.Direction;
import battleship.Ship.ShipSize;
import java.util.*;

/**
 *
 * @author gtanguto
 */
public class Controller {
    
    Player p1=new Player();
    Player p2=new Player();
    Player Winner;
    Board b1;
    Board b2;
    
    public void setPlayer1Details()
    {
        p1.setName("GOPI");
        int shipCords[][]=new int[4][2];
        ShipSize shipsizes[]=new ShipSize[4];
        
        Direction d[]=new Direction[4];
        
        shipCords[0][0]=1; shipsizes[0]=ShipSize.small;
        shipCords[0][1]=1;d[0]=Direction.Horizontal;
        shipCords[1][0]=5;shipsizes[1]=ShipSize.large;
        shipCords[1][1]=1;d[1]=Direction.Vertical;
        shipCords[2][0]=6;shipsizes[2]=ShipSize.medium;
        shipCords[2][1]=4;d[2]=Direction.Horizontal;
        shipCords[3][0]=8;shipsizes[3]=ShipSize.small;
        shipCords[3][1]=8;d[3]=Direction.Horizontal;
        b1=new Board(shipCords,shipsizes,p1,d);
    }
    
    public void setPlayer2Details()
    {
        p2.setName("Lachi");
        int shipCords[][]=new int[5][2];
        ShipSize shipsizes[]=new ShipSize[5];
        
        Direction d[]=new Direction[5];
        
        shipCords[0][0]=0; shipsizes[0]=ShipSize.small;
        shipCords[0][1]=0;d[0]=Direction.Vertical;
        shipCords[1][0]=7;shipsizes[1]=ShipSize.large;
        shipCords[1][1]=1;d[1]=Direction.Horizontal;
        shipCords[2][0]=6;shipsizes[2]=ShipSize.medium;
        shipCords[2][1]=1;d[2]=Direction.Horizontal;
        shipCords[3][0]=8;shipsizes[3]=ShipSize.small;
        shipCords[3][1]=3;d[3]=Direction.Horizontal;
        shipCords[4][0]=1;shipsizes[4]=ShipSize.small;
        shipCords[4][1]=2;d[4]=Direction.Horizontal;
        b2=new Board(shipCords,shipsizes,p2,d);
        
    }
    
    public Controller()
    {
        
    }

    public void startPlaying()
    {
        int chance=2;
        boolean winFlag=false;
        int hit1=0,hit2=0;
        int attempts1=0,attempts2=0;
        while(!winFlag)
        {
            if(chance%2==0) //player 1 chance
            {
                System.out.println(" Player "+p1.getName()+" chance! ");
                Random r=new Random();
               //Scanner sc=new Scanner(System.in);
                //b2.printBoard();
                 int X=r.nextInt(b1.M);
                 int Y=r.nextInt(b1.N);
                //int X=sc.nextInt(); //r.nextInt(b1.M);
                //int Y=sc.nextInt(); //r.nextInt(b1.N);
                //System.out.println("X: "+X+" Y: "+Y+" Hits "+hit1);
                //b2.printBoard();
                if(b2.isShipThere(X, Y))
                {
                    System.out.println(" Hit! ");
                    hit1++;
                    b2.HitShipOfIndex(X,Y);
                }
                else
                {
                    System.out.println(" Miss! ");
                }
                
                if(b2.ships.size()==0)
                {
                    System.out.println(" Player "+p1.getName()+" Won! Number of attempts: "+attempts1);
                    break;
                }
                attempts1++;
            }
            else //player 2 chance 
            {
                System.out.println(" Player "+p2.getName()+" chance! ");
               Random r=new Random();
                //Scanner sc=new Scanner(System.in);
               //b2.printBoard();
                 int X=r.nextInt(b1.M);
                 int Y=r.nextInt(b1.N);
                //int X=sc.nextInt(); //r.nextInt(b1.M);
                //int Y=sc.nextInt(); //r.nextInt(b1.N);
                //System.out.println("X: "+X+" Y: "+Y+" Hits "+hit2);
                 //b1.printBoard();
                if(b1.isShipThere(X, Y))
                {
                    System.out.println(" Hit! ");
                    hit2++;
                    b1.HitShipOfIndex(X,Y);
                }
                else
                {
                    System.out.println(" Miss! ");
                }
                
                if(b1.ships.size()==0)
                {
                    System.out.println(" Player "+p2.getName()+" Won! Number of attempts: "+attempts2);
                    break;
                }
                
                attempts2++;
                
            }
            chance++;
        }
        
        
    }
    
    void start()
    {
        setPlayer1Details();
        setPlayer2Details();
        startPlaying();
        
    }
    
    
}
