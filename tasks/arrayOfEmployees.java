/** Jak wygląda tablica obiektów? */

class Person {

    protected String name;

    Person(final String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("Hello! I am %s \n", this.name);
    }

}

class Employee extends Person {

    private double salary;

    Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public String toString() {
        return super.toString() + String.format("My salary: %.2f \n", this.salary);
    }

}

class Main {
    public static void main(String[] args) {

        Person tom = new Person("Tom");
        Person mike = new Employee("Mike", 1200.59);
        Person ann = new Employee("Ann", 600.50);

        final Person[] users = new Person[3];
        users[0] = tom;
        users[1] = mike;
        users[2] = ann;
        
        System.out.println("Hello everybody!");

        for(Person user: users) {
            System.out.println(user);
        }

        System.out.println("Done...");
    }
}
