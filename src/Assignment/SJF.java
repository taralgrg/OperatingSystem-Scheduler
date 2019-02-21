package Assignment;

import java.util.Comparator;

public class SJF extends Scheduler {

    int n;

    public SJF(Process[] p) {
        super(p);

    }

    @Override
    void runScheduler() {
        int t = 0;

        Comparator<Process> c = new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.getBurstTime() == o2.getBurstTime()) {
                    return o1.getArrivalTime() - o2.getArrivalTime();
                } else {
                    return o1.getBurstTime() - o2.getBurstTime();
                }
            }
        };

        while (true) {
            checkForArrivingProcesses(t);
            readyQueue.sort(c);

            if (activeProcess == null) {
                activeProcess = readyQueue.removeFirst();
            }

            if (!readyQueue.isEmpty() && readyQueue.getFirst().getBurstTime() < activeProcess.getBurstTime()) {
                readyQueue.addLast(activeProcess);
                activeProcess = readyQueue.removeFirst();
            }
            t++;

            activeProcess.reduceBurstRemainingTime();

            for (Process process : readyQueue) {
                process.setWaitingTime(process.getWaitingTime() + 1);
            }

            if (activeProcess.getBurstRemaining() == 0) {

                activeProcess.setTurnaroundTime(t - activeProcess.getArrivalTime());
                if (readyQueue.isEmpty()) {
                    break;
                }
                activeProcess = readyQueue.removeFirst();


            }
        }
    }


    @Override
    void checkForArrivingProcesses(int t) {
        for(Process process: p){
            if(process.getArrivalTime() == t){
                readyQueue.add(process);
            }
        }
    }
}

