public class User {
 private String username;
 private String password;
 private String name;
 private String indentity_number;
 private Boolean gender;
 private String indentity_student;
 private String name_class;


 public User(String username, String password, String name, String indentity_number,Boolean gender,String indentity_student,String name_class) {
  super();
  this.username = username;
  this.password = password;
  this.name = name;
  this.password = password;
  this.indentity_number = indentity_number;
  this.gender = gender;
  this.indentity_student = indentity_student;
  this.name_class = name_class;
 }



 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getIndentity_number() {
  return indentity_number;
 }

 public void setIndentity_number(String indentity_number) {
  this.indentity_number = indentity_number;
 }
 public Boolean getGender() {
  return gender;
 }

 public void setGender(Boolean gender) {
  this.gender = gender;
 }


 public void setIndentity_student(String indentity_student) {
  this.indentity_student = indentity_student;
 }
 public String getIndentity_student() {
  return indentity_student;
 }

 public void setname_class(String name_class) {
  this.name_class = name_class;
 }
 public String getname_class() {
  return name_class;
 }

 
}