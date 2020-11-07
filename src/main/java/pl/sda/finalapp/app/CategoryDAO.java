package pl.sda.finalapp.app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CategoryDAO { //data access object
    private static CategoryDAO INSTANCE;
    private List<Category> categoryList = populateCategories();

    private CategoryDAO() {
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public static CategoryDAO getInstance() {
        if (INSTANCE == null) {
            synchronized (CategoryDAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CategoryDAO();
                }
            }
        }
        return INSTANCE;
    }

    private List<Category> populateCategories() {
        List<String> categoryText;
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resourceURL = classLoader.getResource("categories.txt");
        try {
            categoryText = Files.readAllLines(Paths.get(resourceURL.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            categoryText = Collections.EMPTY_LIST;
        }


        List<Category> listCategories = categoryText.stream()
                .map(t -> Category.applyFromText(t))
                .collect(Collectors.toList());

        /*Map<Integer, List<Category>> categoriesMap = new HashMap<>();
        for (Category lc : ListCategories) {
            if (categoriesMap.containsKey(lc.getDepth())) {
                List<Category> innerList = categoriesMap.get(lc.getDepth());
                innerList.add(lc);
            } else {
                List<Category> innerList = new ArrayList<>();
                innerList.add(lc);
                categoriesMap.put(lc.getDepth(), innerList);
            }

        }*/
        Map<Integer, List<Category>> categoriesMap = listCategories
                .stream().collect(Collectors.groupingBy(e -> e.getDepth()));

        populateParentId(0, categoriesMap);


        return listCategories;
    }

    private void populateParentId(int depth, Map<Integer, List<Category>> categoriesMap) {
        List<Category> parents = categoriesMap.get(depth - 1);
        List<Category> children = categoriesMap.get(depth);
        if (children == null) {
            return;
        }
        if (depth > 0) {
            for (Category child : children) {
                Integer parentId = chooseParent(parents, child);
                child.setParentId(parentId);
            }
        }
        populateParentId(depth + 1, categoriesMap);

    }

    private Integer chooseParent(List<Category> parents, Category child) {
        Integer childId = child.getId();
        Integer parentId = parents.stream()
                .map(e -> e.getId())
                .filter(id -> id < childId)
                .sorted((a, b) -> b - a)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("nie znaleziono rodzica!"));
        return parentId;
    }
}
