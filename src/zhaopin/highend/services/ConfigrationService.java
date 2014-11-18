package zhaopin.highend.services;

import java.util.List;

import zhaopin.highend.entities.configration.StatisticConfig;

public class ConfigrationService 
{
	/**
	 * ��ȡһ����������е�ͳ������
	 * @param categoryID
	 * @return
	 */
	public List<StatisticConfig> GetStatisticConfigByCategoryID(int categoryID)
	{
		String where=" CategoryID=? ";
		
		Object[] objs=new Object[1];
		
		objs[0]=categoryID;
		
		StatisticConfig config=new StatisticConfig();
		
		List<StatisticConfig> configList=config.<StatisticConfig>queryList(where, objs);
		
		return configList;
	}
}
