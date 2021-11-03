package spring.application.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.application.entity.Product;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Repository
public class ProductDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        product.setLocaleDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        product.setLocaleTime(LocalTime.now());
        session.persist(product);
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product").list();
    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }

    public List<Product> filterByPrice(int from, int to) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product P where P.price between'" + from +
                "'and'" + to +"'order by P.price asc").list();
    }

    public List<Product> sortPriceDecreasing(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product P order by P.price desc").list();
    }

    public List<Product> sortPriceIncreasing() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product P order by P.price asc").list();
    }

    public List<Product> sortByOrder() {
        List<Product> products = getAllProducts();
        products.sort(Comparator.comparing(Product::getLocaleDate).thenComparing(Product::getLocaleTime).reversed());
        return products;
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        product.setLocaleDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        product.setLocaleTime(LocalTime.now());
        session.update(product);
    }

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    public boolean checkName(String name){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product where name = :name").setParameter("name", name).list().isEmpty();
    }

    public List<Product> findProduct(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product where name = :name").setParameter("name", name).list();
    }
}
