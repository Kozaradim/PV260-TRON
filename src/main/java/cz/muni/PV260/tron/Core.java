package cz.muni.PV260.tron;

import java.awt.*;

public abstract class Core {

	private boolean running;
    protected ScreenManager screenManager;

	public void run(){
		try{
			init();
			gameLoop();
		}finally{
            screenManager.restoreScreen();
		}
	}
	
	public void init(){
        screenManager = new ScreenManager();
        screenManager.init();
		running = true;
	}

    public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;
		
		while (running){
			long timePassed = System.currentTimeMillis()-cumTime;
			cumTime+= timePassed;
			update();
            Graphics2D graphics = screenManager.getGraphics();
            draw(graphics);
            graphics.dispose();
            screenManager.update();
			
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}

	public void update() {
	}

    public abstract void draw(Graphics2D graphics);
	
}
