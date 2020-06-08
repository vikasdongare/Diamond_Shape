import java.util.*;

public class diamond extends Exception{

	diamond(){}
	diamond(String str){
		System.out.print("\n"+str);
	}

	public static void main(String args[]){

		Scanner input = new Scanner(System.in);
		int size;
		System.out.print("ENTER NO: ");
		size = input.nextInt();

		System.out.println();

		try{
			if(size <= 0){
				diamond d = new diamond("\t!!!INVALID SIZE !!!");
				throw d;
			}
		}

		catch(diamond d){
				System.out.println("\n\t !!! THANK YOU !!!");
				System.exit(0);

		}
		
		help h = new help();

		for(int i=0 ; i < (2*size)+1 ; i++){		//For Loop-1 for rows in diamond

				if(i==0 || i==(2*size)){		//If loop for 1st and last linr frame

					System.out.print("+");
					for (int j=0 ; j < 2*size ; j++) {
						System.out.print("-");
					}
					System.out.println("+");

				}

				else{						//else loop for all internal pattern of diamond
					System.out.print("|");

					if(i==size){		//these loop for central part of diamond
						System.out.print("<");
						for(int j=0; j < (2*size)-2 ;j++){
							h.linePattern(i);
						}
						System.out.print(">");
					}

					else if(i<size){		//these else if for upper half of diamond
						int pos = 0;
						for (int j=0 ; j < 2*size ; j++) {	//these loop for traversing along column
							if(j == size-i){
								System.out.print("/");
								pos = j+1;
							}
							else if(i>1 && i<(2*size)-2 && j> size-i && j < pos+((i-1)*2)){
								h.linePattern(i);
							}
							else if(j == pos+((i-1)*2) && j>size-i){
								System.out.print("\\");
							}
							else{
								System.out.print(" ");
							}
						}
					}

					else if(i>size){		//these else if for lower half of diamond
						int count = 0;
						for (int j=0 ; j < 2*size ; j++) {	//these loop for traversing along column
							if(j == i-size){
								System.out.print("\\");
							}
							else if(i>1 && i<(2*size)-1 && j> i-size && j+1 < size*2-count){
								h.linePattern(i);
							}
							else if(j> i-size && j+1 == size*2-count){
								System.out.print("/");
							}
							else{
								System.out.print(" ");
								count++;
							}
						}
					}

					System.out.println("|");
				}
		}

	System.out.println("\n\n\t!!! THANK YOU !!!");
	}
}

class help{

	public void linePattern(int pat){
		if(pat%2 == 0){
			System.out.print("-");
		}
		else{
			System.out.print("=");
		}
	}

}
