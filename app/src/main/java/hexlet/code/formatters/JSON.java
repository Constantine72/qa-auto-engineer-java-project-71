package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import hexlet.code.InnerRep;

import java.util.List;

public final class JSON {

    private JSON() {
        throw new IllegalStateException("Utility class");
    }

    public static String format(List<InnerRep> tree) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(tree);
    }
}
