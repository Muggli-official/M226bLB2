import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines the player car
 * 
 * @author MUGM
 * @version 0.3
 */
public class MyCar extends Actor
{
    /**
     * every frame, check presses, check environment
     */
    public void act(){
        checkKeyPress(); //call checkKeyPress
        checkCollision(); //call checkCollision
    }
    /**
     * check if a key is pressed and act/move accordingly
     */
    private void checkKeyPress(){
        int x = getX(); //get current X coordinate
        int y = getY(); //get current Y coordinate
        
        //check key presses, if movement possible, adjust coordinate
        if(Greenfoot.isKeyDown("a") && canMoveLeft()) x--;
        if(Greenfoot.isKeyDown("d") && canMoveRight()) x++;
        if(Greenfoot.isKeyDown("w") && canMoveUp()) y--;
        if(Greenfoot.isKeyDown("s") && canMoveDown()) y++;
        if(Greenfoot.isKeyDown("space")) trigger(); //call trigger
        
        setLocation(x, y); //update location with coordinates
    }
    /**
     * check if left road edge is reached, return
     * @return moveLeft boolean used to answer if move would be possible
     */
    private boolean canMoveLeft(){
        boolean moveLeft=true; //initialize return boolean
        int x = getX(); //get current X coordinate
        
        if(x<125)moveLeft=false; //if to far left, false
        
        return moveLeft; //return boolean
    }
    /**
     * check if right road edge is reached, return
     * @return moveRight boolean used to answer if move would be possible
     */
    private boolean canMoveRight(){
        boolean moveRight=true; //initialize return boolean
        int x=getX(); //get current X coordinate
        
        if(x>475)moveRight=false; //if to far right, false
        
        return moveRight; //return boolean
    }
    /**
     * check if top road edge is reached, return
     * @return moveUp boolean used to answer if move would be possible
     */
    private boolean canMoveUp(){
        boolean moveUp=true; //initialize return boolean
        int y=getY(); //get current Y coordinate
        
        if(y<0)moveUp=false; //if to far up, false
        
        return moveUp; //return boolean
    }
    /**
     * check if bottom road edge is reached, return
     * @return moveDown boolean used to answer if move would be possible
     */
    private boolean canMoveDown(){
        boolean moveDown=true; //initialize return boolean
        int y=getY(); //get current Y coordinate
        
        if(y>800)moveDown=false; //if to far down, false
        
        return moveDown; //return boolean
    }
    /**
     * check if in contact with instance of SlowCar or FastCar
     */
    private void checkCollision(){
        Street street = (Street)getWorld(); //create instance of Street
        //check back right, back left, front right, front left
        if (getOneObjectAtOffset(20, 50, SlowCar.class) != null || 
            getOneObjectAtOffset(-20, 50, SlowCar.class) != null||
            getOneObjectAtOffset(20, -50, SlowCar.class) != null || 
            getOneObjectAtOffset(-20, -50, SlowCar.class) != null){
            removeTouching(SlowCar.class); //remove touching SlowCar
            street.addHealth(-50);} //call addHealth to update health count
        //check back right, back left, front right, front left
        if (getOneObjectAtOffset(20, 50, FastCar.class) != null || 
            getOneObjectAtOffset(-20, 50, FastCar.class) != null||
            getOneObjectAtOffset(20, -50, FastCar.class) != null || 
            getOneObjectAtOffset(-20, -50, FastCar.class) != null){
            removeTouching(FastCar.class); //remove touching FastCar
            street.addHealth(-50);} //call addHealth to update health count
    }
    /**
     * call bulletspawner from Street with current location
     */
    private void trigger(){
        Street street = (Street)getWorld(); //get instance of Street
        street.bulletSpawner(getX(), getY());} //call bulletSpawner with current location
}
