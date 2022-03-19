package board;

import java.util.ArrayList;

public class MemberController extends Controller {

	private static MemberController instance = null;
	Member loginedMember = null;

	ArrayList<Member> members = new ArrayList<>();
	int no = 1;

	private MemberController() {}
	
	// 싱글톤 패턴
	public static MemberController getInstance() {

		if (instance == null) {
			instance = new MemberController();
		}

		return instance;
	}

	public void doCommand(String command) {

		if (command.equals("help")) {
			printHelp();

		} else if (command.equals("signup")) {
			signup();

		} else if (command.equals("login")) {
			login();
		}

	}

	private void login() {

		System.out.print("아이디 : ");
		String loginId = scan.nextLine();
		System.out.print("비밀번호 : ");
		String loginPw = scan.nextLine();

		Member member = loginCheck(loginId, loginPw);

		if (member != null) {
			System.out.printf("%s님 반갑습니다!\n", member.getNickname());
		}

	}

	private Member loginCheck(String loginId, String loginPw) {
		Member member = getMemberByLoginId(loginId);

		if (member == null) {
			System.out.println("없는 아이디입니다.");
		} else {
			if (member.getLoginPw().equals(loginPw)) {
				System.out.println("로그인 성공");
				loginedMember = member;
				return member;
			} else {
				System.out.println("비밀번호를 틀렸습니다.");
			}
		}

		return null;
	}

	private Member getMemberByLoginId(String loginId) {
		try {
		
			for (int i = 0; i < members.size(); i++) {
				Member member = members.get(i);
				if (member.getLoginId().equals(loginId)) {
					return member;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private void signup() {

		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.print("아이디를 입력해주세요 : ");
		String loginId = scan.nextLine();

		System.out.print("비밀번호를 입력해주세요 : ");
		String loginPw = scan.nextLine();

		System.out.print("닉네임을 입력해주세요 : ");
		String nickname = scan.nextLine();

		Member member = new Member(no, loginId, loginPw, nickname);
		members.add(member);
		no++;

	}
	
	public Member getLoginedMemger() {
		return loginedMember;
	}
}
