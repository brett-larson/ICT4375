package edu.du.larsonbrett;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * The MainProblemOne class contains the main method associated with 
 * Problem 2 of this week's assignment.
 * @author Brett Larson
 * @version 1.0
 */
public class MainProblemOne {


    public static void main(String[] args) throws MalformedURLException, IOException {
        
        //Main method variables
        String urlTest = "http://mysite.du.edu/~mschwart/ICT4361/hw7.problem1";
        ReadURL readUrl;
        String contents;

        //Create a new ReadURL object using the urlTest string
        try {
            readUrl = new ReadURL(urlTest);
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL Exception has been encountered.");
            throw e;
        }
        
        //Get the contents from the ReadURL object
        try {
            contents = readUrl.getContent();
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered.");
            throw e;
        }
        
        //Print the URL and its contents
        System.out.println(readUrl.getUrlString());
        System.out.println(contents);
        
    }
    
}
