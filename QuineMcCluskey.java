import java.util.Scanner;

public class QuineMcCluskey{
  public static void main(String[] args){
    System.out.println("Special Assignment");
    System.out.println("Submitted to: ");
    System.out.println("Professor MD. Abdul Mottalib, Ph.D.");
    System.out.println("Submitted by:");
    System.out.println("Ridwane-ul-Islam");
    System.out.println("ID: 17101495");
    System.out.println("Course: CSE260");
    System.out.println("Section: 02");
    System.out.println("Department of CSE, BRAC University");
    System.out.println("Submitted on: 6 November, 2017");
    Scanner sc=new Scanner(System.in);
    System.out.println();
    System.out.println("Please enter the number of minterms you have:");
    int r=sc.nextInt();
    int[] reals=new int[r];
    System.out.println("Enter the minterms one by one:");
    for(int i=0; i<reals.length; ++i){
      reals[i]=sc.nextInt();
    }
    int maxReal=reals[0];
    
    for(int i=1; i<reals.length; ++i){
      if(reals[i]>maxReal){
        maxReal=reals[i];
      }
    }
    System.out.println("Please enter the number of don't cares if you have any:");
    int dc=sc.nextInt();
    int[] fakes=new int[dc];
    if(dc!=0){
    System.out.println("Enter the don't cares one by one:");
    }
    for(int i=0; i<fakes.length; ++i){
      fakes[i]=sc.nextInt();
    }
    
    int[] fn=new int[r+dc];
    for(int i=0; i<r; ++i){
      fn[i]=reals[i];
    }
    
    for(int i=r; i<fn.length; ++i){
      fn[i]=fakes[i-r];
    }
    for(int i=0; i<fn.length-1; ++i){
      for(int j=i+1; j<fn.length; ++j){
        if(fn[j]<fn[i]){
          int store=fn[i];
          fn[i]=fn[j];
          fn[j]=store;
        }
      }
    }
    int max=fn[0];
    int v;
    for(int i=1; i<fn.length; ++i){
      if(fn[i]>max){
        max=fn[i];
      }
    }
    v=(Integer.toBinaryString(max)).length();
    String[] fn1=new String[r+dc];
    String[][] fn2=new String[r+dc][4];
    for(int i=0; i<fn1.length; ++i){
      String minbin=Integer.toBinaryString(fn[i]);
      for(int n=minbin.length(); n<v; ++n){
        minbin=0+minbin;
      }
      fn1[i]=minbin;
    }
    int k=0;
    for(int j=0; j<fn1.length; ++j){
      for(int i=0; i<fn1.length; ++i){
        int countOne=0;
        for(int n=0; n<fn1[i].length(); ++n){
          char[] ch=fn1[i].toCharArray();
          if(ch[n]=='1'){
            ++countOne;
          }
        }
        if(countOne==j){
          fn2[k][0]=fn1[i];
          ++k;
        }
      }
    }
    for(int i=0; i<fn.length; ++i){
      fn[i]=Integer.parseInt(fn2[i][0],2);
      fn2[i][1]=String.valueOf(fn[i]);
    }
    int fn3Counter=0;
    for(int i=0; i<fn2.length; ++i){
      for(int j=i+1; j<fn2.length; ++j){
        int dffrCount=0;
        for(int c=0; c<v; ++c){
          if(fn2[i][0].charAt(c)!=fn2[j][0].charAt(c)){
            ++dffrCount;
          }
        }
        if(dffrCount==1){
          for(int c=0; c<v; ++c){
            if(fn2[i][0].charAt(c)!=fn2[j][0].charAt(c)){
              
              ++fn3Counter;
            }
          }
        }
      }
    }
    String[][] fn3=new String[fn3Counter][5];
    String t="done";
    int fn3Loader=0;
    for(int i=0; i<fn2.length; ++i){
      for(int j=i+1; j<fn2.length; ++j){
        int dffrCount=0;
        for(int c=0; c<v; ++c){
          if(fn2[i][0].charAt(c)!=fn2[j][0].charAt(c)){
            ++dffrCount;
          }
        }
        if(dffrCount==1){
          for(int c=0; c<v; ++c){
            if(fn2[i][0].charAt(c)!=fn2[j][0].charAt(c)){
              String front=fn2[i][0].substring(0,c);
              String back=fn2[i][0].substring(c+1,v);
              fn3[fn3Loader][0]=front+"-"+back;
              fn3[fn3Loader][1]=fn2[i][1];
              fn2[i][2]=t;
              fn3[fn3Loader][2]=fn2[j][1];
              fn2[j][2]=t;
              ++fn3Loader;
            }
          }
        }
      }
    }
    int fn4Counter=0;
    for(int i=0; i<fn3.length; ++i){
      
      for(int j=i+1; j<fn3.length; ++j){
        
        int dffrCount=0;
        for(int c=0; c<v; ++c){
          if(fn3[i][0].charAt(c)!=fn3[j][0].charAt(c)){
            ++dffrCount;
          }
        }
        if(dffrCount==1){
          for(int c=0; c<v; ++c){
            if(fn3[i][0].charAt(c)!=fn3[j][0].charAt(c)){
              
              ++fn4Counter;
            }
          }
        }
      }
    }
    String[][] fn4=new String[fn4Counter][6];
    int fn4Loader=0;
    for(int i=0; i<fn3.length; ++i){
      
      for(int j=i+1; j<fn3.length; ++j){
        
        int dffrCount=0;
        for(int c=0; c<v; ++c){
          if(fn3[i][0].charAt(c)!=fn3[j][0].charAt(c)){
            ++dffrCount;
          }
        }
        if(dffrCount==1){
          for(int c=0; c<v; ++c){
            if(fn3[i][0].charAt(c)!=fn3[j][0].charAt(c)){
              String front=fn3[i][0].substring(0,c);
              String back=fn3[i][0].substring(c+1,v);
              fn4[fn4Loader][0]=front+"-"+back;
              fn4[fn4Loader][1]=fn3[i][1];
              fn4[fn4Loader][2]=fn3[i][2];
              fn3[i][3]=t;
              fn4[fn4Loader][3]=fn3[j][1];
              fn4[fn4Loader][4]=fn3[j][2];
              fn3[j][3]=t;
              ++fn4Loader;
            }
          }
        }
      }
    }
    
    int sameCount=0;
    for(int i=0; i<fn4.length; ++i){
      if(fn4[i]!=null){
        for(int j=i+1; j<fn4.length; ++j){
          if(fn4[j]!=null){
            if(fn4[i][0].equals(fn4[j][0])){
              ++sameCount;
              fn4[j]=null;
            }
          }}
      }}
    String[][] finalfn4=new String[fn4.length-sameCount][6];
    
    
    int ffn4Loader=0;
    for(int i=0; i<fn4.length; ++i){
      
      if(fn4[i]!=null){
        finalfn4[ffn4Loader]=fn4[i];
        ++ffn4Loader;
      }
    }
    int[] counter1=new int[maxReal+1];
    for(int i=0; i<finalfn4.length; ++i){
      for(int j=1; j<=4; ++j){
        boolean flag=false;
        for(int rt=0; rt<reals.length; ++rt){
          int p=Integer.valueOf(finalfn4[i][j]);
          if(p==reals[rt]){
            flag=true;
          }
        }
        if(flag==true){
          ++counter1[Integer.valueOf(finalfn4[i][j])];
        }
      }
    }
    for(int i=0; i<fn3.length; ++i){
      if(fn3[i][3]==null){
        for(int j=1; j<=2; ++j){
          boolean flag=false;
          for(int rt=0; rt<reals.length; ++rt){
            int p=Integer.valueOf(fn3[i][j]);
            if(p==reals[rt]){
              flag=true;
            }
          }
          if(flag==true){
            ++counter1[Integer.valueOf(fn3[i][j])];
          }
        }
      }
    }
    for(int i=0; i<fn2.length; ++i){
      if(fn2[i][2]==null){
        for(int j=1; j<=1; ++j){
          boolean flag=false;
          for(int rt=0; rt<reals.length; ++rt){
            int p=Integer.valueOf(fn2[i][j]);
            if(p==reals[rt]){
              flag=true;
            }
          }
          if(flag==true){
            ++counter1[Integer.valueOf(fn2[i][j])];
          }
        }
      }
    }
    for(int i=0; i<finalfn4.length; ++i){
      for(int j=1; j<=4; ++j){
        for(int o=0; o<fakes.length; ++o){
          if(finalfn4[i][j]!=null && Integer.valueOf(finalfn4[i][j])==fakes[o]){
            finalfn4[i][j]=null;
          }
        }
      }
    }
    for(int i=0; i<fn3.length; ++i){
      for(int j=1; j<=2; ++j){
        for(int o=0; o<fakes.length; ++o){
          if(fn3[i][j]!=null && Integer.valueOf(fn3[i][j])==fakes[o]){
            fn3[i][j]=null;
          }
        }
      }
    }
    for(int i=0; i<fn2.length; ++i){
      for(int j=1; j<=1; ++j){
        for(int o=0; o<fakes.length; ++o){
          if(fn2[i][j]!=null && Integer.valueOf(fn2[i][j])==fakes[o]){
            fn2[i][j]=null;
          }
        }
      }
    }
    int[] counter=new int[counter1.length];
    for(int i=0; i<counter.length; ++i){
      counter[i]=counter1[i];}
    String[] result=new String[r];
    int rLoader=0;
    for(int c=0; c<counter.length; ++c){
      if(counter[c]==1){
        
        for(int i=0; i<finalfn4.length; ++i){
          for(int j=1; j<=4; ++j){
            if(finalfn4[i][j]!=null && c==Integer.valueOf(finalfn4[i][j])){
              result[rLoader]=finalfn4[i][0];
              ++rLoader;
              for(int jj=1; jj<=4; ++jj){
                if(finalfn4[i][jj]!=null){
                  counter[Integer.valueOf(finalfn4[i][jj])]=0;}}
            }
          }
        }
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][3]==null){
            for(int j=1; j<=2; ++j){
              if(fn3[i][j]!=null && c==Integer.valueOf(fn3[i][j])){
                result[rLoader]=fn3[i][0];
                ++rLoader;
                for(int jj=1; jj<=2; ++jj){
                  if(fn3[i][jj]!=null){
                    counter[Integer.valueOf(fn3[i][jj])]=0;}}
              }
            }
          }
        }
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][2]==null){
            for(int j=1; j<=1; ++j){
              if(fn2[i][j]!=null && c==Integer.valueOf(fn2[i][j])){
                result[rLoader]=fn2[i][0];
                ++rLoader;
                for(int jj=1; jj<=1; ++jj){
                  if(fn2[i][jj]!=null){
                    counter[Integer.valueOf(fn2[i][jj])]=0;}}
              }
            }
          }
        }
      }
    }
    
    
    for(int c=0; c<counter.length; ++c){
      boolean resultgetter=false;
      if(counter[c]!=0){
        int maxCount=0;
        
        for(int jj=0; jj<counter.length; ++jj){
          if(counter[jj]!=0){
            ++maxCount;
          }
        }
        
        int[] maxm=new int[maxCount];
        int mLoader=0;
        for(int jj=0; jj<counter.length; ++jj){
          if(counter[jj]!=0){
            maxm[mLoader]=jj;
            ++mLoader;
          }
        }
        
        
        int ffn4c=0;
        
        for(int i=0; i<finalfn4.length; ++i){
          
          for(int j=1; j<=4; ++j){
            for(int m=0; m<maxm.length; ++m){
              
              if(finalfn4[i][j]!=null && maxm[m]==Integer.valueOf(finalfn4[i][j])){
                ++ffn4c;
                
              }
            }
          }
          finalfn4[i][5]=String.valueOf(ffn4c);
          ffn4c=0;
        }
        int fn3c=0;
        
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][3]==null){
            
            for(int j=1; j<=2; ++j){
              if(fn3[i][j]!=null){
                for(int m=0; m<maxm.length; ++m){
                  if(maxm[m]==Integer.valueOf(fn3[i][j])){
                    ++fn3c;
                    
                  }}
              }
            }
            fn3[i][4]=String.valueOf(fn3c);
            fn3c=0;
          }
        }
        int fn2c=0;
        
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][2]==null){
            
            for(int j=1; j<=1; ++j){
              if(fn2[i][j]!=null){
                for(int m=0; m<maxm.length; ++m){
                  if(maxm[m]==Integer.valueOf(fn2[i][j])){
                    ++fn2c;
                  }
                }
              }
            }
            fn2[i][3]=String.valueOf(fn2c);
            fn2c=0;
          }
        }
        
        
        int mxp=0, mx4=0, mx3=0, mx2=0;
        for(int i=0; i<finalfn4.length; ++i){
          if(finalfn4[i][5]!=null){
            if(Integer.valueOf(finalfn4[i][5])>mx4){
              mx4=Integer.valueOf(finalfn4[i][5]);
            }
          }
        }
        
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][4]!=null){
            if(Integer.valueOf(fn3[i][4])>mx3){
              mx3=Integer.valueOf(fn3[i][4]);
            }
          }
        }
        
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][3]!=null){
            if(Integer.valueOf(fn2[i][3])>mx2){
              mx2=Integer.valueOf(fn2[i][3]);
            }
          }
        }
        
        if(mx4>mx3 && mx4>mx2){
          mxp=mx4;}
        if(mx3>mx4 && mx3>mx2){
          mxp=mx3;}
        if(mx2>mx3 && mx2>mx4){
          mxp=mx2;}
        
        for(int i=0; i<finalfn4.length; ++i){
          
          if(resultgetter==false && mxp==Integer.valueOf(finalfn4[i][5])){
            result[rLoader]=finalfn4[i][0];
            ++rLoader;
            resultgetter=true;
            for(int jj=1; jj<=4; ++jj){
              if(finalfn4[i][jj]!=null){
                counter[Integer.valueOf(finalfn4[i][jj])]=0;}
            }
            
          }
          
        }
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][3]==null){
            
            if(resultgetter==false && mxp==Integer.valueOf(fn3[i][4])){
              result[rLoader]=fn3[i][0];
              ++rLoader;
              resultgetter=true;
              for(int jj=1; jj<=2; ++jj){
                if(fn3[i][jj]!=null){
                  counter[Integer.valueOf(fn3[i][jj])]=0;}}
            }
            
          }
        }
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][2]==null){
            
            if(resultgetter==false && mxp==Integer.valueOf(fn2[i][3])){
              result[rLoader]=fn2[i][0];
              ++rLoader;
              resultgetter=true;
              for(int jj=1; jj<=1; ++jj){
                if(fn2[i][jj]!=null){
                  counter[Integer.valueOf(fn2[i][jj])]=0;}}
            }
            
          }
        }
      }
    }
    
    
    String[] result1=new String[r];
    int rLoader1=0;
    for(int c=0; c<counter1.length; ++c){
      if(counter1[c]==1){
        
        for(int i=0; i<finalfn4.length; ++i){
          for(int j=1; j<=4; ++j){
            if(finalfn4[i][j]!=null && c==Integer.valueOf(finalfn4[i][j])){
              result1[rLoader1]=finalfn4[i][0];
              ++rLoader1;
              for(int jj=1; jj<=4; ++jj){
                if(finalfn4[i][jj]!=null){
                  counter1[Integer.valueOf(finalfn4[i][jj])]=0;}}
            }
          }
        }
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][3]==null){
            for(int j=1; j<=2; ++j){
              if(fn3[i][j]!=null && c==Integer.valueOf(fn3[i][j])){
                result1[rLoader1]=fn3[i][0];
                ++rLoader1;
                for(int jj=1; jj<=2; ++jj){
                  if(fn3[i][jj]!=null){
                    counter1[Integer.valueOf(fn3[i][jj])]=0;}}
              }
            }
          }
        }
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][2]==null){
            for(int j=1; j<=1; ++j){
              if(fn2[i][j]!=null && c==Integer.valueOf(fn2[i][j])){
                result1[rLoader1]=fn2[i][0];
                ++rLoader1;
                for(int jj=1; jj<=1; ++jj){
                  if(fn2[i][jj]!=null){
                    counter1[Integer.valueOf(fn2[i][jj])]=0;}}
              }
            }
          }
        }
      }
    }
    
    
    for(int c=0; c<counter1.length; ++c){
      boolean resultgetter=false;
      if(counter1[c]!=0){
        int maxCount=0;
        int maxc=counter1[0];
        for(int jj=1; jj<counter1.length; ++jj){
          if(counter1[jj]>maxc){
            maxc=counter1[jj];
          }
        }
        for(int jj=0; jj<counter1.length; ++jj){
          if(counter1[jj]==maxc){
            ++maxCount;
          }
        }
        int[] maxm=new int[maxCount];
        int mLoader=0;
        for(int jj=0; jj<counter1.length; ++jj){
          if(counter1[jj]==maxc){
            maxm[mLoader]=jj;
            ++mLoader;
          }
        }
        
        
        int ffn4c=0;
        
        for(int i=0; i<finalfn4.length; ++i){
          
          for(int j=1; j<=4; ++j){
            for(int m=0; m<maxm.length; ++m){
              
              if(finalfn4[i][j]!=null && maxm[m]==Integer.valueOf(finalfn4[i][j])){
                ++ffn4c;
                
              }}
          }
          finalfn4[i][5]=String.valueOf(ffn4c);
          ffn4c=0;
        }
        int fn3c=0;
        
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][3]==null){
            
            for(int j=1; j<=2; ++j){
              if(fn3[i][j]!=null){
                for(int m=0; m<maxm.length; ++m){
                  if(maxm[m]==Integer.valueOf(fn3[i][j])){
                    ++fn3c;
                    
                  }}
              }
            }
            fn3[i][4]=String.valueOf(fn3c);
            fn3c=0;
          }
        }
        int fn2c=0;
        
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][2]==null){
            
            for(int j=1; j<=1; ++j){
              if(fn2[i][j]!=null){
                for(int m=0; m<maxm.length; ++m){
                  if(maxm[m]==Integer.valueOf(fn2[i][j])){
                    ++fn2c;
                  }}
              }}
            fn2[i][3]=String.valueOf(fn2c);
            fn2c=0;
          }
        }
        
        
        int mxp=0, mx4=0, mx3=0, mx2=0;
        for(int i=0; i<finalfn4.length; ++i){
          if(finalfn4[i][5]!=null){
            if(Integer.valueOf(finalfn4[i][5])>mx4){
              mx4=Integer.valueOf(finalfn4[i][5]);
            }
          }
        }
      
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][4]!=null){
            if(Integer.valueOf(fn3[i][4])>mx3){
              mx3=Integer.valueOf(fn3[i][4]);
            }
          }
        }
       
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][3]!=null){
            if(Integer.valueOf(fn2[i][3])>mx2){
              mx2=Integer.valueOf(fn2[i][3]);
            }
          }
        }
     
        if(mx4>mx3 && mx4>mx2){
          mxp=mx4;}
        if(mx3>mx4 && mx3>mx2){
          mxp=mx3;}
        if(mx2>mx3 && mx2>mx4){
          mxp=mx2;}
      
        for(int i=0; i<finalfn4.length; ++i){
          
          if(resultgetter==false && mxp==Integer.valueOf(finalfn4[i][5])){
            result1[rLoader1]=finalfn4[i][0];
            ++rLoader1;
            resultgetter=true;
            for(int jj=1; jj<=4; ++jj){
              if(finalfn4[i][jj]!=null){
                counter1[Integer.valueOf(finalfn4[i][jj])]=0;}
            }
            
          }
          
        }
        for(int i=0; i<fn3.length; ++i){
          if(fn3[i][3]==null){
            
            if(resultgetter==false && mxp==Integer.valueOf(fn3[i][4])){
              result1[rLoader1]=fn3[i][0];
              ++rLoader1;
              resultgetter=true;
              for(int jj=1; jj<=2; ++jj){
                if(fn3[i][jj]!=null){
                  counter1[Integer.valueOf(fn3[i][jj])]=0;}}
            }
            
          }
        }
        for(int i=0; i<fn2.length; ++i){
          if(fn2[i][2]==null){
            
            if(resultgetter==false && mxp==Integer.valueOf(fn2[i][3])){
              result1[rLoader1]=fn2[i][0];
              ++rLoader1;
              resultgetter=true;
              for(int jj=1; jj<=1; ++jj){
                if(fn2[i][jj]!=null){
                  counter1[Integer.valueOf(fn2[i][jj])]=0;}}
            }
            
          }
        }
      }
    }
    
    
    int sCount=0;
    int sCount1=0;
    for(int i=0; i<result.length; ++i){
      if(result[i]!=null){
        ++sCount;
      }
    }
  
    for(int i=0; i<result1.length; ++i){
      if(result1[i]!=null){
        ++sCount1;
      }
    }
     
    int minResult=sCount;
    if(sCount1<sCount){
      minResult=sCount1;
    }
   
    String[] fresult=new String[minResult];
    int frLoader=0;
    if(minResult==sCount){
      for(int i=0; i<result.length; ++i){
        if(result[i]!=null){
          String fr="";
          for(int j=0; j<result[i].length(); ++j){
            if(result[i].charAt(j)=='0'){
              fr+=(String.valueOf((char)(j+65)))+"'";}
            if(result[i].charAt(j)=='1'){
              fr+=String.valueOf((char)(j+65));
            }
            
          }
          fresult[frLoader]=fr;
          frLoader++;
        }
      }
    }
    else if(minResult==sCount1){
      for(int i=0; i<result1.length; ++i){
        if(result1[i]!=null){
          String fr="";
          for(int j=0; j<result1[i].length(); ++j){
            if(result1[i].charAt(j)=='0'){
              fr+=(String.valueOf((char)(j+65)))+"'";}
            if(result1[i].charAt(j)=='1'){
              fr+=String.valueOf((char)(j+65));
            }
            
          }
          fresult[frLoader]=fr;
          frLoader++;
        }
      }
    }
    System.out.println("Results: ");
    for(int i=0; i<fresult.length; ++i){
      System.out.print(fresult[i]);
      if(i<(fresult.length-1)){
        System.out.print(" + ");}
    }

    System.out.println();
    System.out.println("If you are using Dr. Java, press F2 to run the code again :)");
    
    
  }
}
