/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.IndyPackage;

/**
 *
 * @author Albert Carter
 */
public class Vaccine {
    private String name;
    private long lifespan; //(days)
    private Disease disease;
    private double cdcPercent;
    private double phdPercent;
    private double providerPercent;
    private double price;

    public long getLifespan() {
        return lifespan;
    }

    public void setLifespan(long lifespan) {
        this.lifespan = lifespan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public double getCdcPercent() {
        return cdcPercent;
    }

    public void setCdcPercent(double cdcPercent) {
        this.cdcPercent = cdcPercent;
    }

    public double getPhdPercent() {
        return phdPercent;
    }

    public void setPhdPercent(double phdPercent) {
        this.phdPercent = phdPercent;
    }

    public double getProviderPercent() {
        return providerPercent;
    }

    public void setProviderPercent(double providerPercent) {
        this.providerPercent = providerPercent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return getName();
    }
    
    public boolean checkPaymentDistribution(){
        if(0==(getCdcPercent() + getPhdPercent() + getProviderPercent())){
            return true;
        }else{
            return false;
        }
    }
    
}
