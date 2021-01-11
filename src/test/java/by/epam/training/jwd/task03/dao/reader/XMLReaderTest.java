package by.epam.training.jwd.task03.dao.reader;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import java.util.List;

public class XMLReaderTest {
    private XMLReader reader = new XMLReader();

    @Test
    public void read_existingFile_contentList() throws IOException {
        String file = "note.xml";
        reader.setFilePath(file);
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

    @Test(expected = NullPointerException.class)
    public void read_noneExistingFile_IOException() throws IOException {
        String file = "nonote.xml";
        reader.setFilePath(file);

        reader.read();
    }

}