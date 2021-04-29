package tv;

public class TV {
	private int channel; //1-255
	private int volume; //0-100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		if(power == true) {
			if(channel<1) {
				channel = 255;
			} else if(channel > 255){
				channel = 1;
			}
			this.channel = channel;
		}
	}
	public void channel(boolean up) {
		channel(this.channel + (up?1:-1));
	}
	
	public void volume(int volume) {
		if(power == true) {
			if(volume < 0) {
				volume = 100;
			} else if(volume>100) {
				volume = 0;
			}
			this.volume = volume;
		}
	}
	public void volume(boolean up) {
		volume(this.volume + (up?1:-1));
	}
	
	public void status() {
		String power_status = "on";
		if(power == false) {
			power_status = "off";
		}
		System.out.printf("TV[power=%s, channel=%d, volume=%d]\n",power_status,channel,volume);
	}
}
