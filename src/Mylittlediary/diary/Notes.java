package Mylittlediary.diary;

import java.io.Serializable;
public class Notes implements Serializable {

	private String eventName;
	private String date;
	
	
	public Notes(){
		eventName ="";
		date = "";			
	}
	
	public Notes(String eventName, String date){
		this.eventName=eventName;
		this.date=date;
	}
	
	public String getEventName(){
		return eventName;
	}
	
	
	public void setEventName(String eventName){
		this.eventName = eventName;
	}
	
	public String getDate(){
		return date;
	}
	
	
	public void setDate(String date){
		this.date=date;
	}
}
