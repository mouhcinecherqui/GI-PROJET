
/*
 * /*
 * Project: API GDFA - 29M
 * Copyright© 2017 ORANGE
 * Creation: 17 avr. 2017 by marouane.rais@sofrecom.com
 */

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.validator.GenericValidator;

public class Test3 {

	public static void main(String[] args) throws Exception {
		// System.out.println(makeFullName("marouane", "rais"));
		// System.out.println(makeFullNameCourt("marouane", "rais"));
		// System.out.println("<" + getNom(null) + ">");
		// System.out.println("<" + getPrenom("") + ">");
		// System.out.println("<" + getNom("rais marouane") + ">");
		// System.out.println("<" + getPrenom("rais marouane") + ">");
		// System.out.println("<" + getNom(" rais marouane ") + ">");
		// System.out.println("<" + getPrenom(" rais marouane ") + ">");
		// System.out.println("<" + getNom("raismarouane") + ">");
		// System.out.println("<" + getPrenom("raismarouane") + ">");

		List<String> temp = new ArrayList<String>();
		temp.add("qd");

		isNotNullOrEmpty(null);
		isNotNullOrEmpty(new ArrayList<String>());
		
		isNotNullOrEmpty(temp);
	}

	static String makeFullName(String firstName, String lastName) {
		final StringJoiner joiner = new StringJoiner(" ");
		joiner.add(firstName);
		joiner.add(lastName);
		return joiner.toString();
	}

	static String makeFullNameCourt(String firstName, String lastName) {
		final StringBuilder builder = new StringBuilder();
		builder.append(firstName.charAt(0)).append(". ");
		builder.append(lastName);
		return builder.toString();
	}

	static String getNom(String fullName) {
		String nom = null;
		if (!GenericValidator.isBlankOrNull(fullName)) {
			nom = fullName.trim().replaceAll("\\s{2,}", " ").split(" ")[0];
		}
		return nom;
	}

	static String getPrenom(String fullName) {
		String prenom = null;
		if (!GenericValidator.isBlankOrNull(fullName)) {
			String[] tabStr = fullName.trim().replaceAll("\\s{2,}", " ").split(" ");
			if (tabStr.length > 1) {
				prenom = tabStr[1];
			} else {
				return fullName;
			}
		}
		return prenom;
	}

	public static Boolean isNotNullOrEmpty(List<?> list) {
		if (list != null && !list.isEmpty()) {
			System.out.println("machi erreur");
			return true;
		}
		System.out.println("erreur");
		return false;
	}

}
