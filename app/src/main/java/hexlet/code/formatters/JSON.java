package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.InnerRep;

import java.util.List;

public class JSON {

    public static String format(List<InnerRep> tree) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(tree);
    }
}
