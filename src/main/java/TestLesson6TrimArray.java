import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestLesson6TrimArray {

    private static Main.Lesson6HW hwTest;
    private final int[] arrRes;
    private final int[] arrTested;
    private static int testCounter = 1;

    public TestLesson6TrimArray(int[] arrRes, int[] arrTested) {
        this.arrRes = arrRes;
        this.arrTested = arrTested;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {new int[]{}, new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4}},
                {new int[]{}, new int[]{4}},
                {new int[]{}, new int[]{1, 2, 5, 9, 2, 3, 14, 1, 7}},
                {new int[]{}, new int[]{1, 2, 4, 4, 2, 3, 4}},
                {new int[]{}, new int[]{}}
        });
    }

    @BeforeClass
    public static void init() {
        hwTest = new Main.Lesson6HW();
    }

    @Test
    public void testTrimArray() {
        int number = 4;
        System.out.println("Исходный массив: " + Arrays.toString(arrTested));
        try {
            Assert.assertArrayEquals(arrRes, hwTest.trimArrayOfNumbers(arrTested, number));
            System.out.println("Результат: " + Arrays.toString(hwTest.trimArrayOfNumbers(arrTested, number)));
            System.out.println("Тест " + testCounter + " пройден\n");
        } catch (RuntimeException e) {
            Assert.assertEquals("В массиве нет числа " + number, e.getMessage());
            System.out.println("В массиве нет числа " + number + ". Выброшено исключение RuntimeException");
            System.out.println("Тест " + testCounter + " пройден\n");
        } finally {
            testCounter++;
        }
    }

}
