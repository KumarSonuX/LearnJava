package learn;

public class StudentUtil {

	private int[] StudentList;
	private char[][] StudentGrades;
	
	public StudentUtil(int[] S, char[][] G){
		this.StudentList = S;
		this.StudentGrades = G;
	}
	
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] gpa = {0.0,0.0,0.0};
        
        for (char[] i : studentsGrades) {
        	int total=0,j=0;
        	for (char c : i) {        		
        		switch(c){
        			case 'A': total+=4;
        			case 'B': total+=3;
        			case 'C': total+=2;
        		}				
			}
			gpa[j++] = (double)total/i.length;
		}
		return gpa;
    }
    
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
		int[] student = null;
		int s,j=0;
		double d;
		double[] gpa = null;
		
		gpa = calculateGPA(studentIdList,studentsGrades);
		
		for(int i = 0;i<studentIdList.length;i++){    	
			s=studentIdList[i];
			d=gpa[i];
			if (lower < d && d <higher)
				student[j++] = s;
		}
        return student;
    }

    public static void main(String args[]){
    	int[] S = {1001,1002,1003};
    	char[][] G= {{'A','B','A'},{'A','B','B','A'},{'B','B','A'}};
    	StudentUtil S1 = new StudentUtil(S,G);
    	
    	double[] gpa = calculateGPA(S,G); 
    	System.out.println("GPA is: "+gpa.toString());
    	
    	int[] Sgpa = getStudentsByGPA(1.1,2.2,S,G);
    	System.out.println("Students by GPA: "+ Sgpa);
    }

}
