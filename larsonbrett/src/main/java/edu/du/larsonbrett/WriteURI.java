package edu.du.larsonbrett;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * The WriteURI class sets up a connection and sends/receives data 
 * @author Brett Larson
 * @version 1.0
 */
public class WriteURI {
    
    //Class variables
    private URI uri;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String paramString;
     

    /**
     * Constructor that accepts a URI and calls the openConnection method
     * @param uri URI to be used in the method
     * @throws IOException If the openConnection method runs into any issues
     */
    public WriteURI(URI uri) throws IOException {
        this.uri = uri;
        openConnection();
    }

    /**
     * Constructor that accepts a string 
     * @param paramString representing a URI
     * @throws IOException If the openConnection method runs into any issues
     * @throws URISyntaxException If the string is malformed
     */
    public WriteURI(String paramString) throws IOException, URISyntaxException {
        this.paramString = paramString;
        uri = new URI(paramString);
        openConnection();
    }
    
    /**
     * The openConnection method creates a socket connection and a reader and
     * writer for that connection.
     * @throws IOException 
     */
    public void openConnection() throws IOException {
        
        //Get and print the host
        String host = uri.getHost();
        System.out.println("Host: " + host);
        
        //Get and print the port
        int port = uri.getPort();
        System.out.println("Port: " + port);
        

        try {
            //Set up the new socketObject based on URI info
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("Input/Output exception has been encountered in creating the socket.");
            throw e;
        }
        
        try {
            //Buffered reader and input stream getting the input stream from the connection
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered with the input stream.");
            throw e;
        }

        try {
            //Buffered reader and input stream getting the input stream from the connection
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered with the input stream.");
            throw e;
        }

    }
    
    /**
     * The sendMessage method accepts a string and sends it to the writer
     * that was set up in the openConnection method
     * @param parameter String to send to the writer
     */
    public void sendMessage(String parameter) {
        
        writer.println(parameter);
        
    }
    
    /**
     * The receiveMessage method uses the reader set up in the openConnection
     * method to read the string and returns it to the calling method.
     * @return String of text from the reader
     * @throws IOException 
     */
    public String receiveMessage() throws IOException {
        
        String retString;
        
        try {
            retString = reader.readLine();
        } catch (IOException e) {
            System.out.println("Input/Output exception encountered while attempting to retrieve the string.");
            throw e;
        }
        
        return retString;
        
    }
    
}
