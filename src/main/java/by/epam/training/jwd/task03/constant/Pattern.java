package by.epam.training.jwd.task03.constant;

public interface Pattern {
    String beginTag = "<([^\\/>]+)[\\/]*>";
    //String beginTagWithAttrs = "<([^\\/>]+)[\\/]*>";
    String endTag = "<\\/[^\\/>]+[\\/]*>";
}
