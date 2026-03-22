package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Objects;
import java.util.TreeSet;

public class TreeBuilder {

    public static List<InnerRep> buildTree(Map<String, Object> data1, Map<String, Object> data2) {

        List<InnerRep> innerReps = new ArrayList<>();

        Set<String> keys = new TreeSet<>((data1.keySet()));
        keys.addAll(data2.keySet());

        for (String key : keys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (!data1.containsKey(key)) {
                innerReps.add(new InnerRep(key, "added", null, value2, null));
            } else if (!data2.containsKey(key)) {
                innerReps.add(new InnerRep(key, "deleted", value1, null, null));
            } else if (value1 instanceof Map && value2 instanceof Map) {
                Map<String, Object> map1 = (Map<String, Object>) value1;
                Map<String, Object> map2 = (Map<String, Object>) value2;

                List<InnerRep> children = buildTree(map1, map2);
                innerReps.add(new InnerRep(key, "nested", null, null, children));
            } else if (Objects.equals(value1, value2)) {
                innerReps.add(new InnerRep(key, "unchanged", value1, value2, null));
            } else {
                innerReps.add(new InnerRep(key, "changed", value1, value2, null));
            }
        }
            return innerReps;
        }
    }
