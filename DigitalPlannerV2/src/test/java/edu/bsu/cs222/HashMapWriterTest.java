package edu.bsu.cs222;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class HashMapWriterTest {

    @Test
    public void fileCreation() throws IOException {
        BufferedWriter writer1 = new BufferedWriter(new java.io.FileWriter("sample.txt"));
        writer1.close();
    }

    @Test
    public void fileWrite() throws IOException {
        BufferedWriter writer1 = new BufferedWriter(new java.io.FileWriter("sample.txt", true));

        HashMap<String, String> h1 = new HashMap<>();
        h1.put("note", "note");
        h1.put("title", "title");
        h1.put("date", "date");

        writer1.write(h1.toString());
        writer1.newLine();
        writer1.close();
    }
}
