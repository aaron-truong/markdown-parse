import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;
// javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
// java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    // @Test
    // public void testFile1() throws IOException {
    //     String contents=Files.readString(Path.of("./test-file.md"));
    //     List<String> expect = List.of("https://something.com", "some-page.html");
    //     assertEquals(MarkdownParse.getLinks(contents), expect);

    //     contents = Files.readString(Path.of("./breaking-test-file.md"));
    //     expect = List.of("https://something.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));

    //     contents = Files.readString(Path.of("./breaking-test-file2.md"));
    //     expect = List.of();
    //     assertEquals(expect, MarkdownParse.getLinks(contents));

    //     contents = Files.readString(Path.of("./breaking-test-file3.md"));
    //     expect = List.of("something.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }
    @Test
    public void testSnippet1() {
        String contents = "`[a link`](url.com)\n\n"
            + "[another link](`google.com)\n\n`"
            + "[`cod[e`](google.com)\n\n"
            + "[`code]`](ucsd.edu)";
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expected, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testSnippet2() {
        String contents = "[a [nested link](a.com)](b.com)\n\n"
            + "[a nested parenthesized url](a.com(()))\n\n"
            + "[some escaped \\[ brackets \\]](example.com)";
        List<String> expected = List.of("a.com", "a.com((", "example.com");
        assertEquals(expected, MarkdownParse.getLinks(contents));
        
    }
    @Test
    public void testSnippet3() throws IOException {
        String contents = Files.readString(Path.of("./snippet-3.md"));
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io");
        assertEquals(expected, MarkdownParse.getLinks(contents));
        
    }
}