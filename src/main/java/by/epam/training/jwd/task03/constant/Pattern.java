package by.epam.training.jwd.task03.constant;

public interface Pattern {
    String BEGIN_TAG = "<([^\\/ >]+)[\\/]*>";
    String BEGIN_TAG_WITH_ATTRS = "<([^\\/>]+)[\\/]*>";
    String END_TAG = "<\\/[^\\/>]+[\\/]*>";
    String TAG_ATTRIBUTE = "(\\b\\w+\\b)(\\s*=\\s*)(\"[^\"]*\"|'[^']*'|[^\"'<>\\s]+)";
    String TAG_ATTRIBUTE_WITH_WHITESPACES = "/(\\s+\\b\\w+\\b)(\\s*=\\s*)(\"[^\"]*\"\\s+|'[^']*'\\s+|[^\"'<>\\s]+)/";
    String XML_EXTENTION = "([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.xml)$";
    String TAG_NAME = "<([^<> ]+)>";
    String TAG_CONTENT = "(?<=<%s>)(.*?)(?=<\\/%s>)";
    String ATTRIBUTE_PATTERN = "(%s = %s)";
}
