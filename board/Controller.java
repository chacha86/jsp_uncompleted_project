package board;

import java.util.Scanner;

public abstract class Controller {

	Scanner scan = new Scanner(System.in);
	
	abstract public void doCommand(String command);
	
	protected void printHelp() {
		System.out.println("====== 게시판 명령어 =====");
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");
		System.out.println("update : 게시물 수정");
		System.out.println("delete : 게시물 삭제");
		System.out.println();
		System.out.println("====== 회원기능 명령어 =====");
		System.out.println("signup : 회원가입");
	}
}
