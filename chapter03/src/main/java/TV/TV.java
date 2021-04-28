package TV;

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
			if(1<=channel && channel <=255) {
				this.channel = channel;							
			}
		}
	}
	public void channel(boolean up) {
		if(power == true) {
			if(up==true) {
				if(this.channel<255) {
					this.channel = this.channel + 1;
				} else {
					this.channel = 1;
				}
			} else {
				if(this.channel > 1) {
					this.channel = this.channel - 1;
				} else {
					this.channel = 255;
				}
			}
		}
	}
	
	public void volume(boolean up) {
		if(power == true) {
			if(up==true) {
				if(this.volume<100) {
					this.volume = this.volume + 1;
				} else {
					this.volume = 0;
				}
			} else {
				if(this.volume > 0) {
					this.volume = this.volume - 1;
				} else {
					this.volume = 100;
				}
			}
		}
	}
	public void volume(int volume) {
		if(power == true) {
			if(0<=volume&&volume<=100) {
				this.volume = volume;				
			}
		}
	}
	
	public void status() {
		String power_status = "on";
		if(power == false) {
			power_status = "off";
		}
		System.out.printf("TV[power=%s, channel=%d, volume=%d]\n",power_status,channel,volume);
	}
}
