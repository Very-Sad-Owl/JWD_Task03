package by.epam.training.jwd.task03.exception;

public class NotXmlException extends Exception {
    public NotXmlException(){
        super("Given file is not .xml");
    }
}
