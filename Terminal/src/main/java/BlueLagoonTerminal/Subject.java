/*
 * Copyright 2025 BlueLagoon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package BlueLagoonTerminal;
public class Subject {
    private int subjectCode;
    private int studentNumber;
    private String courseName;
    private int professorAM;
    public int examRoomNumber;
    private int examDate;
    private int examTime;
    private boolean exam = false;
    public static Subject[] subjects = new Subject[10];
    public static int subjectCount = 0;
    //Constructor
    public Subject(int subjectCode, int studNumber, int professorAM, 
        int examrRoomNum, String courseName, int examDate, int examTime) {
        this.courseName = courseName;
        this.subjectCode = subjectCode;
        this.studentNumber = studNumber;
        this.professorAM = professorAM;
        examRoomNumber = 0;
        this.examDate = examDate;
        this.examTime = examTime;
        subjects[subjectCount] = this;
        subjectCount++;
    }
    public String getSubjectName() {
        return this.courseName;
    }
    public int getSubjectCode() {
        return this.subjectCode;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public int getProfessorAm() {
        return professorAM;
    }
    public void getInfo() {
        System.out.println("this is subject " + subjectCode
        + " is taught by " + professorAM + " with enrolled " 
        + studentNumber + " students");
    }
    public void addStudent() {
        this.studentNumber = this.studentNumber + 1;
    }
    public boolean checkExam() {
        if (exam == true) { //if exam is set, returns true
            System.out.println("");
            System.out.println("Exam set on day " + examDate + ", time " 
            + examTime + " on Room " + examRoomNumber);
            return true;
        } else {
            return false;
        }
    }
    public void setExam(int d, int t, int r) {
        examDate = d + 1;
        examRoomNumber = r;
        examTime = t + 1;
        exam = true; //Signals that exam is set
    }
}
