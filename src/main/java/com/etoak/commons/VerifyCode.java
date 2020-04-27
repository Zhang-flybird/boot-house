package com.etoak.commons;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class VerifyCode {

	// 计算结果
	private int result;

	//写到前端的图片
	private BufferedImage image;

	public VerifyCode(){
		this.image = this.createImage();
	}

	private BufferedImage createImage() {
		// 图片宽度
		int width = 105;
		// 图片高度
		int height = 32;

		// 创建BufferedImage对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();

		// 设置背景颜色
		graphics.setColor(new Color(0xCDDCDC));
		graphics.fillRect(0, 0, width, height);

		// 画边框
		graphics.setColor(Color.black);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 随机做干扰线
		Random random = new Random();
		for (int i = 0; i < 15; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			graphics.drawLine(x, y, x + xl, y + yl);
		}

		// 生成验证码表达式，如:1+2*3
		String verifyCode = this.generateExpression();
		// 开始画图
		graphics.setColor(new Color(0, 88, 0));
		graphics.setFont(new Font("Fixedsys", Font.BOLD, 24));
		graphics.drawString(verifyCode + "=?", 8, 24);
		graphics.dispose();

		// 计算表达式结果
		result = this.calc(verifyCode);

		// 返回图片对象
		return image;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * 计算表达式的值
	 * 
	 * @param expression
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private int calc(String expression) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			return (Integer) engine.eval(expression);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 生成验证码表达式：1+2
	 * 
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private String generateExpression() {
		Random random = new Random();

		// 随机获取操作数 0-9
		int number = random.nextInt(10); // [0-9]
		int number2 = random.nextInt(10);
		// 操作符: + - *
		char[] operators = new char[] { '+', '-', '*' };

		// 随机拿出一个操作符
		char operator = operators[random.nextInt(3)];// 0-2
		return "" + number + operator + number2;
	}

}
