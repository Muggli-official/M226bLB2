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
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-2);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+2);
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-4, getY());
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+4, getY());
        }
    }
    
    
    
    
    
    
}
