package com.useCase.ScheduledThreadPool;

import java.util.Calendar;

public interface IScheduleTask {
	
	long     repeatPeriod();
 	Calendar startABC();
 	Boolean schedule();

}
