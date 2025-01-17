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
public class Professor {
    private String name;
    private String surname;
    private int am;
    private String[] courses = new String[5];
    public static Professor[] proffessors = new Professor[5];
    public static int profCount = 0;
    public Professor(String name, String surname, int am, String[] courses) { //Constructor
        this.name=name;
        this.surname=surname;
        this.am=am;
        this.courses=courses;
        proffessors[profCount] = this;
        profCount++;
    }
    public void displayInformation() { //Displays a professors info
        System.out.println("Name:" + name);
        System.out.println("Surename:" + surname);
        System.out.println("ID:" + am);
        System.out.println("Courses:");
        for (int i=0; i < courses.length; i++) {
            System.out.println("-" + courses[i]);
        }
    }
    public int getAM() {
        return this.am;
    }
}
