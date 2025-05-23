package homework.main.movie;

public class MovieVo {

	private String no;
	private String title;
	private String maincha;
	private String gender;
	private String releseDate;
	private String play_yn;
	
	public MovieVo() {
		
	}
	
	public MovieVo(String no, String title, String maincha, String gender, String releseDate, String play_yn) {
		super();
		this.no = no;
		this.title = title;
		this.maincha = maincha;
		this.gender = gender;
		this.releseDate = releseDate;
		this.play_yn = play_yn;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaincha() {
		return maincha;
	}

	public void setMaincha(String maincha) {
		this.maincha = maincha;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReleseDate() {
		return releseDate;
	}

	public void setReleseDate(String releseDate) {
		this.releseDate = releseDate;
	}

	public String getPlay_yn() {
		return play_yn;
	}

	public void setPlay_yn(String play_yn) {
		this.play_yn = play_yn;
	}

	@Override
	public String toString() {
		return "지브리 영화 No " + no + ". | 제목:" + title + " | 주인공:" + maincha + " | 성별:" + gender
				+ " | 개봉일자:" + releseDate + " | 재개봉 여부:" + play_yn + "";
	}
}
