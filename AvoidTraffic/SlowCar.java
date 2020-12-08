import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a car travelling slower than the player
 * 
 * @author MUGM
 * @version 0.1
 */
public class SlowCar extends Actor
{
    /**
     * Act - do whatever the SlowCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()+2);
        
        if (getY() > 800) 
        {
            getWorld().removeObject(this);
        }
    }    
}
