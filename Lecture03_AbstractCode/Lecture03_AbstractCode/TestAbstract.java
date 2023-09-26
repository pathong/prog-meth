public class TestAbstract {
	public static void main(String[] args) {
		// Shape sh = new Shape(); // Shape cannot create a new object itself.
		//

		// useless and cringe.
		Shape x = new Shape() {
			// kinda override.
			double perimeter(){
				return 0;
			}
		};


		Shape shape = new Circle(2.5d, "Circle A");
		// use toString();
		System.out.println(shape);
		
		shape = new Square(4.5d, "Squre D");
		System.out.println(shape);
		
		// System.out.println(cir.toString());
		// System.out.println("Diameter = "+cir.diameter());
		// System.out.println(sqr.toString());

		// Circle cir2 = new Circle(2.5d, "Circle B");
		// System.out.println(cir2.toString());
		// System.out.println("Diameter = " + cir2.diameter());
	}
}

//-----------------------------------
abstract class Shape {
	String name;


	// we can't new but still can make constrcutor.
	//public Shape(String name){
		//this.name = name;
	//}

	// abstract double perimeter(){};
	abstract double perimeter();

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.getName() + "\n\tPerimeter = " + perimeter();
	}
}

class Circle extends Shape {
	double radius;

	public Circle(double r, String n) {
		this.radius = r;
		this.name = n;
	}
	@Override
	double perimeter() {
		return 2 * Math.PI * this.radius;
	}

	double diameter() {
		Shape a = new Circle(3, "n");
		
		return 2 * this.radius;

	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(!(o instanceof Circle cicle)) return false;
		// equal to
		if(!(o instanceof Circle)) return false;
		Circle circle = (Circle)o;
		return Double.compare(radius, circle.radius) == 0;
	}
	public int hashcode(){
		return Object.hash(radius);
	}

}

class Square extends Shape {
	double height;

	public Square(double h, String n) {
		this.height = h;
		this.name = n;
	}

	@Override
	double perimeter() {
		return 4 * this.height;
	}
}
