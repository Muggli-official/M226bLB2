import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a car travelling slower than the player
 * 
 * @author MUGM
 * @version 0.3
 */
public class SlowCar extends Actor
{
    /**
     * every frame, move, check position
     */
    public void act(){
        setLocation(getX(), getY()+2); //move backwards
        
        if(getY() > 840){ //if bottom OOB
            Street street = (Street)getWorld(); //get instance of Street
            street.addScore(); //call addScore to count as overtake
            getWorld().removeObject(this);} //remove itself
    }    
}
