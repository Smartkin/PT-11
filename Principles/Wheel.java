public class Wheel extends Circle {
	private final double rollResistCoef = 0.05;
	private double rollSpeed;
	private int torque;
	private int mass;
	private double weight;
	
	public Wheel(float radius, int mass) {
		super(radius);
		this.mass = mass;
		this.weight = mass * 9.8; // Earth's standard gravity
	}
	
	public void applyTorque(int torque) {
		this.torque = torque;
	}
	
	public void physicsStep(double dt) {
		double accel = (torque - (rollResistCoef * weight)) / mass;
		rollSpeed += accel * dt;
		System.out.println("Wheel speed: " + rollSpeed);
	}
	
	public double getRollSpeed() {
		return rollSpeed;
	}
}