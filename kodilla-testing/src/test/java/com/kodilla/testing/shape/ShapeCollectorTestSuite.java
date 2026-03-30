package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests ShapeCollector")
public class ShapeCollectorTestSuite {
    @Test
    void testAddFigure() {
        // Given
        Shape shape = new Circle(10);
        ShapeCollector shapeCollector = new ShapeCollector();

        // When
        shapeCollector.addFigure(shape);

        // Then
        Assertions.assertEquals(1, shapeCollector.getSize());
    }

    @Test
    void testRemoveFigure() {
        // Given
        Shape shape = new Circle(4);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);

        // When
        shapeCollector.removeFigure(shape);

        // Then
        Assertions.assertEquals(0, shapeCollector.getSize());
    }

    @Test
    void testGetFigure() {
        // Given
        Shape shape = new Circle(3);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);

        // When
        Shape testShape = shapeCollector.getFigure(0);

        // Then
        Assertions.assertEquals(testShape, shape);
    }

    @Test
    void testShowFigures() {
        // Given
        Shape shape = new Circle(7);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);

        // When
        String result = shapeCollector.showFigures();

        // Then
        Assertions.assertEquals("Circle ", result);
    }
}
