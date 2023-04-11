package mathematic;

import Logger.FileLogger;
import Logger.FileLoggerConfig;
import app.Subtraction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubtractionTest {
    private static Subtraction subtraction;
    private static FileLogger fileLogger;


    @BeforeClass
    public static void createNew() {
        subtraction = new Subtraction();
        fileLogger = new FileLogger(new FileLoggerConfig());
    }

    private void informationMod(int actual, int expected, String nameMethod) {

        fileLogger.info(getClass().getSimpleName() + " " + nameMethod + " - "
                + " Expected: -> " + expected + "; Actual: ->" + actual);
    }

    @Test
    public void shouldSubtract() {
        int actual = subtraction.sub(6, 4);
        int expected = 2;
        String nameMethod = new Object() {
        }.getClass().getEnclosingMethod().getName();
        Assert.assertEquals(expected, actual);
        informationMod(actual, expected, nameMethod);
    }

    @Test
    public void shouldSubtractNegativeNumber() {
        int actual = subtraction.sub(-2, -6);
        int expected = 4;
        String nameMethod = new Object() {
        }.getClass().getEnclosingMethod().getName();
        Assert.assertEquals(expected, actual);
        informationMod(actual, expected, nameMethod);
    }
}
