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
    private int ammo;
    private int reloadInterval;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Street()
    {    
        // Create a new world with 600x800 cells with a cell size of 1x1 pixels.
        super(600, 800, 1, false);
        
        prepare();
        //force player and other cars to the front
        setPaintOrder(MyCar.class, SlowCar.class, FastCar.class, Bullet.class ,Upgrade.class);
        
        distancer = 0;
        medianInterval = 0;
        
        score = 0;
        health = 100;
        ammo = 57;
        reloadInterval = 0;
        
        showStats();
        
    }
    
    /**
     * spawn stuff (to be defined) in random intervals
     */
    public void act()
    {
        
        int spawnfreq = Greenfoot.getRandomNumber(199);
        
        if(spawnfreq < 10 && distancer == 0)
        {
            if(spawnfreq == 0)
            {fastCarSpawner();}
            else
            {slowCarSpawner();}
            
            distancer = 100;
        }
        else
        {
            if(distancer != 0) distancer--;
        }
        
        medianSpawner();
        
        liningSpawner();
        
        if(reloadInterval != 0) reloadInterval--;
    }
    
    /**
     * 
     */
    private void slowCarSpawner()
    {
        int lane = 0;
        
        switch(Greenfoot.getRandomNumber(4)){
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
        
        addObject(new SlowCar(), lane, -40);
    }
    
    /**
     * 
     */
    private void fastCarSpawner()
    {
        int lane = 0;
        
        switch(Greenfoot.getRandomNumber(3)){
            case 0:
                lane = 200;
                break;
            case 1:
                lane = 300;
                break;
            case 2:
                lane = 400;
                break;
        }
        
        addObject(new FastCar(), lane, 840);
    }
    
    /**
     * 
     */
    private void medianSpawner()
    {
        if (medianInterval == 50)
        {
            addObject(new Median(), 200, -20);
            addObject(new Median(), 300, -20);
            addObject(new Median(), 400, -20);
                        
            medianInterval = 0;
        }
        medianInterval ++;
    }
    
    /**
     * 
     */
    private void liningSpawner()
    {
        if(Greenfoot.getRandomNumber(99) == 0)
        {
            addObject(new Lining(), Greenfoot.getRandomNumber(74), -20);
        }
        if(Greenfoot.getRandomNumber(99) == 0)
        {
            addObject(new Lining(), Greenfoot.getRandomNumber(74)+525, -20);
        }
    }
    
    private void upgradeSpawner()
    {
        boolean side = Greenfoot.getRandomNumber(100)<50;
        boolean type = Greenfoot.getRandomNumber(100)<50;
        
        if(side)
        {
            addObject(new Upgrade(type), 150, -20);
        }
        else
        {
            addObject(new Upgrade(type), 450, -20);
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
        
        if (score%3 == 0)
        {
            upgradeSpawner();
        }
    }
    
    /**
     * add health
     */
    public void addHealth(int points)
    {
        health = health + points;
        showStats();
        
        if (health < 1)
        {
            //Greenfoot.playSound("game-over.wav");
            showEndMessage();
            
            Greenfoot.stop();
        }
    }
    
    /**
     * add ammo
     */
    public void addAmmo(int bullets)
    {
        ammo = ammo + bullets;
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
        showText("Ammo:", 50, 100);
        showText("" + ammo, 50, 120);
        
    }
    
    /**
     * shows end message
     */
    private void showEndMessage()
    {
        showText("GAME OVER", 300, 400);
        
        showText("Overtaken:", 300, 450);
        showText("" + score, 300, 500);
    }
    
    /**
     * fire
     */
    public void bulletSpawner(int x, int y)
    {
        if(ammo > 0 && reloadInterval == 0)
        {
        
        addObject(new Bullet(), x, y);
        
        ammo--;
        showStats();
        reloadInterval = 50;
        }
    }
    
}
