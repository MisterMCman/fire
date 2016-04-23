package com.surkemper.fire.graphics;

public class Screen {

	private int width, height;
	public int[] pixels;
	public int counter, timer;
	int position = 0;
	int red1 = 0xcd0000;
	int red2 = 0xff0000;
	int yellow1 = 0xfdff00;
	int yellow2 = 0xffe700;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void render() {
		counter++;
		if (counter % 100 == 0) {
			clear();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					position = (int) (x * Math.random() * y * Math.random());
					position = pixels.length - position-1; //invert the position, so the fire is positioned on the ground and not on top
					
					//Used to vary the colour of the fire in different regions
					if (position > 43000){
						if (Math.random() < 0.7) pixels[position] = yellow1;
						else pixels[position] = yellow2;
					}
					
					else if (position > 39000 && Math.random() >= 0.4){
						if (Math.random() < 0.5) pixels[position] = yellow1;
						else pixels[position] = yellow2;
					}
					else if (position > 36000 && Math.random() >= 0.75){
						if (Math.random() < 0.5) pixels[position] = yellow1;
						else pixels[position] = yellow2;
					}
					
					else if (position > 33000 && Math.random() >= 0.9){
						if (Math.random() < 0.5) pixels[position] = yellow1;
						else pixels[position] = yellow2;
					}

					else {
						if (Math.random() < 0.5) pixels[position] = red1;
						else pixels[position] = red2;
					}
				}
			}
		}
	}

	//sets all pixels to black
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

}
