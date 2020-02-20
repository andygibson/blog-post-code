package uk.co.andygibson.blog.jackson.introToSerializers.model.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import uk.co.andygibson.blog.jackson.introToSerializers.model.Dog;
import uk.co.andygibson.blog.jackson.introToSerializers.model.Pet;
import uk.co.andygibson.blog.jackson.introToSerializers.model.Snake;

public class PetSerializer extends StdSerializer<Pet> {

  public PetSerializer() {
    super(Pet.class);
  }

  @Override
  public void serialize(final Pet value, final JsonGenerator gen, final SerializerProvider provider)
      throws IOException {
    gen.writeStartObject();

    gen.writeStringField("type", value.getClass().getSimpleName());
    gen.writeStringField("name", value.getName());

    if (value instanceof Snake) {
      gen.writeNumberField("length", ((Snake) value).getLength());
    }
    if (value instanceof Dog) {
      gen.writeStringField("size", ((Dog) value).getSize().toString());
    }
    gen.writeEndObject();
  }
}
