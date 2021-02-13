package com.example.demo.observer;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create subjects
		Topic science = new Topic();
		Topic sports = new Topic();
		Topic politics = new Topic();
		
		//Create observer objects
		Observer ob1 = new TopicSubscriber("Political CNN");
		Observer ob2 = new TopicSubscriber("Sports TEN");
		Observer ob3 = new TopicSubscriber("Geography NATGeo");
		Observer ob4 = new TopicSubscriber("General BBC");
		
		//Register observers to the subject
		politics.register(ob1);
		sports.register(ob2);
		science.register(ob3);
		politics.register(ob4);
		
		//attach observers with subjects
		ob1.setSubject(politics);
		ob2.setSubject(sports);
		ob3.setSubject(science);
		ob4.setSubject(politics);
		
		//Check for any new updates
		ob1.update();
		ob2.update();
		ob3.update();
		ob4.update();
		
		//Sending messages to subjects
		politics.postMessage("Presidential Election!");
		sports.postMessage("Manchester city wins..!!");
		science.postMessage("New Fossil Discovered..!!");
		
		}

}
