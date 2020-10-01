import static org.apache.commons.io.FileUtils.contentEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AdapterFirstProjectTest {
    private static final String TARGET_TEST_RESOURCES_PATH = "target/test-classes/";

    @Test(description = "")
    public void adapterTest() throws IOException {
        String targetOutputFilePath = TARGET_TEST_RESOURCES_PATH + "output.txt";
        Adapter.main(
                new String[]{
                        "-i",  TARGET_TEST_RESOURCES_PATH + "input.txt",
                        "-o", targetOutputFilePath
                });
         Assert.assertTrue(contentEquals(
                 new File(targetOutputFilePath),
                 new File(TARGET_TEST_RESOURCES_PATH + "expected.txt")
         ));
    }
}
