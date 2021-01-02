package by.epam.training.jwd.task03.parser;

import by.epam.training.jwd.task03.entity.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NodeParserTest {
    NodeParser parser = new NodeParser();

    @Test
    public void parse() {
        ArrayList<String> data = new ArrayList<>();
        data.add("<note>");
        data.add("<to>Tove</to>");
        data.add("<text>");
        data.add("<heading>Reminder</heading>");
        data.add("<body>Don't forget me this weekend!</body>");
        data.add("</text>");
        data.add("</note>");
        Node expected = new Node();
        expected.setName("note");
        ArrayList<Node> childrenForNote = new ArrayList<>();
        Node ch1 = new Node("to", "Tove");
        Node ch2 = new Node("text");
        childrenForNote.add(ch1);
        childrenForNote.add(ch2);
        ArrayList<Node> childrenForText = new ArrayList<>();
        Node ch3 = new Node("heading", "Reminder");
        Node ch4 = new Node("body", "Don't forget me this weekend!");
        childrenForText.add(ch3);
        childrenForText.add(ch4);
        ch2.setChildNodes(childrenForText);
        expected.setChildNodes(childrenForNote);

        Node actual = parser.parse(data);

        assertEquals(expected, actual);

    }
}