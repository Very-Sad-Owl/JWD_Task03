package by.epam.training.jwd.task03.parser;

import by.epam.training.jwd.task03.entity.Attribute;
import by.epam.training.jwd.task03.entity.Node;

import java.util.List;

public class NodeFactory {

    public Node createNode(String name) {
        Node node = new Node();
        node.setName(name);
        return node;
    }

    public Node createNode(String name, String content) {
        Node node = new Node();
        node.setName(name);
        node.setContent(content);
        return node;
    }

    public Node createNode(String name, String content, List<Attribute> attributes) {
        Node node = new Node();
        node.setName(name);
        node.setContent(content);
        node.setAttributes(attributes);
        return node;
    }
}
