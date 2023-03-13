package service;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "book1", 100000, "best seller of month", "tuoi tre"));
        productList.put(2, new Product(2, "book2", 500000, "best seller of Year", "Tien Phong"));
        productList.put(3, new Product(3, "book3", 200000, "best seller of Day", "Hoa Học tro"));
        productList.put(4, new Product(4, "book4", 300000, "best seller of Year", "Tuoi tre"));
        productList.put(5, new Product(5, "book5", 600000, "best seller of month", "Giao duc"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(Product product, int id) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product search(String name) {
        for (Map.Entry<Integer,Product> entry : productList.entrySet()){
            if(name.equals(entry.getValue().getName())){
                return entry.getValue();
            }
        }
        return new Product();
    }
}
