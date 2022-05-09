import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    Calculator sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new Calculator();
    }

    @BeforeAll
    public static void started() {
        System.out.println("test started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void testAdd() {

        int a = 1, b = 2, expected = 3;

        int result = sut.add(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testSubstraction() {

        int a = 3, b = 2, expected = 1;

        int result = sut.substraction(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testMultiplication() {

        int a = 2, b = 3, expected = 6;

        int result = sut.multiply(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testDivide() {

        int a = 15, b = 2, expected = 7;

        int result = sut.divide(a, b);

        assertEquals(expected, result);
    }

    @Test
    public void testDivideByZero() {

        int a = 15, b = 0;

        var expected = ArithmeticException.class;

        assertThrows(expected, () -> sut.divide(a, b));
    }

    @Test
    public void testDivideByNonZero() {
        int a = 15, b = 3;

        assertDoesNotThrow(() -> sut.divide(a, b));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testAdd(int a, int b, int expected) {
        int result = sut.add(a, b);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(1, 2, 3),
                Arguments.of(3, 5, 8),
                Arguments.of(5,5,10));
    }

}
