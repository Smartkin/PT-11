public class Circle {
	private float radius;
	private double area;
	
	public Circle(float radius){
		this.radius = radius;
		this.area = Math.PI * radius * radius;
	}
	
	public float getRadius() {
		return radius;
	}
	
	public double getArea() {
		return area;
	}
	
	public float getDiameter() {
		return radius * 2;
	}
}
