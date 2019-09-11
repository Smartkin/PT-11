
public class Principles {
	public static void main(String[] args) {
		Wheel wheel = new Wheel(0.12f, 23);
		wheel.applyTorque(100);
		ElapsedTime dt = new ElapsedTime();
		for(int i = 0; i < 100000; ++i) {
			wheel.physicsStep(dt.getElapsed());
		}
		System.out.println("Wheel speed: " + wheel.getRollSpeed());
	}
}