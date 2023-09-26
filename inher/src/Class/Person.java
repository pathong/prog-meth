package Class;

public class Person {
    String name;
	int type = 0;

    //public Person(String name){
		//SetName(name);
    //}

    public void SetName(String name){
		if(name.isBlank()){
			this.name = "FUCK";
			return;
		}
		this.name = name;
    }
	public String GetName(){return this.name;}
	public void PrintName(){
		System.out.println(this.name);
	}

	public void TestBinding(){
		System.out.println("person");
	}


}
