package cz.muni.PV260.tron;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ScreenManager {

    private static final DisplayMode[] modes =
            {
                    new DisplayMode(1920, 1080, 32, 0),
                    new DisplayMode(1680, 1050, 32, 0),
                    new DisplayMode(1280, 1024, 32, 0),
                    new DisplayMode(800, 600, 32, 0),
                    new DisplayMode(800, 600, 24, 0),
                    new DisplayMode(800, 600, 16, 0),
                    new DisplayMode(640, 480, 32, 0),
                    new DisplayMode(640, 480, 24, 0),
                    new DisplayMode(640, 480, 16, 0),
            };
    private GraphicsDevice graphicsDevice;
    private Window window;

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
        if (displayMode1.getWidth() != displayMode2.getWidth()
                || displayMode1.getHeight() != displayMode2.getHeight()) {
            return false;
        }
        if (displayMode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI
                && displayMode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI
                && displayMode1.getBitDepth() != displayMode2.getBitDepth()) {
            return false;
        }
        return displayMode1.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN
                || displayMode2.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN
                || displayMode1.getRefreshRate() == displayMode2.getRefreshRate();
    }

    public void setFullScreen(DisplayMode displayMode) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        graphicsDevice.setFullScreenWindow(frame);
        graphicsDevice.setDisplayMode(displayMode);

        if (displayMode != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(displayMode);
            } catch (Exception ex) {
            }
            frame.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        return (Graphics2D) window.getBufferStrategy().getDrawGraphics();
    }

    public void update() {
        window.getBufferStrategy().show();
    }

    public Window getFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow();
    }

    public void restoreScreen() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            window.dispose();
        }
        graphicsDevice.setFullScreenWindow(null);
    }

    public Position getScreenSize() {

        return Position.of(window.getWidth(), window.getHeight());
    }

    void init() {
        DisplayMode displayMode = findFirstCompatibaleMode(modes);
        setFullScreen(displayMode);
        window = getFullScreenWindow();
    }
}
