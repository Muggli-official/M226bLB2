import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a median lane marker
 * 
 * @author MUGM
 * @version 0.3
 */
public class Median extends Actor
{
    /**
     * every frame, move, check position
     */
    public void act(){
        setLocation(getX(), getY()+3); //move backwards
        
        if(getY() > 820){ //if bottom OOB
            getWorld().removeObject(this);} //remove itself
    }    
}
