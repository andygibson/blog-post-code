package uk.co.andygibson.blog.terrain.proc.part1;


import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class Main extends SimpleApplication {
 
  public static void main(final String[] args) {
    final Main app = new Main();
    app.start();
  }
 
  @Override
  public void simpleInitApp() {
   
    // move up, to the side and look at the origin
    getCamera().setLocation(new Vector3f(-4, 5, 10));
    getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
   
    // lets put some light in
    final DirectionalLight sun = new DirectionalLight(new Vector3f(0.2f, -0.6f, -0.5f).normalize());
    sun.setColor(ColorRGBA.White);
    rootNode.addLight(sun);
   
    // create a simple box
    final Box b = new Box(1, 1, 1);
    final Geometry geom = new Geometry("Box", b);
   
    // create a very plain lit material
    final Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
   
    // assign this material to the box geometry.
    geom.setMaterial(mat);
   
    // add the geometry to the scene and we are good to go
    rootNode.attachChild(geom);
  }  
}