package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		if(function.equals("음악")) {
			openMusic();
		} else if(function.equals("앱")) {
			openApplication();
		} else if(function.equals("통화")) {
			super.execute(function);
		}
	}
	public void openMusic() {
		System.out.println("다운로드해서 음악재생");
	}
	public void openApplication() {
		System.out.println("앱실행");
	}
}
