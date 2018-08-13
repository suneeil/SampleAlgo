package reflections1;

public class Employee extends Human{
	
		public int eno;
		public static String eName;
		public String addr;
		
		public Employee(){
			
		}
		
		public void employee(int eno, String eName, String addr){
			this.eno = eno;
			this.eName = eName;
			this.addr = addr;
		}
		
		public void add(int eno, String eName, String addr){
			System.out.println(" Add method");
		}
		
		public void search(int eno){
			System.out.println("Saerch eno: "+ eno);
		}
		
		public void ename(){
			System.out.println(">>>>>>>>>> ename");
		}
		
		public void language(){
			System.out.println(">>>>>>>>>> Language");
		}
		
		public void country(){
			System.out.println(">>>>>>>>>> Country");
		}
		
}
