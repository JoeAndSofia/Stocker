package main.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.db.entity.Stock;
import basic.Basic;

public class StockNetRequest extends Basic{
	
	public static final String HTTP_GET = "GET";
	public static final String HTTP_POST = "POST";
	
	public static final String ENCODE_01 = "GB2312";
	public static final String ENCODE_02 = "GBK";
	
	public static final String BASE_URL = "http://hq.sinajs.cn/list=";
	public static String stockName = "sh601006";
	
	public static void main(String[] args){
		try{
//			String[] stocks = new String[]{stockName};
			String[] stocks = new String[]{
				"sh600600",
				"sh601006",
			};
			
			List<Stock> respStocks = netRequest(stocks);
			for(Stock stock : respStocks){
				pl(stock);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static List<Stock> netRequest(String... stockNames) throws MalformedURLException, IOException{
		StringBuffer requestUrlSb = new StringBuffer();
		requestUrlSb.append(BASE_URL);
		for(int i=0; i<stockNames.length; i++){
			requestUrlSb.append(stockNames[i] + ",");
		}
		pl(requestUrlSb);
		HttpURLConnection con = (HttpURLConnection)(new URL(requestUrlSb.toString()).openConnection());
		con.setRequestMethod(HTTP_GET);
		con.setDoOutput(true);
		con.setDoInput(true);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), ENCODE_01));
		List<Stock> responseList = new ArrayList<Stock>();
		String line = null;
		while((line = br.readLine())!=null){
			responseList.add(new Stock(line.substring(line.indexOf('"')+1, line.lastIndexOf('"')).split(",")));
			
		}
		return responseList;
	}
	
	public static List<String[]> responseAnalyse(List<String> responseList){
		
		return null;
	}
}
