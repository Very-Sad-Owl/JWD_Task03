package by.epam.training.jwd.task03.parser;

import by.epam.training.jwd.task03.entity.Attribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static by.epam.training.jwd.task03.parser.ContentRetriever.*;

public class ContentRetrieverTest {

    @Test
    public void getTagName_someContent_content() {
        String data = "<node>content</node>";
        String expected = "node";

        String actual = getTagName(data);

        assertEquals(expected, actual);
    }

    @Test
    public void getTagContent_noContent_EmptyString(){
        String data = "notmaches";
        String expected = "content";

        String actual = getTagContent(data);

        assertEquals(expected, actual);
    }

    @Test
    public void getTagName_someName_name() {
        String data = "<node>content</node>";
        String expected = "node";

        String actual = getTagName(data);

        assertEquals(expected, actual);
    }

    @Test
    public void getTagName_noName_EmptyString() {
        String data = "node";
        String expected = "";

        String actual = getTagName(data);

        assertEquals(expected, actual);
    }

    @Test
    public void getTagName_containsWhitespace_EmptyString() {
        String data = "<node one>";
        String expected = "";

        String actual = getTagName(data);

        assertEquals(expected, actual);
    }

    @Test
    public void getTagAttrs_containsWhitespaces_someArrts(){
        String data = "<node id = \"1\" uid = \"2\">content</node>";
        ArrayList<Attribute> expected = new ArrayList<>();
        Attribute attr1 = new Attribute("id", "1");
        Attribute attr2 = new Attribute("uid", "2");
        expected.add(attr1);
        expected.add(attr2);

        List<Attribute> actual = getTagAttribute(data);

        assertEquals(expected, actual);
    }

    @Test
    public void getTagAttrs_doesntContainWhitespaces_someArrts(){
        String data = "<node id=\"1\" uid=\"2\">content</node>";
        ArrayList<Attribute> expected = new ArrayList<>();
        Attribute attr1 = new Attribute("id", "1");
        Attribute attr2 = new Attribute("uid", "2");
        expected.add(attr1);
        expected.add(attr2);

        List<Attribute> actual = getTagAttribute(data);

        assertEquals(expected, actual);
    }

    @Test
    public void getTagAttrs_noAttrs_emptyList(){
        String data = "<node>content</node>";

        List<Attribute> actual = getTagAttribute(data);

        assertTrue(actual.isEmpty());
    }
}