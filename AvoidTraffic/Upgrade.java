import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a object which can be picked up be the player to gain health
 * 
 * @author MUGM
 * @version 0.1
 */
public class Upgrade extends Actor
{
    private boolean type;
    
    /**
     * Custom Constructor
     */
    public Upgrade(boolean state)
    {
        
        if(state)
        {
            setImage(new GreenfootImage("ammo.png"));
            type = true;
        }
        else
        {
        type = false;
        }
    }
    
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
        else
        {
        checkPickUp();
        }
    }
    
    private void checkPickUp()
    {
        if (isTouching(MyCar.class))
        {
            Street street = (Street)getWorld();
            
            getWorld().removeObject(this);
            if(type)
            {
            street.addAmmo(50);
            }
            else
            {
            street.addHealth(50);
            }
        }
    }
    
    
    
}
