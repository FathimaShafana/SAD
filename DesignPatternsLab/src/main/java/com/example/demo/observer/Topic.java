//Concrete class for interface Subject
package com.example.demo.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {
private List<Observer> observers;
private String message;
private boolean changed;
private final Object MUTEX = new Object();

public Topic() {
	this.observers=new ArrayList<>();
}

@Override
public void register(Observer obs) {
	// TODO Auto-generated method stub
	if(obs==null)
		throw new NullPointerException("Null Observer");
	synchronized(MUTEX) {
		//This is to assure that the notification is sent only to the registered observers
		//before the message is published
		if(!observers.contains(obs))
			observers.add(obs);
	}
}

@Override
public void unregister(Observer obs) {
	synchronized(MUTEX) {
	// TODO Auto-generated method stub
	observers.remove(obs);
	}
}

@Override
public void notifyObservers() {
	// TODO Auto-generated method stub
	List<Observer> observersLocal =null;
	//Synchronization is used here to assure that any observer who is registered after the message received
	//is not notified
	synchronized(MUTEX) {
		if(!changed)
			return;
		observersLocal = new ArrayList<>(this.observers);
		this.changed = false;
	}
	for(Observer obs : observersLocal) {
		obs.update();
	}
}

@Override
public Object getUpdate(Observer obs) {
	// TODO Auto-generated method stub
	return this.message;
}
//Method to post message to the topic
public void postMessage(String msg) {
	System.out.println("Message has been posted to the Topic : \t"+ msg);
	this.message = msg;
	this.changed = true;
	notifyObservers();
}

}
