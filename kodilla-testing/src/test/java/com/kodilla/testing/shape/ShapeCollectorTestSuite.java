package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("Tests ShapeCollector")
public class ShapeCollectorTestSuite {
    @DisplayName("Test add figure")
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

    @DisplayName("Test remove figure")
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

    @DisplayName("Test remove figure when empty collection")
    @Test
    void testRemoveFigureWhenEmptyCollection() {
        // Given
        Shape shape = new Circle(4);
        ShapeCollector shapeCollector = new ShapeCollector();

        // When
        boolean result = shapeCollector.removeFigure(shape);


        // Then
        Assertions.assertFalse(result);
    }

    @DisplayName("Test get figure")
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

    @DisplayName("Test get figure, when index is higher than size collection")
    @Test
    void testGetFigureWhenIndexIsHigherThanSizeCollection() {
        // Given
        Shape shape = new Circle(3);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(shape);

        // When
        Shape testShape = shapeCollector.getFigure(5);

        // Then
        Assertions.assertNull(testShape);
    }

    @DisplayName("Test show figures")
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
