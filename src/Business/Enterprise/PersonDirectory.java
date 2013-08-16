/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;
import Business.IndyPackage.Person;

/**
 *
 * @author Albert Carter
 */
public class PersonDirectory {
    ArrayList<Person> personList;
    
    public PersonDirectory(){
        personList = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public Person newPerson(){
        Person p = new Person();
        personList.add(p);
        return p;
    }
    
    public Person addPerson(Person p){
        personList.add(p);
        return p;
    }
}
