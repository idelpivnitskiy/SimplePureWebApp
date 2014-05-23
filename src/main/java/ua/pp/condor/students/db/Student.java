package ua.pp.condor.students.db;

public class Student {

    private String name;
    private Mark mark1;
    private Mark mark2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mark getMark1() {
        return mark1;
    }

    public void setMark1(Mark mark1) {
        this.mark1 = mark1;
    }

    public Mark getMark2() {
        return mark2;
    }

    public void setMark2(Mark mark2) {
        this.mark2 = mark2;
    }
}
