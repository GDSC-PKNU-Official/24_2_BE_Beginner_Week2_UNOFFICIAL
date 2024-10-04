package product;

import common.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String DELIMITER = ",";
    private static final String DATA_PATH = "../../resources";
    private static final String DATA_FILE_NAME = "productList.csv";
    private static final List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        readProductData();
        return productList;
    }

    private void readProductData() {
        String dataFilePath = DATA_PATH + "/" + DATA_FILE_NAME;
        InputStream inputStream = ProductDao.class.getResourceAsStream(dataFilePath);
        if(inputStream == null){
            System.err.println("No data in " + dataFilePath);
            return;
        }
        String[] args;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){
            String line;
            boolean isCaption = true;
            while ((line = bufferedReader.readLine()) != null){
                if(isCaption){
                    isCaption = false;
                    continue;
                }
                args = line.split(DELIMITER);
                long id = Long.parseLong(args[0].trim());
                Category category = null;
                for (Category categoryE : Category.values()) {
                    if(categoryE.name().equalsIgnoreCase(args[1].trim())){
                        category = categoryE;
                        break;
                    }
                }
                if(category == null) category = Category.NO_CATEGORY;
                String name = args[2].trim();
                String brand = args[3].trim();
                int price = Integer.parseInt(args[4].trim());
                int stock = Integer.parseInt(args[5].trim());

                productList.add(new Product(id, name, category, brand, price, stock));
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
