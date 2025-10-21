package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Scheduler {
    private int[] arrivalTime;
    private int[] burstTime;
    private int[] startTime;
    private int[] completionTime;
    private int[] waitingTime;
    private int[] turnaroundTime;
    private int totalTurnaroundTime = 0;
    private int timeQuantum;
    private int totalWaitingTime = 0;
    private double averageWaitingTime = 0;
    private double averageTurnaroundTime = 0;
    private int processNum, temp;
    public String[] processName;
    private String tempStr;
    private boolean[] visited;
    int[] remainingBurstTime;
    int[] ganttProcess = new int[100];
    int[] ganttStart = new int[100];
    int ganttIndex = 0; 
    int time;
    
    public Scheduler(int[] arrivalTime, int[] burstTime, String algo){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        processNum = arrivalTime.length;
        startTime = new int[processNum];
        completionTime = new int[processNum];
        waitingTime = new int[processNum];
        processName = new String[processNum];
        if(algo.equalsIgnoreCase("fcfs")) 
            scheduleFcfs();
        else if(algo.equalsIgnoreCase("sjn")) 
            scheduleSjn();
    }
    public Scheduler(int[] arrivalTime, int[] burstTime, int timeQuantum){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.timeQuantum = timeQuantum;
        processNum = arrivalTime.length;
        completionTime = new int[processNum];
        waitingTime = new int[processNum];
        processName = new String[processNum];
        turnaroundTime = new int[processNum];
        visited = new boolean[processNum];
        remainingBurstTime = new int[processNum];
        startTime = new int[processNum];

        scheduleRr();
    }
    
    
    // FCFS - Kryzza
    public void scheduleFcfs(){
        totalWaitingTime = 0;
        averageWaitingTime = 0;
        time = 0;
        Arrays.fill(startTime, 0);
        Arrays.fill(completionTime, 0);
        Arrays.fill(waitingTime, 0);

        for (int i = 0; i < processNum; i++) {
            processName[i] = String.format("P%d", i+1);
        }
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
    
    
    // SJN - Miko
    private void scheduleSjn() {
        totalWaitingTime = 0;
        averageWaitingTime = 0;
        time = 0;

        int[] at = arrivalTime.clone();
        int[] bt = burstTime.clone();
        String[] pn = new String[processNum];
        boolean[] done = new boolean[processNum];

        for (int i = 0; i < processNum; i++) {
            pn[i] = "P" + (i + 1);
        }

        for (int i = 0; i < processNum - 1; i++) {
            for (int j = 0; j < processNum - i - 1; j++) {
                if (at[j] > at[j + 1]) {
                    int temp = at[j]; 
                    at[j] = at[j + 1]; 
                    at[j + 1] = temp;
                    
                    temp = bt[j]; 
                    bt[j] = bt[j + 1]; 
                    bt[j + 1] = temp;
                    
                    String tempStr = pn[j]; 
                    pn[j] = pn[j + 1]; 
                    pn[j + 1] = tempStr;
                }
            }
        }

        int completed = 0;
        int currentTime = at[0];

        int index = 0;

        while (completed < processNum) {
            int idx = -1;
            int shortest = Integer.MAX_VALUE;

            for (int i = 0; i < processNum; i++) {
                if (!done[i] && at[i] <= currentTime && bt[i] < shortest) {
                    shortest = bt[i];
                    idx = i;
                }
            }

            if (idx == -1) {
                currentTime++;
                continue;
            }

            processName[index] = pn[idx];
            arrivalTime[index] = at[idx];
            burstTime[index] = bt[idx];

            startTime[index] = currentTime;
            completionTime[index] = startTime[index] + bt[idx];
            waitingTime[index] = startTime[index] - at[idx];

            totalWaitingTime += waitingTime[index];
            currentTime = completionTime[index];

            done[idx] = true;
            completed++;
            index++;
        }

        averageWaitingTime = (double) totalWaitingTime / (double)processNum;
    }
    
    
    
    // RR - Gerald
    private void scheduleRr() {
        totalTurnaroundTime = 0;
        totalWaitingTime = 0;
        averageWaitingTime = 0;
        averageTurnaroundTime = 0;
        ganttIndex = 0;
        time = 0;
        Arrays.fill(startTime, 0);
        Arrays.fill(completionTime, 0);
        Arrays.fill(waitingTime, 0);
        Arrays.fill(visited, false);

        for (int i = 0; i < processNum - 1; i++) {
            for (int j = 0; j < processNum - i - 1; j++) {
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

        for (int i = 0; i < processNum; i++) {
            remainingBurstTime[i] = burstTime[i];
            processName[i] = "P" + (i + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        int completed = 0;

        for (int i = 0; i < processNum; i++) {
            if (arrivalTime[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }

        while (completed < processNum) {
            if (queue.isEmpty()) {
                time++;
                for (int i = 0; i < processNum; i++) {
                    if (!visited[i] && arrivalTime[i] <= time) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
                continue;
            }

            int i = queue.poll();

            if (remainingBurstTime[i] == burstTime[i]) {
                startTime[i] = time;
            }

            ganttStart[ganttIndex] = time;
            ganttProcess[ganttIndex] = i;
            ganttIndex++;

            int execTime = Math.min(remainingBurstTime[i], timeQuantum);
            remainingBurstTime[i] -= execTime;
            time += execTime;


            for (int j = 0; j < processNum; j++) {
                if (!visited[j] && arrivalTime[j] <= time) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
            if (remainingBurstTime[i] == 0) {
                completionTime[i] = time;
                turnaroundTime[i] = completionTime[i] - arrivalTime[i];
                waitingTime[i] = turnaroundTime[i] - burstTime[i];
                completed++;
            } else {
                queue.add(i);
            }
        }

        for (int i = 0; i < processNum; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        averageWaitingTime = (double) totalWaitingTime / processNum;
        averageTurnaroundTime = (double) totalTurnaroundTime / processNum;
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
    public int getGanttIndex() { return ganttIndex; }
    public int getTime() { return time; }
    public int[] getGanttProcess() { return ganttProcess; }
    public int[] getGanttStart() { return ganttStart; }
    public int[] getTurnaroundTime() { return turnaroundTime; };
    public double getAveTurnaroundTime(){ return averageTurnaroundTime; }
    public int getTotalTurnaroundTime(){ return totalTurnaroundTime; }
}
