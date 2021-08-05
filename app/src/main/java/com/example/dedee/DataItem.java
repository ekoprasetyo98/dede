package com.example.dedee;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("no")
	private String no;

	@SerializedName("nilai")
	private String nilai;

	@SerializedName("pertanyaan")
	private String pertanyaan;

	public String getNo(){
		return no;
	}

	public String getNilai(){
		return nilai;
	}

	public String getPertanyaan(){
		return pertanyaan;
	}
}