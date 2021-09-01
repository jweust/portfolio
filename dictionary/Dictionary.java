//By: Noah Hensley and Jon Weust
package dictionary;

import java.util.*;
import java.io.*;
import java.util.Date;

public class Dictionary {
    static private Map<String, Entry> dictionary = new HashMap<String, Entry>();

    public static String getDefinition(Entry e){
        return e.getWord() + ": " + e.getDef() + " | Written by: " + e.getAuthor() + " on " + e.getDate();
    }
    public static void addDefinition(String word, String definition, String author){
        Date d = new Date();
        Entry e = new Entry(word, definition, author, d);
        dictionary.put(word, e);
    }
    static private String keyword;
    static private String answer;
    public static void main(String[] args) {
        System.out.println("Welcome to the dictionary!");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Search for any word. Press 'q' to exit.");
                keyword = br.readLine();
                if (keyword.equalsIgnoreCase("q")) {
                    break;
                } else if (dictionary.containsKey(keyword)) {
                    System.out.println("This is the definition we have.");
                    System.out.println(getDefinition(dictionary.get(keyword)));
                    System.out.println("Would you like to update this definition? (Y/N)");
                    answer = br.readLine();
                    if(answer.equalsIgnoreCase("y")) {
                        System.out.println("Please enter your name: ");
                        String newAuth = br.readLine();
                        System.out.println("Please enter the updated definition: ");
                        String newDef = br.readLine();
                        addDefinition(keyword, newDef, newAuth);
                    }
                } else {
                    System.out.println("There is no definition for that word. Would you like to add one? (Y/N)");
                    answer = br.readLine();
                    if (answer.equalsIgnoreCase("y")) {
                        System.out.println("Please enter your name: ");
                        String newAuth = br.readLine();
                        System.out.println("Please enter the updated definition: ");
                        String newDef = br.readLine();
                        addDefinition(keyword, newDef, newAuth);

                    }

                }
            }
        }catch(IOException e){
                System.out.println("Unexpected IO error.");

            }
        }
    }
//By: Noah Hensley and Jon Weust
