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
    private int medianInterval;
    
    private int score;
    private int health;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Street()
    {    
        // Create a new world with 400x800 cells with a cell size of 1x1 pixels.
        super(600, 800, 1, false);
        
        prepare();
        //force player car to the front
        setPaintOrder(MyCar.class);
        
        distancer = 0;
        medianInterval = 0;
        
        score = 0;
        health = 100;
        
        showStats();
        
    }
    
    /**
     * spawn stuff (to be defined) in random intervals
     */
    public void act()
    {
        
        //SlowCar spawner
        int spawnfreq = Greenfoot.getRandomNumber(99);
        int lane = 0;
        medianInterval ++;
        
        if(spawnfreq < 4 && distancer == 0)
        {
            switch (spawnfreq) {
                case 0:
                    lane=150;
                    break;
                case 1:
                    lane=250;
                    break;
                case 2:
                    lane=350;
                    break;
                case 3:
                    lane=450;
                    break;
            }
                    
            addObject(new SlowCar(), lane, -20);
            distancer = 50;
            
        }
        else
        {
            if(distancer != 0) distancer--;
        }
        
        //Median spawner
        if (medianInterval == 50)
        {
            addObject(new Median(), 200, -20);
            addObject(new Median(), 300, -20);
            addObject(new Median(), 400, -20);
                        
            medianInterval = 0;
        }
        
        //Lining spawner
        if(Greenfoot.getRandomNumber(99) == 0)
        {
            addObject(new Lining(), Greenfoot.getRandomNumber(74), -20);
        }
        if(Greenfoot.getRandomNumber(99) == 0)
        {
            addObject(new Lining(), Greenfoot.getRandomNumber(74)+525, -20);
        }
    }
    
    /**
     * spawn everything needed to start
     */
    private void prepare()
    {
        
        
        addObject(new MyCar(), 300, 400);
        
        
    }
    
    /**
     * add score
     */
    public void addScore()
    {
        score++;
        showStats();
    }
    
    /**
     * display stats
     */
    private void showStats()
    {
        showText("Overtaken:", 50, 20);
        showText("" + score, 50, 40);
        showText("Health:", 50, 60);
        showText("" + health, 50, 80);
    }
    
    
    
    //probably a few more functions needed to display things like score, health
    
    /**
     * shows end message
     */
    private void showEndMessage()
    {
        showText("GAME OVER", 200, 400);
    
    }
    
        
    
}
