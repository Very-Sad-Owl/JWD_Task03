package by.epam.training.jwd.task03.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.training.jwd.task03.constant.Pattern.*;

public class XMLReader {
    private String filePath;

    public XMLReader(){}

    public XMLReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> read() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
