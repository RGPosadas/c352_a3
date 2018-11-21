//This array-based PQ is sorted from least priority (index 0) to most priority (index size)
public class SortedPQ {
    private static Jobs[] sortedArray;
    private static long currentTime = 0;
    private static int size = 0; //increments only when a job is inserted in the queue, a job is executed, an iteration for starved job

    /**
     * Parameterized constructor that makes the SortedPQ
     * @param jobsArr The array of Jobs
     */
    public SortedPQ(Jobs[] jobsArr) {
        sortedArray = new Jobs[jobsArr.length];
        insert(jobsArr[0], 0);
        for (int i = 1; i < jobsArr.length; i++) {
            sort(jobsArr[i]);
        }
    }

    /**
     * This method inserts a Job at a specified index
     * @param job
     * @param index
     */
    public void insert(Jobs job, int index) {
        currentTime++;
        sortedArray[index] = job;
        sortedArray[index].setEntryTime(currentTime);
        size++;
    }

    /**
     * This method sorts the list and makes room where the Job has to be inserted
     * @param job
     */
    public void sort(Jobs job) {
        //If the current minimum has a lower priority than the current held job, set the new minimum to the held job
        int holdIndex = -1;
        System.out.println("Now taking " + job);
        for (int i = 0; i < size; i++) {
            if (sortedArray[i].getFinalPriority() >= job.getFinalPriority()) {
                if (sortedArray[i].getFinalPriority() == job.getFinalPriority()) {
                    if (sortedArray[i].getEntryTime() < job.getEntryTime()) {
                        holdIndex = i + 1;
                        break;
                    }
                    else {
                        holdIndex = i;
                        break;
                    }
                }
            }
            //If you get here, you've found the index you want to insert to and it is i - 1
            else {
                holdIndex = i - 1;
                break;
            }
            System.out.println("The index I want to put " + job.getName() + " is " + holdIndex);
            shiftRight(holdIndex);
            insert(job, holdIndex);
        }


    }

    public void shiftRight(int index) {
        for (int i = size - 2; i > index; i--) {
            Jobs holdTemp = sortedArray[i];
            sortedArray[i + 1] = sortedArray[i];
            sortedArray[i] = sortedArray[i - 1];
        }
    }

    public static boolean isEmpty() {
        if (size > 0)
            return true;
        else
            return false;
    }

    public static void removeMin() {
        currentTime++;
    }

    public static void display() {
        System.out.println("====================\nFrom SortedPQ");
        for (int i = 0; i < size; i++) {
            System.out.println(sortedArray[i]);
        }
    }

    public static void removeStarvedJob() {

    }

}