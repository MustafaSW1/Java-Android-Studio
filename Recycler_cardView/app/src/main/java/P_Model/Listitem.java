package P_Model;

 // diese klasse initialisiert der cardview elemente sowie (Name , alt ,beschreibung)
 // set und get klasse
public class Listitem {


    private String name;
    private String description;
    private String age;

    //Konstrukteur
    public Listitem(String name, String description ,String age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
