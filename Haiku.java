package model;

import java.io.Serializable;

public class Haiku implements Serializable{
	
	// フィールド
	private int id;
	private String text;
	private String writer;
	private String kigo;
	private String season;
	private String photoId;
	
	//コンストラクタ
	public Haiku(String text, String writer, String kigo, String season, String photoId) {
		super();
		this.text = text;
		this.writer = writer;
		this.kigo = kigo;
		this.season = season;
	}
	
	public Haiku(String text, String writer) {
		super();
		this.text = text;
		this.writer = writer;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	
	
}
