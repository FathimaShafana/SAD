package com.example.demo.state;

public class Main {
	public static void main(String[] args) {
		//An object sm of class SwordMan
		SwordMan sm = new SwordMan();
		sm.increaseAttack(4);
		sm.speedUp(3);
		sm.increaseDefense(1);
		sm.speedUp(2);
		
		System.out.println("Character present State:");
		sm.printStates();
	}

}
