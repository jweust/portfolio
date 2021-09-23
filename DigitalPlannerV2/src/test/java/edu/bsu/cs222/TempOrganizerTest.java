package edu.bsu.cs222;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TempOrganizerTest {

    @Test
    public void TestTemp(){
        Parser parse = new Parser();
        try {
            BufferedReader read = new BufferedReader(new FileReader("tempOrganizer.txt"));
            String line;
            while ((line = read.readLine()) != null){
                System.out.println(parse.reader(line));
            }

        } catch (IOException e) {
            System.out.println("Could not retrieve data");
        }
    }

    @Test
    public void ParseTestOfficialFile(){
        Parser parse = new Parser();
        try {
            BufferedReader read = new BufferedReader(new FileReader("organizer.txt"));
            String line;
            while ((line = read.readLine()) != null){
                System.out.println(parse.reader(line));
            }

        } catch (IOException e) {
            System.out.println("Could not retrieve data");
        }
    }
}
