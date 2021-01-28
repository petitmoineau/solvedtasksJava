/**
 * <h1>Додатковий клас, що створює розширену анкету студента</h1>
 * Цей клас додає до анкети організацію, членом якої є
 * або буде студент.
 * @author Анастасія Пархоменко
 */
public class StudentWithActivity extends Student{
    /**
     * Конструктор класу, що наслідує суперклас Student.
     * @param name Ім'я студента.
     * @param surname Прізвище студента.
     */
    StudentWithActivity(String name, String surname) {
        super(name, surname);
    }

    protected int orgNumber;
    protected String name;

    /**
     * Метод, що визначає організацію, в якій бере участь
     * або збирається у неї вступити, за номером, введеним
     * студентом.
     * @param number Номер огранізації.
     */
    public void chooseOrganization(int number) {
        orgNumber = number;
        switch (orgNumber) {
            case 1 -> {
                Organizations org = Organizations.TA_MOHYLYANKA_1;
                name = org.name();
            }
            case 2 -> {
                Organizations org = Organizations.MASTANDUP_2;
                name = org.name();
            }
            case 3 -> {
                Organizations org = Organizations.SPUDEIISKI_VISNYK_3;
                name = org.name();
            }
            case 4 -> {
                Organizations org = Organizations.SPUDEIISKE_BRATSTVO_NAUKMA_4;
                name = org.name();
            }
            case 5 -> {
                Organizations org = Organizations.BUDDY_NAUKMA_5;
                name = org.name();
            }
            case 6 -> {
                Organizations org = Organizations.POLITOLOGY_STUDENTS_ASSOCIATION_6;
                name = org.name();
            }
            case 7 -> {
                Organizations org = Organizations.DEBATE_CLUB_7;
                name = org.name();
            }
            case 8 -> {
                Organizations org = Organizations.ECOCLUB_GREENWAVE_8;
                name = org.name();
            }
            case 9 -> {
                Organizations org = Organizations.ANCIENT_DANCE_CLUB_9;
                name = org.name();
            }
            case 10 -> {
                Organizations org = Organizations.FIDO_10;
                name = org.name();
            }
            case 11 -> {
                Organizations org = Organizations.SQUAD21_11;
                name = org.name();
            }
            case 12 -> {
                Organizations org = Organizations.THEATRICAL_STUDIO_4THSTUDIO_12;
                name = org.name();
            }
            case 13 -> {
                Organizations org = Organizations.KMA_LEGAL_HACKERS_13;
                name = org.name();
            }
            case 14 -> {
                Organizations org = Organizations.none_14;
                name = org.name();
            }
        }
    }



    /**
     * Цей метод формує заповнену анкету студента з
     * додатковим рядком "організації".
     * @return рядок, який містить всю введену студентом інформацію.
     */

    public String toString() {
        String res = "Full name: " + firstName + " " + lastName + ";";
        res += "\nAge: " + age() + " years old;";
        res += "\nHometown: " + hometown + ";";
        res += "\nUniversity: " + Student.uni + ";";
        res += "\nFaculty: " + relevantFaculty + ";";
        res += "\nSpeciality: " + relevantSpeciality + ";";
        res += "\nCourse: " + (course + (course == 1? "st"
                : (course == 2? "nd" : (course == 3? "rd" : "th")))) + ";";
        res += "\nOrganization: " + name + ";";
        res += "\nPersonal ID: " + personalID() + ".";
        return res;
    }
}
