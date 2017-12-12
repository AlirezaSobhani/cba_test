package alirezasobhani.example.com.cba.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GsonFactory {

    public final static Gson getGsonInstance() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new GsonDateSerializerDeserializer())
                .create();
    }

    private final static class GsonDateSerializerDeserializer implements JsonDeserializer<Date> {

        private final String[] DATE_FORMATS = new String[]{
                "dd/MM/yyyy"
        };

        @Override
        public Date deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context) {

            for (String format : DATE_FORMATS) {
                try {
                    return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
                } catch (ParseException ignoreException) {

                }
            }
            return null;
        }
    }
}
