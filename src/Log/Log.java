package Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	
	private static StringBuilder game_log = new StringBuilder();
	
	public static void log_add(String msg){
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
	    
		String newmsg = "LOG <" + df.format(dateobj) + ">: " + msg;
		System.out.println(newmsg);
		game_log.append(newmsg);
	}
	
	public static String getLog(){
		return game_log.toString();
	}

	public static void log_add(int num) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
	    
		String newmsg = "LOG <" + df.format(dateobj) + ">: " + num;
		System.out.println(newmsg);
		game_log.append(newmsg);
		
	}

}
