package Snake;

import apcs.Window;

public class SnakeGame {

	public static void main(String[] args) {
		// set the size and frame rate of the window
		Window.size(500, 500);
		Window.setFrameRate(10);
		
		// create the head of a snake in the middle of the screen
		Snake head = new Snake(Window.width()/2,Window.height()/2);
		
		int foodx = Window.rollDice(Window.width());
		int foody = Window.rollDice(Window.height());
		
		// Infinitely draw and move the snake segment.
		while(true) {
			Window.out.background("black");
			
			// Draw the snake
			head.draw();
			head.move();
			
			// Draw the food
			Window.out.color("red");
			Window.out.circle(foodx, foody, 5);
			
			if (Math.abs(head.x - foodx) < 10 &&
				Math.abs(head.y - foody) < 10) {
				head.grow();
				foodx = Window.rollDice(Window.width());
				foody = Window.rollDice(Window.height());
			}
			
			// Change the direction of the head
			if (head.size() > 1) {
				if (Window.key.pressed("w") && head.direction != 2) {
					head.direction = 0;
				}
				if (Window.key.pressed("d") && head.direction != 3) {
					head.direction = 1;
				}
				if (Window.key.pressed("s") && head.direction != 0) {
					head.direction = 2;
				}
				if (Window.key.pressed("a") && head.direction != 1) {
					head.direction = 3;
				}
			}
			if (head.size() == 1){
				if (Window.key.pressed("w")) {
					head.direction = 0;
				}
				if (Window.key.pressed("d")) {
					head.direction = 1;
				}
				if (Window.key.pressed("s")) {
					head.direction = 2;
				}
				if (Window.key.pressed("a")) {
					head.direction = 3;
				}
			}
			Window.frame();
		}
		
	}

}
