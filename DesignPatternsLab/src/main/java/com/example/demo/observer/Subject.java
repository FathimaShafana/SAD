package com.example.demo.observer;

public interface Subject {
//Method to register observers
	public void register(Observer obs);
//Method to unregister observers
	public void unregister(Observer obs);
//Method to notify observers of any change	
	public void notifyObservers();
//Method to get updates from subjects	
	public Object getUpdate(Observer obs);
	
}
