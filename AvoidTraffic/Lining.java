import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a shrub which acts as lining
 * 
 * @author MUGM
 * @version 0.3
 */
public class Lining extends Actor
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
