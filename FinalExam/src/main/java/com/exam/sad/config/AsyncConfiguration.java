package com.exam.sad.config;


import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

		private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfiguration.class);

		@Bean(name = "taskExecutor")

		public Executor taskExecutor() {
			LOGGER.debug("Creating Async Task Executor");
			final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			// Set both equal to have fixed-size thread pool
			executor.setCorePoolSize(3);	//No. of threads
			executor.setMaxPoolSize(3);  	//Maximum size of threads
			
			executor.setQueueCapacity(90); //number of items your threadPool will accept before rejecting them
			executor.setThreadNamePrefix("ProductThread-");
			executor.initialize();
			return executor;
		}
	}


