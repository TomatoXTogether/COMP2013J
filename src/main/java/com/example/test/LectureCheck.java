package com.example.test;

import java.io.Serializable;
import java.time.LocalDate;
import com.example.test.Checkbox;

public class LectureCheck extends Lecture implements Serializable {

        public LectureCheck(int lectureID, int lecturerID, String name, int room, int building, String schedule, String startDate, String endDate) {
            super(lectureID, lecturerID, name, room, building, schedule, startDate, endDate);
            // TODO Auto-generated constructor stub
        }


        public transient Checkbox checkbox = new Checkbox();


}
