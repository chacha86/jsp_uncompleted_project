package board;

import java.util.Scanner;

public class FrontController {
	
	Scanner scan = new Scanner(System.in);
	
	Controller controller = null;
	
	public void run() {
		while (true) {
			
			// MemberController에서 login한 유저 정보를 불러와서
			
			if(loginedMember가 null인지 판단) {
				System.out.print("명령어를 입력해주세요 : ");	
			} else {
				System.out.printf("명령어를 입력해주세요 [%s(%s)]: ");
			}
			
			String command = scan.nextLine();

			String[] commandBits = command.split(" ");
			
			if(commandBits.length < 2) {
				System.out.println("잘못된 명령어입니다.");
				continue;
			}
			
			String module = commandBits[0];
			String func = commandBits[1];

			if(module.equals("article")) {
				controller = ArticleController.getInstance();
			}
			else if(module.equals("member")) {
				controller = MemberController.getInstance();
			}
			
			controller.doCommand(func);
			
		}
	}
}
