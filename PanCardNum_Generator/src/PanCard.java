
import java.util.Random;
import java.util.Scanner;

public class PanCard {

	// Method to generate a random alphabetic character
	private static char getRandomAlphabet() {
		Random random = new Random(); // We're getting ready to pick something randomly.
		return (char) ('A' + random.nextInt(26)); // Here, we're picking a random letter from 'A' to 'Z'.
	}

	// Method to generate a random digit
	private static char getRandomDigit() {
		Random random = new Random(); // Again, getting ready to pick randomly.
		return (char) ('0' + random.nextInt(10)); // This time, we're picking a random number from '0' to '9'.
	}

	// Method to generate a random PAN number
	public static String generatePAN(String fullName, boolean isPerson) {
		StringBuilder pan = new StringBuilder(); // This is like a box where we'll put all the parts of your PAN card.

		// Split full name into parts
		String[] parts = fullName.split("\\s+"); // We're taking your full name and dividing it where there are spaces.

		// Extract surname (last part)
		String surname = parts[parts.length - 1]; // We're taking the last part of your name as your surname.

		// First three random alphabets
		for (int i = 0; i < 3; i++) {
			pan.append(getRandomAlphabet()); // We're picking three random letters and adding them to your PAN card.
		}

		// Fourth character: 'P' for person or 'O' for organization
		pan.append(isPerson ? 'P' : 'O'); // Depending on whether you said you're a person or an organization, we add
											// 'P' or 'O'.

		// Fifth character: first letter of the surname
		pan.append(Character.toUpperCase(surname.charAt(0))); // We take the first letter of your surname and add it to
																// your PAN card.

		// Next four characters: random digits
		for (int i = 0; i < 4; i++) {
			pan.append(getRandomDigit()); // We're picking four random numbers and adding them to your PAN card.
		}

		// Last character: random alphabet
		pan.append(getRandomAlphabet()); // Finally, we pick one more random letter and add it to your PAN card.

		return pan.toString(); // We put all the parts together and give you your unique PAN card number.
	}

	// Main method to test the PAN number generation
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // We're getting ready to listen to what you type.

		// Ask the user to input their full name
		System.out.print("Enter your full name: ");
		String fullName = scanner.nextLine(); // We're waiting for you to type your full name.

		// Ask the user to specify whether they are a person or an organization
		System.out.print("Are you a person or an organization? (Enter 'P' for person or 'O' for organization): ");
		char type = scanner.nextLine().charAt(0); // We're asking if you're a person ('P') or an organization ('O').

		boolean isPerson = (type == 'P' || type == 'p'); // We're figuring out if you said 'P' or 'p', you're a person.

		// Generate the PAN number
		String pan = generatePAN(fullName, isPerson); // We're using all the things you told us to make your PAN card.

		System.out.println("Generated PAN: " + pan); // We're showing you your special PAN card number.

		scanner.close(); // We're done listening now.
	}
}
