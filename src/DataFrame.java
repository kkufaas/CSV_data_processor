import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFrame {
    private final List<String> header;
    private List<DataRow> rows;
    private Map<String,DataColumn> columns;

    public List<String> getHeader(){
        return header;
    }

    public DataRow getData(int index){
        return rows.get(index);
    }

    public DataColumn getColumn(String name){
        return columns.get(name);
    }

    public DataFrame (List<String> header, List<List<String>> data){
        this.header = new ArrayList<>(header);
        createRows(data);
        createColumns();
    }

    private void createRows(List<List<String>> data) {
        this.rows = new ArrayList<>();
        for (List<String> datum : data) {
            this.rows.add(new DataRow(datum));
        }
    }

    private void createColumns(){
        this.columns = new HashMap<>();
        for (int i = 0; i < header.size(); i++) {
            ArrayList<String> column = new ArrayList<>();
            for (DataRow row : rows) {
                column.add(row.getElement(i));
            }
            columns.put(header.get(i),new DataColumn(column, header.get(i)));
        }
    }
}



