/**
 * 
 */
package com.dale.ms.status;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dale'
 * @date 2017-5-9 下午12:11:58
 * @description 将任务状态，以及Http任务返回结果进行存储的类
 */
public class TaskStatusMap {

	//所有Task 当前状态记录表
	private static ConcurrentHashMap<String, TaskStatus> taskStatusMap = new ConcurrentHashMap<>();
	
	//所有Task 运行结果记录表
	private static ConcurrentHashMap<String, String> taskResultMap = new ConcurrentHashMap<String, String>();
	
	//通过 唯一标识 获取 Result
	public static String getTaskResultForKey(String uuid) {
		return taskResultMap.get(uuid);
	}
	
	//通过 唯一标识 获取 Status
	public static TaskStatus getTaskStatusForKey(String uuid) {
		if ( taskStatusMap.get(uuid) == null) {
			return TaskStatus.NoAdded;
		}
		return taskStatusMap.get(uuid);
	}
	
	//通过 唯一标识 修改 Status
	public static void putTaskStatusForKey(String uuid, TaskStatus taskStatus) {
		// 使用同步锁解决并发冲突
		synchronized (TaskStatusMap.class) {
			taskStatusMap.put(uuid, taskStatus);
		}
	}
	
	//通过 唯一标识 修改 result
	public static void putTaskResultForKey(String uuid, String result) {
		synchronized (TaskStatusMap.class) {
			taskResultMap.put(uuid, result);
		}
	}
	
	// 根据 唯一标识 将结果映射表中的key-value删除
	public static void deleteTaskResultForKey(String uuid) {
		taskResultMap.remove(uuid);
	}
	
	// 根据 唯一标识 将状态映射表中的key-value删除
	public static void deleteTaskStatusForKey(String uuid) {
		taskStatusMap.remove(uuid);
	}
	
}
