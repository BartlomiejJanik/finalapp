package pl.sda.finalapp.app;

/* domenowy model danych */
public class Category {
    private Integer id;
    private Integer parentId;
    private String categoryName;
    private Integer depth;
    private static Integer idCounter = 0;


    public static Category applyFromText(String t){
        Category category = new Category();
        category.categoryName = t.trim();
        category.id = ++idCounter;
        category.depth = calculateDepth(t);
        return category;
    }

    private static int calculateDepth(String t) {
        if(!t.startsWith(" ")){
            return 0;
        }
        return t.split("\\S+")[0].length();
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getDepth() {
        return depth;
    }

    public CategoryDTO toDTO(){
        return new CategoryDTO(id, parentId,categoryName);
    }
}