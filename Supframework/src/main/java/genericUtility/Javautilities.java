package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautilities {
	
	public int randomNumber(int range)
	{
		Random ran=new Random();
	int	random=ran.nextInt(range);
	return random;
	}
	
	public String currentSystemDate()
	{
		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actdate = sim.format(dateobj);
		return actdate;
	}
	
	public String requiredDate(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim1=new SimpleDateFormat("yyyy-MM-dd");
		String actdate=sim1.format(dateobj);
		Calendar cal=sim1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requireddate=sim1.format(cal.getTime());
		return requireddate;
		
	}

}
