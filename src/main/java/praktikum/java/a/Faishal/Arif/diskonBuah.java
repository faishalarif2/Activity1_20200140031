/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.java.a.Faishal.Arif;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author NITRO
 */
@Controller
public class diskonBuah {
    @RequestMapping("/inputanUser")
    public String inputanuser(HttpServletRequest data, Model Buah){
        String nbuah = data.getParameter("var_namabuah");
        String hbuah = data.getParameter("var_hargakilo");
        Integer chbuah = Integer.valueOf(hbuah);
        String jbuah = data.getParameter("var_jumlahbeli");
        Double cjbuah = Double.valueOf(jbuah);
        Double jumlahbayar = chbuah * cjbuah;
        Double totalbayar = null;
        Integer diskon = 0;
        Double hargadiskon = 0.0;

        if(jumlahbayar < 16000){
            totalbayar = jumlahbayar - (jumlahbayar*0/100);
            hargadiskon = jumlahbayar*diskon/100;
            
        }else if( jumlahbayar < 25000){
            diskon = 10;
            totalbayar = jumlahbayar - (jumlahbayar*10/100);
            hargadiskon = jumlahbayar*diskon/100;
        }else {
            diskon = 15;
            totalbayar = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
        }
        
        proses prosesdata = new proses();
        
        Buah.addAttribute("nama", prosesdata.namabuah(nbuah)); //proses pengiriman data ke html
        Buah.addAttribute("harga",chbuah);
        Buah.addAttribute("perkilo",cjbuah);
        Buah.addAttribute("totalbayar",totalbayar);
        Buah.addAttribute("discount",hargadiskon);
        Buah.addAttribute("disc",diskon);
        Buah.addAttribute("total",jumlahbayar);
        return "FaishalArif"; //halaman web yang dituju
    }
}
