package tupro1;
import java.util.*;
/**
 *
 * @author Muhammad Mujaddid Ashtsaqofi/1301174184
 */
public class Tupro1 {
    static double PlotPeluang[]=new double[10];
    static String KromosomX1 []=new String[10];
    static String KromosomX2 []=new String[10];
    static String hasil1="";
    static String hasil2="";
    static String Ortu []=new String[10];//orang tua yang terpilih
    static double nilaiOrtu[]=new double[10];
    static String NextGenKromosom []=new String[10];//kromosom generasi selanjutnya
    static double NextGenNilai[]=new double[10];//nilai generasi selanjutnya
    static double NilaiIndividu[]=new double[10];
    static double NilaiMin;
    static String KromosomMin;
    
    static double HitungNilai(double x1,double x2)
    {
        double hasil;
        hasil = ((4-(2*(Math.pow(x1,2)))+((Math.pow(x1,4))/3))*Math.pow(x1,2))+(x1*x2)+((-4+(4*Math.pow(x2,2)))*Math.pow(x2,2));
        return hasil;
    }
    
    static double HitungFitnes(double x)
    {
        double hasil;
        hasil=1/(x+0.0000001);
        if(hasil<0)
        {
            hasil=hasil*-1;
        }
        return hasil;
    }
    
    static String CekPeluang(double peluang)
    {
        String Ortu="";
        if ((peluang>=0)&&(peluang<=PlotPeluang[0]))
            Ortu=KromosomX1[0]+KromosomX2[0];               
        else if ((peluang>=PlotPeluang[0])&&(peluang<=PlotPeluang[1]))
            Ortu=KromosomX1[1]+KromosomX2[1]; 
        else if ((peluang>=PlotPeluang[1])&&(peluang<=PlotPeluang[2]))
            Ortu=KromosomX1[2]+KromosomX2[2]; 
        else if ((peluang>=PlotPeluang[2])&&(peluang<=PlotPeluang[3]))
            Ortu=KromosomX1[3]+KromosomX2[3];  
        else if ((peluang>=PlotPeluang[3])&&(peluang<=PlotPeluang[4]))
            Ortu=KromosomX1[4]+KromosomX2[4]; 
        else if ((peluang>=PlotPeluang[4])&&(peluang<=PlotPeluang[5]))
            Ortu=KromosomX1[5]+KromosomX2[5]; 
        else if ((peluang>=PlotPeluang[5])&&(peluang<=PlotPeluang[6]))
            Ortu=KromosomX1[6]+KromosomX2[6]; 
        else if ((peluang>=PlotPeluang[6])&&(peluang<=PlotPeluang[7]))
            Ortu=KromosomX1[7]+KromosomX2[7]; 
        else if ((peluang>=PlotPeluang[7])&&(peluang<=PlotPeluang[8]))
            Ortu=KromosomX1[8]+KromosomX2[8]; 
        else if ((peluang>=PlotPeluang[8])&&(peluang<=PlotPeluang[9]))
            Ortu=KromosomX1[8]+KromosomX2[8]; 
        
        return Ortu;
    }
    
    static String Mutasi(String x)
    {
        String temp,subString;
        temp="";
        int tempBiner;
        int i=0;
        while(i<=9)
        {
            double acakM=Math.random();
            subString=x.substring(i,(i+1));
            tempBiner=Integer.parseInt(subString);
            if (acakM<0.1)
            {
                if(tempBiner==1)
                    tempBiner=0;
                else if (tempBiner==0)
                    tempBiner=1;
            }
            temp=temp+tempBiner;
            i++;
        }
        return temp;
    }
    
    static void CrossOver(String x, String y)
    {
        String temp1,temp2,tempM;
        int acakN=(int)(Math.random() * 11);
        if ((acakN==0)&&(acakN==10))
        {
            hasil1=Mutasi(x);
            hasil2=Mutasi(y);
        }
        else
        {
            temp1=x.substring(0,acakN);
            temp2=y.substring(acakN,(y.length()));
            hasil1=temp1+temp2;
            tempM=Mutasi(hasil1);
            hasil1=tempM;
            temp1=y.substring(0,acakN);
            temp2=x.substring(acakN,(x.length()));
            hasil2=temp1+temp2;
            tempM=Mutasi(hasil2);
            hasil2=tempM;
        }
    }
    
    
    
    static double decodeKromosomX1(String x)
    {
        int i=0,tempA;
        double DecoderKali=0;
        String temp;    
        while (i<=4)
        {
            temp=x.substring(i,(i+1));
            tempA=Integer.parseInt(temp);
            if(tempA==0)
            {
                DecoderKali=DecoderKali+(1/(Math.pow(2, (i+1))));
            }
            i++;
        }
        return 3+(-6.1935*DecoderKali);
    }
    
    static double decodeKromosomX2(String x)
    {
        int i=0,tempA;
        double DecoderKali=0;
        String temp;  
        while (i<=4)
        {
            temp=x.substring((i+5),(i+6));
            tempA=Integer.parseInt(temp);
            if(tempA==0)
            {
                DecoderKali=DecoderKali+(1/(Math.pow(2, (i+1))));
            }
            i++;
        }
        return 2+(-4.1290*DecoderKali);
    }
    
    static void CekNextGen()
    {
        int i=0;
        while (i<=9)
        {
            int x=0;
            while (x<=9)
            {
                if(nilaiOrtu[i]<NextGenNilai[x])
                {
                    NextGenNilai[x]=nilaiOrtu[i];
                    NextGenKromosom[x]=Ortu[i];
                    break;
                }   
                x++;
            }
            i++;
        }
    }
    
    static double nilaiMin()
    {
        int i=0;
        double temp=NextGenNilai[i];
        while (i<=9)
        {
            if(NextGenNilai[i]<temp)
            {
                temp=NextGenNilai[i];
                KromosomMin=NextGenKromosom[i];
            }
            i++;
        }
        return temp;
    }
    
    public static void main(String[] args) {
        double IndividuX1 []=new double[10];//individu random pertama
        double IndividuX2 []=new double[10];
        double NilaiFitnes[]=new double[10];
        double Peluang[]=new double[10];
        double totalfitnes=0;
        double totalpeluang=0;
        int RandomNumber;
        Random acak = new Random();
        int i=0;
        int x1=0;
        int x2=0;
        while (x1<=9)//pembutan Individu
            {
                double DecoderKali=0;
                double HasilDecode=0;
                int x=1;
                KromosomX1[x1]="";
                while(x<=5)
                {
                    
                    RandomNumber= acak.nextInt(10)+1;
                    int cek= RandomNumber%2;
                    if(cek==1)
                    {
                        DecoderKali=DecoderKali+(1/(Math.pow(2, x)));
                        KromosomX1[x1]=KromosomX1[x1]+"1";
                    }
                    else
                    {
                        KromosomX1[x1]=KromosomX1[x1]+0;
                    }
                    x++;
                }
                HasilDecode=3+(-6.1935*DecoderKali);
                IndividuX1[x1]=HasilDecode;
                x1++;
            }
        while (x2<=9)//decode individu
            {
                double DecoderKali=0;
                double HasilDecode=0;
                int x=1;
                KromosomX2[x2]="";
                while(x<=5)
                {
                    
                    RandomNumber= acak.nextInt(10)+1;
                    int cek= RandomNumber%2;
                    if(cek==1)
                    {
                        DecoderKali=DecoderKali+(1/(Math.pow(2, x)));
                        KromosomX2[x2]=KromosomX2[x2]+"1";
                    }
                    else
                    {
                        KromosomX2[x2]=KromosomX2[x2]+0;
                    }
                    x++;
                }
                HasilDecode=2+(-4.1290*DecoderKali);
                IndividuX2[x2]=HasilDecode;
                x2++;
            }       
        i=0;
        while(i<=9)//hitung nilai individu
        {
            double hitung=HitungNilai(IndividuX1[i],IndividuX2[i]);
            NilaiIndividu[i]=hitung;
            i++;
        }
        i=0;
        while(i<=9)//hitung fitness individu
        {
            
            double hitung=HitungFitnes(NilaiIndividu[i]);
            NilaiFitnes[i]=hitung;
            totalfitnes=totalfitnes+NilaiFitnes[i];
            i++;
        }
        i=0;
        while(i<=9)//penghitungan peluang
        {
            double hitungPeluang=NilaiFitnes[i]/totalfitnes;
            Peluang[i]=hitungPeluang;
            totalpeluang=totalpeluang+Peluang[i];
            i++;
        }
        PlotPeluang[0]=Peluang[0];
        i=1;
        while(i<=9)//pembuatan plot peluang individu
            {
                PlotPeluang[i]=PlotPeluang[i-1]+Peluang[i];
                i++;
            }
        i=0;
        while(i<=9)//pemilihan ortu
            {
                double acakO=(Math.random()*totalpeluang);
                Ortu[i]=CekPeluang(acakO);
                nilaiOrtu[i]=HitungNilai(decodeKromosomX1(Ortu[i]),decodeKromosomX2(Ortu[i]));
                i++;
            }
        i=0;
        while(i<=9)//cross over,mutasi,hitung nilai next gen
        {
            double temp1=0,temp2=0;
            
            CrossOver(Ortu[i],Ortu[i+1]);
            NextGenKromosom[i]=hasil1;
            temp1=decodeKromosomX1(NextGenKromosom[i]);
            temp2=decodeKromosomX2(NextGenKromosom[i]);
            NextGenNilai[i]=HitungNilai(temp1,temp2);
            NextGenKromosom[i+1]=hasil2;
            temp1=decodeKromosomX1(NextGenKromosom[i+1]);
            temp2=decodeKromosomX2(NextGenKromosom[i+1]);
            NextGenNilai[i+1]=HitungNilai(temp1,temp2);
            i=i+2;
        }
        CekNextGen();
        NilaiMin=nilaiMin();
        int checker=1,gen=1;
        while (checker<=99)
        {
            totalfitnes=0;
            double minLokal;
            i=0;
            while (i<=9)
            {
                double hitung=HitungFitnes(NextGenNilai[i]);
                NilaiFitnes[i]=hitung;
                totalfitnes=totalfitnes+NilaiFitnes[i];
                i++;
            }
            totalpeluang=0;
            i=0;
            while(i<=9)//penghitungan peluang
            {
                
                double hitungPeluang=NilaiFitnes[i]/totalfitnes;
                Peluang[i]=hitungPeluang;
                totalpeluang=totalpeluang+Peluang[i];
                i++;
            }
             PlotPeluang[0]=Peluang[0];
            i=1;
            while(i<=9)//pembuatan plot peluang individu
                {
                    PlotPeluang[i]=PlotPeluang[i-1]+Peluang[i];
                    i++;
                }
            while(i<=9)//pemilihan ortu
            {
                double acakO=(Math.random()*totalpeluang);
                Ortu[i]=CekPeluang(acakO);
                nilaiOrtu[i]=HitungNilai(decodeKromosomX1(Ortu[i]),decodeKromosomX2(Ortu[i]));
                i++;
            }
            i=0;
            while(i<=9)//cross over,mutasi,hitung nilai next gen
            {
                double temp1=0,temp2=0;
                CrossOver(Ortu[i],Ortu[i+1]);
                NextGenKromosom[i]=hasil1;
                temp1=decodeKromosomX1(NextGenKromosom[i]);
                temp2=decodeKromosomX2(NextGenKromosom[i]);
                NextGenNilai[i]=HitungNilai(temp1,temp2);
                NextGenKromosom[i+1]=hasil2;
                temp1=decodeKromosomX1(NextGenKromosom[i+1]);
                temp2=decodeKromosomX2(NextGenKromosom[i+1]);
                NextGenNilai[i+1]=HitungNilai(temp1,temp2);
                i=i+2;
            }
            CekNextGen();
            NilaiMin=nilaiMin();
            checker++;
        } 
        double minx1=decodeKromosomX1(KromosomMin);
        double minx2=decodeKromosomX2(KromosomMin);
        System.out.println("Kromosom Terkecil = "+KromosomMin);
        System.out.println("Nilai X1    = "+minx1);
        System.out.println("Nilai X2    = "+minx2);
        System.out.println("Nilai h     = "+HitungNilai(minx1,minx2));
    }   
}
