package mathematic;

import Logger.FileLogger;
import Logger.FileLoggerConfig;
import app.Multiplication;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultiTest {
    private static Multiplication multiplication;
    private static FileLogger fileLogger;

    @BeforeClass
    public static void createNew() {
        multiplication = new Multiplication();
        fileLogger = new FileLogger(new FileLoggerConfig());
    }

    private void informationMod(int actual, int expected, String nameMethod) {

        fileLogger.info(getClass().getSimpleName() + " " + nameMethod + " - "
                + " Expected: -> " + expected + "; Actual: ->" + actual);
    }

    @Test
    public void shouldMultiplicationOperation() {
        int actual = multiplication.mult(10, 5);
        int expected = 50;
        String nameMethod = new Object() {
        }.getClass().getEnclosingMethod().getName();
        Assert.assertEquals(expected, actual);
        informationMod(actual, expected, nameMethod);
    }

    @Test
    public void shouldMultiplicationNegativeNumber() {
        int actual = multiplication.mult(-3, -7);
        int expected = 21;
        String nameMethod = new Object() {
        }.getClass().getEnclosingMethod().getName();
        Assert.assertEquals(expected, actual);
        informationMod(actual, expected, nameMethod);
    }
}
