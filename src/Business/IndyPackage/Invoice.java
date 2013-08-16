/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

import Business.Enterprise.Enterprise;
import java.util.Date;

/**
 *
 * @author Albert Carter
 */
public class Invoice {

    private int count;
    private static int index = 0;
    private Date creationDate;
    private Enterprise owedTo;
    private double amount;
    private String status; //"receivable" or "payable"
    private String payment; //"unpaid", "marked for payment", or "paid"  //for receivable accounts, "unpaid", "received for review", "verified paid"

    public Invoice() {

        count = index++;
        creationDate = new Date();
        payment = "unapid"; //invoices are unpaid when first generated
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Enterprise getOwedTo() {
        return owedTo;
    }

    public void setOwedTo(Enterprise owedTo) {
        this.owedTo = owedTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
