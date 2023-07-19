import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataColumn extends TableElement{
    private String name;
    public String getName(){
        return name;
    }
    public DataColumn(Collection<String> elements, String name){
        super(elements);
        this.name = name;
    }
}
