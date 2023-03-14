package service;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    IProductRepository repository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Product product, int id) {
        repository.update(product, id);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public Product search(String name) {
        return repository.search(name);
    }
}
