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
import com.dropbox.core.DbxUrlWithExpiration;
import com.dropbox.core.DbxWriteMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
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
     public void downloadFile(File pFile) throws FileNotFoundException, DbxException, IOException
   {
      
       init();
       
        FileOutputStream outputStream = new FileOutputStream("temp.txt");
        try {
              DbxEntry.File downloadedFile = client.getFile("/MiniPierre/" + pFile.getName(), null,
               outputStream);
            } finally {
             outputStream.close();
            }
   }
   public Set<URL> downloadFileNames(String pIngrediant) throws DbxException, MalformedURLException{
         init();        
         Set<URL> mNames = new HashSet<URL>();
         String[] ingrediants = pIngrediant.split(";");
         DbxEntry.WithChildren listing = client.getMetadataWithChildren("/MiniPierre/Recipes");
          for (DbxEntry child : listing.children) {
             String temp = child.name;
             for (String st : ingrediants){
            if(temp.contains(".txt") && temp.contains(st)){              
                 DbxUrlWithExpiration fileURL = client.createTemporaryDirectUrl("/MiniPierre/Recipes/" + temp);
                 mNames.add(new URL(fileURL.url)); 
                }
             }          
         }
       return mNames;
   }
   public String fileContents(File pFile) throws DbxException, MalformedURLException, IOException{
        init();
        String poop = "";
        DbxUrlWithExpiration fileURL = client.createTemporaryDirectUrl("/MiniPierre/Recipes" + pFile.getName() + ".txt");
        URL my_url = new URL(fileURL.url);
        BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));            
        String strTemp = "";
        while (null != (strTemp = br.readLine())) {
               poop += strTemp + "\n";
        }
            
        return poop;     
   }

    private void init() {
       accessToken = "x1raWxa-_xwAAAAAAAAAAR3y5SlXrULyS1lyDIykZ5OWUhSEWS4kzYjNDf-nxUVY";
        // Only display important log messages.
        config = new DbxRequestConfig("MiniPierre", Locale.getDefault().toString());
        client = new DbxClient(config, accessToken);
    }
}
