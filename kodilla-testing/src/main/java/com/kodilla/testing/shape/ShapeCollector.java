package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (!shapes.contains(shape)) {
            return false;
        }
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n > shapes.size()) {
            return null;
        }
        return shapes.get(n);
    }

    public String showFigures() {
        StringBuilder result = new StringBuilder();

        for (Shape shape : shapes) {
            result.append(shape.getShapeName())
                    .append(" ");
        }

        return result.toString();
    }

    public int getSize() {
        return shapes.size();
    }
}
