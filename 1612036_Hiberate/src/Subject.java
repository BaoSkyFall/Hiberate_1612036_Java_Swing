public class Subject {
 private String code_subject;
 private String name;
 private String room;
 private String name_class;


 public Subject(String code_subject, String name, String room,String name_class) {
  super();
  this.code_subject = code_subject;
  this.name = name;
  this.room = room;
  this.name_class = name_class;
 }



 public String getCode_subject() {
  return code_subject;
 }

 public void setCode_subject(String code_subject) {
  this.code_subject = code_subject;
 }



 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getRoom() {
  return room;
 }

 public void setRoom(String room) {
  this.room = room;
 }


 public void setname_class(String name_class) {
  this.name_class = name_class;
 }
 public String getname_class() {
  return name_class;
 }

 
}