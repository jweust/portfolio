package edu.bsu.cs222;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HashMapParserTest {

    @Test
    public void FileReader() throws IOException {

        String line;
        String[] s1;
        String sD;
        String sT;
        String sN;

        try {
            BufferedReader read = new BufferedReader(new java.io.FileReader("sample.txt"));

            while ((line = read.readLine()) != null) {

                s1 = line.split(",");
                sD = s1[0].replace("=", " = ");
                sN = s1[1].replace("=", " = ");
                sT = s1[2].replace("=", " = ");

                System.out.println(sD);
                System.out.println(sT);
                System.out.println(sN + "\n");

            }
        }catch (FileNotFoundException e){
            System.out.println("file cannot be found");
        }

    }
}
