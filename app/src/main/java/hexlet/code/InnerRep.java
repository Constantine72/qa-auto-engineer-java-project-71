package hexlet.code;

import java.util.List;

public final class InnerRep {

    private String name;
    private String type;
    private Object value1;
    private Object value2;
    private List<InnerRep> children;

    public InnerRep(String innerRepName, String innerRepType, Object val1,
                    Object val2, List<InnerRep> innerRepChildren) {

        this.name = innerRepName;
        this.type = innerRepType;
        this.value1 = val1;
        this.value2 = val2;
        this.children = innerRepChildren;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }

    public List<InnerRep> getChildren() {
        return children;
    }
}
