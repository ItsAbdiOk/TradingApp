public class User{
    private String name;
    public User(String name){
        this.name = name;
    }
// this is a constructor
    public String GetName(){
        return this.name;
    }
//this is a getter
    public void setName(String name){
        this.name=name;
    }
//this is a setter
}