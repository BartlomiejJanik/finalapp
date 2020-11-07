package pl.sda.finalapp.app;

// domenowy model danych
public class Category {
    private Integer id;
    private Integer parentId;
    private String categoryName;
    private Integer depth;
    private static Integer idCounter = 0;

    public static Category applyFromText(String text) {
        Category category = new Category();
        category.categoryName = text.trim();
        category.id = ++idCounter;
        category.depth = calculateDepth(text);
        return category;
    }

    private static int calculateDepth(String text) {
        if (!text.startsWith(" ")) {
            return 0;
        }
        return text.split("\\S+")[0].length();
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

    public static Integer getIdCounter() {
        return idCounter;
    }
}
