package by.epam.training.jwd.task03.service.parser;

import by.epam.training.jwd.task03.entity.Attribute;
import by.epam.training.jwd.task03.entity.Node;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task03.constant.Pattern.*;
import static by.epam.training.jwd.task03.service.parser.util.ContentRetriever.*;

public class NodeParser {

    private ArrayDeque<Node> stack = new ArrayDeque<>();

    public Node parse(List<String> data) {

        Node result = Node.newBuilder().build();
        Node node;
        Node parentNode;
        Matcher matcherBeginTag;
        Matcher matcherEndTag;
        Matcher matcherAttribute;
        Matcher matcherBeginAttribute;

        for (String line : data) {

            matcherBeginTag = Pattern.compile(BEGIN_TAG).matcher(line);
            matcherEndTag = Pattern.compile(END_TAG).matcher(line);
            matcherAttribute = Pattern.compile(TAG_ATTRIBUTE).matcher(line);
            matcherBeginAttribute = Pattern.compile(BEGIN_TAG_WITH_ATTRS).matcher(line);

            if (matcherBeginTag.matches()) {
                node = Node.newBuilder().withName(getTagName(line)).build();
                stack.push(node);

            } else if(matcherBeginAttribute.matches()) {
                List<Attribute> attributes = getTagAttribute(line);
                node = Node.newBuilder().withName(getTagName(line)).withAttributes(attributes).build();
                stack.push(node);

            } else if (matcherEndTag.matches()) {
                node = stack.pop();
                if (!stack.isEmpty()) {
                    parentNode = stack.peek();
                    parentNode.addChild(node);
                } else {
                    result = node;
                }

            } else if (matcherAttribute.find()) {
                List<Attribute> attrs = getTagAttribute(line);
                String name = getTagName(line);
                String content = getTagContent(line.isEmpty() ? null : line);
                node = Node.newBuilder().withName(name).withContent(content).withAttributes(attrs).build();

                if (!stack.isEmpty()) {
                    parentNode = stack.peek();
                    parentNode.addChild(node);
                } else {
                    stack.push(node);
                }

            } else {
                String name = getTagName(line);
                String content = getTagContent(line);
                node = Node.newBuilder().withName(name).withContent(content).build();

                if (!stack.isEmpty()) {
                    parentNode = stack.peek();
                    parentNode.addChild(node);
                } else {
                    stack.push(node);
                }

            }
        }

        return result;
    }
}
