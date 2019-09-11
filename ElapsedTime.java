public class ElapsedTime {
	private long start;
	
	public ElapsedTime() {
		start = System.currentTimeMillis();
	}
	
	public double getElapsed() {
		return (System.currentTimeMillis() - start) / 1000.0;
	}
}