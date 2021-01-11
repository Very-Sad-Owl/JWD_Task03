package by.epam.training.jwd.task03.dao.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.training.jwd.task03.constant.Pattern.*;

public class XMLReader {
    private String fileName;

    public XMLReader(){}

    public XMLReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> read() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        List<String> content = new ArrayList<>();
        String line;

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        line = reader.readLine();
        if(line.contains("?xml version")) {
            line = reader.readLine();
        }

        while(line != null) {
            content.add(line);
            line = reader.readLine();
        }

        reader.close();
        fileReader.close();

        return content;
    }

    private boolean isXML(File file){
        return file.getName().matches(XML_EXTENTION);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
