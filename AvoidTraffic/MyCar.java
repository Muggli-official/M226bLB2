import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines the player car
 * 
 * @author MUGM
 * @version 0.1
 */
public class MyCar extends Actor
{
    /**
     * Act - do whatever the MyCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //
        
        checkKeyPress();
    }    
    
    /**
     * Check if a key is pressed and act/move accordingly
     */
    private void checkKeyPress()
    {
        int y = getY();
        int x = getX();
        //Variablen evtl. noch ändern
        if(Greenfoot.isKeyDown("a") && canMoveLeft()) x--;
        if(Greenfoot.isKeyDown("d") && canMoveRight()) x++;
        if(Greenfoot.isKeyDown("w") && canMoveUp()) y--;
        if(Greenfoot.isKeyDown("s") && canMoveDown()) y++;
        
        setLocation(x, y);
        
        /*
        //old movement system
        
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-1);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+1);
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-2, getY());
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+2, getY());
        }
        
        */
        
    }
    
    
    
    public boolean canMoveLeft()
    {
        boolean moveLeft=true;
        
        int x = getX();
        
        if(x<150)moveLeft=false;
        
        return moveLeft;
    }
    
    public boolean canMoveRight()
    {
        boolean moveRight=true;
        
        int x=getX();
        
        if(x>450)moveRight=false;
        
        return moveRight;
    }
    
    
    public boolean canMoveUp()
    {
        boolean moveUp=true;
        
        int y=getY();
        
        if(y<0)moveUp=false;
        
        return moveUp;
    }
    
    public boolean canMoveDown()
    {
        boolean moveDown=true;
        
        int y=getY();
        int worldHeight = 800; // use get method in the future
        
        if(y>worldHeight)moveDown=false;
        
        return moveDown;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
