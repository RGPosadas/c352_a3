import java.util.Random;
public class PriorityQueueSimulatorTester {

    public static void main(String[] args) {
//        int[] maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000};
        int[] maxNumberOfJobs = {10};
        Random randomizer = new Random();
        long start = 0;
        long finish = 0;
        long totalTime = 0;
        int numTerminatedJobs = 0;


        for (int i = 0; i < maxNumberOfJobs.length; i++) {
//            Jobs[] jobsInputArray = new Jobs[maxNumberOfJobs[i]];
//            Jobs[] jobsInputArrayDeepCopy = new Jobs[maxNumberOfJobs[i]];

            //Fill in jobsInputArray
//            for (int j = 0; j < jobsInputArray.length; j++) {
//                int jobsLength = randomizer.nextInt((70 - 1) + 1) + 1;
//                int jobsPriority = randomizer.nextInt((40 - 1) + 1) + 1;
//                jobsInputArray[j] = new Jobs("JOB_" + (j + 1), jobsLength, jobsPriority);
//            }

            //Fill in the other array as a deep copy
//            for (int j = 0; j < jobsInputArray.length; j++) {
//                jobsInputArrayDeepCopy[j] = new Jobs("JOB_" + (j + 1), jobsInputArray[j].getJobLength(), jobsInputArray[j].getJobPriority());
//            }

//            System.out.println(jobsInputArray.length);
//
//            for (int j = 0; j < jobsInputArray.length; j++) {
//                System.out.println(jobsInputArray[j]);
//            }

//            System.out.println("\n\n\n");
//            for (int j = 0; j < jobsInputArray.length; j++) {
//                System.out.println(jobsInputArrayDeepCopy[j]);
//            }


            /////////////////////////////////////////
            // START UNSORTED ARRAY PRIORITY QUEUE
            /////////////////////////////////////////
            Jobs j1 = new Jobs("JOB_1", 4,30);
            Jobs j2 = new Jobs("JOB_2",27,26);
            Jobs j3 = new Jobs("JOB_3",52,19);
            Jobs j4 = new Jobs("JOB_4",21,3);
            Jobs j5 = new Jobs("JOB_5",18,4);
            Jobs j6 = new Jobs("JOB_6",10,16);
            Jobs j7 = new Jobs("JOB_7",2,4);
            Jobs j8 = new Jobs("JOB_8",22,7);
            Jobs j9 = new Jobs("JOB_9",52,32);
            Jobs j10 = new Jobs("JOB_10",25,16);

            Jobs[] jobsInputArray = {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};

            start = System.nanoTime();

            UnsortedArrayPQ unsortedPQ = new UnsortedArrayPQ(jobsInputArray);

            System.out.println("Displaying UnsortedPQ");
            unsortedPQ.display();

            System.out.println(unsortedPQ.getSize());

            while (!unsortedPQ.isEmpty()) {
//                if (numTerminatedJobs < 5) {
                    unsortedPQ.removeMin();
                    numTerminatedJobs++;
//                }
//                else {
//                    unsortedPQ.removeStarvedJob();
//                    numTerminatedJobs = 0;
//                }
            }


            finish = System.nanoTime();
            totalTime = finish - start;



            /////////////////////////////////////////
            // START LL HEAP SORT PRIORITY QUEUE
            /////////////////////////////////////////
            start = System.nanoTime();

            finish = System.nanoTime();
            totalTime = finish - start;
        }
    }
}
