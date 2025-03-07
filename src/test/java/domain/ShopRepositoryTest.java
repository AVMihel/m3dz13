package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {

    @Test
    public void testRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        repository.add(product1);
        repository.add(product2);

        repository.remove(1);

        Product[] products = repository.findAll();

        // Проверка длины массива
        int expectedLength = 1;
        int actualLength = products.length;
        Assertions.assertEquals(expectedLength, actualLength);

        // Проверка ID оставшегося продукта
        int expectedId = 2;
        int actualId = products[0].getId();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    public void testRemoveNonExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        repository.add(product1);
        repository.add(product2);

        assertThrows(NotFoundException.class, () -> {
            repository.remove(3);
        });
    }
}
