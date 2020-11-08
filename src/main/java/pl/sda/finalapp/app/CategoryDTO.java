package pl.sda.finalapp.app;

public class CategoryDTO {
    private Integer id;
    private Integer parentId;
    private String categoryName;
    private CategoryState state;

    public CategoryDTO(Integer id, Integer parentId, String categoryName) {
        this.id = id;
        this.parentId = parentId;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return categoryName;
    }

    public String getParent() {
        if (parentId == null) {
            return "#";
        } else {
            return String.valueOf(parentId);
        }
    }

    public CategoryState getState(){
        if(state == null){
            return new CategoryState(false, false);
        }
        return state;
    }


}
