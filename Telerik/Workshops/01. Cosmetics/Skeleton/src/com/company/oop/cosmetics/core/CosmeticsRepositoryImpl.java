package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.Product;
import com.company.oop.cosmetics.models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class CosmeticsRepositoryImpl implements CosmeticsRepository {


    private final List<Product> products;
    private final List<Category> categories;
    private final ShoppingCart shoppingCart;

    public CosmeticsRepositoryImpl() {
        products = new ArrayList<>();
        categories = new ArrayList<>();

        shoppingCart = new ShoppingCart();
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }


    /**
     * Finds a product in the shopping cart by name.
     *
     * @param productName the name of the product to search for
     * @return the first product found with the given name
     * @throws IllegalArgumentException if no product is found with the given name
     * @author Petar Pechev
     */
    @Override
    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }

        throw new IllegalArgumentException("Product with this name does not exist");
    }


    /**
     * Searches for a category with the given name in the shopping cart's categories list.
     *
     * @param categoryName the name of the category to search for
     * @return the category object if found
     * @throws IllegalArgumentException if no category with the given name exists
     * @author Petar Pechev
     */
    @Override
    public Category findCategoryByName(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category;
            }
        }

        throw new IllegalArgumentException("Category with this name does not exist");
    }


    /**
     * Creates a new category with the given name if a category with the same name doesn't already exist.
     *
     * @param categoryName the name of the category to be created
     * @author Petar Pechev
     */
    @Override
    public void createCategory(String categoryName) {
        if (!categoryExist(categoryName)) {
            Category category = new Category(categoryName);

            categories.add(category);
        }
    }


    /**
     * Creates a new product and adds it to the shopping cart's list of products.
     *
     * @param name   the name of the product
     * @param brand  the brand of the product
     * @param price  the price of the product
     * @param gender the gender for which the product is intended
     *
     * @throws IllegalArgumentException if a product with the same name already exists
     *
     * @author Petar Pechev
     */
    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        if (!productExist(name)) {
            Product product = new Product(name, brand, price, gender);

            products.add(product);
        }
    }


    /**
     * Checks if a category with the given name exists in the list of categories.
     *
     * @param categoryName the name of the category to check
     *
     * @return true if a category with the given name exists, false otherwise
     *
     * @author Petar Pechev
     */
    @Override
    public boolean categoryExist(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return true;
            }

        }
        return false;
    }


    /**
     * Returns true if a product with the given name exists in the shopping cart, false otherwise.
     *
     * @param productName the name of the product to check for existence
     *
     * @return true if a product with the given name exists in the shopping cart, false otherwise
     *
     * @author Petar Pechev
     */
    @Override
    public boolean productExist(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
