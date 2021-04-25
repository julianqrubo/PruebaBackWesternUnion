package com.backend.westernunion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static boolean validateEmail(final String email) {
		Pattern pattern = Pattern.compile(
				"^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
		Matcher mather = pattern.matcher(email);
		return mather.find();
	}
}
