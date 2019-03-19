package cz.muni.PV260.tron;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ScreenManager {

    private GraphicsDevice graphicsDevice;

    public ScreenManager() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
    }

    public DisplayMode findFirstCompatibaleMode(DisplayMode[] allowedDisplayModes) {

        DisplayMode[] supportedModes = graphicsDevice.getDisplayModes();
        for (int allowedModeIndex = 0; allowedModeIndex < allowedDisplayModes.length; allowedModeIndex++) {
            for (int supportedModeIndex = 0; supportedModeIndex < supportedModes.length; supportedModeIndex++) {
                if (displayModesMatch(allowedDisplayModes[allowedModeIndex], supportedModes[supportedModeIndex])) {
                    return allowedDisplayModes[allowedModeIndex];
                }
            }
        }
        return null;
    }

    public boolean displayModesMatch(DisplayMode displayMode1, DisplayMode displayMode2) {
        if (displayMode1.getWidth() != displayMode2.getWidth() || displayMode1.getHeight() != displayMode2.getHeight()) {
            return false;
        }
        if (displayMode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && displayMode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && displayMode1.getBitDepth() != displayMode2.getBitDepth()) {
            return false;
        }
        return displayMode1.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || displayMode2.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || displayMode1.getRefreshRate() == displayMode2.getRefreshRate();
    }

    public void setFullScreen(DisplayMode displayMode) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        graphicsDevice.setFullScreenWindow(frame);

        if (displayMode != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(displayMode);
            } catch (Exception ex) {
            }
            frame.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            BufferStrategy bs = window.getBufferStrategy();
            return (Graphics2D) bs.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            BufferStrategy bufferStrategy = window.getBufferStrategy();
            if (!bufferStrategy.contentsLost()) {
                bufferStrategy.show();
            }
        }
    }

    public Window getFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow();
    }

    public int getWidth() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            return window.getWidth();
        } else {
            return 0;
        }
    }

    public int getHeight() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            return window.getHeight();
        } else {
            return 0;
        }
    }

    public void restoreScreen() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            window.dispose();
        }
        graphicsDevice.setFullScreenWindow(null);
    }

    public Position getScreenSize() {
        return Position.of(getWidth(), getHeight());
    }

}
