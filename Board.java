/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import battleship.Ship.ShipSize;
import java.util.*;

/**
 *
 * @author gtanguto
 */
public  final class Board {
    int M;
    int N;
    int[][] board;
    List<Ship> ships=new ArrayList<Ship>();
    Player p;


    
    public enum Direction{Vertical,Horizontal;
    
        /**
         *
         * @param d
         * @return
         */
    /*
    public int value(Direction d)
    {
        if(d==Vertical)return 1;
        
    }*/
    
    };
    
    
    
    public final void init()
    {
        board=new int[M][N];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                board[i][j]=-1;
            }
        }
    }
    
    public void printBoard()
    {
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
    public boolean isShipThere(int X,int Y)
    {
        return board[X][Y]!=-1;
    }
    
    public int getShipIndex(int x,int y)
    {
        if(isShipThere(x,y))
        {
            return board[x][y];
        }
        return -1;
    }
    
    public void HitShipOfIndex(int x,int y)
    {
        int index=getShipIndex(x,y);
        Iterator it=ships.iterator();
        
        while(it.hasNext())
        {
            Ship temp_ship=(Ship)it.next();
            if(temp_ship.getIndex()==index)
            {
                board[x][y]=-1;
                //System.out.println(temp_ship.getLiveSize());
                temp_ship.decLiveSize();
                if(temp_ship.getLiveSize()==0)
                {
                    ships.remove(temp_ship);
                }
                break;
            }
        }
    }
    
    public Board(int[][] shipCords,ShipSize sizes[],Player p,Direction d[])
    {
        this.N = 10;
        this.M = 10;
        init();
        this.p=p;
        createShipsForP(shipCords,sizes,p,d);
    }
    
    void createShipsForP(int[][] shipCords,ShipSize sizes[],Player p,Direction d[])
    {
        for(int i=0;i<shipCords.length;i++)
        {
            if(issafeAndSet(shipCords[i][0],shipCords[i][1],sizes[i],d[i],i))
               {
                   Ship s=new Ship(this,sizes[i],p,i);
                   System.out.println(" Created Ship for "+p.getName());
                   s.setCord(shipCords[i][0],shipCords[i][1]);
                   ships.add(s);
               }
        }
        p.setShips(ships);
    }

    private boolean issafeAndSet(int shipCordX,int shipCordY,ShipSize size,Direction d,int shipindex) 
    {
        if((shipCordX>=0 && shipCordX<M ) && (shipCordY>=0 && shipCordY<N) )
         {
            int end_X=shipCordX+size.value;
            int end_Y=shipCordY+size.value;
             if((d==Direction.Vertical) && end_X<M)
                {
                     
                    for(int j=shipCordX;j<end_X;j++)
                        board[j][shipCordY]=shipindex;
                    return true;
             
                }
             else if((d==Direction.Horizontal) && end_Y<N)
             {
                 
                 for(int j=shipCordY;j<end_Y;j++)
                    board[shipCordX][j]=shipindex;
                    
                 return true;
             }
             else
             {
                 return false;
             }
    }
    return false;
}
    
}
