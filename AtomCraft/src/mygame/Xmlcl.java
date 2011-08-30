/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;

import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author STABERAS
 * This is a xml parser it reads the file boxes.xml where the position of the objects are, since i am a noob in xml parsing 
 * i read it one by one the float values, transform them to new float value and then save them in a float array which i return.
 * 
 * 
 */
public class Xmlcl {       
         
    ArrayList<Float> al = new ArrayList<Float>();

            
public class small{
    
    
   public void innersmall(){
       
          try{
                              
     SAXParserFactory factory = SAXParserFactory.newInstance();
     SAXParser saxParser = factory.newSAXParser();
 
     DefaultHandler handler = new DefaultHandler() {
   // create an array list
       	//al here


              boolean posname = false; 
              
              
                    @Override
     public void startElement(String uri, String localName,
        String qName, Attributes attributes)
        throws SAXException {
       
              if (qName.equalsIgnoreCase("Position")) {
		 posname = true;
              
                
	   }
 
     }
 
                @Override
     public void endElement(String uri, String localName,
          String qName)
          throws SAXException {
 
     
         
 
     }
 
                @Override
                
     public void characters(char ch[], int start, int length)
         throws SAXException {
 

			if (posname) {
	//-			System.out.println("value : "
        //-                     + new String(ch, start, length));
                    
			String vcc = new String(ch, start, length);
                            Float fl = new Float(vcc); 
                            al.add(fl);
                            posname = false;
			}
         
 
        }
                 
      //-   public ArrayList al1(){
          //   ArrayList al = new ArrayList;
    //-                 return al;
    //-     }           
                
      };
     
      saxParser.parse("C:/Users/STABERAS/jMonkeyProjects/AtomCraft/src/mygame/boxes.xml", handler);
           
    } catch (Exception e) {
      e.printStackTrace();
    }
    }
   
    //This is the part where the xml values are transform into Flaot an then are inserted into float arrays.
       public ArrayList<Vector3f> al1(){
               Vector3f alx = new Vector3f();  
          //   ArrayList al = new ArrayList;
          //   ArrayList<Float> alx = new ArrayList<Float>();
               ArrayList<Vector3f> al2 = new ArrayList<Vector3f>();
               
           innersmall();
           int b=0;
           int c=1;
           int d=2;
           int m=al.size();               
           
           m=m/3;
          
           for(int v=0; v<m; v++){
               //Adds the float al array into the Float . Then i add the into the "old" float (due to incompatibillity in the code) 
               //Then add them into the new array.

            Float fObj  = al.get(b);
            Float fObj1 = al.get(c);
            Float fObj2 = al.get(d);

            float f = fObj.floatValue();
            float f1 = fObj1.floatValue();
            float f2 = fObj2.floatValue();

            al2.add(alx.add(f, f1, f2));
                        
               b=b+3;
               c=c+3;
               d=d+3;
         }
          
         return al2;
       }    
} 
    
}
