package uk.co.andygibson.blog.jackson.introToSerializers.model;

public class Pet {

  private final String name;

  public Pet(final String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
