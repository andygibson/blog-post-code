package uk.co.andygibson.blog.jackson.inheritedSerializers.model.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import uk.co.andygibson.blog.jackson.inheritedSerializers.model.Snake;

public class SnakeSerializer extends PetSerializer<Snake> {

  private static final long serialVersionUID = 1L;

  public SnakeSerializer() {
    super(Snake.class);
  }

  @Override
  protected void doWriteProperties(final Snake value, final JsonGenerator gen, final SerializerProvider provider)
      throws IOException {
    super.doWriteProperties(value, gen, provider);
    gen.writeNumberField("length", value.getLength());
  }
}
