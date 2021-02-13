//Concrete class for Observer interface
package com.example.demo.observer;

public class TopicSubscriber implements Observer{
	private String name;
	private Subject topic;
	
	public TopicSubscriber(String name) {
	this.name=name;	
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		String msg=(String) topic.getUpdate(this);
		if(msg == null) {
			System.out.println(name+ ":: No new messages");
		}
		else
			System.out.println(name+ ":: Consuming message \t" + msg + "\n");
		}
		
	
	@Override
	public void setSubject(Subject sub) {
		// TODO Auto-generated method stub
		this.topic=sub;
	}
}