package zhaopin.highend.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.List;

import zhaopin.highend.entities.configration.StatisticConfig;
import zhaopin.highend.entities.log.StatisticLog;

public class LogService 
{
	/**
	 * 分页获取日志数据
	 * @param pageParameter
	 * @param date
	 * @param categoryID
	 * @return
	 */
	public List<StatisticLog> GetStatisticLog(Date start,Date end,int categoryID)
	{
		List<StatisticLog> logList=new ArrayList<StatisticLog>();
		
		String parameterString="";
		
		List<StatisticConfig> configList=new ConfigrationService().GetStatisticConfigByCategoryID(categoryID);
		
		Object[] params=null;
		
		if(configList!=null&&configList.size()>0)
		{
			params=new Object[configList.size()+2];
			
			for(int i=0;i<configList.size();i++)
			{
				if(parameterString=="")
				{
					parameterString="?";
				}
				else
				{

					parameterString+=",?";
				}
				
				params[i]=configList.get(i).StatisticID;
				
			}
		}
		
		

		String where=" StatisticID in("+parameterString+") And StatisticDate>=? and StatisticDate<=?";
		
		params[params.length-2]=start;
		
		params[params.length-1]=end;
		
		StatisticLog log=new StatisticLog();
		
		logList=log.<StatisticLog>queryList(where, params,"StatisticDate desc,StatisticID asc");

		
		return logList;
	}
	
	/**
	 * 获取统计数据
	 * @param start
	 * @param end
	 * @param categoryID
	 * @return
	 */
	public HashMap<java.util.Date,List<StatisticLog>> GetStatisticLogList(Date start,Date end,int categoryID)
	{
		HashMap<java.util.Date,List<StatisticLog>> dic=new HashMap<java.util.Date,List<StatisticLog>>();
		
		List<StatisticLog> list=GetStatisticLog(start,end,categoryID);
		
		List<StatisticLog> tempList=new ArrayList<StatisticLog>();
		
		java.util.Date currentDate=list.get(0).StatisticDate;
		
		for(int i=0;i<list.size();i++)
		{
			StatisticLog log=list.get(i);
			
			if(i!=0&&log.StatisticDate!=currentDate)
			{
				dic.put(currentDate, tempList);
				tempList.clear();
				currentDate=log.StatisticDate;
			}
			
			tempList.add(log);
			
			if(i==list.size()-1)
			{
				dic.put(currentDate, tempList);
			}
			
		}
		
		return dic;
		
	}
}
