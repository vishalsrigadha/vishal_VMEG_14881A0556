import java.util.Date;
import java.util.*;
import java.util.Arrays;
import java.util.Calendar;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	public Student[] getStudents() {
		// Add your implementation here
		
		return this.students;
	}

	
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students == null)
		{
			throw new IllegalArgumentException();
		}
		this.students = students;
	}

	
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length)
		{
			throw new IllegalArgumentException();
		}	
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(index < 0 || index > students.length || student == null)
		{
			throw new IllegalArgumentException();
		}
		this.students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException();
		}
		this.students[0] = student;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException();
		}
		this.students[(this.students.length)-1] = student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(index < 0 || index > students.length || student == null)
		{
			throw new IllegalArgumentException();
		}	
		this.students[index] = student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length)
		{
			throw new IllegalArgumentException();
		}
		
		List<Student> subst = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{	
			if(i != index)
			{
				subst.add(this.students[i]);
			}
		}
		Student[] st = new Student[subst.size()];
		st = subst.toArray(st);
		students = st;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException();
		}
		List<Student> subst = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{	
			if(this.students[i].compareTo(student) != 0)
			{
				subst.add(this.students[i]);
			}
		}
		Student[] st = new Student[subst.size()];
		st = subst.toArray(st);
		students = st;
		
	}

	@Override
	public void removeFromIndex(int index) {
		if(index < 0 || index > students.length)
		{
			throw new IllegalArgumentException();
		}
		this.students = Arrays.copyOfRange(this.students, 0, index);		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0; i<=this.students.length; i++)
		{
			if(this.students[i].compareTo(student) == 0)
			{
				this.students = Arrays.copyOfRange(this.students, 0, i);
				break;
			}
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index > students.length)
		{
			throw new IllegalArgumentException();
		}
		this.students = Arrays.copyOfRange(this.students, index, this.students.length-1);
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException();
			
		}
		for(int i=0; i<=this.students.length; i++)
		{
			if(this.students[i].compareTo(student) == 0)
			{
				this.students = Arrays.copyOfRange(this.students,i, this.students.length-1);
				break;
			}
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		
    for (int a=1; a < this.students.length; a++) {
        for(int b=0; b < this.students.length - a; b++) {
            if (this.students[b].compareTo(this.students[b+1]) > 0)
			{
                //swap movies[b] with movies[b+1]
                Student temp = this.students[b];
                this.students[b] = this.students[b+1];
                this.students[b+1] = temp;
			}
        }
    }
}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null)
		{
			throw new IllegalArgumentException();
			
		}
		List<Student> subst = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{
			if(this.students[i].getBirthDate().equals(date))
			{
				subst.add(this.students[i]);
			}
		}
		Student[] st = new Student[subst.size()];
		st = subst.toArray(st);
		return st;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate == null)
		{
			throw new IllegalArgumentException();
			
		}
		List<Student> subst = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{
			if(this.students[i].getBirthDate().after(firstDate) && this.students[i].getBirthDate().before(lastDate))
			{
				subst.add(this.students[i]);
			}
		}
		Student[] st = new Student[subst.size()];
		st = subst.toArray(st);
		return st;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation her
		if(date == null)
		{
			throw new IllegalArgumentException();			
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		Date end = c.getTime();
		
		List<Student> subst = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{
			if(this.students[i].getBirthDate().after(date) && this.students[i].getBirthDate().before(end))
			{
				subst.add(this.students[i]);
			}
		}
		Student[] st = new Student[subst.size()];
		st = subst.toArray(st);
		return st;		
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent == 0)
		{
			throw new IllegalArgumentException();
			
		}
		Calendar c = Calendar.getInstance();
		Date today = c.getTime();
		Date birth = this.students[indexOfStudent].getBirthDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(birth);
		int cur = c.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
		if((c.get(Calendar.MONTH)-c1.get(Calendar.MONTH))<0)
		{
			cur = cur-1;
		}
		return cur;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		List<Student> subst = new ArrayList<Student>();
		for(int i=0;i<this.students.length;i++)
		{
			if(getCurrentAgeByDate(i) == age){
				subst.add(this.students[i]);
		}
		}
		Student[] st = new Student[subst.size()];
		st = subst.toArray(st);
		return st;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		List<Student> subst = new ArrayList<Student>();
		double maxavg = this.students[0].getAvgMark();
		for(int i=0;i<this.students.length;i++)
		{
			if(maxavg < this.students[i].getAvgMark())
			{
				maxavg = this.students[i].getAvgMark();
			}
		}
		for(int i=0;i<this.students.length;i++)
		{
			if(this.students[i].getAvgMark() == maxavg)
			{
				subst.add(this.students[i]);
			}
		}
		Student[] st = new Student[subst.size()];
		st = subst.toArray(st);
		return st;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		
		if(student == null)
		{
			throw new IllegalArgumentException();
		}
		for(int i=0; i<=this.students.length; i++)
		{
			if(this.students[i].compareTo(student) == 0)
			{
				return this.students[i+1];
			}
		}
		return null;
	}
}
