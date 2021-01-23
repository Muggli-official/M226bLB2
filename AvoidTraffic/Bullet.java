import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()-4);
        
        if(getY() < -40) 
        {
            //
            getWorld().removeObject(this);
        }
        else
        {
            checkHit();
        }
    }   
    
    /**
     * 
     */
    private void checkHit()
    {
        if (getOneObjectAtOffset(0, 0, SlowCar.class) != null)
        {
            removeTouching(SlowCar.class);
            getWorld().removeObject(this);
        }
        else if (getOneObjectAtOffset(0, 0, FastCar.class) != null)
        {
            removeTouching(FastCar.class);
            getWorld().removeObject(this);
        }
    }
}
