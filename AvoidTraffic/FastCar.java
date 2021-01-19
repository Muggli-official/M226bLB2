import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a car travelling faster than the player
 * 
 * @author MUGM
 * @version 0.1
 */
public class FastCar extends Actor
{
    /**
     * Act - do whatever the FastCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()-1);
        
        if(getY() < -40) 
        {
            //
            Street street = (Street)getWorld();
            street.addScore();
            
            
            getWorld().removeObject(this);
        }
    }    
}
