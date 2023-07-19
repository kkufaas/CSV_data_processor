import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TableElement {
    private final List<String> elements;
    public String getElement(int index){
        return elements.get(index);
    }

    public TableElement(Collection<String> elements){
        this.elements = new ArrayList<>(elements);
    }

}
