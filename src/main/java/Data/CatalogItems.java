package Data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CatalogItems {




    private String name;
    private String description;
    private int rating;

    public CatalogItems(String name,String description,int rating){

        this.name=name;
        this.description=description;
        this.rating=rating;

    }


}
