package homework.main;

import homework.main.movie.MovieController;

public class Main {

	public static void main(String[] args) {
		
		MovieController moiveController = new MovieController();
		System.out.println("지브리 재개봉 기념리스트");
//		moiveController.insert();
//		moiveController.update();
//		moiveController.delete();
//		moiveController.selectOne();
		moiveController.selectList();
	}

}
