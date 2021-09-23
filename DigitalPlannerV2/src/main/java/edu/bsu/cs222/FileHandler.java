package edu.bsu.cs222;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

class FileHandler {

    private Controller control = new Controller();

    void fileCreation() {
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("organizer.txt"));
            writer.close();

        }catch (FileNotFoundException e){
            System.out.println("Something went wrong, file doesn't exist");
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Something went wrong, file doesn't exist");
        }catch (IOException e){
            System.out.println("Something went wrong, try something different");
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Something went wrong, try something different");
        }
    }


    void writeToFile(LocalDate date, String title, String note) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("organizer.txt", true));



            HashMap<String, String> stringMap = new HashMap<>();
            stringMap.put("note", note + "&~");
            stringMap.put("title", title + "&~");

            //if statement checks whether a date has been specified by the user
            //this if statement is used in various places, but all uses are too different to be able to effectively combine into a method or function
            if (date == null) {
                Date today = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                stringMap.put("date", format.format(today) + "&~");
            } else {
                stringMap.put("date", date.toString() + "&~");
            }

            writer.write(stringMap.toString());
            writer.newLine();
            writer.close();

        }catch(IOException e){
            System.out.println("Something went wrong, IO exception occurred");
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Something went wrong, try something different");
        }
    }



    void tempFileForEdits(){
        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("organizer.txt"));
            writer.close();

        }catch (FileNotFoundException e){
            System.out.println("Something went wrong, file doesn't exist");
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Something went wrong, file doesn't exist");
        }catch (IOException e){
            System.out.println("Something went wrong, try something different");
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Something went wrong, try something different");
        }
    }

    void tempWriteToFile(String temp) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("organizer.txt", true));

            String tempNote = "";
            String tempTitle = "";
            String tempDate = "";

            int noteIndex = 0;

            HashMap<String, String> tempData = new HashMap<>();

            if(temp.contains("\ntitle")){
                temp = temp.replace("\n", "");
                if(temp.contains("\nnote")){
                    temp = temp.replace("\n", "");
                }
            }

            if(temp.contains("title")){
                noteIndex = temp.indexOf("note");
                tempTitle = temp.substring(25, noteIndex);
            }

            if(temp.contains("note")){
                tempNote = temp.substring(noteIndex + 7);
            }

            if(temp.contains("date")){
                tempDate = temp.substring(7, 17);
            }

            tempData.put("note", tempNote + "&~");
            tempData.put("title", tempTitle + "&~");
            tempData.put("date", tempDate + "&~");

            writer.write(tempData.toString());
            writer.newLine();
            writer.close();

        }catch (IOException e){
            System.out.println("Something went wrong, IO exception occurred");
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Something went wrong, try something different");
        } catch(NullPointerException e){
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "null pointer exception");
        } catch(RuntimeException e){
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Please don't edit the words 'date', 'title' or 'note'");
        } catch(Exception e){
            control.systemDisplay.clear();
            control.systemDisplay.insertText(0, "Please don't do whatever you just did");
        }
    }
}
