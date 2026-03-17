package collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }
    @DisplayName("When given empty list then return empty list")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(emptyList);
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("When given odd and even numbers then return even numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        List<Integer> normalList = new ArrayList<>();
        normalList.add(5);
        normalList.add(4);
        normalList.add(3);
        normalList.add(2);
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(normalList);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(4, result.get(0));
        Assertions.assertEquals(2, result.get(1));



    }
}
