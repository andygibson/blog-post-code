package uk.co.andygibson.blog.jackson.introToSerializers.model.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import uk.co.andygibson.blog.jackson.introToSerializers.model.Person;

public class PersonSerializer extends StdSerializer<Person> {

  private static final long serialVersionUID = 1L;

  public PersonSerializer() {
    super(Person.class);
  }

  @Override
  public void serialize(final Person value, final JsonGenerator gen, final SerializerProvider provider)
      throws IOException {
    gen.writeStartObject();
    gen.writeStringField("firstName", value.getFirstName());
    gen.writeStringField("lastName", value.getLastName());
    gen.writeFieldName("pets");
    gen.writeObject(value.getPets());
    gen.writeEndObject();
  }
}