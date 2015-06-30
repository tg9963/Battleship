/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author gtanguto
 */
public class Ship {
    
    public enum ShipSize
    {
        small(2),medium(3),large(4);
    public  int value;
    
    private ShipSize(int value)
    {
        this.value=value;
    }
    };
    int index;
    ShipSize SSize;
    public static int M=2,N=3,O=4;
    int live_size=0;
    boolean alive=true;
    int X=0,Y=0;
    Board b=null;
    Player p;
    
    public void setIndex(int index)
    {
        this.index=index;
    }
    
    public int getIndex()
    {
        return this.index;
    }
    
    public void setCord(int X,int Y)
    {
        this.X=X;
        this.Y=Y;
    }
    
    public int getX()
    {
        return this.X;
    }
    
    public int getY()
    {
        return this.Y;
    }
    
    Player getPlayer()
    {
        return p;
    }
    
    public Ship(Board b,ShipSize SSize,Player p,int index)
    {
        this.SSize=SSize;
        this.b=b;
        this.p=p;
        setIndex(index);
        setLiveSize(getShipSize());
        
    }
    
    public Board getBoard()
    {
        return this.b;
    }
    
    public void setLiveSize(int live_size)
    {
        this.live_size=live_size;
    }
    
    public int getLiveSize()
    {
        return this.live_size;
    }
    
    public void decLiveSize()
    {
        if(live_size>0)this.live_size=this.live_size-1;
        else
        {
            alive=false;
        }
    }
    
    public boolean isAlive()
    {
        return alive==true;
    }
    
    public int getShipSize()
    {
        if(SSize==ShipSize.small)
        {
            return M;
        }
        else if(SSize==ShipSize.medium)
        {
            return N;
        }
        else if(SSize==ShipSize.large)
        {
            return O;
        }
        else
        {
            return 0;
        }
    }
   
}
