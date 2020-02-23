package uk.co.andygibson.blog.jackson.inheritedSerializers.model.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import uk.co.andygibson.blog.jackson.inheritedSerializers.model.Pet;

public class PetSerializer<T extends Pet> extends ObjectSerializer<T> {

  private static final long serialVersionUID = 1L;

  public PetSerializer(final Class<T> clazz) {
    super(clazz);
  }

  @Override
  protected void doWriteProperties(final T value, final JsonGenerator gen, final SerializerProvider provider)
      throws IOException {
    // this could go in the subclass serializer if a more calculated value was needed.
    gen.writeStringField("type", value.getClass().getSimpleName());
    gen.writeStringField("name", value.getName());
  }
}
