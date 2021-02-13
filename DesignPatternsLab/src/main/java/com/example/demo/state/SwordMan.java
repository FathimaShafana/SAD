package com.example.demo.state;

public class SwordMan implements State{
	int agi=7;
	int atck=13;
	int def=5;
	@Override
	public void increaseDefense(int increment) {
		def = def+increment;
		
	}
	
	@Override
	public void speedUp(int increment) {
		
		atck=atck+2*increment;
		agi=agi+increment;
			
	}
	
	@Override
	public void increaseAttack(int increment) {
		atck=atck+increment;
		//Casting a floating value to integer
		def=def-(int)0.3*increment;
		
	}
	@Override
	public void printStates() {
		System.out.println("Agi-Atck-def:" +agi+ "--" +atck+ "--" +def);
		
	}
		
}
