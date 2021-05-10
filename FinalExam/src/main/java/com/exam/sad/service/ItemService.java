/*package com.exam.sad.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.sad.Dao.ProductDao;
import com.exam.sad.model.Product;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ProductDao product;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void incrementAmount(String id, int amount) {
        Product item = product.getOne(id).orElseThrow(EntityNotFoundException::new);
        product.setAmount(item.getPrice() + amount);
    }

}
*/