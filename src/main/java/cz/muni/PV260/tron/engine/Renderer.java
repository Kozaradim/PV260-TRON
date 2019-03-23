package cz.muni.PV260.tron.engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
    private final Graphics2D graphics;
    private final List<Renderable> renderables = new ArrayList<>();

    public Renderer(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public void addRenderable(Renderable renderable) {
        renderables.add(renderable);
    }

    public void renderAll() {
        renderables.forEach(renderable -> renderable.render(graphics));
    }
}
