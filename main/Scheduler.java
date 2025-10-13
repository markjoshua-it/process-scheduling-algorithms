package main;


public class Scheduler {
    private int[] arrivalTime;
    private int[] burstTime;
    private int[] startTime;
    private int[] completionTime;
    private int[] waitingTime;
    private int timeQuantum;
    private int totalWaitingTime = 0;
    private double averageWaitingTime = 0;
    private int processNum, temp;
    public String[] processName;
    private String tempStr;
    
    public Scheduler(int[] arrivalTime, int[] burstTime){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        processNum = arrivalTime.length;
        startTime = new int[processNum];
        completionTime = new int[processNum];
        waitingTime = new int[processNum];
        processName = new String[processNum];
        scheduleFcfs();
    }
    public Scheduler(int[] arrivalTime, int[] burstTime, int timeQuantum){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.timeQuantum = timeQuantum;
    }
    
    public void scheduleFcfs(){
        // adding processNum processName
        for (int i = 0; i < processNum; i++) {
            processName[i] = String.format("P%d", i+1);
        }
        // sorting values
        for (int i = 0; i < processNum - 1; i++) {
            for (int j = 0; j <processNum - i - 1; j++) {
                if (arrivalTime[j] > arrivalTime[j + 1]) {
                    temp = arrivalTime[j];
                    arrivalTime[j] = arrivalTime[j + 1];
                    arrivalTime[j + 1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    tempStr = processName[j];
                    processName[j] = processName[j + 1];
                    processName[j + 1] = tempStr;
                }
            }
        }
        int currentTime = arrivalTime[0];
        for (int i = 0; i < processNum; i++) {
            startTime[i] = currentTime;
            completionTime[i] = startTime[i] + burstTime[i];
            currentTime = completionTime[i];
        }
        for(int i = 0; i < processNum; i++){
            waitingTime[i] += startTime[i]-arrivalTime[i];
            totalWaitingTime += waitingTime[i];
        }
        averageWaitingTime = (double)totalWaitingTime / processNum;
    }
    
    public int[] getArrivalTime(){ return arrivalTime; }
    public int[] getBurstTime(){ return burstTime; }
    public int geTimeQuantum(){ return timeQuantum; }
    public int[] getStartTime(){ return startTime; }
    public int[] getCompletionTime(){ return completionTime; }
    public int[] getWaitingTime(){ return waitingTime; }
    public int getTotalWaitingTime(){ return totalWaitingTime; }
    public double getAverageWaitingTime(){ return averageWaitingTime; }
    public int getProcessNum(){ return processNum; }
    public String[] getProcessName(){ return processName; }
    
}
