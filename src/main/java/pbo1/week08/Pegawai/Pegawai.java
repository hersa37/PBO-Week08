/*
 *  Made for college assignments/personal projects.
 *  Do not use without permission
 */

package pbo1.week08.Pegawai;

/**
 *
 * @author echa
 * Bernardus Hersa Galih Prakoso - 215314018
 * Informatika - Universitas Sanata Dharma
 */
public class Pegawai {
    
    private String employeeID;
    private static String uniqueID="0"; 
    private String name;
    private String jabatan;
    private int gaji;
    
    public Pegawai(){
        this("");
    }
    
    public Pegawai(String name){
        employeeID=Pegawai.getUniqueID();
        this.name=name;
    }
        
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = String.format("%4s", employeeID);
    }
    
    public void setUniqueID(int uniqueID){
        Pegawai.uniqueID=String.valueOf(uniqueID);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public String getJabatan() {
        return jabatan;
    }
    
    /*
    Checks if jabatan is listed. If not, set empty
    */
    public void setJabatan(String jabatan) {
        switch(jabatan){
            case "pimpinan":case "teknisi":case "akuntan":
                this.jabatan=jabatan;
        }
        this.jabatan = "";
    }
    
    /*
    Static method to automatically set new ID each time a new pegawai is called
    */
    private static String getUniqueID(){
        int id=Integer.parseInt(uniqueID);
        uniqueID=String.format("%04d", ++id);
        return uniqueID;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }
    
    @Override
    public String toString(){
        return "{ID: "+getEmployeeID()
                +"; Name: "+getName()                
                +"}";
    }
}
