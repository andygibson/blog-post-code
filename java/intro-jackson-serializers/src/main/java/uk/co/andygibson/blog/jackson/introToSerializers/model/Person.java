package uk.co.andygibson.blog.jackson.introToSerializers.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

  private final String firstName;
  private final String lastName;
  private final List<Pet> pets = new ArrayList<>();

  public Person(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public Person addPet(final Pet pet) {
    pets.add(pet);
    return this;
  }

}
