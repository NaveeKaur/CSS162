/**
 * Person class to test in main in TestSet.java
 */
public class Person {
    int age;
    String name;
    public Person(){
    }

    /**
     * Gets the person's age and name
     * @param aAge
     * @param aName
     */
    public Person(int aAge, String aName){
        age=aAge;
        name=aName;
    }

    /**
     * Returns age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns age and name as a string.
     */
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}