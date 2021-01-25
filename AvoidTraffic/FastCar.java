import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a car travelling faster than the player
 * 
 * @author MUGM
 * @version 0.3
 */
public class FastCar extends Actor
{
    /**
     * every frame, move, check position
     */
    public void act(){
        setLocation(getX(), getY()-1); //move forward
        
        if(getY() < -40){ //if top OOB
            Street street = (Street)getWorld(); //get instance of Street
            street.addScore(); //call addScore to count as overtake
            getWorld().removeObject(this);} //remove itself
    }    
}
