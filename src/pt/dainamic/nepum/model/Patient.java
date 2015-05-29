package pt.dainamic.nepum.model;


public class Patient extends User{

    private int idPatient;
    private int nif;
    private String maritalStatus;
    private String gender;
    private String pathology;
    private String description;
    private int idHealthProfessional;

    public Patient() {
      super();
    }

    /**
     * @param name
     * @param lastName
     * @param numCC
     * @param picture
     * @param adress
     * @param numTel
     * @param nif
     * @param email
     * @param maritalStatus
     * @param birthDate
     * @param bloodGroup
     * @param nationality
     * @param gender
     * @param password
     * @param pathology
     * @param description
     * @param idHealthProfessional
     */
    public Patient(String name, String lastName, int numCC, String picture,
            String adress, int numTel, int nif, String email, String maritalStatus, String birthDate,
            String bloodGroup, String nationality, String gender, String password, String pathology,
            String description, int idHealthProfessional) {
        super(name, lastName, numCC, picture, adress, numTel, email, birthDate, bloodGroup, nationality, password);
        this.nif = nif;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.pathology = pathology;
        this.description = description;
        this.idHealthProfessional = idHealthProfessional;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getIdHealthProfessional() {
        return idHealthProfessional;
    }


    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String miritalState) {
        this.maritalStatus = miritalState;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPathology() {
        return pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Patient{" + "idPatient=" + idPatient + ", name=" + this.getName() + ", lastName=" + this.getLastName()
                + ", numCC=" + this.getNumCC() + ", adress=" + this.getAdress() + ", numTel=" + this.getNumTel() + ", nif=" + nif
                + ", email=" + this.getEmail() + ", maritalStatus=" + maritalStatus + ", birthDate=" + this.getBirthDate()
                + ", bloodGroup=" + this.getBloodGroup() + ", nationality=" + this.getNationality() + ", gender=" + gender
                + ", password=" + this.getPassword() + ", pathology=" + pathology + ", description=" + description
                + ", picture=" + this.getPicture() + ", idHealthProfessional=" + idHealthProfessional + '}';
    }

}
