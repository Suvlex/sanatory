import entitys.Patient;
import services.DBConnector;
import services.DoctorService;
import services.PatientService;
import services.PlaceService;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import static util.Util.showMessage;

public class Main {
  public static void main(String[] args) throws IOException, SQLException {
    PatientService patientService = PatientService.getInstance();

    DoctorService doctorService = DoctorService.getInstance();
//CREATE »
/*Patient patient = new Patient();
patient.setFirst_name("Valerar");
patient.setSecond_name("Svetloff");
patient.setLast_name("Tu-Tu");
patient.setDate_of_birth(new Date(87, 7, 29));
patient.setPhone_number(380633798443L);

if (!patientService.create(patient))
showMessage("ERROR:", patient.toString() + " NOT CREATED IN DB !", JOptionPane.ERROR_MESSAGE);
else showMessage("COMPLETE:", patient.toString() + "ADDED TO DB !", JOptionPane.INFORMATION_MESSAGE);*/
//READ»
    /*System.err.print("Ddd search parameter\n(int or String):");
    String next = new Scanner(System.in).next();
    System.out.println(patientService.read(next));*/
//read doctor
/*    System.err.print("Ddd search parameter\n(int or String):");
    String next = new Scanner(System.in).next();
    System.out.println(doctorService.read(next));*/
// UPDATE»
    System.err.print("Ddd search parameter\n(int or String):");
    String next = new Scanner(System.in).next();
    System.out.println(patientService.update(next));
//DELETE» ONLY FOR 'PLACE' (~FOREIGN_KEY~)!!!

//GET ALL»

  }
}
