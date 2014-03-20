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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordan Jensen
 */
public class Download {
     private String accessToken;
     private DbxRequestConfig config;
     private DbxClient client;
     public void DownloadFile(File pFile) throws FileNotFoundException, DbxException, IOException
   {
      
       init();
       
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Jordan Jensen\\Desktop\\temp\\temp.txt");
        try {
              DbxEntry.File downloadedFile = client.getFile("/MiniPierre/" + pFile.getName(), null,
               outputStream);
            } finally {
             outputStream.close();
            }
   }
   public List DownloadFileNames() throws DbxException{
         List mNames = new ArrayList();
         init();
         DbxEntry.WithChildren listing = client.getMetadataWithChildren("/MiniPierre/Recipes");
         for (DbxEntry child : listing.children) {
             String temp = child.name;
             if(temp.contains(".txt")){
                mNames.add(child.name);
                System.out.println(child.name);
             }
         }
       return mNames;
   }

    private void init() {
       accessToken = "x1raWxa-_xwAAAAAAAAAAR3y5SlXrULyS1lyDIykZ5OWUhSEWS4kzYjNDf-nxUVY";
        // Only display important log messages.
        config = new DbxRequestConfig("MiniPierre", Locale.getDefault().toString());
        client = new DbxClient(config, accessToken);
    }
}
