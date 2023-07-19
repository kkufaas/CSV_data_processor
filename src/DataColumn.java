import java.util.Collection;

public class DataColumn extends TableElement{
    private final String name;
    public String getName(){
        return name;
    }
    public DataColumn(Collection<String> elements, String name){
        super(elements);
        this.name = name;
    }
}
