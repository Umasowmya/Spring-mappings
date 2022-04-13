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

}