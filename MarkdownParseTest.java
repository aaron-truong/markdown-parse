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
    public void testGetLinks() throws IOException {
        String contents = Files.readString(Path.of("/Users/Aaron/Documents/Github/markdown-parse/breaking-test-file.md"));
        assertEquals(List.of("https://something.com"), MarkdownParse.getLinks(contents));

    }
}