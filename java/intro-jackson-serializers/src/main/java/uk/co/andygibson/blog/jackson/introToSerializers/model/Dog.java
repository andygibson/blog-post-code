package uk.co.andygibson.blog.jackson.introToSerializers.model;

public class Dog extends Pet {

  public enum Size {
    SMALL, MEDIUM, LARGE
  };

  private final Size size;

  public Dog(final String name, final Size size) {
    super(name);
    this.size = size;
  }

  public Size getSize() {
    return size;
  }

}
