package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product, int id);

    void remove(int id);

    Product search(String name);
}
