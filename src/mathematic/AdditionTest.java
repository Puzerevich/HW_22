package mathematic;

import Logger.FileLogger;
import Logger.FileLoggerConfig;
import app.Addition;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionTest {
    private static Addition addition;
    private static FileLogger fileLogger;

    @BeforeClass
    public static void createNew() {
        addition = new Addition();
        fileLogger = new FileLogger(new FileLoggerConfig());
    }

    private void informationMod(int actual, int expected, String nameMethod) {

        fileLogger.info(getClass().getSimpleName() + " " + nameMethod + " - "
                + " Expected: -> " + expected + "; Actual: ->" + actual);
    }

    @Test
    public void shouldSumOperation() {
        int actual = addition.sum(5, 5);
        int expected = 10;
        String nameMethod = new Object() {
        }.getClass().getEnclosingMethod().getName();
        Assert.assertEquals(expected, actual);
        informationMod(actual, expected, nameMethod);
    }

    @Test
    public void shouldSumNegativeNumbers() {
        int actual = addition.sum(-3, -1);
        int expected = -4;
        String nameMethod = new Object() {
        }.getClass().getEnclosingMethod().getName();
        Assert.assertEquals(expected, actual);
        informationMod(actual, expected, nameMethod);
    }
}
