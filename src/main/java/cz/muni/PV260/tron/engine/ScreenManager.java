package cz.muni.PV260.tron.engine;

import cz.muni.PV260.tron.model.Position;

import javax.swing.*;
import java.awt.*;

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
    private final GraphicsDevice graphicsDevice;
    private Window window;

    public ScreenManager() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
    }

    private DisplayMode findFirstCompatibleMode() {

        DisplayMode[] supportedModes = graphicsDevice.getDisplayModes();
        for (int allowedModeIndex = 0; allowedModeIndex < ScreenManager.modes.length; allowedModeIndex++) {
            for (DisplayMode supportedMode : supportedModes) {
                if (displayModesMatch(ScreenManager.modes[allowedModeIndex], supportedMode)) {
                    return ScreenManager.modes[allowedModeIndex];
                }
            }
        }
        return null;
    }

    private boolean displayModesMatch(DisplayMode displayMode1, DisplayMode displayMode2) {
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

    private void setFullScreen(DisplayMode displayMode) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        graphicsDevice.setFullScreenWindow(frame);
        graphicsDevice.setDisplayMode(displayMode);

        if (displayMode != null && graphicsDevice.isDisplayChangeSupported()) {
            graphicsDevice.setDisplayMode(displayMode);
            frame.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        return (Graphics2D) window.getBufferStrategy().getDrawGraphics();
    }

    void update() {
        getGraphics().dispose();
        window.getBufferStrategy().show();
    }

    public Window getFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow();
    }

    void restoreScreen() {
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
        DisplayMode displayMode = findFirstCompatibleMode();
        setFullScreen(displayMode);
        window = getFullScreenWindow();
    }
}
