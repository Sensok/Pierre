package service;

import com.dropbox.core.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;


//TODO: Jordan - make sure that all the files get back into dropbox
/**
 * This will upload files to dropbox
 * @author Adam Harper
 */
public class Upload
{
   /**
    * String for file sep
    */
   private String mPathSep;
   /**
    * Creates a new Upload object.
    *
    * @param mDBApi Dropbox api to use to upload files to dropbox
    */
   public void Upload(/*File pFile*/) throws FileNotFoundException, DbxException, IOException
   {
       final String accessToken = "x1raWxa-_xwAAAAAAAAAAR3y5SlXrULyS1lyDIykZ5OWUhSEWS4kzYjNDf-nxUVY";
        // Only display important log messages.
          DbxRequestConfig config = new DbxRequestConfig(
            "JavaTutorial/1.0", Locale.getDefault().toString());
        DbxClient client = new DbxClient(config, accessToken);
        File inputFile = new File("C:\\Users\\Jordan Jensen\\Desktop\\Winter 14\\.emacs");//pFile;
        FileInputStream inputStream = new FileInputStream(inputFile);
        try { 
              DbxEntry.File uploadedFile = client.uploadFile("/MiniPierre/"+inputFile.getName(),
              DbxWriteMode.add(), inputFile.length(), inputStream);
              System.out.println("Uploaded: " + uploadedFile.toString());
            } finally {
              inputStream.close();
            }
   }
}
