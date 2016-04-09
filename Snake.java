package Snake;

import apcs.Window;

public class Snake {
	//Position of the snake
	int x;
	int y;
	// Direction
	int direction = 0;
	
	Snake next;
	
	int SIZE = 10;

	/**
	 * Creates a snake object at the given (x,y) position
	 *
	 * @param x - the x position this snake starts at
	 * @param y - the y position this snake starts at
	 */
	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Creates a snake object at the given (x,y) position
	 * with the given direction
	 * 
	 * @param x - the x position this snake starts at
	 * @param y - the y position this snake starts at
	 * @param direction - the direction that the snake is moving in
	 */
	public Snake(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public void draw() {
		Window.out.color("orange");
		Window.out.square(x, y, SIZE);
		
		// If there is a next snake segment, tell it to draw
		if (next != null) {
			next.draw();
		}
	}
	
	/**
	 * Moves the snake
	 */
	public void move() {
		//up
		if (direction == 0) {
			y -= SIZE;
		}
		//right
		if (direction == 1) {
			x += SIZE;
		}
		//down
		if (direction == 2) {
			y += SIZE;
		}
		//left
		if (direction == 3) {
			x -= SIZE;
		}
		if (x > Window.width() - SIZE/2) {
			x = Window.width() - SIZE/2;
		}
		if (x < 0 + SIZE/2) {
			x = 0 + SIZE/2;
		}
		if (y > Window.height() - SIZE/2) {
			y = Window.height() - SIZE/2;
		}
		if (y < 0 + SIZE/2) {
			y = 0 + SIZE/2;
		}
		
		if (next != null) {
			next.move();
			next.direction = this.direction;
		}
	}
	/**
	 * adds a snake segment to the end of the snake
	 */
	public void grow() {
		if (next == null) {
			if (direction == 0)
				next = new Snake(x, y + SIZE);
			if (direction == 1)
				next = new Snake(x - SIZE, y);
			if (direction == 2)
				next = new Snake(x, y - SIZE);
			if (direction == 3)
				next = new Snake(x + SIZE, y);
			next.direction = this.direction;
		}
		
		else {
			next.grow();
		}
	}
	/**
	 * Return the size of the snake.
	 */
	public int size() {
		// Tail snake
		if (next == null) {
			return 1;
		}
		else {
			return 1 + next.size();
		}
	}

}
