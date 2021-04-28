package TV;

public class TV {
	private int channel; //1-255
	private int volume; //0-100
	private boolean power;
	
	public void power(boolean switch) {
		this.power = switch;
	}
	public void channel(int channel) {
		this.channel = channel;
	}
	public void channel(boolean up) {
		if 
		this.channel = this.channel + 1;
	}
	public void volume(boolean up) {
		
	}
	public void volume(int channel) {
		
	}
	public void status() {
		String power_status = "on";
		if(power == false) {
			power_status = "off"
		}
		System.out.printf("TV[power=%s, channel=%d, volume=%d",power_status,channel,volume);
	}
}
