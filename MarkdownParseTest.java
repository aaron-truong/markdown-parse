import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents=Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);

        contents = Files.readString(Path.of("./breaking-test-file.md"));
        expect = List.of("https://something.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));

        contents = Files.readString(Path.of("./breaking-test-file2.md"));
        expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));

        contents = Files.readString(Path.of("./breaking-test-file3.md"));
        expect = List.of("something.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }


}