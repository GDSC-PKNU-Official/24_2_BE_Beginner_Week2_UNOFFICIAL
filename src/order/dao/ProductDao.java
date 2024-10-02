package order.dao;

import common.Category;
import order.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ProductDao {
    private static final String DELIMITER = ",";
    private static final String DATA_PATH = "resource";
    private static final String DATA_FILE_NAME = "productList.csv";

    private void readProductData(List<Product> productList) {
        String dataFilePath = DATA_PATH + "/" + DATA_FILE_NAME;
        InputStream inputStream = ProductDao.class.getResourceAsStream(dataFilePath);
        if(inputStream == null){
            System.err.println("No data in " + dataFilePath);
            return;
        }
        String[] args;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            int increment = 0;
            while ((line = bufferedReader.readLine()) != null){
                increment++;
                if(increment < 3) continue;
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
                double price = Double.parseDouble(args[4].trim());
                int stock = Integer.parseInt(args[5].trim());
                Product product = new Product(id, name, category, brand, price, stock);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
