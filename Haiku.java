package model;

import java.io.Serializable;

public class Haiku implements Serializable{
	
	// フィールド
	private int id;
	private String text;
	private String writer;
	private String kigo;
	private String season;
	private int photoId;
	private int date;
	
	//コンストラクタ
	public Haiku(String text, String writer, String kigo, String season, int date) {
		super();
		this.text = text;
		this.writer = writer;
		this.kigo = kigo;
		this.season = season;
		this.date = date;
	}
	public Haiku(String text, String writer) {
		super();
		this.text = text;
		this.writer = writer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getKigo() {
		return kigo;
	}

	public void setKigo(String kigo) {
		this.kigo = kigo;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}



	
	
	
	
	
}
