import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawns the world and all the needed objects in it
 * 
 * @author MUGM
 * @version 0.1
 */
public class Street extends World
{

    private int distancer;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Street()
    {    
        // Create a new world with 400x800 cells with a cell size of 1x1 pixels.
        super(600, 800, 1, false);
        
        
        
        distancer = 0;
        
        prepare();
        
    }
    
    /**
     * spawn stuff (to be defined) in random intervals
     */
    public void act()
    {
        
        int test = Greenfoot.getRandomNumber(99);
        
        if(test < 4 && distancer == 0)
        {
            if(test==0) test=150;
            else if(test==1) test=250;
            else if(test==2) test=350;
            else if(test==3) test=450;
            
            addObject(new SlowCar(), test, -20);
            distancer = 50; 
        }
        else
        {
            if(distancer != 0) distancer--;
        }
        
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Lining(), Greenfoot.getRandomNumber(100), -20);
        }
        if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Lining(), Greenfoot.getRandomNumber(100)+500, -20);
        }
    }
    
    /**
     * spawn everything needed to start
     */
    private void prepare()
    {
        MyCar mycar = new MyCar();
        addObject(mycar, 300, 400);
        
        
        
        
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
