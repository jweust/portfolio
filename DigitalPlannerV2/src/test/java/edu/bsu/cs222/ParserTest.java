package edu.bsu.cs222;

import org.junit.Test;

public class ParserTest {

    @Test
    public void parsingTest() {
        Parser parse = new Parser();
        String line = "{date=2019-11-10, note=test tomorrow, title=math}";
        parse.reader(line);
    }

}
