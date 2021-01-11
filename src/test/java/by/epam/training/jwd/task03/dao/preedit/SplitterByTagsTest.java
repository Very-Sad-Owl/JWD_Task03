package by.epam.training.jwd.task03.dao.preedit;

import by.epam.training.jwd.task03.dao.impl.SplitterByTags;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SplitterByTagsTest {

    @Test
    public void split_validXml_ListOfTags() {
        List<String> arg = new ArrayList<>();
        arg.add("<note>");
        arg.add("<to>Tove</to>");
        arg.add("<from>Jani</from> <heading>Reminder</heading>");
        arg.add("<body>Don't forget me this weekend!</body></note>");
        List<String> expected = new ArrayList<>();
        expected.add("<note>");
        expected.add("<to>Tove</to>");
        expected.add("<from>Jani</from>");
        expected.add("<heading>Reminder</heading>");
        expected.add("<body>Don't forget me this weekend!</body>");
        expected.add("</note>");

        SplitterByTags validator = new SplitterByTags();
        List<String> actual = validator.split(arg);

        assertEquals(expected, actual);
    }
}