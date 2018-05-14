package com._4mila.backend.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateUtility {

	public final static Date truncateToDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public final static boolean checkDateOrder(Date date1, Date date2) {
		if (truncateToDay(date1) != null && truncateToDay(date2) != null) {
			return truncateToDay(date1).before(truncateToDay(date2)) || truncateToDay(date1).equals(truncateToDay(date2));
		}
		return true;
	}

	public final static Date parseDate(String date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		Date result;
		try {
			result = dateFormat.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public final static String formatDateTime(Date d) {
		if (d == null) {
			return "";
		}
		return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.GERMAN).format(d);
	}

	public final static String formatDuration(Long duration) {
		if (duration != null) {
			if (duration < 60) {
				return duration + "s";
			} else if (duration < 3600) {
				return (duration / 60) + "min " + (duration % 60) + "s";
			} else {
				return (duration / 3600) + "h " + ((duration % 3600) / 60) + "min";
			}
		}
		return "";
	}

}
