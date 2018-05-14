package com._4mila.backend.service.language;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Strings;

public class LanguageUtility {

	private static LanguageMock english;
	private static LanguageMock german;
	private static LanguageMock italian;
	private static LanguageMock dutch;

	private static ThreadLocal<LanguageMock> userLanguage = new ThreadLocal<LanguageMock>() {
		@Override
		protected LanguageMock initialValue() {
			return null;
		}
	};

	static {
		english = new LanguageMock();
		english.setCode("en");
		german = new LanguageMock();
		german.setCode("de");
		italian = new LanguageMock();
		italian.setCode("it");
		dutch = new LanguageMock();
		dutch.setCode("nl");

		english.getName().put(english, "English");
		english.getName().put(german, "Englisch");
		german.getName().put(english, "German");
		german.getName().put(german, "Deutsch");
		italian.getName().put(english, "Italian");
		italian.getName().put(german, "Italienisch");
		dutch.getName().put(english, "Dutch");
		dutch.getName().put(german, "Holländisch");
	}

	private LanguageUtility() {
	}

	public static void setUserLanguage(String languageCode) {
		userLanguage.set(english);
		if (languageCode != null) {
			if (languageCode.equals("de")) {
				userLanguage.set(german);
			} else if (languageCode.equals("it")) {
				userLanguage.set(italian);
			} else if (languageCode.equals("nl")) {
				userLanguage.set(dutch);
			}
		}
	}

	public static LanguageMock getUserLanguage() {
		if (userLanguage.get() != null) {
			return userLanguage.get();
		}
		return german; // default
	}
	
	public static LanguageMock getLanguage(String languageCode) {
		if (languageCode != null) {
			if (languageCode.equals("de")) {
				return german;
			} else if (languageCode.equals("it")) {
				return italian;
			} else if (languageCode.equals("nl")) {
				return dutch;
			}
		}
		return german;
	}

	public static LanguageMock getEnglish() {
		return english;
	}

	public static LanguageMock getGerman() {
		return german;
	}

	public static LanguageMock getItalian() {
		return italian;
	}

	public static LanguageMock getDutch() {
		return dutch;
	}

	public static String getTranslation(Map<LanguageMock, String> translations) {
		if (translations == null || translations.isEmpty()) {
			return "";
		}
		if (Strings.isNullOrEmpty(translations.get(getUserLanguage()))) {
			for (String translation : translations.values()) {
				if (!Strings.isNullOrEmpty(translation)) {
					return translation;
				}
			}
		}
		return translations.get(getUserLanguage());
	}
	
	public static Map<LanguageMock, String> createLanguageMap(String name) {
		Map<LanguageMock, String> map = new HashMap<>();
		map.put(LanguageUtility.getGerman(), name);
		map.put(LanguageUtility.getEnglish(), name);
		map.put(LanguageUtility.getItalian(), name);
		map.put(LanguageUtility.getDutch(), name);
		return map;
	}
	
}
