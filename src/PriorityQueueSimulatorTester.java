import java.util.Random;
public class PriorityQueueSimulatorTester {

    public static void main(String[] args) {
//        int[] maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000};
        int[] maxNumberOfJobs = {100};
        Random randomizer = new Random();

        for (int i = 0; i < maxNumberOfJobs.length; i++) {
            Jobs[] jobsInputArray = new Jobs[maxNumberOfJobs[i]];

            for (int j = 0; j < jobsInputArray.length; j++) {
                int jobsLength = randomizer.nextInt((70 - 1) + 1) + 1;
                int jobsPriority = randomizer.nextInt((40 - 1) + 1) + 1;
                jobsInputArray[j] = new Jobs("JOB_" + (j + 1), jobsLength, jobsPriority);
            }

            for (int j = 0; j < jobsInputArray.length; j++) {
                System.out.println(jobsInputArray[j]);
            }
        }
    }
}
