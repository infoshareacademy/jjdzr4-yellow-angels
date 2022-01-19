package pl.infoshare.repository;

import pl.infoshare.model.*;

import java.util.List;
import java.util.Optional;

public interface ItemComponentRepository {
    List<Item> getAllItems();
    List<Pack> getAllPacks();
    List<ItemComponent> getAll();
    List<Category> getAllCategories();
    List<Producer> getAllProducers();
    void saveItem(Item item);
    void savePack(Pack pack);
    Optional<Item> getItemById(int id);
    Optional<Pack> getPackById(int id);
    Optional<Category> getCategoryById(int id);
    Optional<Producer> getProducerById(int id);
}
