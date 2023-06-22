import java.util.*;

public class CareerPathFinder {
	public static void main(String[] args) {
			
		// Welcome message to the user 
		System.out.println("Welcome to the Career Path Finder application!");
		
		// Simulates a user input
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter his/her name 
		System.out.print("Please enter your name: ");
		String userName = input.nextLine();	
		
		// Prompt user to enter his/her age 
		System.out.print("Please enter your age: ");
		int userAge = input.nextInt();
		
		// Prompt user to enter the career field they are interested in
		System.out.print("Please enter the career field you are interested in: ");
		String careerField = input.nextLine();
		
		// Prompt user to enter their educational background 
		System.out.print("Please enter your educational background: ");
		String education = input.nextLine();
		
		// Prompt user to enter their current job experience 
		System.out.print("Please enter your current job experience: ");
		String jobExperience = input.nextLine();
		
		// Prompt user to enter their skills 
		System.out.print("Please enter your skills: ");
		String skills = input.nextLine();
		
		// Prompt user to enter any certifications he/she has 
		System.out.print("Please enter any certifications you have: ");
		String certifications = input.nextLine();
		
		// Prompt user to enter their professional goals
		System.out.print("Please enter your professional goals: ");
		String professionalGoals = input.nextLine();
		
		// Prompt user to enter their preferred job location
		System.out.print("Please enter your preferred job location: ");
		String jobLocation = input.nextLine();
		
		// Prompt user to enter if they are willing to relocate
		System.out.print("Are you willing to relocate? (yes/no): ");
		String relocateChoice = input.nextLine();
		boolean relocate;
		
		// Determine if user is willing to relocate based on input 
		if (relocateChoice.equalsIgnoreCase("yes")) {
			relocate = true;
		} else if (relocateChoice.equalsIgnoreCase("no")) {
			relocate = false;
		} else {
			System.out.println("Please enter a valid input (yes/no).");
			relocate = false;
		}
		
		// Prompt user to enter their desired salary
		System.out.print("Please enter your desired salary: ");
		double desiredSalary = input.nextDouble();
		
		// Prompt user to enter how long they plan to stay in the job
		System.out.print("How long do you plan to stay in your job? (in years): ");
		int jobDuration = input.nextInt();
		
		// Prompt user to enter any additional information 
		System.out.print("Please enter any additional information: ");
		String addInfo = input.nextLine();
		
		// Store all the user input into an array 
		String[] userInput = {userName, Integer.toString(userAge), careerField, education,
				jobExperience, skills, certifications, professionalGoals, jobLocation,
				Boolean.toString(relocate), Double.toString(desiredSalary),
				Integer.toString(jobDuration), addInfo};
		
		// Calculate the user's career score based on the input 
		int careerScore = calculateCareerScore(userInput);
		
		// Look up the user's career score 
		String careerPath = lookUpCareerScore(careerScore);
		
		// Display the user's career path 
		System.out.println("Hello, " + userName + "!");
		System.out.println("Your career path is: " + careerPath);
		
		// Close the scanner 
		input.close();
	}
	
	// Method to calculate the career score 
	public static int calculateCareerScore(String[] userInput) {
		
		// Initialize the career score as 0
		int careerScore = 0;
		
		// Calculate the career score based on the user input 
		for (int i = 0; i < userInput.length; i++) {
			if (userInput[i].equals("Education")) {
				careerScore += 30;
			} else if (userInput[i].equals("Job Experience")) {
				careerScore += 40;
			} else if (userInput[i].equals("Skills")) {
				careerScore += 15;
			} else if (userInput[i].equals("Certifications")) {
				careerScore += 10;
			} else if (userInput[i].equals("Professional Goals")) {
				careerScore += 5;
			}
		}		
		
		// If user is willing to relocate, add 10 to the career score 
		if (Boolean.valueOf(userInput[9])) {
			careerScore += 10;
		}
		
		// If user has a desired salary, add 5 to the career score 
		if(!userInput[10].equals("0")) {
			careerScore += 5;
		}
		
		// If user has a job duration set, add 10 to the career score 
		if (!userInput[11].equals("0")) {
			careerScore += 10;
		}
		
		return careerScore;
	}
	
	// Method to look up the career path based on the career score 
	public static String lookUpCareerScore(int careerScore) {
		
		// Initialize the career path as "beginner"
		String careerPath = "Beginner";
		
		// Look up the career path based on the career score 
		if (careerScore >= 80) {
			careerPath = "Advanced";
		} else if (careerScore >= 60 && careerScore < 80) {
			careerPath = "Intermediate";
		} else if (careerScore < 60) {
			careerPath = "Beginner";
		}
		
		return careerPath;
	}
}