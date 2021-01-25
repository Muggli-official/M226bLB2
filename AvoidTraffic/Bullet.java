import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a bullet  which can be fired by the player
 * 
 * @author MUGM
 * @version 0.3
 */
public class Bullet extends Actor
{
    /**
     * every frame, move, check position and environment
     */
    public void act(){
        setLocation(getX(), getY()-4); //move forward
        
        if(getY() < -40){ //if top OOB
            getWorld().removeObject(this);} //remove itself
        else{ //call checkHit
            checkHit();}
    }   
    /**
     * check if in contact with instance of SlowCar or FastCar
     */
    private void checkHit(){
        if (getOneObjectAtOffset(0, 0, SlowCar.class) != null){ //if touching SlowCar
            removeTouching(SlowCar.class); //remove touching SlowCar
            getWorld().removeObject(this);} //remove itself
        else if (getOneObjectAtOffset(0, 0, FastCar.class) != null){ //if touching FastCar
            removeTouching(FastCar.class); //remove touching FastCar
            getWorld().removeObject(this);} //remove itself
    }
}
