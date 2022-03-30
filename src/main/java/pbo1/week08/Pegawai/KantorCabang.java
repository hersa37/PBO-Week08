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
public class KantorCabang {
    public static final int MAX_PEGAWAI=100; //Constant owned by KantorCabang
    
    private String kodeCabang;
    private Pegawai pimpinan;
    private Pegawai[] pegawai; //Array of Pegawai objects
    private int jumlahPegawai;
    
    /*
    *Default constructor that calls constructor with corresponding parameters
    */
    public KantorCabang(){
        this("",new Pegawai[MAX_PEGAWAI]);         
    }
    /*
    Constructor with KanCab kode and pimpinan
    */    
    public KantorCabang(String kode, Pegawai[] pegawai){
        kodeCabang=kode;
        this.pegawai=pegawai; //Assigns array with the size of MAX_PEGAWAI
    }   

    public String getKodeCabang() {
        return kodeCabang;
    }

    public void setKodeCabang(String kodeCabang) {
        this.kodeCabang = kodeCabang;
    }

    public Pegawai getPimpinan() {
        return pimpinan;
    }

    public void setPimpinan(Pegawai pimpinan) {
        //Checks if pegawai is pimpinan. Creates default Pegawai if check fails
        if(pimpinan.getJabatan().equals("pimpinan")){ 
            this.pimpinan = pimpinan;
        } else this.pimpinan = new Pegawai();
    }

    public Pegawai[] getPegawai() {
        return pegawai;
    }
    /*
    sets array of pegawai and sets jumlahpegawai to actual number of pegawai
    Array size stays at MAX_PEGAWAI
    */
    public void setPegawai(Pegawai[] pegawai, int jumlahPegawai) {
        this.pegawai = pegawai;
        this.jumlahPegawai=jumlahPegawai;
    }
    
    public int getJumlahPegawai(){
        return jumlahPegawai;
    }
    
    /*
    Adds new Pegawai at first null index, which is at jumlahPegawai
    */
    public void addPegawai(Pegawai pegawaiNew){
        if(jumlahPegawai<MAX_PEGAWAI){
            pegawai[jumlahPegawai]=pegawaiNew;
            jumlahPegawai++;
        } else System.out.println("FULL");        
    }
    
    /*
    Removes pegawai by putting last non-null index to desired index, then 
    sets last non-null index to null. Updates jumlahPegawai
    */
    public void removePegawai(int index){
        pegawai[index]=pegawai[jumlahPegawai-1];
        pegawai[jumlahPegawai-1]=null;
        jumlahPegawai--;
    }
    
    /*
    Sets first index as baseline. Compares to the rest of the array up to 
    last non-null index
    */
    public Pegawai getPegawaiGajiTerbesar(){
        Pegawai gajiMax=pegawai[0];
        for(int i=1;i<jumlahPegawai;i++){
            if(pegawai[i].getGaji()>gajiMax.getGaji()){
                gajiMax=pegawai[i];
            }
        }
        return gajiMax;
    }
    
    public Pegawai getPegawaiGajiTerkecil(){
        Pegawai gajiMin=pegawai[0];
        for(int i=1;i<jumlahPegawai;i++){
            if(pegawai[i].getGaji()<gajiMin.getGaji()){
                gajiMin=pegawai[i];
            }
        }
        return gajiMin;
    }
    
    public Pegawai findPegawai(int employeeID){
        for(int i=0;i<jumlahPegawai;i++){
            if(Integer.parseInt(pegawai[i].getEmployeeID())==employeeID){
                return pegawai[i];
            }
        }
        System.out.println("Pegawai not found");
        return new Pegawai("-");        
    }
    
    public Pegawai findPegawai(String name){
        for(int i=0;i<jumlahPegawai;i++){
            if(pegawai[i].getName().equals(name)){
                return pegawai[i];
            }
        }
        System.out.println("Pegawai not found");
        return new Pegawai("-");        
    }
    @Override
    public String toString(){
        String print="{";
        for(int i=0;i<jumlahPegawai;i++){
            print+="Pegawai: "+pegawai[i].getName()
                    +"; Gaji: "+pegawai[i].getGaji()+"\n";
        }
        print+="} ";
        return print;
    }  
}
