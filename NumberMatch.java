package ass;
import java.io.IOException;
import java.util.*;


public class NumberMatch {
	static int Round =1;
	static int chance =10;
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
	    boolean notOver = true;
	    Vector<Integer> SecretNumber = Secret();

	    while (notOver) {

	        System.out.println("You have " + chance + " chances!!!");
	        if (chance == 0) {
	            SecretNumber.removeAllElements();
	            
	            Round++;
	            if (Round == 6) {
		            System.out.println("Your Round Complete!!!");
		            System.exit(0);

		        }
	            
	            System.out.println("Game Over !!!");
	            System.out.println("Try Another Round!!  y/n?  ");
	            char game = (char) System.in.read();
	            scanner.nextLine();
	            chance=10;
	            
	             if (game == 'y') {
	                System.out.println("Start a new game!!!");
	               
	                SecretNumber = Secret();
	                

	            } else
	                return;
	        }
	        

	        Vector<Integer> Player = play();
	        notOver = check(SecretNumber, Player);

	    }
	}

	public static Vector<Integer> Secret() {
	    Vector<Integer> secretRandom = new Vector<Integer>();

	    int num;
	    boolean notComplete = true;
	    Random randomObj = new Random();
	    while (notComplete) {
	        if (secretRandom.size() != 4) {
	            num = randomObj.nextInt(9) + 1;
	            if (!secretRandom.contains(num)) {
	                secretRandom.addElement(num);
	                if (secretRandom.size() == 4)
	                    notComplete = false;
	            }
	        }
	    }
	    System.out.println("Welcome");
	    //System.out.println("Computer- " + secretRandom);
	    System.out.println("Round - "+ Round+"\n");
	    return secretRandom;

	}

	public static Vector<Integer> play() {
	    Vector<Integer> list = new Vector<Integer>();
	    int num;
	    String cutString = null;
	    boolean notComplete = true;

	    while (notComplete) {
	        System.out.print("Enter Numbers: ");
	        String numString = scanner.nextLine();
	        

	        if (numString.length() >= 4) {
	            cutString = numString.substring(0, 4);
	            for (int i = 0; i < cutString.length(); i++) {
	                num = Character.getNumericValue(cutString.charAt(i));
	                if (list.contains(num)) {
	                    System.out.println("Duplicate!!!\n");
	                    list.removeAllElements();
	                    break;
	                } else {
	                    list.addElement(num);
	                    if (list.size() == 4) {
	                        notComplete = false;
	                    }
	                }
	            }
	        } else {
	            System.out.println("Please input aleast 4 numbers!!!");
	        }
	    }
	    System.out.println("Player- " + list+"\n");
	    return list;
	}

	public static boolean check(Vector<Integer> computer, Vector<Integer> player) {
	    int H = 0, B = 0;
	    boolean notOver = true;
	    for (int i = 0; i < computer.size(); i++) {
	        for (int j = 0; j < player.size(); j++) {
	            if (computer.get(i) == player.get(j)) {
	                if (i == j)
	                    H++;
	                else
	                    B++;
	            }

	        }
	    }
	    if (H == 4) {
	        System.out.println("You Win!!!!");
	      //  System.out.println("Computer- " + computer);
	        notOver = false;
	    } else {
	        System.out.println("Try again!!!");
	        System.out.println("Result- " + H + "H\t" + B + "B\n");
	        player.removeAllElements();
	    }
	    chance--;

	    return notOver;
	}
	}

