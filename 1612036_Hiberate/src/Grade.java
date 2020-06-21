public class Grade {
	private String indentity_student;
 private String name;
 private Double midTermGrade;
 private Double finalGrade;
 private Double otherGrade;
 private Double totalGrade;
 private String codeSubject;

 private String name_class;


 public Grade( String indentity_student,String name,Double midTermGrade,Double finalGrade, Double otherGrade,Double totalGrade,String codeSubject) {
  super();

  this.name = name;
    this.indentity_student = indentity_student;
  this.midTermGrade = midTermGrade;
  this.finalGrade = finalGrade;
  this.otherGrade = otherGrade;
  this.totalGrade = totalGrade;
  this.codeSubject = codeSubject;
 }



 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }




 public void setIndentity_student(String indentity_student) {
  this.indentity_student = indentity_student;
 }
 public String getIndentity_student() {
  return indentity_student;
 }

 public void setMidTermGrade(Double midTermGrade) {
  this.midTermGrade = midTermGrade;
 }
 public Double getMidTermGrade() {
  return midTermGrade;
 }
  public void setfinalGrade(Double finalGrade) {
  this.finalGrade = finalGrade;
 }
 public Double getFinalGrade() {
  return finalGrade;
 }
  public void setOtherGrade(Double otherGrade) {
  this.otherGrade = otherGrade;
 }
 public Double getOtherGrade() {
  return otherGrade;
 }
  public void setTotalGrade(Double totalGrade) {
  this.totalGrade = totalGrade;
 }
 public Double getTotalGrade() {
  return totalGrade;
 }

  public void setCodeSubject(String codeSubject) {
  this.codeSubject = codeSubject;
 }
 public String getCodeSubject() {
  return codeSubject;
 }

 
}