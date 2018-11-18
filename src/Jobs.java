public class Jobs {

   /**
    * Attributes
    */
   private String jobName;
   private int jobLength; //always between 1 and 70 jobs, doesn't change
   private int currentJobLength; //-- everytime it is executed
   private int jobPriority; //between 1 and 40, doesn't change
   private int finalPriority; //--, it changes
   private long entryTime;
   private long waitTime;
   private long endTime;
   private static long currentTime = 0; //increments only when a job is inserted in the queue, a job is executed, an iteration for starved,

   /**
    * Default constructor of Jobs class. Used when just making Jobs ohjects
    * @param jobName
    * @param jobLength
    * @param jobPriority
    */
   public Jobs (String jobName, int jobLength, int jobPriority) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.currentJobLength = jobLength;
        this.jobPriority = this.finalPriority = jobPriority;
   }

   public void setCurrentJobLength(int x) {
       currentJobLength = x;
   }

   public int getCurrentJobLength() {
       return currentJobLength;
   }

   public void setFinalPriority(int x) {
       finalPriority = x;
   }

   public int getFinalPriority() {
       return finalPriority;
   }

   public String toString() {
       return "Now executing " + jobName + ". Job length: " + jobLength + "; Current remaining length: " + currentJobLength + "; Initial priority: " + jobPriority + "; Current priority: " + finalPriority;
   }
}