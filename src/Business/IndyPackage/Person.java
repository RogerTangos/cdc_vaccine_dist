/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

/**
 *
 * @author Albert Carter
 */
public class Person {
    private String firstName;
    private String lastName;
    private String dob;
    private String ssn;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    @Override
    public String toString(){
        return firstName + " " + lastName;
    }
}
