package TestPackage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestClass {
	

	JSONArray array ;
	
	@BeforeTest
	public void readJSONData() throws IOException, ParseException {
		
		JSONParser jsonParser= new JSONParser();
		FileReader fileReader = new FileReader("src\\test\\resources\\TeamRCB.json");

		  //Read Json file
		Object obj = jsonParser.parse(fileReader);
		JSONObject jsonobject=(JSONObject)obj;
		array = (JSONArray) jsonobject.get("player");
		
		
	}
	
	
	
	@Test
  public void validateForeigners() {
		
		int foreignPlayers=0;
		for(int i=0;i<array.size();i++) {
			JSONObject player=(JSONObject) array.get(i);
			String country= (String) player.get("country");
			
			if(!(country.equalsIgnoreCase("India"))) {
				foreignPlayers++;
				
			}
		  
		}
		System.out.println("Number of foreign players in team RCB are : "+foreignPlayers);
		Assert.assertEquals(4, foreignPlayers);
		  
  }
	
	@Test
	public void validateWicketKeeper() {
		
		int wicketKeepers=0;
		for(int i=0;i<array.size();i++) {
			JSONObject player=(JSONObject) array.get(i);
			String role= (String) player.get("role");
			
			if(role.equalsIgnoreCase("Wicket-keeper")) {
				wicketKeepers++;
				break;
				
			}
		  
		}
		System.out.println("Number of Wicket Keepers in team RCB are : "+wicketKeepers);
		Assert.assertEquals(1, wicketKeepers);
		
		
	}
}
