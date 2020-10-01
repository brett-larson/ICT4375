package edu.du.larsonbrett;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The MainProblemThree class contains the main method associated with 
 * Problem 3 of this week's assignment.
 * @author Brett Larson
 * @version 1.0
 */
public class MainProblemThree {

    public static void main(String[] args) throws IOException, URISyntaxException {
        
        //Variables to be used within the main method
        String uriFileName = "hw7server.uri";
        String name = "Brett";
        String uriResource;
        String response;
        
        //Buffered reader object
        BufferedReader reader;
 
        //Try to find the file and add contents to the reader variable
        try {
            reader = new BufferedReader(new FileReader(uriFileName));
        } catch (FileNotFoundException e) {
            System.out.println("The file " + uriFileName + " was not found.");
            throw e;
        }  

        //Try to read and store the line
        try {
            uriResource = reader.readLine(); 
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered reading one line to the variable.");
            throw e;
        }
        
        //Close the reader
        reader.close();
       
        //Create the WriteURI object with URI resource
        WriteURI write = new WriteURI(uriResource);
        
        //Send the message
        System.out.println("Sending the message '" + name + "'");
        write.sendMessage(name);
        
        //Receive the response
        System.out.println("Receiving the message");
        response = write.receiveMessage();
        
        //Print the response
        System.out.println(response);
    }
    
}
