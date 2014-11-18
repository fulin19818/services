package zhaopin.highend.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		HashMap<java.util.Date,List<StatisticLog>> dic=service.GetStatisticLogList(DateTimeOper.GetDate(2014, 11, 12),DateTimeOper.GetDate(2014, 11,17),6);
		
		for(Map.Entry<java.util.Date,List<StatisticLog>> entry:dic.entrySet())
		{
			
			System.out.println("<tr><td>"+entry.getKey().toLocaleString()+"</td>");
			
			for(StatisticLog log :entry.getValue())
			{

				System.out.println("<td>"+log.DataCount.toString()+"</td>");
			}
			
			
			System.out.println("</tr>");
		}
		
	}
}
