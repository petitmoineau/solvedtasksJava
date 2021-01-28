/**
 * <h1>Анкета студента</h1>
 * Цей клас реалізовує регістрацію студента,
 * приймає на вхід дані, опрацьовує їх та
 * виводить на екран всі дані у вигляді анкети.
 * @author Анастасія Пархоменко
 */
import java.time.LocalDate;
import java.util.UUID;
import static java.lang.Math.abs;

public class Student {
    protected final String firstName;
    protected final String lastName;
    protected String hometown;
    public static final String uni = "Kyiv-Mohyla Academy";

    /** Конструктор створює студента з певним ім'ям та прізвищем.
     * @param name Ім'я студента.
     * @param surname Прізвище студента.
     */
    Student (String name, String surname) {
        firstName = name;
        lastName = surname;
    }

    private int birthDay;
    private int birthMonth;
    private int birthYear;
    protected LocalDate birthDate;

    /** Цей метод задає дату народження студента.
     * @param dayInput День народження.
     * @param monthInput Місяць народження.
     * @param yearInput Рік народження.
     */
    public void setDateOfBirth(int dayInput, int monthInput, int yearInput) {
        birthDay = dayInput;
        birthMonth = monthInput;
        birthYear = yearInput;

        birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
    }

    private int nowDay;
    private int nowMonth;
    private int nowYear;

    protected int course;
    protected int uniqueID;

    protected String relevantFaculty;
    protected String relevantSpeciality;

    /** Цей метод є допоміжним для вираховування релевантного віку студента.
     * Метод задає дату дня заповнення анкети.
     */
    private void currentDate() {
        LocalDate nowDate = LocalDate.now();
        nowDay = nowDate.getDayOfMonth();
        nowMonth = nowDate.getMonthValue();
        nowYear = nowDate.getYear();
    }

    /** Цей метод повертає релевантний вік студента, шляхом
     * порівнювання дня, місяця і року народження з сьогоднішньою датою.
     * @return цілочисельну змінну, що відображає вік студента на даний момент.
     */
    public int age() {
        currentDate();
        return nowMonth == birthMonth ? (nowDay == birthDay ? (nowYear - birthYear) :
                (nowDay < birthDay ? (nowYear - birthYear - 1) : (nowYear - birthYear))) :
                (nowMonth < birthMonth ? (nowYear - birthYear - 1) :(nowYear - birthYear));
    }

    /** Цей метод задає факультет, на якому навчається студент.
     * @param faculty Факультет.
     */
    public void setRelevantFaculty(String faculty) {
        relevantFaculty = faculty;
    }

    /** Цей метод задає спеціальність студента.
     * @param speciality Спеціальність.
     */
    public void setRelevantSpeciality(String speciality) {
        relevantSpeciality = speciality;
    }

    /** Цей метод задає курс студента.
     * @param numberOfCourse Курс.
     */
    public void setCourse(int numberOfCourse) {
        course = numberOfCourse;
    }

    /** Цей метод задає місто, родом з якого є студент.
     * @param town Рідне місто.
     */
    public void setHometown(String town) {
        hometown = town;
    }

    /** Цей метод присвоює та повертає унікальний код студента.
     * @return цілочисельний код, що є ідентифікатором студента в системі.
     */
    public int personalID() {
        uniqueID =  abs(UUID.randomUUID().hashCode());
        return uniqueID;
    }

    /** Цей метод формує заповнену анкету студента.
     * @return рядок, який містить всю введену студентом інформацію.
     */
    public String toString() {
        String res = "Full name: " + firstName + " " + lastName + ";";
        res += "\nAge: " + age() + " years old;";
        res += "\nHometown: " + hometown + ";";
        res += "\nUniversity: " + uni + ";";
        res += "\nFaculty: " + relevantFaculty + ";";
        res += "\nSpeciality: " + relevantSpeciality + ";";
        res += "\nCourse: " + (course + (course == 1? "st"
                : (course == 2? "nd" : (course == 3? "rd" : "th")))) + ";";
        res += "\nPersonal ID: " + personalID() + ".";

        return res;
    }
}
