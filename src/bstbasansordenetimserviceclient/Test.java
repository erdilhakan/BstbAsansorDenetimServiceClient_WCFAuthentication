package bstbasansordenetimserviceclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import com.sun.xml.wss.XWSSConstants;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.xml.bind.JAXBElement;

import javax.xml.ws.soap.AddressingFeature;

public class Test{
      static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
          BstbAsansorDenetimServis service=null;
 IBstbAsansorDenetimServis iService;

        try {
          File currentDirFile = new File("");
String helper = currentDirFile.getAbsolutePath();
System.out.println("HELPER :"+helper);

String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());
System.out.println("CURRENT DIR:"+currentDir);
           StringBuilder path=new StringBuilder();
           
           path.append(Path.instance.getPath()).append("/dsl.jks");
             String sslStoreProp = "javax.net.ssl.trustStore";
          //String userDir = System.getProperty("user.dir");
          //  System.out.println(url.getPath()+"/dsl.jks");
          System.setProperty(sslStoreProp, helper+"/src/keystore/dsl.jks");
            System.out.println("KEYSTORE FILE PATH :"+helper+"/src/keystore/dsl.jks");
          System.out.println("KEYSTORE EX FILE PATH :"+path.toString());
          System.setProperty("javax.net.ssl.keyStorePassword","changeit");
              service = new BstbAsansorDenetimServis();
            iService = service.getWSHttpBindingIBstbAsansorDenetimServis(new AddressingFeature(true, true));
            ((javax.xml.ws.BindingProvider)iService).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "BSTB-234953");
            ((javax.xml.ws.BindingProvider)iService).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "bs20tb*2dn3493Prd!"); 	
//((javax.xml.ws.BindingProvider)iService).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "bs20tb*2dn3493Prd!"); 	
         
          
                for (int i=1;i<=100;i++){
                      
	                   ServisSonucOfArrayOfIlce8Zb117HL s=   iService.ileBagliIlceSorgulama(i);
                           if (!s.isHata()){
                          List<Ilce> ilceList= s.getSonuc().getValue().getIlce();
                         if (ilceList.size()>0)
                               ilceEkle(ilceList, i);
                          
                           }
                           
	                
	              
	                }
               
	       
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static  Connection getConnection() {
    Connection connection=null;
		try {
			if (connection == null || connection.isClosed()) {
				

				connection = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/Asansor", "postgres", "123123");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

public static void ilceEkle(List<Ilce> ilceList,int ilKodu){
    Connection con=null;
    PreparedStatement psmt=null;
    
    try{
        con=getConnection();
        con.setAutoCommit(false);
        psmt=con.prepareStatement("insert into uavt.ilce values (?,?,?)");
        psmt.setInt(3, ilKodu);
        for (Ilce i:ilceList){
            psmt.setInt(1,i.getKod());
            psmt.setString(2, i.getAd().getValue());
            psmt.addBatch();
        }
        psmt.executeBatch();
        con.commit();
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try {
            psmt.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
}
  
    
}
