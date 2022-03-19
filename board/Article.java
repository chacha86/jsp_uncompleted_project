package board;

public class Article {
	
	// 캡슐화 -> 자원에 대한 접근을 제어하고 특정 메서드로만 열어두는 것.
	private int no;
	private String title;
	private String body;
	private String regDate;
	private int hit;
	private String nickname;
	
	
	// 생성자 -> 기본생성자, 모든 인수 받는 생성자 
	public Article() {}

	public Article(int no, String title, String body, String regDate, int hit, String nickname) {
		super();
		this.no = no;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.hit = hit;
		this.nickname = nickname;
	}



	// getter, setter
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
