package spring.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.application.entity.Product;
import spring.application.repository.ProductDAO;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StoreService {
    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Transactional
    public void deleteProduct(Product product) {
        productDAO.deleteProduct(product);
    }

    @Transactional
    public List<Product> filterByPrice(int from, int to) {
        return productDAO.filterByPrice(from, to);
    }

    @Transactional
    public List<Product> sortPriceDecreasing(){
        return productDAO.sortPriceDecreasing();
    }

    @Transactional
    public List<Product> sortPriceIncreasing() {
        return productDAO.sortPriceIncreasing();
    }

    @Transactional
    public List<Product> sortByOrder() {
        return productDAO.sortByOrder();
    }

    @Transactional
    public void editProduct(Product product) {
        productDAO.editProduct(product);
    }

    @Transactional
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Transactional
    public boolean checkName(String name) {
        return productDAO.checkName(name);
    }

    @Transactional
    public List<Product> findProduct(String name) {
        return productDAO.findProduct(name);
    }
}
