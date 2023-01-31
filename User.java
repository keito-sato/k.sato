package model;

import java.io.Serializable;

public class User implements Serializable {
	// フィールド
	private String name;
	private String pass;
	
	// コンストラクタ
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	// ゲッター
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
}
