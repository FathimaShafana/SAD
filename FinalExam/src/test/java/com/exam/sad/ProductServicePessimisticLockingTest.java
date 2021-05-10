package com.exam.sad;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.exam.sad.Dao.ProductDao;
import com.exam.sad.model.Product;
import com.exam.sad.service.LockingService;
import com.exam.sad.service.ProductService;

import java.util.Arrays;
	import java.util.List;
	import java.util.UUID;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	import java.util.concurrent.TimeUnit;

	import static org.junit.jupiter.api.Assertions.assertAll;
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertThrows;
	import static org.junit.jupiter.api.Assertions.assertTrue;
	import static org.mockito.ArgumentMatchers.any;
	import static org.mockito.ArgumentMatchers.anyInt;
	import static org.mockito.Mockito.doAnswer;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	@SpringBootTest
	@ActiveProfiles("test")
	//@ActiveProfiles("test-mysql")
	@Slf4j
	class InventoryServicePessimisticLockingTest {

	    @Autowired
	    private ProductDao product;

	    @Autowired
	    private ProductService pService;
	    
	    @Autowired
	    private LockingService lService;

	    @Autowired
	    private PlatformTransactionManager transactionManager;

	    @AfterEach
	    void tearDown() {
	        product.deleteAll();
	    }

	    /*
	     * TEST PESSIMISTIC LOCKING
	     */

	    @Test
	    void shouldIncrementItemAmount_withoutConcurrency() throws Exception {
	        assertIncrementItemAmountWithPessimisticLocking(false, false, 2);
	    }

	    @Test
	    void shouldIncrementItemAmount_withinPessimisticLockingConcurrencyWithMinimalLockTimeout() throws Exception {
	        assertIncrementItemAmountWithPessimisticLocking(true, true, 3);
	    }

	    @Test
	    void shouldIncrementItemAmount_withinPessimisticLockingConcurrencyWithDefaultLockTimeout() throws Exception {
	        assertIncrementItemAmountWithPessimisticLocking(true, false, 2);
	    }

	    private void assertIncrementItemAmountWithPessimisticLocking(
	            boolean simulatePessimisticLocking,
	            boolean hasToSetMinimalLockTimeOut,
	            int expectedNumberOfItemServiceInvocations) throws Exception {

	        /* given
	        if (hasToSetMinimalLockTimeOut) {
	            long lockTimeOutInMs = customizedItemRepositoryContext.getMinimalPossibleLockTimeOutInMs();
	            when(customizedItemRepositoryContext.getLockTimeOutInMsForQueryGetItem()).thenReturn(lockTimeOutInMs);
	        }

	        if (hasToSetMinimalLockTimeOut && customizedItemRepositoryContext.isRequiredToSetLockTimeoutForTestsAtStartup()) {
	            log.info("... set lockTimeOut {} ms through native query at startup ...", customizedItemRepositoryContext.getMinimalPossibleLockTimeOutInMs());
	            TransactionStatus tx = transactionManager.getTransaction(new DefaultTransactionDefinition());
	            itemRepository.setLockTimeout(customizedItemRepositoryContext.getMinimalPossibleLockTimeOutInMs());
	            transactionManager.commit(tx);
	        }
*/
	       // if (simulatePessimisticLocking) {
	         //   insertDelayAtTheEndOfPessimisticLockingSection();
	       // }

	        final Product srcItem = product.save(new Product());

	        // when
	        final List<Integer> itemAmounts = Arrays.asList(10, 5);

	        if (simulatePessimisticLocking) {
	            final ExecutorService executor = Executors.newFixedThreadPool(itemAmounts.size());

	            for (final int amount : itemAmounts) {
	                executor.execute(() -> pService.calculateStock(product.getOne(null), amount));
	            }

	            executor.shutdown();
	            assertTrue(executor.awaitTermination(1, TimeUnit.MINUTES));
	        } else {
	            for (final int amount : itemAmounts) {
	                pService.calculateStock(product.getOne(null), amount);
	            }
	        }

	        // then
	       // final Product product = product.getId();
	        assertAll(
	                () -> assertEquals(15, product.getStock()),
	                () -> verify(pService, times(expectedNumberOfItemServiceInvocations)).calculateStock(any(Product.class), anyInt())
	        );
	    }

	    /*private void insertDelayAtTheEndOfPessimisticLockingSection() {
	        long delay = customizedItemRepositoryContext.getDelayAtTheEndOfTheQueryForPessimisticLockingTestingInMs();
	        doAnswer(invocation -> {
	            try {
	                TimeUnit.MILLISECONDS.sleep(delay);
	            } catch (InterruptedException ie) {
	                Thread.currentThread().interrupt();
	            }
	            return null;
	        }).when(customizedItemRepositoryContext).insertArtificialDealyAtTheEndOfTheQueryForTestsOnly();
	    }
*/
	    /*
	     * TEST SET&GET LOCK TIMEOUT
	    

	    @Test
	    void shouldSetAndGetLockTimeOut() {
	        if (ProductDaoContext.isRequiredToSetLockTimeoutQueryHint()) {
	            assertThrows(UnsupportedOperationException.class, () -> itemRepository.setLockTimeout(0));
	            assertThrows(UnsupportedOperationException.class, () -> itemRepository.getLockTimeout());
	            return;
	        }

	        assertSetLockTimeOut(customizedItemRepositoryContext.getMinimalPossibleLockTimeOutInMs());
	        assertSetLockTimeOut(TimeUnit.SECONDS.toMillis(2));
	        assertSetLockTimeOut(TimeUnit.MINUTES.toMillis(2));
	        assertSetLockTimeOut(TimeUnit.HOURS.toMillis(2));
	        assertSetLockTimeOut(TimeUnit.DAYS.toMillis(2));
	    }

	    private void assertSetLockTimeOut(long expectedMilliseconds) {
	        TransactionStatus tx = transactionManager.getTransaction(new DefaultTransactionDefinition());
	        itemRepository.setLockTimeout(expectedMilliseconds);
	        assertEquals(expectedMilliseconds, itemRepository.getLockTimeout());
	        transactionManager.commit(tx);
	    }
	    */
	}