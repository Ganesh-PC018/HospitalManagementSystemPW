import java.util.*;

class Doctor
{
    private String doctorName;
    private String doctorId;
    private String specility;

    Doctor(String doctorName,String doctorId,String specility)
    {
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.specility = specility;
    }

    public String getDoctorName()
    {
        return doctorName;
    }

    public String getDoctorId()
    {
        return doctorId;
    }

    public String getSpecility()
    {
        return specility;
    }

    public String toString()
    {
        return "Doctor[Name : "+getDoctorName()+" , Id : "+getDoctorId()+" , Specialization : "+getSpecility()+"]";
    }
}

class Patient
{
    private String patientId;
    private String patientName;
    private String patientAddress;
    private int age;

    public Patient(String patientId,String patientName,String patientAddress,int age)
    {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.age = age;
    }

    public String getPatientId()
    {
        return patientId;
    }
    public String getPatientName()
    {
        return patientName;
    }

    public String getPatientAddress()
    {
        return patientAddress;
    }

    public int getAge()
    {
        return age;
    }

    public String toString()
    {
        return "Patient[Name : "+getPatientName()+" , Id : "+getPatientId()+" , Address : "+getPatientAddress()+" , Age : "+getAge()+"]";
    }
}

class Appointment
{
    private String appointmentId;
    private Doctor doctor;
    private Patient patient;

    public Appointment(String appointmentId,Doctor doctor,Patient patient)
    {
        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
    }
    public String getAppointmentId()
    {
        return appointmentId;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public String toString()
    {
        return "Appointment[AppointmentId : "+getAppointmentId()+", \n\t\t\t\tDoctor : "+getDoctor()+",\n\t\t\t\t Patient : "+getPatient()+"]";
    }
}
public class HospitalManagementSystem {
    static int doctorCount =0;
    static int patientCount =0;
    static int appointmentCount =0;

    public static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner stringSc = new Scanner(System.in);
        ArrayList<Doctor> dl = new ArrayList<Doctor>();
        ArrayList<Patient> pl = new ArrayList<Patient>();
        ArrayList<Appointment> al = new ArrayList<Appointment>(); 
        int choice =0;
        do
        {
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Book Apointment");
            System.out.println("4. Display Doctor List");
            System.out.println("5. Display Patient Details");
            System.out.println("6. Display Appintment Details");
            System.out.println("6. Clear System");
            System.out.print("Enter Your Choice : ");
            choice= sc.nextInt();
            switch (choice) {
                case 1:
                        System.out.print("Enter Doctor Name : ");
                        String doctorName = stringSc.nextLine();
                        System.out.print("Enter Doctor Id   : ");
                        String doctorId = stringSc.nextLine();
                        System.out.print("Enter Doctor Specialization : ");
                        String doctorSpecility = stringSc.nextLine();
                        dl.add(new Doctor(doctorName, doctorId, doctorSpecility));
                        System.out.println("\n\nDoctor Details Added Successfully...!!!");
                        break;
                case 2 :
                        System.out.print("Enter The Patient Name    : ");
                        String patientName = stringSc.nextLine();
                        System.out.print("Enter The Patient Id      : ");
                        String patientId = stringSc.nextLine();
                        System.out.print("Enter The Patient Address : ");
                        String patientAddress = stringSc.nextLine();
                        System.out.print("Enter The Patient Age     : ");
                        int age = sc.nextInt();
                        pl.add(new Patient(patientId, patientName, patientAddress, age));
                        System.out.println("\n\nPatient Added Successfully....!!!");
                        break;
                case 3 :
                        if(dl.isEmpty() || pl.isEmpty())
                        {
                            System.out.println("Thier is not Doctor or Patient Registered....!!!");
                        }
                        else
                        {
                        System.out.print("Enter AppointmentId : ");
                        String appointmentId = stringSc.nextLine();
                        System.out.println("Select Doctor Id ");
                        for(Doctor d : dl)
                        {
                            System.out.println("\t\t\t"+d.getDoctorName() +"  :  "+d.getDoctorId());
                        }
                        
                        System.out.print("Enter Doctor id : ");
                        String selectedDoctorId = stringSc.nextLine();
                        System.out.println("Select Patient Id : ");
                        for(Patient p : pl)
                        {
                            System.out.println("\t\t\t"+p.getPatientName() +"  :  "+p.getPatientId());
                        }
                        System.out.print("Enter Patient Id : ");
                        String selectedPatientId = stringSc.nextLine();
                        Iterator doctorList = dl.iterator();
                        Doctor selectDoctor = null;
                        while(doctorList.hasNext())
                        {
                            Doctor d1 = (Doctor)doctorList.next();
                            if(d1.getDoctorId().equals(selectedDoctorId))
                            {
                                selectDoctor = d1;
                            }
                        }

                        Iterator patientList = pl.iterator();
                        Patient selectPatient = null;
                        while(patientList.hasNext())
                        {
                            Patient p1 = (Patient)patientList.next();
                            if(p1.getPatientId().equals(selectedPatientId))
                            {
                                selectPatient = p1;
                            }
                        }

                        if(selectDoctor == null)
                        {
                            System.out.println("Thier is no such Doctor Available...!!!!");
                            break;
                        }
                        if(selectPatient == null)
                        {
                            System.out.println("Thier is no such Patient Available...!!!!");
                            break;
                        }

                        al.add(new Appointment(appointmentId, selectDoctor, selectPatient));
                        System.out.println("Booked Appointment Successfully...!!!!");
                    }
                    break;   
            
            case 4 :
                    Iterator doctorList = dl.iterator();
                    while(doctorList.hasNext())
                    {
                        System.out.println(doctorList.next());
                        doctorCount++;
                    }
                    System.out.println(doctorCount +" Doctor's Registered....!!!");
                    break;
            case 5 :
                    Iterator patientList = pl.iterator();
                    while(patientList.hasNext())
                    {
                        System.out.println(patientList.next());
                        patientCount++;
                    }
                    System.out.println(patientCount +" Pantient's Registered....!!!");
                    break;
            case 6 : 
                    Iterator appointmentList = al.iterator();
                     while(appointmentList.hasNext())
                    {
                        System.out.println(appointmentList.next());
                        appointmentCount++;
                    }
                    System.out.println(appointmentCount +" Appointment's Registered....!!!");
                    break;
                default:
                        System.out.println("Error");
                    break;
            }
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            HospitalManagementSystem.clearConsole();
        }while(choice != 0);
    }
}
