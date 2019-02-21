package Assignment;

import java.io.IOException;
import java.util.Arrays;

public class Assignment {
	
	/**
	 * Reads process file, writes to an array, passes to Scheduler that then runs.
	 * Prints relevant metric information.
	 * Amend to run different schedulers and determine necessary evaluation outcomes.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
			
		// FCFS  Average Waiting Time = 17.0 , Average Turn around Time = 27.0
		Process[] p = {new Process(1, 24, 0, 1), new Process(2, 3,0, 1), new Process(3, 3,0, 1)};
		// Priority Average WT = 8.2 Average Turn around time = 12.0
		Process[] p1 = {new Process(1, 10, 0, 3), new Process(2, 1,0, 1), new Process(3, 2,0, 4), new Process(4, 1,0, 5), new Process(5, 5,0, 2)};
		// preemptive SJF: Average Waiting Time = 3.0 , Average Turn around Time = 7.0
		Process[] p2 = {new Process(1, 7, 0, 1), new Process(2, 4,2, 1), new Process(3, 1,4, 1), new Process(4, 4,5, 1)};
		//RR, quantum = 20: Average Waiting Time = 30.25 , Average Turn around Time = 70.75
		Process[] p3 = {new Process(1, 53, 0, 1), new Process(2, 17,30, 1), new Process(3, 68,50, 1), new Process(4, 24,60, 1)};

		ProcessReader pr = new ProcessReader();
		Process []  pa = pr.readProcesses("src/Assignment/Processes.txt");

//		Scheduler scheduler = new FCFS(pa);      //FCFS execution
//		scheduler.runScheduler();
//		System.out.println("Average wait time = " + scheduler.calculateAverageWaitTime());
//		System.out.println("Average turnaround time = " + scheduler.calculateAverageTurnaroundTime());

//		Scheduler scheduler1 = new NonPreemptive(pa);  //Non-Preemptive priority execution
//		scheduler1.runScheduler();
//		System.out.println("Average wait time = " + scheduler1.calculateAverageWaitTime());
//		System.out.println("Average turnaround time = " + scheduler1.calculateAverageTurnaroundTime());

//		Scheduler scheduler2 = new RoundRobin(pa);  //Round Robin execution
//		scheduler2.runScheduler();
//		System.out.println("Average wait time = " + scheduler2.calculateAverageWaitTime());
//		System.out.println("Average turnaround time = " + scheduler2.calculateAverageTurnaroundTime());

		Scheduler scheduler3 = new SJF(pa);  //SJF execution
		scheduler3.runScheduler();
		System.out.println("Average wait time = " + scheduler3.calculateAverageWaitTime());
		System.out.println("Average turnaround time = " + scheduler3.calculateAverageTurnaroundTime());
	}

}
