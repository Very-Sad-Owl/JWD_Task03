package by.epam.training.jwd.task03.dao.reader.impl;

import by.epam.training.jwd.task03.dao.reader.BasicSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitterByTags implements BasicSplitter {

    public List<String> split(List<String> content){
        List<String> prepared = new ArrayList<>();
        String splitter = "> +<|><";
        String replacement = ">;<";
        for (String line : content) {
            line = line.replaceFirst("^\\s*", "");
            line = line.replaceAll(splitter, replacement);
            String[] temp = line.split(";");
            prepared.addAll(Arrays.asList(temp));

        }
        return prepared;
    }
}
