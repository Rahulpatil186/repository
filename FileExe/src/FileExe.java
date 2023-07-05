
import java.io.*;
import java.util.*;
class FileOp
{
	
  Scanner sc=new  Scanner(System.in);
  String directorypath="D:/java_prog/javapractise/FileOperation";
  public void createFile()throws IOException
   {
           System.out.println("enter name of file with extension");
           String filetemp=sc.next();
           String newfile=directorypath+filetemp;
           File file=new File(newfile);
           if(file.exists())
             {
                System.out.println("file alread exist");
             }
            else
              {
                   try
                    {
                         file.createNewFile();
                         System.out.println("file created successfully");
                     }
                     catch(FileNotFoundException e)
                      {
                           e.printStackTrace();
                      }
                }
     }
     public void write()throws IOException
      {
           this.directory();
           Scanner sc1=new Scanner(System.in);
           System.out.println("----------------------");
           System.out.println("select file to write");
           String writefile=sc.next();
           String write=directorypath+writefile;
           FileWriter filewrite=new FileWriter(write);
           System.out.println("write content to file");
           try
           {
                
                 while(sc1.hasNext())
                   {
                        String writeElement=sc1.next();
                        if(writeElement=="exit")
                        {
                        	break;
                        }
                        filewrite.write(writeElement);
                           
                   }
             }
             catch(FileNotFoundException e)
              {
                    e.printStackTrace();
              }
             finally 
             {
            	 
                 filewrite.close();
                 sc1.close();
              }
     }
      public void read()throws IOException
      {
            this.directory();
           
            System.out.println("----------------------");
            System.out.println("select file to read");
            String readfile=sc.next();
            String read=directorypath+readfile;
            FileReader readFile=new FileReader(read);
            Scanner readf=new Scanner(readFile);
            while(readf.hasNext())
                   {
                        String readline=readf.next();
                        System.out.println(readline);
                  }
                 readFile.close();
                 readf.close();
   }
  public void directory()
   {
           File direcory =new File(directorypath);
           File[] contents=direcory.listFiles();
            System.out.println("===================");
            for(int i=0;i<contents.length;i++)
             {
                      System.out.println("||"+contents[i].getName()+"||");
               }
           System.out.println("===================");
      }
  public void deleteFile()
 {
        System.out.println("Enter file name you want to delete :");
        String delf=sc.next();
        String delfile=directorypath+delf;
         File deletefile=new File(delfile);
         if(deletefile.delete())
           {
              System.out.println("File deleted successfully");
           }
          else
          {
               System.out.println("file doesn't exists");
           }
     }
}
class FileExe
{
   public static void main(String[] arg)
     {
        Scanner sc=new Scanner(System.in);
         FileOp op=new FileOp();
         boolean v=true;
         while(v)
         {
              System.out.println("----------------------");
              System.out.println("Choose From Following\n1)Create new File\n2)write to the file\n3)read File\n4)See Directory\n5)delete file\n6)Exit");
               System.out.println("enter choice :");
               int ch=sc.nextInt();
               switch(ch)
                 {
                      case 1:
                        try{
                         op.createFile();
                         }
                         catch(IOException e)
                           {
                                e.printStackTrace();
                            }
                          break;
                     case 2:
                         try
                         {
                             op.write();
                          }
                        catch(IOException e)
                           {
                                e.printStackTrace();
                            }
                          break;   
                       case 3:
                        try
                        {
                         op.read();
                         }
                         catch(IOException e)
                          {
                               e.printStackTrace();
                          }
                          break;   
                      case 4:
                            op.directory();
                             break;
                        case 5:
                             op.deleteFile();
                             break;
                          case 6:
                             v=false;
                             break;
                         default :
                              System.out.println("wrong choice enter again");
                               break;
                         }
              
                }
            sc.close();
           }
      }                          
