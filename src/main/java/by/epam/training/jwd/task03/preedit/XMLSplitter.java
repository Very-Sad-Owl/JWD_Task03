package by.epam.training.jwd.task03.preedit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLSplitter implements BasicSplitter {

    @Override
    public boolean validate(List<String> content) {
        return false;
    }

    public List<String> splitByTags(List<String> content){
        List<String> prepared = new ArrayList<>();

        Pattern endTag = Pattern.compile("(.+)(</.+>)");
        Pattern beginTag = Pattern.compile("(<.+>|<[^>]+\\sid\\b[^>]*>)(.+)(<.+>)");
        Pattern wholeTag = Pattern.compile("(<.+>|<[^>]+\\sid\\b[^>]*>)(.+)(<\\/.+>$)");
        Pattern oneOccur = Pattern.compile("(<.+>|<[^>]+\\s\\b[^>]*>.+)(<\\/.[^<>]+>)\\W|$");
        Pattern elBoeder = Pattern.compile("> +<|><");
        Matcher matcher;
//<\/.*?> closing tag
        // one occur tag (<.+>|<[^>]+\s\b[^>]*>.+)(<\/.[^<>]+>)\W|$
        for (String line : content) {
            //String[] res = elBoeder.split(line);
            line = line.replaceAll("> +<|><", ">;<");
            String[] temp = line.split(";");
            prepared.addAll(Arrays.asList(temp));
            System.out.println(Arrays.asList(temp));

        }
        return prepared;
    }
}
