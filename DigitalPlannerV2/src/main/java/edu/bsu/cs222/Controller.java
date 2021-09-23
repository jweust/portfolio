package edu.bsu.cs222;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    public javafx.scene.control.Button closeButton;
    public TextField note;
    public TextField title;
    public ListView displayField;
    public DatePicker calendar;
    public TextField systemDisplay;

    public void handleCloseButtonAction(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

    public void handleAddButtonAction(){
        FileHandler f1 = new FileHandler();
        f1.writeToFile(calendar.getValue(), title.getText(), note.getText());
        String titlePrint = "title = " + title.getText() + "\n";
        String notePrint = "note = " + note.getText();
        String datePrint;

        if (calendar.getValue() == null) {
            Date today = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            datePrint = "date = " + format.format(today) + "\n";
            displayField.getItems().addAll(datePrint + titlePrint + notePrint);
        } else {
            datePrint = "date = " + calendar.getValue() + "\n";
            displayField.getItems().addAll(datePrint + titlePrint + notePrint);
        }

        systemDisplay.clear();
        systemDisplay.insertText(0, "successfully saved to file");
        title.clear();
        note.clear();
    }

    public void handleNewFileButtonAction(){
        FileHandler f2 = new FileHandler();
        f2.fileCreation();
        displayField.getItems().clear();
        systemDisplay.clear();
        systemDisplay.insertText(0, "new file created, old file deleted");
    }

    public void handleDisplayAction() {
        Parser parse = new Parser();
        displayField.getItems().clear();
        systemDisplay.clear();

        try {
            BufferedReader read = new BufferedReader(new FileReader("organizer.txt"));
            String line;
            while ((line = read.readLine()) != null){
                displayField.getItems().addAll(parse.reader(line));
            }

        } catch (IOException e) {
            systemDisplay.insertText(0, "Could not retrieve data");
        }
    }

    public void handleSpecificViewAction(){
        Parser parse = new Parser();
        displayField.getItems().clear();
        systemDisplay.clear();

        String testDate;
        if (calendar.getValue() == null) {
            Date today = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            testDate = format.format(today);
        } else {
            testDate = calendar.getValue().toString();

        }
        try {
            BufferedReader read = new BufferedReader(new FileReader("organizer.txt"));
            String line;
            int yesCounter = 0;
            while ((line = read.readLine()) != null){
                if(parse.reader(line).contains(testDate)) {
                    displayField.getItems().addAll(parse.reader(line));
                    yesCounter += 1;
                }
            }
            if (yesCounter == 0){
                systemDisplay.insertText(0, "no entries under specified date");
            }

        } catch (IOException e) {
            systemDisplay.clear();
            systemDisplay.insertText(0, "Could not retrieve data");
        }
    }

    public void handleEditAction(){
        displayField.setEditable(true);
        displayField.setCellFactory(TextFieldListCell.forListView());
    }


    public void handleSaveAction(){

        FileHandler tempFile = new FileHandler();
        tempFile.tempFileForEdits();

        ObservableList<String> test = displayField.getItems();

        try {
            for (String tempRead : test) {
                tempFile.tempWriteToFile(tempRead);
            }
        }catch(NullPointerException e){
            systemDisplay.clear();
            systemDisplay.insertText(0, "Error occurred, entry will be deleted");
        }

    }


}
