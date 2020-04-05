package uk.co.andygibson.blog.terrain.proc.part2;

import com.jme3.terrain.noise.basis.ImprovedNoise;

public interface HeightProvider {
  
  /**
   * Return the height of the map at a given x,y point.
   */
  public float getHeight(float x, float y);
 
  /**
   * Scale out the x,y co-ords, i.e. spread the map out further
   */
  public default HeightProvider scale(float scale) {
    return (x, y) -> this.getHeight(x * scale, y * scale);
  }
 
  /**
   * Multiply the height so we get taller points 
   */
  public default HeightProvider mul(float mul) {
    return (x, y) -> this.getHeight(x, y) * mul;
  }
  
  public default HeightProvider sq() { 
    return (x, y) -> {
      float v = this.getHeight(x, y);
      return v*v;
    };
  }
  
 
  /**
   * Create a height provider based on the JME noise functions.
   */
  public static HeightProvider noise() {
    return (x, y) -> ImprovedNoise.noise(x, y, 87);
  }
  
  public default float[] toFloats(float x, float y, int size) {
    final float[] heightData = new float[size * size];
    for (int ix = 0; ix < size; ix++) {
      for (int iy = 0; iy < size; iy++) {
        heightData[(ix * size) + iy] = getHeight(x + ix, y + iy);
      }
    }
    return heightData;
  }  
}