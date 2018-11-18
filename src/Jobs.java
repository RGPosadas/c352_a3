public class Jobs {

   /**
    * Attributes
    */
   private String jobName;
   private int jobLength; //always between 1 and 70 jobs
   private int currentJobLength;
   private int jobPriority; //between 1 and 40
   private int finalPriority;
   private long entryTime;
   private long waitTime;
   private long endTime;
   private static long currentTime = 0;

   /**
    * Default constructor of Jobs class
    * @param jobName
    * @param jobLength
    * @param currentJobLength
    * @param jobPriority
    * @param entryTime
    */
   public Jobs (String jobName, int jobLength, int currentJobLength, int jobPriority, long entryTime) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.currentJobLength = currentJobLength;
        this.jobPriority = this.finalPriority = jobPriority;
        this.entryTime = entryTime;
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