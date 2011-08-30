package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.SkyFactory;
import com.jme3.util.TangentBinormalGenerator;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * test
 * @author normenhansen
 * remove light and textures from boxes
 * add array of elements and more classes
 *
 */
public class Atomcraft extends SimpleApplication {

    
    
    public static void main(String[] args) {
      Xmlcl method = new Xmlcl();
      //System.out.println("Addition: " + method.add(1,41));
   //test remove look xmlcl
      //   method.small();
        Atomcraft app = new Atomcraft();      
        app.start();
        
    }

boolean redball = false;
//xml stuff
  //  List myEmpls;
  //  Document dom;
    
   // 
    //end of xml stuff

Testbutton1 Testbutton1 = new Testbutton1();
float areaofeffect = 0;
//method end

   
   BitmapText sizegui;
   protected Geometry player;
      Boolean isRunning=true;
      
      int p;
      int c;
       
    public float fnumber;
   
    public int boxer;
    public int boxer2;
    public Vector3f positionofcamera;
    public Vector3f lastpos = null;

    public Vector3f thirtyplus = new Vector3f(0,30,0);
       
   // Spatial sky;
            
    public void elements14() {
            
        int hydrogene;
        int helium;
        
    }
    //create a local library of elements 

   

    //int grav size
    public int gsize = 1;
    
    //Node jusi;
    Node sb;
    Node pivot;
    Node gasplanet;
    Node genert;
    Node oxi;
    Geometry mark;
  
    
    
    Mesh m = new Mesh();
   // public String hitman;
      
//no    private Nifty nifty;
   // Skybox sb;
        
    
    @Override
    public void simpleInitApp() {
       //Init player   
    Box b = new Box(Vector3f.ZERO, 1, 1, 1);
    player = new Geometry("Player", b);
    Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat.setColor("Color", ColorRGBA.Blue);
    player.setMaterial(mat);
    rootNode.attachChild(player);
    //init xml
     // initxml();
    
      initKeys(); // load my custom keybinding
//no      initsky();  
        
        
       // initCrossHairs(); // a "+" in the middle of the screen to help aiming
       // initKeys();       // load custom key mappings
        initMark();       // a red sphere to mark the hit
        
       	    //Add the skybox
        //initskybox();
      
        Box a1 = new Box( new Vector3f(-3,1,1), 1f,1f,1f);
        Geometry alpha1 = new Geometry("A1", a1);
        Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //Texture tex_ml = assetManager.loadTexture("Textures/moontexture.jpg");
        mat1.setColor("Color", ColorRGBA.Blue);
        alpha1.setMaterial(mat1);
        
        Box b1 = new Box( new Vector3f(-3,3,1), 1f,1f,1f);
        Geometry beta1 = new Geometry("B1", b1);
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //Texture tex_ml2 = assetManager.loadTexture("Textures/moontexture.jpg");
        mat2.setColor("Color", ColorRGBA.Red);
        beta1.setMaterial(mat2);

//no       NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
//no                                                      inputManager,
//no                                                       audioRenderer,
//no                                                      guiViewPort);
//no        nifty = niftyDisplay.getNifty();

       //nifty.fromXml("Interface/hellojme.xml", "start");

        // attach the nifty display to the gui view port as a processor 
 //no       guiViewPort.addProcessor(niftyDisplay);

        flyCam.setDragToRotate(true);
        
         // Display a line of text with a default font
        guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText helloText = new BitmapText(guiFont, false);
        helloText.setSize(guiFont.getCharSet().getRenderedSize());
        helloText.setText("AtomCraft version 0.0.1");
        helloText.setLocalTranslation(300, helloText.getLineHeight(), 0);
        guiNode.attachChild(helloText);
        
        
        
        //genarate 10 boxes
     //  generator();
        
        

        pivot = new Node("pivot");
        

        sb = new Node("sb");

        rootNode.attachChild(pivot);
    

          	// Attach the skybox to our root node, and force the rootnode to show
		// so that the skybox will always show
		//rootNode.attachChild(sb);
		//rootNode.setCullHint(Spatial.CullHint.Never);
         rootNode.attachChild(sb);
         
         userinterface();
         
          pivot.attachChild(alpha1);
          
          pivot.attachChild(beta1);
         
          //sky  
         /** 
        sky = (SkyFactory.createSky(
            assetManager, "Textures/stellar.png", false));
       sky.setLocalScale(100);
        rootNode.attachChild(sky);

                rootNode.setCullHint(CullHint.Never);
               
              //  rootNode.setQueueBucket(Bucket.Sky);
        
         // attach the two boxes to the *pivot* node!
     //   pivot.attachChild(alpha1);
    //    pivot.attachChild(beta1);
       
        
        // rotate pivot node: Both boxes have rotated!
         // pivot.rotate( 0.4f , 0.4f , 0.0f );
 */
    } 
    
    public void userinterface(){
      
      
        sizegui = new BitmapText(guiFont, false);
        sizegui.setSize(guiFont.getCharSet().getRenderedSize());
        sizegui.setText("Tool Size : "+ areaofeffect);
        sizegui.setLocalTranslation(500, sizegui.getLineHeight(), 0);
        guiNode.attachChild(sizegui); 
    }
    
    public void generator() {
        //the genarator will randomly generate numbers within a certain parameters 
        //those number will represent the number of quntity composition and postition of the elements.
        //
      c = 4; 
      
      //String[] o;
      // o = new String[10];
       //testing phase
      

      //end test
      genert = new Node("genert");
     
      
       for (int ol=1; ol<10;  ol++){
        Box o = new Box( new Vector3f(c,c,c), 1f,1f,1f);
        Geometry omikron = new Geometry("o", o);
        Material materia = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //Texture tex_ml = assetManager.loadTexture("Textures/moontexture.jpg");
        materia.setColor("Color", ColorRGBA.Blue);
        omikron.setMaterial(materia);
        c++;
        c++;
        
        pivot.attachChild(omikron);
       
       }
          rootNode.attachChild(genert);

    }
    
  


    
   
    
    

  /** Declaring the "Shoot" action and mapping to its triggers. */
  private void initKeys() {
      // You can map one or several inputs to one named action 
    inputManager.addMapping("Left",   new KeyTrigger(KeyInput.KEY_A));
    inputManager.addMapping("Right",  new KeyTrigger(KeyInput.KEY_D));
    inputManager.addMapping("Shoot",
    new KeyTrigger(KeyInput.KEY_SPACE), // trigger 1: spacebar
    new MouseButtonTrigger(0));         // trigger 2: left-button click
    inputManager.addListener(actionListener, "Shoot");
    inputManager.addMapping("Heat",  new KeyTrigger(KeyInput.KEY_M));
    inputManager.addListener(actionListener, "Heat");
    inputManager.addMapping("Ion",  new KeyTrigger(KeyInput.KEY_N));
    inputManager.addListener(actionListener, "Ion");
    inputManager.addListener(analogListener, new String[]{"Left", "Right"});
    //test 159 sizes
        inputManager.addListener(actionListener, "1");
    inputManager.addMapping("1",  new KeyTrigger(KeyInput.KEY_1));
        inputManager.addListener(actionListener, "5");
    inputManager.addMapping("5",  new KeyTrigger(KeyInput.KEY_5));
        inputManager.addListener(actionListener, "9");
    inputManager.addMapping("9",  new KeyTrigger(KeyInput.KEY_9));
                                              
  }
  
  
     /** Defining the "Shoot" action: Determine what was hit and how to respond. */
        private ActionListener actionListener = new ActionListener() {
          @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
              
               if (name.equals("1") && !keyPressed) {
               areaofeffect = 1;
               }
               if (name.equals("5") && !keyPressed) {
               areaofeffect = 5;
               }
               if (name.equals("9") && !keyPressed) {
               areaofeffect = 900;
               }
               
               
              //gravity
          if (name.equals("Shoot") && !keyPressed) {
        // 1. Reset results list.
        CollisionResults results = new CollisionResults();
        // 2. Aim the ray from cam loc to cam direction.
        Ray ray = new Ray(cam.getLocation(), cam.getDirection());
        // 3. Collect intersections between Ray and Shootables in results list.
        pivot.collideWith(ray, results);
        // 4. Print the results. 
        System.out.println("----- Collisions? " + results.size() + "-----");
        if (results.size()==0){
            
           Vector3f cameraposition = cam.getLocation();
           //-System.out.println("--->  " +cameraposition );
           //-System.out.println("--->  " +thirtyplus );
           thirtyplus.add(cameraposition, cameraposition);
           System.out.println("--->  " +areaofeffect );
            Testbutton1.nocollision(cameraposition, areaofeffect);
            
          // for 
            //thirtyplus.distanceSquared();
            
           //-System.out.println("---> Camera position y=+30 " +cameraposition );
           // System.out.println("--->  " +cameraposition );
        }
        for (int i = 0; i < results.size(); i++) {
          // For each hit, we know distance, impact point, name of geometry.
          float dist = results.getCollision(i).getDistance();
          Vector3f pt = results.getCollision(i).getContactPoint();
          String hit = results.getCollision(i).getGeometry().getName();
         
          System.out.println("* Collision #" + i);
       
          System.out.println("  You shot " + hit + " at " + pt + ", " + dist + " wu away.");
        }
        
        // 5. Use the results (we mark the hit object)
        if (results.size() > 0){
          // The closest collision point is what was truly hit:
          CollisionResult closest = results.getClosestCollision();
          // Let's interact - we mark the hit with a red dot.
          mark.setLocalTranslation(closest.getContactPoint());
          rootNode.attachChild(mark);
        } else {
        // No hits? Then remove the red mark.
          rootNode.detachChild(mark);
        }
      }
          
          
              
              //heat
          if (name.equals("Heat") && !keyPressed) {
          
     
                         
              
              
          }
          
          
          
          
              
              //ion
          if (name.equals("Ion") && !keyPressed) {
          
              
              
              
              
              
              
              
          
          }
          
          
          
          
          
          
          
          
          
          
    }
  };

        
//

        	
        
        
        
        
        
        
    private AnalogListener analogListener = new AnalogListener() {
    public void onAnalog(String name, float value, float tpf) {
      if (isRunning) {
        
        if (name.equals("Right")) {
          Vector3f v = player.getLocalTranslation();
          player.setLocalTranslation(v.x + value*speed, v.y, v.z);
        }
        if (name.equals("Left")) {
          Vector3f v = player.getLocalTranslation();
          player.setLocalTranslation(v.x - value*speed, v.y, v.z);
        }
      }
    }
  };
  
        
    /** A red ball that marks the last spot that was "hit" by the "shot". */
    protected void initMark() {
    Sphere sphere = new Sphere(30, 90, 0.2f);
    mark = new Geometry("BOOM!", sphere);
    Material mark_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mark_mat.setColor("Color", ColorRGBA.Red);
    mark.setMaterial(mark_mat);
  }
 

    public void initsky() {
       Spatial sky = SkyFactory.createSky(assetManager, "Textures/stellar.png", false);
       sky.setLocalScale(100);
       rootNode.attachChild(sky); 
        
    }
    
    protected void gasgiant() {
        //do a box check
      //  if (hitman=="A1"){
           //int boxer = 80;
           //int boxer2 = 50;
        Vector3f positionofcamera = cam.getLocation();
        int boxer = (int)positionofcamera.getX();
        int boxer2 = (int)positionofcamera.getY();
        boxer = 40+boxer ;
        boxer2 = 40+boxer2 ;
        System.out.println("position is : " + positionofcamera );
        System.out.println("position X is  : " + boxer + " and Y : " + boxer2 + " .!-");
     //   }
        
     //jupiter with lighting 
        Sphere jupi = new Sphere(40, 40, 1f);
        //Sphere jupi = new Sphere();
        Geometry jupiter = new Geometry("Jupiter", jupi);
        TangentBinormalGenerator.generate(jupi); 
        Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //Material mat3 = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat3.setTexture("ColorMap", assetManager.loadTexture("Textures/jupiter2_1k.jpg"));
        //DiffuseMap
        jupiter.setMaterial(mat3);
    //  mat3.setFloat("Shininess", 300f); 
        
    //   DirectionalLight sun = new DirectionalLight();
    //   sun.setDirection(new Vector3f(80,80, 5).normalizeLocal());
        
    //   sun.setColor(ColorRGBA.White);
   //    rootNode.addLight(sun);
        gasplanet = new Node("gasplanet");
        rootNode.attachChild(gasplanet);
        gasplanet.attachChild(jupiter);
        gasplanet.move(positionofcamera); 
    }
    
   

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        Vector3f positionofcamera = cam.getLocation();
        int boxer = (int)positionofcamera.getX();
        int boxer2 = (int)positionofcamera.getY();
                   
        
       
        //System.out.println("position is : " + positionofcamera );
        //System.out.println("position X is  : " + boxer + " and Y : " + boxer2 + " .");
                
       
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
        
          
    }
}
