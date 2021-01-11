package by.epam.training.jwd.task03.service.parser;

import by.epam.training.jwd.task03.entity.Attribute;
import by.epam.training.jwd.task03.entity.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NodeParserTest {
    NodeParser parser = new NodeParser();

    @Test
    public void parse_withoutAttrs_rootNode() {
        ArrayList<String> data = new ArrayList<>();
        data.add("<note>");
        data.add("<to>Tove</to>");
        data.add("<text>");
        data.add("<heading>Reminder</heading>");
        data.add("<body>Don't forget me this weekend!</body>");
        data.add("</text>");
        data.add("</note>");
        Node expected = Node.newBuilder().build();
        expected.setName("note");
        ArrayList<Node> childrenForNote = new ArrayList<>();
        Node ch1 = Node.newBuilder().withName("to").withContent("Tove").build();
        Node ch2 = Node.newBuilder().withName("text").build();
        childrenForNote.add(ch1);
        childrenForNote.add(ch2);
        ArrayList<Node> childrenForText = new ArrayList<>();
        Node ch3 = Node.newBuilder().withName("heading").withContent("Reminder").build();
        Node ch4 = Node.newBuilder().withName("body").withContent("Don't forget me this weekend!").build();
        childrenForText.add(ch3);
        childrenForText.add(ch4);
        ch2.setChildNodes(childrenForText);
        expected.setChildNodes(childrenForNote);

        Node actual = parser.parse(data);

        assertEquals(expected, actual);

    }

    @Test
    public void parse_withAttributes_rootNode() {
        ArrayList<String> data = new ArrayList<>();
        data.add("<note>");
        data.add("<to>Tove</to>");
        data.add("<text a = \"2\" b = \"!\">");
        data.add("<heading lvl = \"1\">Reminder</heading>");
        data.add("<body>Don't forget me this weekend!</body>");
        data.add("</text>");
        data.add("</note>");
        Node expected = Node.newBuilder().build();
        expected.setName("note");
        ArrayList<Node> childrenForNote = new ArrayList<>();
        Node ch1 = Node.newBuilder().withName("to").withContent("Tove").build();
        Node ch2 = Node.newBuilder().withName("text").build();
        List<Attribute> attributes2 = new ArrayList<>();
        attributes2.add(new Attribute("a", "2"));
        attributes2.add(new Attribute("b", "!"));
        ch2.setAttributes(attributes2);
        childrenForNote.add(ch1);
        childrenForNote.add(ch2);
        ArrayList<Node> childrenForText = new ArrayList<>();
        Node ch3 = Node.newBuilder().withName("heading").withContent("Reminder").build();
        List<Attribute> attributes3 = new ArrayList<>();
        attributes3.add(new Attribute("lvl", "1"));
        ch3.setAttributes(attributes3);
        Node ch4 = Node.newBuilder().withName("body").withContent("Don't forget me this weekend!").build();
        childrenForText.add(ch3);
        childrenForText.add(ch4);
        ch2.setChildNodes(childrenForText);
        expected.setChildNodes(childrenForNote);

        Node actual = parser.parse(data);

        assertEquals(expected, actual);

    }
}