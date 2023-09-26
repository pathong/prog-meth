package main;
import Class.*;


public class Main{

	public static void main(String[] args){
		Person peaw= new Student();
//		Student peaw= new Person(); -> can't do this.

		peaw.TestBinding(); //return as student.
		System.out.println(peaw.getClass());
		//Person t = new Student("t",3); //can, but only got class person.
		System.out.println("Hi");


	}
}
