package by.epam.training.jwd.task03.parser;

import by.epam.training.jwd.task03.entity.Attribute;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentRetriever {

    static String getTagName(String data){
        Pattern pattern = Pattern.compile("<([^>]+)>");
        Matcher matcher = pattern.matcher(data);
        String tagName = "";
        if (matcher.find())
        {
            tagName = matcher.group(1);
        }
        return tagName.replaceAll(" ", "");
    }

    static List<Attribute> getTagAttribute(String data){
        Pattern pattern = Pattern.compile("(\\b\\w+\\b)\\s*=\\s*(\"[^\"]*\"|'[^']*'|[^\"'<>\\s]+)");
        Matcher matcher = pattern.matcher(data);
        ArrayList<Attribute> attrs = new ArrayList<>();
        while (matcher.find())
        {
            Attribute attr = new Attribute();
            attr.setName(matcher.group(1));
            attr.setContent(matcher.group(2).replace("\"", "").replace("'", ""));
            attrs.add(attr);
        }
        return attrs;
    }

    static String getTagContent(String data){
        String regex = "(?<=<%s>)(.*?)(?=<\\/%s>)";
        String tagName = getTagName(data);
        Pattern pattern = Pattern.compile(String.format(regex, tagName, tagName));
        Matcher matcher = pattern.matcher(data);
        String content = "";
        if (matcher.find())
        {
            content = matcher.group();
        }
        return content;
    }
}
