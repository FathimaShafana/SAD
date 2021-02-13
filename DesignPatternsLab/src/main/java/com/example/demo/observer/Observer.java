package com.example.demo.observer;

public interface Observer {
//Method used by the subject to update the observer 
	public void update();
//Attach with subject to observe
	public void setSubject(Subject sub);
}
