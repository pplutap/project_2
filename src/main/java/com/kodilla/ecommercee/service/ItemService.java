package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    public List<Item> getAllItems() {
        return Optional.ofNullable(itemRepository.findAll()).orElse(new ArrayList<>());
    }

    public List<Item> getAllItemsInCart(Cart cart) {
        return itemRepository.findByCart(cart);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
