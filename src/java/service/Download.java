/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordan Jensen
 */
public class Download {
     public void Download(/*File pFile*/) throws FileNotFoundException, DbxException, IOException
   {
       final String accessToken = "x1raWxa-_xwAAAAAAAAAAR3y5SlXrULyS1lyDIykZ5OWUhSEWS4kzYjNDf-nxUVY";
        // Only display important log messages.
          DbxRequestConfig config = new DbxRequestConfig(
            "JavaTutorial/1.0", Locale.getDefault().toString());
        DbxClient client = new DbxClient(config, accessToken);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Jordan Jensen\\Desktop\\temp\\temp.txt");
        try {
              DbxEntry.File downloadedFile = client.getFile("/MiniPierre/Cans.txt", null,
               outputStream);
              System.out.println("Metadata: " + downloadedFile.toString());
            } finally {
             outputStream.close();
            }
   }
   
}
