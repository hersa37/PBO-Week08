/*
 *  Made for college assignments/personal projects.
 *  Do not use without permission
 */

package pbo1.week08.Pegawai;

import java.util.Scanner;

/**
 *
 * @author echa
 * Bernardus Hersa Galih Prakoso - 215314018
 * Informatika - Universitas Sanata Dharma
 */
public class KanCabMain {
    
    public static void main(String[] args) {
        int jumlahPegawai=2;
        Scanner input=new Scanner(System.in);
               
        KantorCabang kc=new KantorCabang();
        Pegawai[] pegawai=new Pegawai[KantorCabang.MAX_PEGAWAI];
        kc.setPegawai(pegawai, jumlahPegawai);
        for(int i=0;i<jumlahPegawai;i++){
            pegawai[i]=new Pegawai();
            System.out.print("Nama: ");
            pegawai[i].setName(input.next());
            System.out.print("Gaji: ");
            pegawai[i].setGaji(input.nextInt());          
        }
        System.out.println(kc.toString());
    }   
}
