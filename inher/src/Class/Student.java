package Class;

public class Student extends Person {
    int grade;
    int type = 1;
    //public Student(String name, int grade){
    //super(name);
    //this.grade = grade;
    //}

    void SetGrade(int grade) {
        this.grade = Math.max(0, grade);
    }

    public int GetGrade() {
        return this.grade;
    }

    public void superDiff() {
        System.out.println(type); // 1
        System.out.println(super.type); //0
    }

    public void TestBinding() {
        System.out.println("student");
    }


}
