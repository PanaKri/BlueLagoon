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
public class Schedule {
    private int days = 5;
    private int times = 5;//9-7 available times by 2 hour intervals
    private int numOfRooms = 5;
    private String [][][] examTimes = new String[5][5][5]; //day, time, room, subject and inspector
    public Schedule() { //Constructor
        examTimes = new String[days][times][numOfRooms];
        for (int index = 0; index < days; index++) {
            for (int index1 = 0; index1 < times; index1++) {
                for (int index2 = 0; index2 < numOfRooms; index2++) {
                    this.examTimes[index][index1][index2] = "None";
                }
            } 
        }
    }
    public void addExam(Subject sub, int d, int t) { //Availability Check
        String s = sub.getSubjectName();
        int num = sub.getStudentNumber();
        int day = d;
        int time = t;
        int min = 1000000000;
        int r = 0;
        Room newRoom = Room.rooms[r]; 
        int bestChoice = -1;
        boolean flag = false;
        for (r = 0; r < 5; r++) { // Finds optimized Room for Exam
            newRoom = Room.rooms[r];
            if (newRoom.getNumberOfSeats() >= num & newRoom.getNumberOfSeats() <= min) {
            bestChoice = r;
            min = newRoom.getNumberOfSeats();
            }
        }
        newRoom = Room.rooms[bestChoice];
        do { // Searches when available, if not assigns it later
            if (newRoom.checkAvailability(day, time, bestChoice) == true) {
                this.examTimes[d][t][bestChoice] = s;
                flag = true;
                sub.setExam(day, t, bestChoice);
            } else {
                time = time + 1;
                if (time == 5) {
                    day = day + 1;
                    time = 0;
                }
            }
        } while (flag == false & day < 5);
    }
    public void printSchedule() { //For cmd line
        for (int d = 0; d < 5; d++) {
            System.out.println("Day" + " " + (d + 1)); // Prints day up top
            System.out.println("");
            for (int t = 0; t < 5; t++) {
                System.out.print("Zone" + " " + (t + 1)); //Prints time below day
                for (int r = 0; r < 5; r++) {
                    if (examTimes[d][t][r] != "None") {
                        System.out.print(" Course:" + examTimes[d][t][r] + " on "
                        + "Room:" + r + "  "); //Prints Course and room next to zone
                    }
                }
                System.out.println(""); //Line change
            }
            System.out.println(""); //Line change
            System.out.println(""); //Line change
        }
    }
    public String[][] scheduleArray() { //For UI, womt run if in Terminal
        String[][] scheduleArr = new String[30][6];
        int h = 0;//Tracks the hour based on row
        for (int i = 0; i < 30; i++) {
            if (i % 6 == 0) { //Top rows are the days
                int g = (i % 6) + 1;
                scheduleArr[i][0] = "DAY" + g;
                h = 0;
            } else {
                for (int j = 0; j < 6; j++) {
                    int k = j % 6;
                    if (j % 5 == 0) { //Time on the left
                        scheduleArr[i][j] = "HOUR" + h;
                    } else {
                        if (examTimes[k][h][j-1] != "None") {
                            scheduleArr[i][j] =  examTimes[k][h][j-1] + ","
                            + " Room" + (j - 1); //Saves subject and Room
                        } else {
                            scheduleArr[i][j] = ""; //Displays Nothing
                        }
                    }
                }
                h = h + 1;
            }
            
        }
        return scheduleArr; 
    }
}
