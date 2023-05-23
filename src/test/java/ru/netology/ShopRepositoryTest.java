package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ShopRepositoryTest {
    @Test
    public void testProductExist0() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Ноутбук", 50000);
        Product product2 = new Product(2, "Диск", 500);
        Product product3 = new Product(3, "Телефон", 5000);
        Product product4 = new Product(4, "Салфетка", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3, product4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testProductNotExist0() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Ноутбук", 50000);
        Product product2 = new Product(2, "Диск", 500);
        Product product3 = new Product(3, "Телефон", 5000);
        Product product4 = new Product(4, "Салфетка", 50);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(5)
                );


    }
}