package edu.du.larsonbrett;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * The ReadURL class is used to read from a webpage and use the data to create 
 * other items, such as URI objects.
 * @author Brett Larson
 * @version 1.0
 */
public class ReadURL {
    
    //Creating a new URL object
    private URL urlObject;
    
    //Creating a new URI object
    private URI uriObject;
    
    //Variable to hold a string containing the URL
    private String urlString;

    /**
     * Constructor to create a new object and accepts a URL object
     * @param urlObject URL object to be used by the class
     */
    public ReadURL(URL urlObject) {
        this.urlObject = urlObject;
    }
    
    /**
     * Constructor to create a new object and accepts a URI object
     * @param uriObject URI object to be used by the class
     * @throws MalformedURLException If the URI is not formatted properly
     */
    public ReadURL(URI uriObject) throws MalformedURLException {
        try {
            this.urlObject = uriObject.toURL();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL Exception Encountered");
            throw e;
        }
    }

    /**
     * Constructor to create a new object and accepts a string that represents
     * a URL. It takes the URL and creates a new URL object
     * @param urlString String representing a URL
     * @throws MalformedURLException If the URL does not meet formatting requirements
     */
    public ReadURL(String urlString) throws MalformedURLException {
        this.urlString = urlString;
        try {
            this.urlObject = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL Exception Encountered");
            throw e;
        }
    }

    /**
     * Return the String urlString
     * @return String urlString
     */
    public String getUrlString() {
        return urlString;
    }

    @Override
    public String toString() {
        return "ReadURL{" + "urlObject=" + urlObject + ", uriObject=" + uriObject + ", urlString=" + urlString + '}';
    }
        
    /**
     * The getContent method is used to retrieve and return string content from a site
     * @return String first line of text
     * @throws IOException Thrown if errors are encountered with input/output operations
     */
    public String getContent() throws IOException {
        
        //Variable for return value
        String retString = null;
        
        //URLConnection object
        URLConnection connection;
        
        //Buffered reader object
        BufferedReader reader;
        
        //Create and open a URLConnection
        try {
            connection = urlObject.openConnection();
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered opening the connection.");
            throw e;
        }
        
        //Read and store text
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered with the input stream.");
            throw e;
        }

        //Read the first line from the reader and store in a string variable
        try {
            //Read one line
            retString = reader.readLine(); 
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered reading one line to the variable.");
            throw e;
        }
        
        //Close the buffered reader
        reader.close();
        
        return retString;
    }
    
    /**
     * The getContentAsUri method retrieves information and uses it to build
     * a URI object
     * @return URI object based on input
     * @throws IOException when getting content
     * @throws URISyntaxException when creating URI object
     */
    public URI getContentAsUri() throws IOException, URISyntaxException {
        
        //URI object to return to the calling method
        URI retUri;
        
        //Variable to hold retrieved content
        String getContentString;
        
        //Get and store content
        try {
            getContentString = getContent();
        } catch (IOException e) {
            System.out.println("Input/Output Exception has been encountered calling getContent from getContentAsUri.");
            throw e;
        }
        
        //Take stored content and use it to create the retUri object
        try {
            retUri = new URI(getContentString);
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax exception has been encountered.");
            throw e;
        }
        
        return retUri;
        
    }
    
    
    

    
    

    

    
    
    
    
    
}
