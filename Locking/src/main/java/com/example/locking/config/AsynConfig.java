package com.example.locking.config;

import java.util.concurrent.Executor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsynConfig {

		private static final Logger LOGGER = LoggerFactory.getLogger(AsynConfig.class);

		@Bean(name = "taskExecutor")

		public Executor taskExecutor() {
			LOGGER.debug("Creating Async Task Executor");
			final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			executor.setCorePoolSize(2);
			executor.setMaxPoolSize(2);
			executor.setQueueCapacity(100);
			executor.setThreadNamePrefix("ProductThread-");
			executor.initialize();
			return executor;
		}
	}

