package com.maxwell.android_examples;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ConvertImg {
	public Bitmap Imagen(String url){
        String strImageUrl = url;
        URL imageUrl = null;
        HttpURLConnection conn = null;
        Bitmap bm = null; 
             
        try{
            imageUrl = new URL(strImageUrl);
            conn = (HttpURLConnection) imageUrl.openConnection();
            
            if(conn.getResponseCode() != 200)
            {
              return bm;
            }
            
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is); 
                     
            try
            {
              bm = BitmapFactory.decodeStream(bis);  
            }
            catch(OutOfMemoryError ex)
            {
              bm = null;
            }
            bis.close(); 
            is.close();

        }catch (Exception e) {
         e.printStackTrace();
       }
        
       return bm;     
    }
}
