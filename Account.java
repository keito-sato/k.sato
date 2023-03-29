package model;

import java.io.Serializable;

public class Account implements Serializable{
	// フィールド
	private String name;
	private String pass;
	
	// コンストラクタ
	public Account(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	
	// ゲッター
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}
}
