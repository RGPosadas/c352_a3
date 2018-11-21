public class UnsortedArrayPQ {
    private static Jobs[] unsortedArray;
    private static long currentTime = 0;
    private static int size = 0; //increments only when a job is inserted in the queue, a job is executed, an iteration for starved job
    private static int priorityChanged = 0;
    private static double totalWaitTime = 0;

    /**
     * Parameterized constructor that makes the SortedPQ
     * @param jobsArr The array of Jobs
     */
    public UnsortedArrayPQ(Jobs[] jobsArr) {
        unsortedArray = new Jobs[jobsArr.length];
        for (int i = 0; i < jobsArr.length; i++) {
            initialInsert(jobsArr[i], i);
        }
    }

    /**
     * This method inserts a Job at a specified index
     * @param job
     * @param index
     */
    public static void initialInsert(Jobs job, int index) {
        currentTime++;
        unsortedArray[index] = job;
        unsortedArray[index].setEntryTime(currentTime);
        size++;
    }

    public void insert(Jobs job, int index) {
        currentTime++;
        unsortedArray[index] = job;
        size++;
    }

    public static int getSize() {
        return size;
    }

    public static boolean isEmpty() {
        if (size > 0)
            return false;
        else
            return true;
    }

    public void removeMin() {
        currentTime++;

        //Search for smallest priority
//        Jobs toExecute = unsortedArray[0];
//        int holdIndex = 0;
        Jobs toExecute = null;
        int holdIndex = -1;
        for (int i = 0; i < size - 1; i++) {
//            if (unsortedArray[i].getFinalPriority() >= toExecute.getFinalPriority()) {//if index[i] is bigger than or equal to the current highest priorty
//                //if both of them are the same priorty
                if (unsortedArray[i].getFinalPriority() == unsortedArray[i + 1].getFinalPriority()) {
                    if (unsortedArray[i + 1].getHasExecuted() == true && unsortedArray[i].getHasExecuted() == false) {//if toExecute already has been executed before but the one its comparing to hasn't
                        toExecute = unsortedArray[i];
                        holdIndex = i;
                    }
                    else if (unsortedArray[i + 1].getHasExecuted() == false && unsortedArray[i].getHasExecuted() == true) {
                        toExecute = unsortedArray[i + 1];
                        holdIndex = i;
                    }
                    //if none of them have ever been executed before
                    else if ( unsortedArray[i + 1].getHasExecuted() == false && unsortedArray[i].getHasExecuted() == false && unsortedArray[i].getEntryTime() < unsortedArray[i + 1].getEntryTime()) {//if index[i] has a higher priority than toExecute
                        toExecute = unsortedArray[i];
                        holdIndex = i;
                    }
                    //if both have already been executed then execute the one that has been executed the least
                    else if (unsortedArray[i + 1].getHasExecuted() == true && unsortedArray[i].getHasExecuted() == true) {
                        if ((unsortedArray[i + 1].getJobLength() - unsortedArray[i + 1].getCurrentJobLength()) > (unsortedArray[i].getJobLength() - unsortedArray[i].getCurrentJobLength()) ) {
                            toExecute = unsortedArray[i];
                            holdIndex = i;
                        }
                        else {
                            toExecute = unsortedArray[i + 1];
                            holdIndex = i;
                        }
                    }
                }
//            }
            else if (unsortedArray[i].getFinalPriority() < unsortedArray[i + 1].getFinalPriority()){ //if index[i] has a higher priorty than the current highest priority
                toExecute = unsortedArray[i];
                holdIndex = i;
            }
        }
//        System.out.println("Found " + toExecute.getName() + " as smallest with priority " + toExecute.getFinalPriority());
//        System.out.println("Executed " + toExecute.getName());

        toExecute.setCurrentJobLength(toExecute.getCurrentJobLength() - 1);
        toExecute.setHasExecuted();
//        toExecute.setFinalPriority(changePriority());
        System.out.println(toExecute);
        if (toExecute.getCurrentJobLength() > 0) {
            shiftLeft(holdIndex);
            insert(toExecute, size);
        }
        //If job is terminated
        else {
            shiftLeft(holdIndex);
            toExecute.setEndTime(currentTime);
            toExecute.setWaitTime(toExecute.getEndTime() - toExecute.getEntryTime() - toExecute.getJobLength());
            totalWaitTime += toExecute.getWaitTime();
        }

    }

    public int changePriority() {
        int lowestPriority = unsortedArray[0].getFinalPriority();
        for (int i = 1; i < size; i++) {
            if (lowestPriority < unsortedArray[i].getFinalPriority()) {
                lowestPriority = unsortedArray[i].getFinalPriority();
            }
        }
        priorityChanged++;
//        System.out.println("lowest priority is : " + lowestPriority);
        if (lowestPriority == 40)
            return 40;
        else
            return lowestPriority + 1;
    }

    public void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            unsortedArray[i] = unsortedArray[i + 1];
        }
        size--;
    }
    public static void fullyExecuted(Jobs job) {

    }

    public static void display() {
        System.out.println("====================\nFrom UnsortedPQ");
        for (int i = 0; i < unsortedArray.length; i++) {
            System.out.println(unsortedArray[i]);
        }
    }

    public static void removeStarvedJob() {
        currentTime++;
        Jobs lowestPriority = null;
        for (int i = 0; i < size - 1; i++) {
            if (unsortedArray[i].getFinalPriority() > unsortedArray[i + 1].getFinalPriority() && unsortedArray[i].getHasExecuted() == false)
                lowestPriority = unsortedArray[i];
        }
        if (lowestPriority != null) {
            lowestPriority.setFinalPriority(1);
            System.out.println("Lowest job is " + lowestPriority);
        }
    }

    public static double getAverageWaitTime() {
        return (totalWaitTime/unsortedArray.length);
    }
}
