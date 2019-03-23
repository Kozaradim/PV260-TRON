package cz.muni.PV260.tron.engine;

public abstract class Core {

	protected final ScreenManager screenManager;
	protected boolean running;
    protected Renderer renderer;

	protected Core(ScreenManager screenManager) {
		this.screenManager = screenManager;
	}

	public void run() {
		try{
			init();
			gameLoop();
		}finally{
            screenManager.restoreScreen();
		}
	}
	
	public void init(){
        renderer = new Renderer(screenManager.getGraphics());
		running = true;
	}

	private void gameLoop() {
		while (running){
			update();
            draw();
            screenManager.update();
			
			try{
				Thread.sleep(20);
			} catch (Exception ignored) {
			}
		}
	}

	protected abstract void update();

    public void draw() {
        renderer.renderAll();
    }
	
}
