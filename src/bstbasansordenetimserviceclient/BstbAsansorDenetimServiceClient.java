/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bstbasansordenetimserviceclient;

import com.sun.xml.wss.XWSSConstants;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.soap.AddressingFeature;

/**
 *
 * @author Lenovo
 */
public class BstbAsansorDenetimServiceClient {
    public BstbAsansorDenetimServiceClient(String arg0) {
          String sslStoreProp = "javax.net.ssl.trustStore";
          System.setProperty(sslStoreProp, arg0);
          System.setProperty("javax.net.ssl.keyStorePassword","changeit");
    }
    
    public BstbAsansorDenetimServiceClient() {
        
        /*
          String sslStoreProp = "javax.net.ssl.trustStore";
          String userDir = System.getProperty("user.dir");
          System.setProperty(sslStoreProp, userDir + "\\src\\keystore\\dsl.jks");
          System.out.println("DSL Directory :"+userDir);
          */
         /*
             String sslStoreProp = "javax.net.ssl.trustStore";
                URL url=Test.class.getResource("/keystore");
          System.setProperty(sslStoreProp, url.getPath()+"/dsl.jks");
            System.out.println("KEYSTORE FILE PATH :"+url.getPath()+"/dsl.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","changeit");
        */
       /*
          File currentDirFile = new File("");
String helper = currentDirFile.getAbsolutePath();
System.out.println("HELPER :"+helper);

String currentDir;
        try {
            currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());
            System.out.println("CURRENT DIR:"+currentDir);
           StringBuilder path=new StringBuilder();
           
           path.append(Path.instance.getPath()).append("/dsl.jks");
             String sslStoreProp = "javax.net.ssl.trustStore";
          //String userDir = System.getProperty("user.dir");
          //  System.out.println(url.getPath()+"/dsl.jks");
          System.setProperty(sslStoreProp, helper+"/src/keystore/dsl.jks");
            System.out.println("KEYSTORE FILE PATH :"+helper+"/src/keystore/dsl.jks");
          System.out.println("KEYSTORE EX FILE PATH :"+path.toString());
        } catch (IOException ex) {
            Logger.getLogger(BstbAsansorDenetimServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }

          System.setProperty("javax.net.ssl.keyStorePassword","changeit");
                
          */
    }
    
    

   
    public static BstbAsansorDenetimServiceClient INSTANCE =new BstbAsansorDenetimServiceClient();
    
   
    
 
 public BstbAsansorDenetimServis service=null;
 public  IBstbAsansorDenetimServis iService;
  
    
    public IBstbAsansorDenetimServis port() throws Exception{
           try {
               
            service = new BstbAsansorDenetimServis();
            iService = service.getWSHttpBindingIBstbAsansorDenetimServis(new AddressingFeature(true, true));
   
	((javax.xml.ws.BindingProvider)iService).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "BSTB-234953");
((javax.xml.ws.BindingProvider)iService).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "bs20tb*2dn3493Prd!"); 	
    return iService;
               
        } catch (Exception ex) {
            Logger.getLogger(BstbAsansorDenetimServiceClient.class.getName()).log(Level.SEVERE, null, ex);
             throw  new Exception(ex.getMessage());
        }
    }
    
}
