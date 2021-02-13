//Traditional method to create Singleton Class
package com.example.demo.Model;

public class Singleton {

	//Make it static to have only one instance of it.
	//Class level
	private static volatile Singleton instance;
	
	//It is private. So no one can create it.
	private Singleton() {}
	
	//Method to create a new only if it does not exist
	public static Singleton getInstance() {
		if(null==instance) {
			synchronized (Singleton.class) {
		if(null==instance) {
			instance=new Singleton();
				}
			}
		}
		return instance;
		
	}
}
