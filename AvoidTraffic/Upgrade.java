import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines a object which can be picked up be the player to gain health
 * 
 * @author MUGM
 * @version 0.3
 */
public class Upgrade extends Actor
{
    private boolean type;
    
    /**
     * custom constructor, change image accordingly
     * @param state boolean defines what kind of Upgrade gets constructed
     */
    public Upgrade(boolean state){
        if(state){ //if delivered state true
            setImage(new GreenfootImage("ammo.png")); //set image to ammo pickup
            type = true;} //set instance variable
        else{ //delivered state false
            type = false; //set instance variable
        }
    }
    /**
     * every frame, move, check position and environment
     */
    public void act(){
        setLocation(getX(), getY()+3); //move backwards
        
        if(getY() > 820){
            getWorld().removeObject(this);} //remove itself
        else{
            checkPickUp();} //call checkPickUp
    }
    private void checkPickUp(){
        if (isTouching(MyCar.class)){
            Street street = (Street)getWorld(); //get instance of Street
            getWorld().removeObject(this); //remove itself
            if(type){ //if type true
            street.addAmmo(50);} //call addAmmo to update ammo count
            else{ //type false
            street.addHealth(50);} //call addHealth to update health count
        }
    }
}
