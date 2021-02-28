package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.example.demo.Strategy.CompleteRecognition;
import com.example.demo.Strategy.RecognitionStrategy;
import com.example.demo.Strategy.ThreeWayRecognition;

import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
public class Product {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;

		private String name;
		private String type;

		@Transient
		private RecognitionStrategy recognitionStrategy;

		public Product(String name, String type) {
			this.name = name;
			this.type = type;
			initRecognitionStrategy();
		}

		protected void initRecognitionStrategy() {
			if ("PHOTOEDIT".equals(type)) {
				recognitionStrategy = new CompleteRecognition();
			} else if ("VIDEOEDIT".equals(type)) {
				recognitionStrategy = new ThreeWayRecognition(30, 90);
			} else if ("DRAWVECTOR".equals(type)) {
				recognitionStrategy = new ThreeWayRecognition(30, 60);
			} else {
				throw new IllegalArgumentException(
						"Unsupported product type [" + type + "]");
			}
		}

		public void calculateRevenueRecognition(Contract contract) {
			recognitionStrategy.calculateRevenueRecognitions(contract);
		}

		@PostLoad	//Method needs to be executed after find/query the object
		protected void onPostLoad() {
			initRecognitionStrategy();
		}

		protected Product() { /* as needed by JPA/ORM */ 
			
		}

}
