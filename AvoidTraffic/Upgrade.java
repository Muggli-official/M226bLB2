import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a object which can be picked up be the player to gain health
 * 
 * @author MUGM
 * @version 0.1
 */
public class Upgrade extends Actor
{
    /**
     * Act - do whatever the Upgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()+3);
        
        if(getY() > 820) 
        {
            //
            
            getWorld().removeObject(this);
        }
    }    
}
