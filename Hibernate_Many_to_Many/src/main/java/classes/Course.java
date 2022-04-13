package classes;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="course")
public class Course {

    // define our fields

    // define constructors

    // define getter setters

    // define tostring

    // annotate fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;


    @OneToMany(fetch=FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name="course_id")
    private List<Review> reviews;


    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
                 name="course_student",
                 joinColumns = @JoinColumn(name = "course_id"),
                 inverseJoinColumns=@JoinColumn(name="student_id") )
    private List<Student> students;


    public Course(){}

    public Course(String title){
        this.title=title;
    }


    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + "]";
    }


    public void add(Review review){

        if (reviews==null)
            reviews=new ArrayList<>();

        reviews.add(review);

    }

    public void addStudent(Student student){
        if(students==null)
            students=new ArrayList<>();
        students.add(student);

    }

}