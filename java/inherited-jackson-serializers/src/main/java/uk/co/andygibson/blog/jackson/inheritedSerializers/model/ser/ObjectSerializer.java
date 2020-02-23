package uk.co.andygibson.blog.jackson.inheritedSerializers.model.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public abstract class ObjectSerializer<T> extends StdSerializer<T> {

  private static final long serialVersionUID = 1010180664348395817L;

  public ObjectSerializer(final Class<T> t) {
    super(t);
  }

  @Override
  public void serialize(final T value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeStartObject();
    doWriteProperties(value, gen, provider);
    gen.writeEndObject();
  }

  /**
   * Override this to write properties to the json generator for the value object passed in.
   *
   */
  protected abstract void doWriteProperties(final T value, final JsonGenerator gen, final SerializerProvider provider)
      throws IOException;
}
