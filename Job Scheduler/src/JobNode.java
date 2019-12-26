/**
 * File Header COMES HERE
 */
 
/**
 * JavaDoc Class Header COMES HERE
 *
 */
 
public class JobNode {
		
	// Class Fields
	private static int jobCount = 0; // number of jobs already created
	
	// Object Fields
	private int    jobId; 			// unique job identifier
	private float  arrivalTime;      // arrival time in seconds
	private int    userId;			// identifier of the user that created the job
	private int    priority; 		// job priority
	private int    timeToLive; 	    // job Time To Live in seconds
	private String description;     // job description
	
	private JobNode next;           // reference to the next job in the linked list
	
	// Constructor using fields
	/**
	 * Description of the constructor comes here
	 * @param arrivalTime
	 * @param userId
	 * @param priority
	 * @param ttl
	 * @param description
	 */
	public JobNode(float arrivalTime, int userId, int priority, int ttl, String description) {
		
		this.arrivalTime = arrivalTime;
		this.userId      = userId;
		this.priority    = priority;
		this.timeToLive  = ttl;
		this.description = description;
		
	}
	
	// You can overload your class by other constructors
	
	public void setNext(JobNode nextNode) {
		this.next = nextNode;
	}
	
	public int getJobId() {
		return this.jobId;
	}
	
	public float getArrivalTime() {
		return this.arrivalTime;
	}

	public int getUserId() {
		return this.userId;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public int getTimeToLive() {
		return this.timeToLive;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public JobNode getNext() {
		return this.next;
	}
 
	
	/**
	 * This method returns a new reference to a copy of the current JobNode
	 * @return a new reference to a copy of this (instanceof JobNode)
	 */
	public JobNode copy() {
		return this.next; 
		
	}
}