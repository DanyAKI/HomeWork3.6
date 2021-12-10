import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestLesson6ArrayContainsNumbers {

    private static Main.Lesson6HW hwTest;
    private final int[] arr;
    private final Boolean expectedResult;
    private static final int num1 = 1;
    private static final int num2 = 4;
    private static int testCounter = 0;

    public TestLesson6ArrayContainsNumbers(Boolean expectedResult, int[] arr) {
        this.expectedResult = expectedResult;
        this.arr = arr;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, new int[]{1, 4, 4, 4, 1, 1, 4, 1, 1}},
                {true, new int[]{1, 4, 1, 4}},
                {true, new int[]{1, 4}},
                {false, new int[]{}},
                {false, new int[]{1}},
                {false, new int[]{4}},
                {false, new int[]{2, 3, 5}},
                {false, new int[]{1, 2, 3, 4, 5}},
                {false, new int[]{1, 1, 1, 1, 4, 4, 4, 4, 0}}
        });
    }

    @BeforeClass
    public static void init() {
        hwTest = new Main.Lesson6HW();
    }

    @Test
    public void testIsArrayContainsNumbers() {
        System.out.println("Тест " + testCounter);
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        Assert.assertEquals(expectedResult, hwTest.isArrayContainsNumbers(arr, num1, num2));
        System.out.println("Результат: " + hwTest.isArrayContainsNumbers(arr, num1, num2));
        testCounter++;
    }
}
