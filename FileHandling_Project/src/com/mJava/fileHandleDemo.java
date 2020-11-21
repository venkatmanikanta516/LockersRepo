package com.mJava;

import java.io.*;
import java.util.*;

 

public class fileHandleDemo {
	Scanner sc=new Scanner(System.in);
	String fileNameMethod()
	{
		String filename=null;
		try {
			System.out.println("Enter which file you Want : ");
			
			
			  filename=sc.nextLine();
			return filename;
			
		} catch (Exception e) {
			
			System.out.println("Exception at fileNameMethod with error Msg : "+e.getMessage());
			return filename;
		}
		

	}
	 
void  optionsMethod()
{
	String option=null;
	try {
		//System.out.println("==================================================================================");
		System.out.println("\n$***** Main Menu *****$");
		System.out.println("\n1.Files List\n2.Add File\n3.Delete File\n4.Search File\n5.Exist");
		System.out.println("\nAbove options to select which operation do you want :");
		
		option=sc.next();
		
		 
		  if(option.equals("0")||option.equals("1")||option.equals("2")||option.equals("3")||option.equals("4")||option.equals("5"))
			optionsSwitchMethod(Integer.parseInt(option));
		else
		{
			System.out.println("\n\n## Alert : PLEASE SELECT VALID OPTION\n\n");
			optionsMethod();
		}
			
			
			 
		 
		 
	} catch (Exception e) {
		System.out.println("Exception at optionsMethod with error Msg : "+e.getMessage()); 
		 
	}
	 
	
	
}
	
void optionsSwitchMethod(int Option)
{
	switch(Option)
	{
	/*
	 * case 0: newFolderMethod(); break;
	 */
	case 1:
		FilesListMethod();
		 break;
	case 2:
		addFileMethod();
		 break;
	case 3:
		deleteFileMethod();
		 break;
	case 4:
		searchFileMethod();
		break;
	case 5:
		exitMethod();
		break;
		 default :
			System.out.println("No Option Available.Try Again");
			 
		
	}
}
void newFolderMethod()
{
	try {
		System.out.println("Enter the path to create a directory: ");
	      Scanner sc = new Scanner(System.in);
	      String path = sc.next();
	      System.out.println("Enter the name of the desired a directory: ");
	      String foldername=sc.next();
	      path = path+foldername;
	      //Creating a File object
	      File file = new File(path);
	      //Creating the directory
	      boolean bool = file.mkdir();
	      if(bool){
	         System.out.println("Directory created successfully");
	         optionsMethod();
	      }
	      else if(file.exists())
	      {
	    	  
	    	  System.out.println("Directory Already Available.CheckOnce");
	    	  optionsMethod();
	      }
	      else{
	         System.out.println("Sorry couldn�t create specified directory");
	         optionsMethod();
	      }
		
	} catch (Exception e) {
		System.out.println("Exception at newFolderMethod with error Msg : "+e.getMessage());
	}
}

void addFileMethod()
{
	String isYorN="N";
	try {
		
		String filename="";
System.out.println("Enter Path Directory : ");
		
		filename=sc.next();
		
		System.out.println("Patth is :  "+filename);
		 
		System.out.println("Enter File Name : ");
		
		filename=filename+sc.next();
		 
		
		File file=new File(filename);
		
		 
		if(file.exists())
		{
			System.out.println("File Already Exists.");
			optionsMethod();
		}
		else
		{
			
			
			FileOutputStream FOS=new FileOutputStream(file);
			FOS.write(8);
			FOS.flush();
			FOS.close();
			System.out.println("File Created at location "+file.getPath());
		
			System.out.println("\nFor Main Menu Press 'Y' or to Add another File Press 'N' ");
			boolean IsYorN= NavigateMainMethod();
			if(IsYorN==true)
			{
				
				optionsMethod()	;
			}
			 else
				 addFileMethod();
			 
		}
		 
	} catch (Exception e) {
	  System.out.println("Exception at addFileMethod with error Msg : "+e.getMessage());
	}
	
}

void deleteFileMethod()
{
	String isYorN="N";
	try {
		
		String filename="";
		System.out.println("Enter File Name to Delete : ");
		filename=sc.next();
		
		
		File file=new File(filename);
		if(file.exists())
		{
			boolean isDeleted= file.delete();
			 if(isDeleted==true)
			 {
				 System.out.println("File Deleted"); 
			 }
			
			 else
			 {
				 System.out.println("File Not Deleted"); 
			 }
			 System.out.println("For Main Menu Press 'Y' other wise Press 'N' ");
			boolean IsYorN= NavigateMainMethod();
		if(IsYorN==true)
		{
			optionsMethod()	;
		}
		else
			deleteFileMethod();
		}
		else
		{
			
			System.out.println("File Not Exists.");
			optionsMethod()	;
			
		}
		 
	} catch (Exception e) {
	  System.out.println("Exception at addFileMethod with error Msg : "+e.getMessage());
	}
	
}

void searchFileMethod()
{
	try {
		int count=0;
		System.out.println("Enter file name to Search : ");
	String filename=sc.next();
		File f=new File(filename);
	 if(f.exists())
		 
	 {
		 System.out.println("## "+filename+" file is Avilable\n\n");
	 }
	 else
	 {
		 System.out.println("## "+filename+" file Not Found.\n\n");
	 }
		optionsMethod();
		
	} catch (Exception e) {
		System.out.println("Exception at searchFileMethod with error Msg : "+e.getMessage());
	}
	
}

boolean NavigateMainMethod()
{
	boolean IsYorN=false;
	String YorN=null;
	try {
//System.out.println("For Menu Press 'Y' other wise Press 'N' ");
		
		YorN=sc.next();
		 
		if(YorN.toLowerCase().equals("y"))
		{
			IsYorN=true;
		}
		else if(YorN.toLowerCase().equals("n"))
		{
			 
			IsYorN=false; 
		}
		else
		{
			IsYorN=false; 
			System.out.println("## Alert : Invalid Option.Try again");
			NavigateMainMethod();
		}
		
	} catch (Exception e) {
		System.out.println("Exception at NavigateMainMethod with error Msg : "+e.getMessage());
		return IsYorN;
	}
	return IsYorN;
}
void FilesListExitMethod()
{
	try {
		 String  YorN=null;
		 
		 System.out.println("\nFor Main menu Press'Y' or to Find Another Path Press 'N' : ");
		 YorN=sc.next();
		 if(YorN.toLowerCase().equals("y"))
			 optionsMethod();
		 else  if(YorN.toLowerCase().equals("n"))
			 FilesListMethod();
		 else
		 {
			 System.out.println("## Alert: Please Select Valid Option : ");
				
			 FilesListExitMethod();
		 }
	} catch (Exception e) {
		System.out.println("Exception at FilesListExitMethod with error Msg : "+e.getMessage());
	} 
	
}

void FilesListMethod()
{
	try {
		System.out.println("Enter Path to show Avialable files in the Directory : ");
		String fileDirectory=sc.next();
		if(fileDirectory.isEmpty())
		{
			System.out.println("##### Please enter file Directory.");
			FilesListMethod();
		}
		 
		else
		{
			 
			File f=new File(fileDirectory);
			if(f.exists())
			{
				String[] s=f.list();
				File[] sq=f.listFiles();
			 
				 Arrays.sort(sq);
				 System.out.println("\n$$$ Below are the Available files in the Directory of  "+fileDirectory+" $$$\n");
				 for(File file:sq)
			     {
			         System.out.println(file.getName());
			     }
			/*	 System.out.println("=============================================================================");
				for (String a:s)
				{
				 
					 
					System.out.println(a);
					
				}*/
				
				 FilesListExitMethod();
				
					
			}
			else
			{
				System.out.println("\nInvalid File Path.Check Once and Try Again.\n");
				FilesListMethod();
			}
			
		}
		
	} catch (Exception e) {
		System.out.println("Exception at FilesListMethod with error Msg : "+e.getMessage());
		
	}
	
	
}
 
void exitMethod()
{
	System.out.println("Are you sure want to exist Press 'Y'. otherwise press 'N' to Main menu");
	String YorN=sc.next();
	 
	if(YorN.toLowerCase().equals("y"))
	{
		System.out.println("$$**** THANK YOU ****$$");
		return;	
	}
	else if(YorN.toLowerCase().equals("n"))
	{
		
		optionsMethod();
		 
	}
	else
	{
		System.out.println("## Alert : Invalid Option.Try again");
		exitMethod();
	}
		
			
	
}

public static void main(String[] args) throws IOException
	{
	
	System.out.println("$******** Welcome to LockedMe.com ********$\n");
	System.out.println("$******** Developed By : Venkata Manikanta ********$\n");
		
		try
		{
			fileHandleDemo FHD=new fileHandleDemo();
			//FHD.FilesListMethod();
		   FHD.optionsMethod();
		 
			//FHD.FilesListMethod();
		  
		  
			//FHD.optionsSwitchMethod(Option);
			
			
			//System.out.println(Option);
			
		/*	String filename=FHD.fileNameMethod();
			
			
			if(filename.isEmpty())
			{
				System.out.println("Please enter file Name ");
				  filename=FHD.fileNameMethod();
			}
			else
			{
				File file=new File(filename);
				
			}
			
			*/



	//
	//FileOutputStream fos=new FileOutputStream(filename);
	//fos.write(13);
	//fos.flush();
	//fos.close();

	/*
	boolean isFileExist=file.exists();
	 
	FileInputStream fis=new FileInputStream(file);

	int Data;
	while((Data=fis.read())!=-1)
	{
	  


	System.out.println(""+(char)Data);
	}
	fis.close();

	*/
			
		}
		
		catch(Exception e)
		{
			System.out.println("Exception at mainMethod with error Msg : "+e.getMessage()); 
		}
	
		
	}

}
