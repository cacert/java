package com.kasim.mm.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.jdbc.core.RowMapper;

public class PollWorkerScheduler {
	
	/**
	 * in a fixed period
	 * poll db
	 * submit jobs to pool
	 * */
	public void start(){
		List<PollInfo> queryForList = Utils.getJdbcTemplate().query("Select * from polling ",new RowMapper<PollInfo>(){
			@Override
			public PollInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				PollInfo pollInfo = new PollInfo();
				pollInfo.setFilename(rs.getString("FILENAME"));
				pollInfo.setPollingid(rs.getInt("POLLINGID"));
				pollInfo.setSourceap(rs.getInt("SOURCEAP"));
				pollInfo.setTrycount(rs.getInt("TRYCOUNT"));
				return pollInfo;
			}
		});
		System.err.println(queryForList.size());
		
		
		List<Callable<Long>> tasks = new ArrayList<>();
		
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
		
		executorService.scheduleAtFixedRate(()->{System.out.println("deneme");}, 0, 10, TimeUnit.SECONDS);
		
		
	}
	public static void main(String[] args) {
		new PollWorkerScheduler().start();
	}
}

class PollInfo{
	private int pollingid;
	private String filename;
	private int sourceap;
	private int trycount;
	public int getPollingid() {
		return pollingid;
	}
	public void setPollingid(int pollingid) {
		this.pollingid = pollingid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getSourceap() {
		return sourceap;
	}
	public void setSourceap(int sourceap) {
		this.sourceap = sourceap;
	}
	public int getTrycount() {
		return trycount;
	}
	public void setTrycount(int trycount) {
		this.trycount = trycount;
	}
}
