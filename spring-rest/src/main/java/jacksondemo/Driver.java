package jacksondemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            Student s = mapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("First name is "+s.getFirstName());

            System.out.println("Last name is "+s.getLastName());

            Address a = s.getAddress();

            System.out.println("Street is "+a.getStreet());

            System.out.println("city is "+a.getCity());

            System.out.print("Known languages are ");
            for(String t : s.getLanguages()){
                System.out.print(t+",");
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


}
