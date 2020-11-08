package pl.sda.finalapp.app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/*data access object*/ /*SINGLETON*/
public class CategoryDAO {
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
        List<String> categoriesText;
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resourceURL = classLoader.getResource("categories.txt");

        try {
            categoriesText = Files.readAllLines(Paths.get(resourceURL.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            categoriesText = Collections.EMPTY_LIST;
        }

        List<Category> listCategories = categoriesText.stream()
                .map(t -> Category.applyFromText(t))
                .collect(Collectors.toList());

        Map<Integer, List<Category>> categoriesMap = listCategories.stream()
                .collect(Collectors.groupingBy(e -> e.getDepth()));

/*        for (Category lC : listCategories) {
            if (categoriesMap.containsKey(lC.getDepth())) {
                List<Category> innerList = categoriesMap.get(lC.getDepth());
                innerList.add(lC);
            } else {
                List<Category> innerList = new ArrayList<>();
                innerList.add(lC);
                categoriesMap.put(lC.getDepth(), innerList);
            }
        }*/

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
                chooseParent(parents, child);
            }
        }
        populateParentId(depth + 1, categoriesMap);

    }

    private void chooseParent(List<Category> parents, Category child) {
        Integer childId = child.getId();
        Integer parentId = parents.stream()
                .map(e -> e.getId())
                .filter(id -> id < childId)
                .sorted((a, b) -> b - a)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono rodzica"));
        child.setParentId(parentId);
    }
}
