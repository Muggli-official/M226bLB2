import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawns the world and all the needed objects in it
 * 
 * @author MUGM
 * @version 0.1
 */
public class Street extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Street()
    {    
        // Create a new world with 400x800 cells with a cell size of 1x1 pixels.
        super(400, 800, 1); 
        
        
        
        prepare();
        
    }
    
    /**
     * spawn stuff (to be defined) in random intervals
     */
    public void act()
    {
        
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new SlowCar(), Greenfoot.getRandomNumber(200)+100, 0);
        }
    }
    
    /**
     * spawn everything needed to start
     */
    private void prepare()
    {
        MyCar mycar = new MyCar();
        addObject(mycar, 200, 400);
    }
    
    
    
    //probably a few more functions needed to dispaly things like score, health
    
    
    
    /**
     * shows end message
     */
    private void showEndMessage()
    {
        showText("GAME OVER", 200, 400);
    
    }
    
        
    
}
