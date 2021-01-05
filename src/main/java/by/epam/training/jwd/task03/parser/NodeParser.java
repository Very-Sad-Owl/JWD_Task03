package by.epam.training.jwd.task03.parser;

import by.epam.training.jwd.task03.entity.Attribute;
import by.epam.training.jwd.task03.entity.Node;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task03.constant.Pattern.*;
import static by.epam.training.jwd.task03.parser.ContentRetriever.*;

public class NodeParser {

    private ArrayDeque<Node> stack = new ArrayDeque<>();

    public Node parse(List<String> data) {

        Node result = new Node();
        NodeFactory creator = new NodeFactory();
        Node node;
        Node parentNode;
        Matcher matcherBeginTag;
        Matcher matcherEndTag;
        Matcher matcherAttribute;

        for (String line : data) {

            matcherBeginTag = Pattern.compile(BEGIN_TAG).matcher(line);
            matcherEndTag = Pattern.compile(END_TAG).matcher(line);
            matcherAttribute = Pattern.compile(TAG_ATTRIBUTE).matcher(line);

            if (matcherBeginTag.matches()) {
                node = creator.createNode(getTagName(line));
                stack.push(node);
//                if (!stack.isEmpty()){
//                    parentNode = stack.peek();
//                    parentNode.addChild(node);
//                }
            } else if (matcherEndTag.matches()) {
                node = stack.pop();
                if (!stack.isEmpty()) {
                    parentNode = stack.peek();
                    parentNode.addChild(node);
                } else {
                    result = node;
                }

            } else if (matcherAttribute.find()) {
                String name = getTagName(line);
                String content = getTagContent(line);
                List<Attribute> attrs = getTagAttribute(line);
                node = creator.createNode(name, content, attrs);

                if (!stack.isEmpty()) {
                    parentNode = stack.peek();
                    parentNode.addChild(node);
                } else {
                    stack.push(node);
                }

            } else {
                String name = getTagName(line);
                String content = getTagContent(line);
                node = creator.createNode(name, content);

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
