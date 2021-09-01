//By: Noah Hensley and Jon Weust
package dictionary;

import java.util.Date;

public class Entry {
    private String word;
    private String definition;
    private String author;
    private Date date;

    public Entry(String w, String d, String a, Date x){
        word = w;
        definition = d;
        author = a;
        date = x;
    }

    public String getWord(){
        return word;
    }
    public String getDef(){
        return definition;
    }
    public String getAuthor(){
        return author;
    }
    public Date getDate(){
        return date;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
//By: Noah Hensley and Jon Weust