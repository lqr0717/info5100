package a4;


class Shape{ 
   public String name; 
   protected double area;
   protected double perimeter; 

   public Shape() {
	   this.name = "Shape";

   }
   public void draw() {
	   System.out.println("Drawing " + this.name);
   }
   
   public void getArea() {
	   System.out.println(this.area);
   };
   public void getPerimeter() {
	   System.out.println(this.perimeter);
   };
   
}
//CIRCLE
class Circle extends Shape{
	double radius;
	public Circle(double radius) {
		this.name = "Circle"; 
		this.radius = radius; 
	}
	public void getArea() {
		this.area =  Math.PI * radius *radius;
		super.getArea();
	}
	public void getPerimeter() {
		this.perimeter = 2 * Math.PI * radius;
		super.getPerimeter();
	   }
}
// RECTANGLE
class Rectangle extends Shape {
	double length;
	double width;

   public Rectangle(double _length, double _width) { 
      this.name = "Rectangle"; 
      this.length = _length; 
      this.width = _width; 
   }
   public void getArea() {
		this.area = length * width;
		super.getArea();
		}
	public void getPerimeter() {
		this.perimeter = 2 * (length + width);
		super.getPerimeter();
	   }
}
//SQUARE
class Square extends Shape{
	double side;
	public Square(double side) {
		this.name = "Square"; 
		this.side = side;
	}
	public void getArea() {
		this.area =  side * side;
		super.getArea();
	}
	public void getPerimeter() {
		this.perimeter = 4 * side;
		super.getPerimeter();
	   }
}

public class ShapeTester{
	public static void main(String[] args) {
		Shape s = new Shape();
		Rectangle r = new Rectangle(2.0,3.0);
		Circle c = new Circle(4.0);
		Square sq = new Square(4.0);
		r.getArea();
		r.getPerimeter();
		c.getArea();
		c.getPerimeter();
		sq.getArea();
		sq.getPerimeter();
		r.draw();
		c.draw();
		s.draw();
		sq.draw();
		
		
		
	}
}

   
