package edu.bsu.cs222;

class Parser {

    String reader(String line) {

        //the code below splits up the inputted string into usable and organizable parts
        String[] sArray = line.split("&~, ");
        String sDate = sArray[0].replace("=", " = ").replace("{", "");
        String sNote = sArray[1].replace("=", " = ");
        String sTitle = sArray[2].replace("=", " = ").replace("&~}", "");

        return sDate + "\n" + sTitle + "\n" + sNote + "\n";
    }
}
