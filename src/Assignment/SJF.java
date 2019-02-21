package Assignment;

public class SJF extends Scheduler {


    public SJF(Process[] p) {
        super(p);

    }

    @Override
    void runScheduler() {
        int t = 0;

        while(true){
            checkForArrivingProcesses(t);

            readyQueue.sort(Process::compareTo);

            if(activeProcess == null){
                activeProcess = readyQueue.removeFirst();
            }
            t++;

            for (Process process: readyQueue){
                process.setWaitingTime(process.getWaitingTime() + 1);
            }
            activeProcess.reduceBurstRemainingTime();

            if (activeProcess.getBurstRemaining() == 0){

                activeProcess.setTurnaroundTime(t - activeProcess.getArrivalTime());
                if(readyQueue.isEmpty()){
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
