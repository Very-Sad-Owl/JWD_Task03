package by.epam.training.jwd.task03.reader;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import java.util.List;

public class XMLBasicReaderTest {
    XMLReader reader = new XMLReader();

    @Test
    public void read_existingFile_contentList() throws IOException {
        String file = "note.xml";
        reader.setFILE_PATH(file);
        List<String> expected = new ArrayList<>();
        expected.add("<note>");
        expected.add("<to>Tove</to>");
        expected.add("<from>Jani</from>");
        expected.add("<heading>Reminder</heading>");
        expected.add("<body>Don't forget me this weekend!</body>");
        expected.add("</note>");

        List<String> actual = reader.read();

        assertEquals(expected, actual);
    }

    @Test(expected = IOException.class)
    public void read_nonexistingFile_IOException() throws IOException {
        String file = "nonote.xml";
        reader.setFILE_PATH(file);

        reader.read();
    }
}