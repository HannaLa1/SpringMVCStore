package spring.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.application.entity.Product;
import spring.application.service.StoreService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StoreController {
    private StoreService storeService;

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<Product> products = storeService.getAllProducts();
        model.addAttribute("productsList", products);
        return "products";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        Product product = storeService.getProductById(id);
        model.addAttribute("product", product);
        return "editPage";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") @Valid Product product,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors())
        {
            return "editPage";
        }

        if (storeService.checkName(product.getName()) || storeService.getProductById(product.getId()).getName().equals(product.getName())) {
            storeService.editProduct(product);
        }
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage() {
        return "editPage";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") @Valid Product product,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "editPage";
        }

        storeService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        Product product = storeService.getProductById(id);
        storeService.deleteProduct(product);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String filterByPricePage() {
        return "filterPage";
    }

    @PostMapping("/filter")
    public String filterByPrice(@ModelAttribute("from") int from,
                                @ModelAttribute("to") int to, Model model) {
        List<Product> products = storeService.filterByPrice(from, to);

        if(products.isEmpty() || from >= to){
            return "errorPage";
        }

        model.addAttribute("productsList", products);
        return "showProductsPage";
    }

    @GetMapping("/sortPriceIncreasing")
    public String sortPriceIncreasing(Model model) {
        List<Product> products = storeService.sortPriceIncreasing();;

        if(products.isEmpty()){
            return "errorPage";
        }

        model.addAttribute("productsList", products);
        return "showProductsPage";
    }

    @GetMapping("/sortPriceDecreasing")
    public String sortPriceDecreasing(Model model) {
        List<Product> products = storeService.sortPriceDecreasing();;

        if(products.isEmpty()){
            return "errorPage";
        }

        model.addAttribute("productsList", products);
        return "showProductsPage";
    }

    @GetMapping("/sortByOrder")
    public String sortByOrder(Model model) {
        List<Product> products = storeService.sortByOrder();

        if(products.isEmpty()){
            return "errorPage";
        }

        model.addAttribute("productsList", products);
        return "showProductsPage";
    }

    @PostMapping("/find")
    public String findProduct(@ModelAttribute("name") String name, Model model) {
        List<Product> products = storeService.findProduct(name);

        if(products.isEmpty()){
            return "errorPage";
        }

        model.addAttribute("productsList", products);
        return "showProductsPage";
    }
}
