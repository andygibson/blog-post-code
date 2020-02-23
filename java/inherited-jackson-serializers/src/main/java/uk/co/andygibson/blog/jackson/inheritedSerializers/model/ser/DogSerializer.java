package uk.co.andygibson.blog.jackson.inheritedSerializers.model.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import uk.co.andygibson.blog.jackson.inheritedSerializers.model.Dog;

public class DogSerializer extends PetSerializer<Dog> {

  private static final long serialVersionUID = 1L;

  public DogSerializer() {
    super(Dog.class);
  }

  @Override
  protected void doWriteProperties(final Dog value, final JsonGenerator gen, final SerializerProvider provider)
      throws IOException {
    super.doWriteProperties(value, gen, provider);
    gen.writeStringField("size", value.getSize().toString());
  }
}
