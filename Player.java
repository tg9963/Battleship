/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.*;

/**
 *
 * @author gtanguto
 */
public  class Player {
    private String name;
    private int total_ship_count;
    int alive_count;
    boolean alive=true;
    Board b;
    List<Ship> ships=new ArrayList<Ship>();
    
    public void setBoard(Board b)
    {
        this.b=b;
    }
    
    public Board getBoard()
    {
        return b;
    }
    
    public void  setName(String name )
    {
        this.name=name;
    }
    
    String getName()
    {
        return this.name;
    }
    
    void setTotalShipCount(int count)
    {
        this.total_ship_count=count;
    }
    
    int getTotalShipCount()
    {
        return this.total_ship_count;
    }
    
    void decShipCount()
    {
        if(alive_count>0)
        {
            alive_count--;
            return;
        }
        alive=false;
    }
    
    boolean is_alive()
    {
        return alive==true;
    }
    
    void setAlive()
    {
        this.alive=true;
    }
    
    void setShips(List<Ship> ships)
    {
        this.ships=ships;
        setTotalShipCount(this.ships.size());
        setAlive();
    }
    
    List<Ship> getShips()
    {
        return this.ships;
    }
    
    
    
    
    
}
