package uk.co.andygibson.blog.terrain.proc.part2;


import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.terrain.geomipmap.TerrainQuad;

public class Main extends SimpleApplication {
  
  private static final int MAP_SIZE = 513;
  private static final int TILE_SIZE = 65;

  public static void main(final String[] args) {
    final Main app = new Main();
    app.start();
  }

  @Override
  public void simpleInitApp() {

    // set how fast WASD keys move us over the landscape.
    flyCam.setMoveSpeed(10);

    // move up, to the side and look at the origin
    getCamera().setLocation(new Vector3f(0, 12, 30));
    getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);

    // lets put some light in
    final DirectionalLight sun = new DirectionalLight(new Vector3f(0.2f, -0.6f, -0.5f).normalize());
    sun.setColor(ColorRGBA.White);
    rootNode.addLight(sun);

    final Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        
    final HeightProvider provider = HeightProvider.noise().scale(0.1f).mul(3).sq();
    final float[] data = provider.toFloats(0, 0, MAP_SIZE);
    final TerrainQuad q = new TerrainQuad("terrain", TILE_SIZE, MAP_SIZE, data);
    q.setMaterial(mat);
    
    rootNode.attachChild(q);
  }
}
