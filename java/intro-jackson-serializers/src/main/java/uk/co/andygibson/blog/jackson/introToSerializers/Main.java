package uk.co.andygibson.blog.jackson.introToSerializers;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;

import uk.co.andygibson.blog.jackson.introToSerializers.model.Dog;
import uk.co.andygibson.blog.jackson.introToSerializers.model.Person;
import uk.co.andygibson.blog.jackson.introToSerializers.model.Snake;
import uk.co.andygibson.blog.jackson.introToSerializers.model.ser.PersonSerializer;
import uk.co.andygibson.blog.jackson.introToSerializers.model.ser.PetSerializer;

public class Main {

  public static void main(final String[] args) throws JsonProcessingException {
    final ObjectMapper objectMapper = new ObjectMapper();
    final SimpleModule module = new SimpleModule("mySerializers");
    module.addSerializer(new PersonSerializer());
    module.addSerializer(new PetSerializer());
    objectMapper.registerModule(module);

    // build our models
    final Person p1 = new  Person("John", "Dolittle")
        .addPet(new Dog("Fido", Dog.Size.SMALL))
        .addPet(new Snake("Kaa", 489));

    final Person p2 = new Person("Tom", "Riddle").addPet(new Snake("Nagini", 489));

    final Collection<Person> people = new ArrayList<>();
    people.add(p1);
    people.add(p2);

    // now write the json
    System.out.println("people unformatted is:\n" + objectMapper.writeValueAsString(people));

    // grab the pretty printer and store it
    final ObjectWriter prettyWriter = objectMapper.writerWithDefaultPrettyPrinter();

    // now write formatted json
    System.out.println("people are :\n" + prettyWriter.writeValueAsString(people));
    System.out.println("p1 is :\n" + prettyWriter.writeValueAsString(p1));
    System.out.println("p2 is :\n" + prettyWriter.writeValueAsString(p2));
    System.out.println("p2.pet(0) is :\n" + prettyWriter.writeValueAsString(p2.getPets().get(0)));
  }
}
