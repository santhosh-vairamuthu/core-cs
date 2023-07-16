import java.util.*;
public class HillCipher{
    public static void main(String[] args){
        System.out.print("If you want to perform\n1.Encryption\n2.Decryption\n\nEnter the choice : ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1){
            System.out.print("Enter the plain text : ");
            sc.nextLine();
            String s=sc.nextLine();
            s=s.toLowerCase();
            int i,j,k,l,index=0,index1=0,index2=0,b,index3=0,index4=0;
            for(i=0;i<s.length();i++){
                if(s.charAt(i)==' '){
                    index++;
                }
            }char arr[]=new char[s.length()-index],resarr[]=new char[s.length()-index];
            System.out.println("Enter the key : ");
            int a[][]=new int[3][3];
            for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    a[i][j]=sc.nextInt();
                }
            }for(i=0;i<s.length();i++){
                if(s.charAt(i)!=' '){
                    arr[index2++]=s.charAt(i);
                }
            }int c=arr.length%3;
            if(c==0){
                b=arr.length/3;
            }else{
                b=(arr.length/3);
                b++;
            }for(i=0;i<b;i++){
                int mat[][]=new int[3][1];
                for(j=0;j<3;j++){
                    mat[j][0]=arr[index1++]-97;
                }int[][] result=new int[3][1];
                for(j=0;j<3;j++) {
                    for(k=0;k<1;k++) {
                        for(l=0;l<3;l++) {
                            result[j][k]+=a[j][l]*mat[l][k];
                        }
                    }
                }for(j=0;j<3;j++){
                    result[j][0]%=26;
                    if(result[j][0]<0){
                        result[j][0]=26-result[j][0];
                    }char ch=(char)(result[j][0]+65);
                    resarr[index3++]=ch;
                }
            }System.out.print("The cipher text is : ");
            for(i=0;i<s.length();i++){
                if(s.charAt(i)==' '){
                    System.out.print(" ");
                }else{
                    System.out.print(resarr[index4++]);
                }
            }
        }else if(n==2){
            System.out.print("Enter the cipher text : ");
            sc.nextLine();
            String s=sc.nextLine();
            s=s.toLowerCase();
            int i,j,k,index=0,index2=0;
            for(i=0;i<s.length();i++){
                if(s.charAt(i)==' '){
                    index++;
                }
            }char arr[]=new char[s.length()-index],resarr[]=new char[s.length()-index];
            System.out.println("Enter the key : ");
            int a[][]=new int[3][3],adja[][]=new int [3][3],adj[][]=new int[3][3];
            for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    a[i][j]=sc.nextInt();
                }
            }for(i=0;i<s.length();i++){
                if(s.charAt(i)!=' '){
                    arr[index2++]=s.charAt(i);
                }
            }int index1=0,l,detk=(a[0][0]*((a[1][1]*a[2][2])-(a[1][2]*a[2][1])))-(a[0][1]*((a[1][0]*a[2][2])-(a[1][2]*a[2][0])))+(a[0][2]*((a[1][0]*a[2][1])-(a[1][1]*a[2][0])));
            detk%=26;
            if(detk<0){
                detk=26+detk;
            }adja[0][0]=((a[1][1]*a[2][2])-(a[1][2]*a[2][1]));
            adja[0][1]=0-((a[1][0]*a[2][2])-(a[1][2]*a[2][0]));
            adja[0][2]=((a[1][0]*a[2][1])-(a[1][1]*a[2][0]));
            adja[1][0]=0-((a[0][1]*a[2][2])-(a[0][2]*a[2][1]));
            adja[1][1]=((a[0][0]*a[2][2])-(a[0][2]*a[2][0]));
            adja[1][2]=0-((a[0][0]*a[2][1])-(a[0][1]*a[2][0]));
            adja[2][0]=((a[0][1]*a[1][2])-(a[0][2]*a[1][1]));
            adja[2][1]=0-((a[0][0]*a[1][2])-(a[0][2]*a[1][0]));
            adja[2][2]=((a[0][0]*a[1][1])-(a[0][1]*a[1][0]));
            for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    adj[j][i]=adja[i][j]%26;
                    if(adj[j][i]<0){
                        adj[j][i]=26+adj[j][i];
                    }
                }
            }
            int r1=26,r2=detk,t1=0,t2=1;
            while(r2!=0){
                int q=r1/r2,r=r1%r2;
                int t=t1-(q*t2);
                t1=t2;
                t2=t;
                r1=r2;
                r2=r;
            }int det=t1,kinverse[][]=new int[3][3];
            if(det<0){
                det+=26;
            }for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    kinverse[i][j]=(adj[i][j]*det)%26;
                }
            }int c=arr.length%3,b,index3=0,index4=0;
            if(c==0){
                b=arr.length/3;
            }else{
                b=(arr.length/3);
                b++;
            }for(i=0;i<b;i++){
                int mat[][]=new int[3][1];
                for(j=0;j<3;j++){
                    mat[j][0]=arr[index1++]-97;
                }int[][] result=new int[3][1];
                for(j=0;j<3;j++) {
                    for(k=0;k<1;k++) {
                        for(l=0;l<3;l++) {
                            result[j][k]+=kinverse[j][l]*mat[l][k];
                        }
                    }
                }for(j=0;j<3;j++){
                    result[j][0]%=26;
                    if(result[j][0]<0){
                        result[j][0]=26-result[j][0];
                    }char ch=(char)(result[j][0]+65);
                    resarr[index3++]=ch;
                }
            }System.out.print("The cipher text is : ");
            for(i=0;i<s.length();i++){
                if(s.charAt(i)==' '){
                    System.out.print(" ");
                }else{
                    System.out.print(resarr[index4++]);
                }
            }
        }
    }
}
