/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;
import com.jme3.math.Vector3f;
import java.util.ArrayList;


/**
 *
 * @author STABERAS
 * 
 * Test button 1 , If there isnt a collision (nocollision) , will search if in there is somenthing around the position 10 "meters" infront of the camera.
 * Also 
*/

public class Testbutton1 {
    
    boolean firstime=true; 
    boolean nearbox=false;

    //- ArrayList al; 
    
    public void nocollision(Vector3f cameraposition, float areaofeffect){
        //thirtyplus -> cameraposition
        
        //xml parse save values here
        
        Xmlcl method = new Xmlcl();
            
        Xmlcl.small method2 = method.new small();

        ArrayList<Vector3f> al1 = method2.al1();
   
        System.out.println("Array values test button1: " +al1);
         
      //http://www.javalobby.org/java/forums/t93816.html
      //convert arraylist to array
       Object array[] = al1.toArray();
      
       
       
       for (int i=0; i<al1.size(); i++){
            System.out.println("------------testbutton1---------");
            System.out.println("for i =  " +i);

            System.out.println("al1.get =  " +al1.get(i));
            
            Vector3f vctor = al1.get(i);
              
            System.out.println("camera position  " +cameraposition);
            float dist = al1.get(i).distanceSquared(cameraposition);
            System.out.println("distancesquared  " +dist);
                            
              //if  distance < area of affect tool..
            if (dist<=areaofeffect){
              if(firstime==true){
                  //lastboxpost
                 Vector3f lastboxbox = cameraposition;
                  //add elements from list scene
                 firstime=false;
                 nearbox=true; 
                  
                  
              }
              if(nearbox==true){
                  //add box element to lastbox
                  //remove box 
                  
                  
                  
              }
            } 
              
       }
        
       
       
       
    }
    
 }
