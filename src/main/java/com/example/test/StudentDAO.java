package com.example.test;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.example.test.LecturerDAO.getAllLecturers;

public class StudentDAO {
    public static List<User> getAllStudents() {
        List<User> users = new ArrayList<User>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT DISTINCT studentID, name, email, password FROM students");

            while (rs.next()) {
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int password = rs.getInt("password");

                Student e = new Student(studentID, name, password, email);

                users.add(e);
            }

            rs.close();
            st.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static Student getStudentByID(int studentID) {
        Student student  = null;
        for (User s : getAllStudents()) {
            if (s.getID() == studentID) {
                student = (Student) s;
                break;
            }
        }

        return student;
    }

    public static List<Student> getStudentsByLectureID(String lectureID) {
        List<Student> students = new ArrayList<Student>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE lectureID = '" + lectureID + "'");

            while (rs.next()) {
                int studentID = rs.getInt("studentID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int password = rs.getInt("password");
                String grade = rs.getString("grade");
                Student student = getStudentByID(studentID);
                student.setName(student.getLectureName());


                Student e = new Student(studentID, name, password, email);
                e.setGrade(grade);

                students.add(e);
            }
            rs.close();
            st.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    //以下三类用于更新学生所选课程
    //getAllLectures: 用于显示学生所选课程
    //selectLecture: 用于添加学生所选课程
    //cancelLecture: 用于删除学生所选课程
    public static List<Lecture> getAllLectures(int studentID) {
        List<Lecture> lectures = new ArrayList<Lecture>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT lectureID, grade FROM students WHERE studentID =" + studentID);

            while (rs.next()) {
                String lectureID = rs.getString("lectureID");
                String grade = rs.getString("grade");
                Lecture lecture = LectureDAO.getLectureByID(lectureID);

                if (lecture != null) {
                    lecture.setGrade(grade);
                }


                lectures.add(lecture);
                StudentDAO.getStudentByID(studentID).lectures = lectures;
        }
            rs.close();
            st.close();
            conn.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return lectures;
    }

    public static List<Lecture> selectLecture(Student student, Lecture lecture) {
        try {
            Connection conn = JDBCTool.getConnection();

            PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*), lectureID FROM students WHERE studentID = ? AND lectureID = ?");
            checkStmt.setInt(1, student.getID());
            checkStmt.setString(2, lecture.getLectureID());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            String lectureID = rs.getString(2);
            checkStmt.close();

            if(count == 0){
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (studentID, lectureID, name, email, password, grade) VALUES (?, ?, ?, ?, ?, ?);");

                stmt.setInt(1, student.getID());
                stmt.setString(2, lecture.getLectureID() );
                stmt.setString(3, student.getName());
                stmt.setString(4, student.getEmail());
                stmt.setInt(5, student.getPassword());
                stmt.setString(6, "null");
                stmt.executeUpdate();

                student.lectures.add(lecture);
                stmt.close();
            }else if (count == 1 && lectureID.equals("null")){
                PreparedStatement stmt = conn.prepareStatement("UPDATE students SET lectureID = ? WHERE studentID = ?");

                stmt.setString(1, lecture.getLectureID() );
                stmt.setInt(2, student.getID());

                student.lectures.add(lecture);
                stmt.close();
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student.lectures;
    }

    public static List<Lecture> cancelLecture(Student student, Lecture lecture) {
        List<Lecture> lectures = getAllLectures(student.getID());
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement st = conn.prepareStatement("DELETE from students where lectureID = ? and studentID = ?");

            st.setString(1, lecture.getLectureID());
            st.setInt(2, student.getID());
            st.executeUpdate();

            lectures.remove(lecture);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lectures;
    }

    public static void registerStudent(Student student) {

        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO students(studentID, lectureID, name, email, password, grade) VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, student.getID());
            stmt.setString(2,  "null");
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getEmail());
            stmt.setInt(5, student.getPassword());
            stmt.setString(6, "null");
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateStudentGrade(int studentID, String lectureID, String newGrade) {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE students SET grade = ? WHERE studentID = ? AND lectureID = ?");
            stmt.setString(1, newGrade);
            stmt.setInt(2, studentID);
            stmt.setString(3, lectureID);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changePassword(Student student, int password) {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE students SET password = ? WHERE studentID = ?");
            stmt.setInt(1, password);
            stmt.setInt(2, student.getID());
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
