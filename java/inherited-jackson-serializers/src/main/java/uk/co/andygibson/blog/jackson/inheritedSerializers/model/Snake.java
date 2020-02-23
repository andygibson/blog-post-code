package uk.co.andygibson.blog.jackson.inheritedSerializers.model;

public class Snake extends Pet {

  private final int length;

  public Snake(final String name, final int length) {
    super(name);
    this.length = length;
  }

  public int getLength() {
    return length;
  }

}
