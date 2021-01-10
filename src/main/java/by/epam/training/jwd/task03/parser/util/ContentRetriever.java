package by.epam.training.jwd.task03.parser.util;

import by.epam.training.jwd.task03.entity.Attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task03.constant.Pattern.*;

public class ContentRetriever {

    public static String getTagName(String data){
        String modifiedData = clearAttributes(data);
        Pattern pattern = Pattern.compile(TAG_NAME);
        Matcher matcher = pattern.matcher(modifiedData);
        String tagName = "";
        if (matcher.find())
        {
            tagName = matcher.group(1);
        }
        return tagName.replaceAll("\\s", "");
    }

    public static List<Attribute> getTagAttribute(String data){
        Pattern pattern = Pattern.compile(TAG_ATTRIBUTE);
        Matcher matcher = pattern.matcher(data);
        ArrayList<Attribute> attrs = new ArrayList<>();
        while (matcher.find())
        {
            Attribute attr = new Attribute();
            attr.setName(matcher.group(1));
            attr.setContent(matcher.group(3).replace("\"", "").replace("'", ""));
            attrs.add(attr);
        }
        return attrs;
    }

    public static String getTagContent(String data){
        String modifiedData = clearAttributes(data);
        String tagName = getTagName(data);
        Pattern pattern = Pattern.compile(String.format(TAG_CONTENT, tagName, tagName));
        Matcher matcher = pattern.matcher(modifiedData);
        String content = "";
        if (matcher.find())
        {
            content = matcher.group();
        }
        return content;
    }

    private static String clearAttributes(String line) {
        String lineCopy = line;
        Matcher matcher = Pattern.compile(TAG_ATTRIBUTE).matcher(line);
        if (matcher.find()){
            lineCopy = line.replaceAll(TAG_ATTRIBUTE, "").replaceAll("\\s", "");
        }
        return lineCopy;
    }
}
