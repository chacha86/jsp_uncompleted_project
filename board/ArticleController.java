package board;

import java.util.ArrayList;

public class ArticleController extends Controller {
	
	private static ArticleController instance = null;
	
	ArrayList<Article> articles = new ArrayList<>();
	int no = 4;
	
	private ArticleController() {
		makeData();
	}
	
	// 싱글톤 패턴
	public static ArticleController getInstance() {
		
		if(instance == null) {
			instance = new ArticleController();
		}
		
		return instance;
	}

	public void doCommand(String command) {

		if (command.equals("help")) {
			printHelp();

		} else if (command.equals("add")) {
			add();

		} else if (command.equals("list")) {
			printArticles(articles);

		} else if (command.equals("update")) {
			update();

		} else if (command.equals("delete")) {
			delete();

		} else if (command.equals("search")) {
			search();

		} else if (command.equals("read")) {
			read();

		}
	}

	private void read() {
		System.out.print("상세보기할 게시물 번호 :");
		int targetNo = Integer.parseInt(scan.nextLine());

		Article article = getArticleByNo(targetNo);

		if (article != null) {
			printArticle(article);

		} else {
			System.out.println("없는 게시물입니다.");
		}
	}

	private void printArticle(Article article) {

		System.out.printf("==== %d번 게시물 ====\n", article.getNo());
		System.out.printf("번호 : %d\n", article.getNo());
		System.out.printf("제목 : %s\n", article.getTitle());
		System.out.println("-------------------");
		System.out.printf("내용 : %s\n", article.getBody());
		System.out.println("-------------------");
		System.out.println("등록날짜 : " + article.getRegDate());
		System.out.println("조회수 : " + article.getHit());
		System.out.println("작성자 : " + article.getNickname());
		System.out.println("===================");
		System.out.println("========댓글=======");
		System.out.println("===================");
		
	}

	private void search() {

		System.out.println("검색 키워드를 입력해주세요 :");
		String keyword = scan.nextLine();

		ArrayList<Article> searchedList = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);

			if (article.getTitle().contains(keyword)) {
				searchedList.add(article);
			}
		}

		printArticles(searchedList);

	}

	private void makeData() {

		Article a1 = new Article(1, "안녕하세요", "내용1", MyUtil.getCurrentDate(), 30, "홍길동");
		Article a2 = new Article(2, "반갑습니다.", "내용2", MyUtil.getCurrentDate(), 20, "이순신");
		Article a3 = new Article(3, "안녕2", "내용3", MyUtil.getCurrentDate(), 10, "을지문덕");

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}

	private void delete() {
		System.out.print("삭제할 게시물 번호 :");
		int targetNo = Integer.parseInt(scan.nextLine());

		Article article = getArticleByNo(targetNo);

		if (article != null) {

			// ArrayList 삭제 -> remove(index), remove(value)
			articles.remove(article);
			System.out.println("삭제가 완료되었습니다.");

			printArticles(articles);

		} else {
			System.out.println("없는 게시물 번호입니다.");

		}

	}

	private void update() {
		System.out.print("수정할 게시물 번호 :");
		int targetNo = Integer.parseInt(scan.nextLine());

		Article article = getArticleByNo(targetNo);

		if (article != null) {
			System.out.print("제목 :");
			String title = scan.nextLine();
			System.out.print("내용 :");
			String body = scan.nextLine();

			article.setTitle(title);
			article.setBody(body);

			System.out.println("수정이 완료되었습니다.");

			printArticles(articles);

		} else {
			System.out.println("없는 게시물 번호입니다.");

		}
	}

	private void add() {

		System.out.print("제목을 입력해주세요 : ");
		String title = scan.nextLine();

		System.out.print("내용을 입력해주세요 : ");
		String body = scan.nextLine();

		int hit = 0;
		String nickname = "익명";

		Article article = new Article(no, title, body, MyUtil.getCurrentDate(), hit, nickname);
		articles.add(article);

		System.out.println("게시물이 저장되었습니다.");
		no++;

	}

	private Article getArticleByNo(int targetNo) {

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			if (article.getNo() == targetNo) {
				return article;
			}
		}

		return null;

	}

	private void printArticles(ArrayList<Article> targetList) {
		for (int i = 0; i < targetList.size(); i++) {
			Article article = targetList.get(i);
			System.out.println("번호 : " + article.getNo());
			System.out.println("제목 : " + article.getTitle());
			System.out.println("등록날짜 : " + article.getRegDate());
			System.out.println("조회수 : " + article.getHit());
			System.out.println("작성자 : " + article.getNickname());
			System.out.println("====================================");
		}

	}
}
