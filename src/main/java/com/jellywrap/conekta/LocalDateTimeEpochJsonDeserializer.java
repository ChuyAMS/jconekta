/**
 * 
 */
package com.jellywrap.conekta;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author Jesus Mata
 *
 */
public class LocalDateTimeEpochJsonDeserializer extends JsonDeserializer<LocalDateTime> {

    /*
     * (non-Javadoc)
     * 
     * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser,
     * com.fasterxml.jackson.databind.DeserializationContext)
     */
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctx) throws IOException, JsonProcessingException {

	return LocalDateTime.ofEpochSecond(jp.getLongValue(), 0, ZoneOffset.UTC);
    }

}
