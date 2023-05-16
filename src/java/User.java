package java;

public class User {

    private String fname;
    private String lname;
    private String username;
    private String email;
    private String pass;
    private String phno;

    // Payment method pending
    private int type;

    public User(String fname, String lname, String username,String email, String pass, String phno, int type){
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.phno = phno;
        this.type = type;
    }


    void set_fname(String fname){
        this.fname=fname;
    }   
    String get_fname(){
        return this.fname;
    }
    
    void set_lname(String lname){
        this.lname=lname;
    }   
    String get_lname(){
        return this.lname;
    }
    
    void set_username(String username){
        this.username=username;
    }   
    String get_username(){
        return this.username;
    }


    void set_email(String email){
        this.email=email;
    }   
    String get_email(){
        return this.email;
    }

    void set_pass(String pass){
        this.pass=pass;
    }   
    String get_pass(){
        return this.pass;
    }

    void set_phno(String phno){
        this.phno = phno;
    }   
    String get_phno(){
        return this.phno;
    }

    void set_type(int type){
        this.type=type;
    }   
    int get_type(){
        return this.type;
    }    

}
