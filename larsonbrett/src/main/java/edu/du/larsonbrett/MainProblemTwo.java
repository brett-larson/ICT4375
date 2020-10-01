package edu.du.larsonbrett;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * The MainProblemTwo class contains the main method associated with 
 * Problem 2 of this week's assignment.
 * @author Brett Larson
 * @version 1.0
 */
public class MainProblemTwo {

    public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
        
        
        //Variable to hold user input (if different from static text)
        //String inputString;
        
        //Create a new scanner object to receive user input
        //Scanner input = new Scanner(System.in);
        
        //Code to obtain and store the Properties file name
        //System.out.print("Please provide a name for the Properties file: ");
        //inputString = input.nextLine();
        
        String inputString = "http://mysite.du.edu/~mschwart/ICT4361/hw7.problem2";
        
        //First ReadURL object
        ReadURL firstUrl;
        
        //Second ReadURL object
        ReadURL secondUrl;

        //URI object
        URI uri;
        
        //URL object
        URL url;
        
        //Variable to hold the contents received
        String contents;
        
        //Use the firstUrl ReadURL object and pass in the URL
        try {
             firstUrl = new ReadURL(inputString);
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL Exception Encountered");
            throw e;
        }
        
        //Take the firstUrl ReadURL object and convert content to URI
        try {
            uri = firstUrl.getContentAsUri();
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax exception has been encountered.");
            throw e;
        }
        
        //Convert the URI object to a URL object
        url = uri.toURL();
        
        //Take the url object and use it to set up the secondUrl object
        secondUrl = new ReadURL(url);
        
        //Get the contents of the secondURL
        try {
            contents = secondUrl.getContent();
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered.");
            throw e;
        }
        
        //Print the firstURL URL
        System.out.println(firstUrl.getUrlString());
        
        //Print the secondURL URL
        System.out.println(uri.normalize());

        //Print the contents of the secondURL
        System.out.println(contents);
        
        

    }
    
}
