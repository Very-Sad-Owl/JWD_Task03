package by.epam.training.jwd.task03.constant;

public interface Pattern {
    String BEGIN_TAG = "<([^\\/>]+)[\\/]*>";
    //String beginTagWithAttrs = "<([^\\/>]+)[\\/]*>";
    String END_TAG = "<\\/[^\\/>]+[\\/]*>";
    String ATTRIBUTE = "(\\b\\w+\\b)(\\s*=\\s*)(\"[^\"]*\"|'[^']*'|[^\"'<>\\s]+)";
}
