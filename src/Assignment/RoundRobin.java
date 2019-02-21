package Assignment;

public class RoundRobin extends Scheduler {


    public RoundRobin(Process[] p) {
        super(p);

    }

    @Override
    void runScheduler() {
        int t = 0;

        overall:
        while(true){

//            readyQueue.sort(Process::compareTo);
            if(activeProcess != null){
                readyQueue.addLast(activeProcess);
                activeProcess = readyQueue.removeFirst();
            }
            if(activeProcess == null && !readyQueue.isEmpty()){
                activeProcess = readyQueue.removeFirst();
            }


            for(int i = 0; i < 20; i++) {
                checkForArrivingProcesses(t);

                if(activeProcess == null){
                    activeProcess = readyQueue.removeFirst();
                }

                activeProcess.reduceBurstRemainingTime();
                t++;
                for (Process process : readyQueue) {
                    process.setWaitingTime(process.getWaitingTime() + 1);
                }
                if (activeProcess.getBurstRemaining() == 0){

                    activeProcess.setTurnaroundTime(t - activeProcess.getArrivalTime());
                    if(readyQueue.isEmpty()){
                        break overall;
                    }
                    activeProcess = null;
                    break;
                }
            }


        }
    }


//    @Override
//    void runScheduler() {
//        int t = 0;
//
//        overall:
//        while(true){
//            checkForArrivingProcesses(t);
//
//           readyQueue.sort(Process::compareTo);
//
//            if(activeProcess == null){
//                activeProcess = readyQueue.removeFirst();
//            }
//
//            for(int i = 0; i < 20; i++) {
//                activeProcess.reduceBurstRemainingTime();
//                t++;
//                for (Process process : readyQueue) {
//                    process.setWaitingTime(process.getWaitingTime() + 1);
//                }
//                if (activeProcess.getBurstRemaining() == 0){
//
//                    activeProcess.setTurnaroundTime(t - activeProcess.getArrivalTime());
//                    if(readyQueue.isEmpty()){
//                        break overall;
//                    }
//                    activeProcess = readyQueue.removeFirst();
//                    break;
//                }
//            }
//
//
//        }
//    }

    @Override
    void checkForArrivingProcesses(int t) {
        for(Process process: p){
            if(process.getArrivalTime() == t){
                readyQueue.add(process);
            }
        }
    }
}
