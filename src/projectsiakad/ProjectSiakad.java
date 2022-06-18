/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectsiakad;
import akademik.*;
import baak.*;
import dosen.*;
import entitas.*;
import implement.*;
import koneksiData.*;
import mahasiswa.*;

/**
 *
 * @author Helmy Fauzi
 */
public class ProjectSiakad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
}
