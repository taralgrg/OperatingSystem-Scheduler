package Assignment;

import java.util.LinkedList;

public abstract class Scheduler {
	
	/**
	 * Relevant data structure and variables common to all schedulers.
	 */
	int n;
	protected Process[] p;
	protected LinkedList<Process> readyQueue, terminatedProcesses;
	protected Process activeProcess;
	
	/**
	 * Each class extending Scheduler should make a call to this super constructor from their own constructors.
	 * @param pArray
	 */
	public Scheduler(Process [] pArray) {
		readyQueue = new LinkedList<Process>();
		terminatedProcesses = new LinkedList<Process>();
		p = pArray;
		n = p.length;
	}
	
	/**
	 * This method is specific to a given scheduler.
	 * (Hint: each scheduler will have a slightly different way of running)
	 */
	abstract void runScheduler();
	
	/**
	 * This method is specific to a given scheduler.
	 * (Hint: this has common elements, but will differ slightly for some scheduling algorithms)
	 */
	abstract void checkForArrivingProcesses(int t);
	
	/**
	 * Calculates the average waiting time of all processes
	 * (Hint: this is common to all schedulers)
	 * @return
	 */
	public double calculateAverageWaitTime() {
		double avgWT = 0.0;
		for (Process process: p) {
			avgWT = avgWT + process.getWaitingTime();
		}
		// complete code in this class
		return avgWT/n;
	}
	
	/**
	 * Calculates the average turnaround time of all processes
	 * (Hint: this is common to all schedulers)
	 * @return
	 */
	public double calculateAverageTurnaroundTime() {
		double avgTT = 0.0;
		for (Process process: p) {
			avgTT = avgTT + process.getTurnaroundTime();
		}
		//complete code in this class
		return avgTT/n;
	}
	
	/**
	 * Return total run time of all processes
	 * @return
	 */
	public int getRuntime() {
		return 0;
	}
	
	/**
	 * Calculates how busy a CPU is over a given time period (efficiency)
	 * @param minutes
	 * @return
	 */
	public double getProcessorUsage(double minutes) {
		return 0;
	}
	
	
	
}
