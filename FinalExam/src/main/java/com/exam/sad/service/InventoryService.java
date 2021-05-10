package com.exam.sad.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.sad.Dao.ProductDao;

@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryService {

    private final ProductDao product;
    @Autowired
    ProductService pService;

    @Transactional(readOnly = true)
    public void DeductStock(int id, int order) {
        try {
            pService.calculateStock(product.getOne(null), order);
        } catch (ObjectOptimisticLockingFailureException e) {
            log.warn("Somebody has already updated the amount for item:{} in concurrent transaction. Will try again...", id);
            pService.calculateStock(product.findProductForRead(null), order);
        }
    }

}