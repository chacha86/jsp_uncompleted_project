package board;

public class Member {
	
	private int no;
	private String loginId;
	private String loginPw;
	private String nickname;
	
	public Member() {}

	public Member(int no, String loginId, String loginPw, String nickname) {
		super();
		this.no = no;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
