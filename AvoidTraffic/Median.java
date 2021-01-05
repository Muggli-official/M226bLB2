import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a median lane marker
 * 
 * @author MUGM
 * @version 0.1
 */
public class Median extends Actor
{
    /**
     * Act - do whatever the Median wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()+3);
        
        if(getY() > 820) 
        {
            getWorld().removeObject(this);
        }
    }    
}
