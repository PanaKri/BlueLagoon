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
public class Room {
    private int numberOfSeats;
    private int roomNumber;    
    public boolean availability[][] = new boolean[5][5];
    public static Room[] rooms = new Room[10];
    public static int roomCount = 0;
    // Constructor
    public Room(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        this.roomNumber = roomCount;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.availability[i][j] = true;
            }
        }
        rooms[roomCount] = this;
        this.roomNumber = roomCount;
        roomCount++;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public boolean checkAvailability(int day, int hour, int r) { 
        if (this.availability[day][hour] == true) { //Checks if its available on selected day and hour
            this.availability[day][hour] = false;
            System.out.println("");
            System.out.println("Room " + r + " is available on Day " + (day + 1) + " "
            + "Hour " + (hour + 1) +  " ,set exam in this day on this room");
            return true;
        } else {
            System.out.println("Not available on day " + day + " Hour" + hour);
            return false;
        }
    }
}
