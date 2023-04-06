package Data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryItems {

//    public CategoryItems(String name,String description,int rating){
//
//        this.name=name;
//        this.description=description;
//        this.rating=rating;
//
//    }


    private String name;
    private String description;
    private int rating;


}
