package zhaopin.highend.services;

import java.util.HashMap;
import java.util.List;
import zhaopin.highend.entities.configration.StatisticConfig;
import zhaopin.highend.entities.log.StatisticLog;
import zhaopin.highend.utilities.DateTimeOper;

public class Test {

	/**
	 * ≤‚ ‘
	 * @param args
	 */
	public static void main(String[] args)
	{
		LogServiceTest();
	}
	
	public static void test()
	{

		List<StatisticConfig> list=new ConfigrationService().GetStatisticConfigByCategoryID(1);
		
		System.out.println(list.size());
	}
	
	
	public static void LogServiceTest()
	{
		LogService service=new LogService();

		HashMap<java.util.Date,List<StatisticLog>> dic=service.GetStatisticLogList(DateTimeOper.GetDate(2014, 10, 1),DateTimeOper.GetDate(2014, 11,12),6);
		
		System.out.println(dic.size());
		
	}
}
