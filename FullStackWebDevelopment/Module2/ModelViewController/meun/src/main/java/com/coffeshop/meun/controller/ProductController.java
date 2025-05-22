package com.coffeshop.meun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coffeshop.meun.model.Product;

import java.util.List;

@Controller // This annotation tells Spring that ProductController is a controller, allowing it to handle web requests.
@RequestMapping("/products") // This means all URLs start with http://localhost:8080/products/
public class ProductController {
    private List<Product> productsList = List.of(
            new Product(1, "Espresso", 2.50),
            new Product(2, "Latte", 3.50),
            new Product(3, "Croissant", 2.00),
            new Product(4, "Chocolate Muffin", 2.25),
            new Product(5, "Americano", 2.75)
    );

    @RequestMapping("/") // This maps to the URL http://localhost:8080/products/
    @ResponseBody // The @ResponseBody annotation directs Spring Boot to send the returned string directly as an HTTP response.
    public String home() { // The method returns a message as a String, displaying plain text in the browser.
        return "Welcome to the Coffee Shop!";
    }

    @RequestMapping("/list2") // This maps to the URL http://localhost:8080/products/list
    @ResponseBody // annotation directs the response to be sent directly to a web page, allowing you to include HTML tags to format the output.
    // This method runs when the user hits the URL http://localhost:8080/products/list.
    public String listProducts() {
        String productDisplay = "<strong>Product List:</strong> <hr>";  // The <strong> tag here makes the text bold.
                                                                        // The <hr> tag adds a horizontal line after the text.
        for (Product product : productsList) {
            productDisplay += "Product: " + product.getId() + " - " + product.getName() + " - $" + product.getPrice() + "<br>";
        }
        return productDisplay;
    }

    @RequestMapping("/list") // This maps to the URL http://localhost:8080/products/list
    public String listProducts(Model productListModel) { // Model argument is used to pass data to the view
        productListModel.addAttribute("products", productsList); // Add the productsList to the model
        return "menu";  // This returns the view name, that is, the JSP file name
    }

    @RequestMapping("/details/{id}") // This maps to the URL http://localhost:8080/products/details/{id}
    @ResponseBody
    // This method is accessible at http://localhost:8080/products/details/{id}, where {id} is the specific product ID to be written without the curly braces.
    public String getProductDetailsByID(@PathVariable int id){ // @PathVariable extract the {id} from the URL
        for (Product product : productsList) {
            if (product.getId() == id) {
                return "<strong>Requested Product Details: </strong> <hr> Product ID: " + product.getId() + "<br> Name: " + product.getName() + "<br> Price: $" + product.getPrice();
            }
        }
        return "Product not found!";
    }
}
