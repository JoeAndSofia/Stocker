package main.db.entity;

import main.db.basic.DBEntity;

public class Stock extends DBEntity{
	public String 股票名字 = "";
	public float 今日开盘价 = 0.0f;
	public float 昨日收盘价 = 0.0f;
	public float 当前价格 = 0.0f;
	public float 今日最高价 = 0.0f;
	public float 今日最低价 = 0.0f;
	public float 竞买价 = 0.0f;
	public float 竞卖价 = 0.0f;
	public int 成交量 = 0;
	public float 成交金额 = 0.0f;
	public int 买一量 = 0;
	public float 买一价 = 0.0f;
	public int 买二量 = 0;
	public float 买二价 = 0.0f;
	public int 买三量 = 0;
	public float 买三价 = 0.0f;
	public int 买四量 = 0;
	public float 买四价 = 0.0f;
	public int 买五量 = 0;
	public float 买五价 = 0.0f;
	public int 卖一量 = 0;
	public float 卖一价 = 0.0f;
	public int 卖二量 = 0;
	public float 卖二价 = 0.0f;
	public int 卖三量 = 0;
	public float 卖三价 = 0.0f;
	public int 卖四量 = 0;
	public float 卖四价 = 0.0f;
	public int 卖五量 = 0;
	public float 卖五价 = 0.0f;
	public String 日期 = "";
	public String 时间 = "";

	public Stock(String[] data){
		this.股票名字 = data[0];
		this.今日开盘价 = Float.parseFloat(data[1]);
		this.昨日收盘价 = Float.parseFloat(data[2]);
		this.当前价格 = Float.parseFloat(data[3]);
		this.今日最高价 = Float.parseFloat(data[4]);
		this.今日最低价 = Float.parseFloat(data[5]);
		this.竞买价 = Float.parseFloat(data[6]);
		this.竞卖价 = Float.parseFloat(data[7]);
		this.成交量 = Integer.parseInt(data[8]);
		this.成交金额 = Float.parseFloat(data[9]);
		this.买一量 = Integer.parseInt(data[10]);
		this.买一价 = Float.parseFloat(data[11]);
		this.买二量 = Integer.parseInt(data[12]);
		this.买二价 = Float.parseFloat(data[13]);
		this.买三量 = Integer.parseInt(data[14]);
		this.买三价 = Float.parseFloat(data[15]);
		this.买四量 = Integer.parseInt(data[16]);
		this.买四价 = Float.parseFloat(data[17]);
		this.买五量 = Integer.parseInt(data[18]);
		this.买五价 = Float.parseFloat(data[19]);
		this.卖一量 = Integer.parseInt(data[20]);
		this.卖一价 = Float.parseFloat(data[21]);
		this.卖二量 = Integer.parseInt(data[22]);
		this.卖二价 = Float.parseFloat(data[23]);
		this.卖三量 = Integer.parseInt(data[24]);
		this.卖三价 = Float.parseFloat(data[25]);
		this.卖四量 = Integer.parseInt(data[26]);
		this.卖四价 = Float.parseFloat(data[27]);
		this.卖五量 = Integer.parseInt(data[28]);
		this.卖五价 = Float.parseFloat(data[29]);
		this.日期 = data[30];
		this.时间 = data[31];

	}
	
	public String toString(){
		return "["+股票名字+","+今日开盘价+","+昨日收盘价+","+当前价格+","+今日最高价+","+今日最低价+","+竞买价+","+竞卖价+","+成交量+","+成交金额+","+买一量+","+买一价+","+买二量+","+买二价+","+买三量+","+买三价+","+买四量+","+买四价+","+买五量+","+买五价+","+卖一量+","+卖一价+","+卖二量+","+卖二价+","+卖三量+","+卖三价+","+卖四量+","+卖四价+","+卖五量+","+卖五价+","+日期+","+时间+"]";

		
	}
}
