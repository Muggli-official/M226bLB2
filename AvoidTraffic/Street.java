import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawns the world and all needed objects in it
 * 
 * @author MUGM
 * @version 0.3
 */
public class Street extends World
{
    private int distancer; //to track frames between cars spawning
    private int medianInterval; //to track frames since last median spawning
    private int score; //to track numbers of cars passed
    private int health; //to track current health
    private int ammo; //to track current ammo count
    private int reloadInterval; //to track frames between firing
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public Street(){    
        // create a new world with 600x800 cells with a cell size of 1x1 pixels.
        super(600, 800, 1, false);
        
        //force depth order (MyCar and other cars in front of rest of world)
        setPaintOrder(MyCar.class, SlowCar.class, FastCar.class, Bullet.class ,Upgrade.class);
        
        //initialize variables
        distancer = 0;
        medianInterval = 0;
        score = 0;
        health = 100; //starting at 100
        ammo = 0;
        reloadInterval = 0;
        
        prepare(); //spawn MyCar and stats
    }
    /**
     * spawn everything needed in somewhat random intervals
     */
    public void act(){
        int spawnfreq = Greenfoot.getRandomNumber(200); //random number in 200 range
        
        //if random below 10 and distancer is at 0
        if(spawnfreq < 10 && distancer == 0){
            if(spawnfreq == 0){
                fastCarSpawner();} //chance 1/200 for FastCar
            else{
                slowCarSpawner();} //chance 9/200 for SlowCar
            
            distancer = 100;} //set distancer 100 to prevent close spawn
        else{
            if(distancer != 0) distancer--;} //if not spawning and if not 0, count down
        
        medianSpawner(); //call to spawn median lines
        
        liningSpawner(); //call to spawn lining scrubs
        
        if(reloadInterval != 0) reloadInterval--; //if not 0, count down
    }
    /**
     * spawn SlowCar in random lane
     */
    private void slowCarSpawner(){
        int lane = 0; //initialize variable
        
        //switch define lane with random number
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
                break;}

        //spawn new SlowCar in chosen lane, top OOB
        addObject(new SlowCar(), lane, -40);
    }
    /**
     * spawn FastCar between random lanes
     */
    private void fastCarSpawner(){
        int lane = 0; //initialize variable
        
        //switch define lane with random number
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
        
        //spawn new FastCar between chosen lanes, bottom OOB
        addObject(new FastCar(), lane, 840);
    }
    /**
     * spawn 3 Medians in interval
     */
    private void medianSpawner(){
        //if 50 frames passed, spawn 3 Medians, top OOB
        if (medianInterval == 50){
            addObject(new Median(), 200, -20);
            addObject(new Median(), 300, -20);
            addObject(new Median(), 400, -20);
                        
            medianInterval = 0;} //reset interval
        
        medianInterval ++; //count up
    }
    /**
     * spawn random lining
     */
    private void liningSpawner(){
        if(Greenfoot.getRandomNumber(100) == 0){ //chance 1/100 for left lining, random position, top OOB
            addObject(new Lining(), Greenfoot.getRandomNumber(74), -20);}
        if(Greenfoot.getRandomNumber(100) == 0){ //chance 1/100 for right lining, random position, top OOB
            addObject(new Lining(), Greenfoot.getRandomNumber(74)+525, -20);}
    }
    /**
     * spawn random Upgrades
     */
    private void upgradeSpawner(){
        if(Greenfoot.getRandomNumber(100)<50){ //chance 1/2 for left spawn, chance 1/2 for health or ammo, top OOB
            addObject(new Upgrade(Greenfoot.getRandomNumber(100)<50), 150, -20);}
        else{ //chance 1/2 for left spawn, chance 1/2 for health or ammo, top OOB
            addObject(new Upgrade(Greenfoot.getRandomNumber(100)<50), 450, -20);}
    }
    /**
     * fire gun
     * @param x defines X coordinate of spawn
     * @param y defines Y coordinate of spawn
     */
    public void bulletSpawner(int x, int y){
        //if has ammo and interval 0
        if(ammo > 0 && reloadInterval == 0){
        addObject(new Bullet(), x, y); //spawn Bullet at defined location from MyCar
        addAmmo(-1); //count down
        reloadInterval = 50;} //reset 
    }
    /**
     * spawn everything needed to start
     */
    private void prepare(){
        showStats(); //show stats for the first time
        addObject(new MyCar(), 300, 400); //spawn players car in center
    }
    /**
     * add to score
     */
    public void addScore(){
        score++; //count up
        showStats(); //display updated stats
        
        if (score%30 == 0){ //if score dividable by 30, spawn upgrade
            upgradeSpawner();}
    }
    /**
     * add or substract to health
     * @param points defines value to add to health
     */
    public void addHealth(int points){
        health = health + points; //update with received value
        showStats(); //display updated stats
        
        if (health < 1){ //if health drops below 1, call EndMSG
            //Greenfoot.playSound("game-over.wav");
            showEndMessage();}
    }
    /**
     * add or subtract to ammo
     * @param bullets defines value to add to ammo
     */
    public void addAmmo(int bullets){
        ammo = ammo + bullets; //update with received value
        showStats(); //display updated stats
    }
    /**
     * display stats
     */
    private void showStats(){
        //display current values of score, health, ammo to world
        showText("Overtaken:", 50, 20);
        showText("" + score, 50, 40);
        showText("Health:", 50, 60);
        showText("" + health, 50, 80);
        showText("Ammo:", 50, 100);
        showText("" + ammo, 50, 120);
    }
    /**
     * show end message
     */
    private void showEndMessage(){
        //display MSG, reached score
        showText("GAME OVER", 300, 400);
        showText("Overtaken:", 300, 450);
        showText("" + score, 300, 500);
        
        waiter(); //call waiter
    }
    /**
     * waits for input to reset
     */
    private void waiter(){
        //wait while space not pressed
        while(!Greenfoot.isKeyDown("space")){Greenfoot.delay(1);}
        
        Greenfoot.stop(); //stop game
        Greenfoot.setWorld(new Street()); //create new world from Street (reset)
    }
}
