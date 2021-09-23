# Digital Planner

PROGRAMMERS:

Nick Ceglio

Ryan Slack

John Xiao

Jon Weust

PROGRAM IDIOSYNCRASIES:

Changed reading and writing technology to a string hashmap that writes to a .txt file and back.

Abandoned using JSON because it was not ideal for our use case.

Project needs JavaFX to run, We've gotten it to work with JFX 11 and FJX 13, so anything 11 or newer should work.

Our unit tests need JSON, although the production code itself has moved away from JSON, tests only kept to show that they were conducted in the first place.

if javafx runtime components are missing, add this to VM options (changing file path to whatever it is on your computer) --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls,javafx.fxml

TO-DO:

having trouble writing multiple lines into json file - solved

need to figure out if there is a way to automatically get the username in order to simplify the creation process - solved and obsolete

need to figure out how to write the json object key as well as the value into the json file - solved

need to add parser in order to read from the json file - solved and obsolete

need to get javafx working - solved

need to display all parsed data to the listView in UI