package by.epam.training.jwd.task03.constant;

public interface Pattern {
    String BEGIN_TAG = "<([^\\/>]+)[\\/]*>";
    String END_TAG = "<\\/[^\\/>]+[\\/]*>";
    String TAG_ATTRIBUTE = "(\\b\\w+\\b)(\\s*=\\s*)(\"[^\"]*\"|'[^']*'|[^\"'<>\\s]+)";
    String XML_EXTENTION = "([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.xml)$";
    String TAG_NAME = "<([^<> ]+)>";
    String TAG_CONTENT = "(?<=<%s>)(.*?)(?=<\\/%s>)";
    String OUTPUT_ELEMENT_WITH_ATTRIBUTES_PATTERN = "{ %s(%s) : %s }\n";
    String OUTPUT_ELEMENT_PATTERN = "{ %s : %s }\n";
}
