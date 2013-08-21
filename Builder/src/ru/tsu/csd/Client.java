package ru.tsu.csd;

public class Client {
	public static void main(String[] args) {
		Complector c = new Complector();
		Builder builder = new KamikazeBuilder();
		c.setBuilder(builder);
		c.giveAmmo();
		Soldier s = c.getSoldier();
		System.out.println(s);
	}
}

class Soldier {
	private Weapon weapon;
	private int numOfGrenades;
		
	public void setWeapon(Weapon w) {
		weapon = w;
	}
	
	public void setGren(int i) {
		numOfGrenades = i;
	}
	
	@Override
	public String toString() {
		return ("weapon: " + weapon + "\n" + "num of gren: " + numOfGrenades);
	}
}

class Complector {
	private Builder builder;
	public Complector(Builder builder) {
		this.builder = builder;
	}	
	public Complector() {
		
	}
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	public Soldier getSoldier() {
		return builder.getSoldier();
	}
	
	public void giveAmmo() {
		builder.createSoldier();
		builder.buildWeapon();
		builder.buildGren();
	}
}

enum Weapon {
	AK, KNIFE
}

abstract class Builder {
	protected Soldier soldier;
	public Soldier getSoldier() {
		return soldier;
	}
	
	public void createSoldier() {
		soldier = new Soldier();
	}
	
	abstract void buildWeapon();
	abstract void buildGren(); 
}

class KamikazeBuilder extends Builder {
	public void buildWeapon() {
		soldier.setWeapon(Weapon.KNIFE);
	}
	public void buildGren() {
		soldier.setGren(6);
	}
}

class ShooterBuilder extends Builder {
	public void buildWeapon() {
		soldier.setWeapon(Weapon.AK);
	}
	public void buildGren() {
		soldier.setGren(2);
	}
}