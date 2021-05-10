package com.exam.sad;

import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.SpyBean;

import com.exam.sad.Dao.ProductDao;
import com.exam.sad.service.InventoryService;
import com.exam.sad.service.ProductService;

import java.util.Arrays;
	import java.util.List;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	import java.util.concurrent.TimeUnit;

	import static org.junit.jupiter.api.Assertions.assertAll;
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertTrue;
	import static org.mockito.ArgumentMatchers.anyInt;
	import static org.mockito.ArgumentMatchers.anyString;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;

	@SpringBootTest
	public class OptimisticLockingTest { 

	    @Autowired
	    private ProductService pService;

	    @Autowired
	    private ProductDao product;
	    
	    @Autowired
	    private InventoryService iService;

	    private final List<Integer> itemAmounts = Arrays.asList(10, 5);

	    @Test
	    void shouldIncrementItemAmount_withoutConcurrency() {
	        // given
	        final Product srcItem = product.save();
	        assertEquals(0, srcItem.getVersion());

	        // when
	        for (final int amount : itemAmounts) {
	            iService.incrementProductAmount(srcItem.getId(), amount);
	        }

	        // then
	        final Product item = product.findById(srcItem.getId()).orElseThrow(() -> new IllegalArgumentException("No item found!"));

	        assertAll(
	                () -> assertEquals(2, item.getVersion()),
	                () -> assertEquals(15, item.getAmount()),
	               // () -> verify(iService, times(2)).incrementAmount(anyString(), anyInt())
	        );
	    }

	    @Test
	    void shouldIncrementItemAmount_withOptimisticLockingHandling() throws InterruptedException {
	        // given
	        final Item srcItem = product.save(new Item());
	        assertEquals(0, srcItem.getVersion());

	        // when
	        final ExecutorService executor = Executors.newFixedThreadPool(itemAmounts.size());

	        for (final int amount : itemAmounts) {
	            executor.execute(() -> inventoryService.incrementProductAmount(srcItem.getId(), amount));
	        }

	        executor.shutdown();
	        assertTrue(executor.awaitTermination(1, TimeUnit.MINUTES));

	        // then
	        final Item item = itemRepository.findById(srcItem.getId()).orElseThrow(() -> new IllegalArgumentException("No item found!"));

	        assertAll(
	                () -> assertEquals(2, item.getVersion()),
	                () -> assertEquals(15, item.getAmount()),
	                () -> verify(itemService, times(3)).incrementAmount(anyString(), anyInt())
	        );
	    }
	}
}
