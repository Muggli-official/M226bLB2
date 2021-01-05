import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a shrub which acts as lining
 * 
 * @author MUGM
 * @version 0.1
 */
public class Lining extends Actor
{
    /**
     * Act - do whatever the Lining wants to do. This method is called whenever
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
