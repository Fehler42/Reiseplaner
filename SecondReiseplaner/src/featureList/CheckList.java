package featureList;

import java.util.List;

import start.Main;

public class CheckList {

	public static void fillList() {
		Main.features = XMLParser.parse(Main.features);
		checkList(Main.features);
	}

	public static List<String> checkList(List<String> features) {
		if ((features.get(1).toString().equals("1") || features.get(2).toString().equals("1")
				|| features.get(3).toString().equals("1")) && features.get(0).toString().equals("0")) {
			System.out.println("invalid list of features!");
		} else if (features.get(0).toString().equals("1") && (features.get(1).toString().equals("0")
				&& features.get(2).toString().equals("0") && features.get(3).toString().equals("0"))) {
			System.out.println("invalid list of features!");
		} else if ((features.get(4).toString().equals("1") || features.get(5).toString().equals("1"))
				&& features.get(3).toString().equals("0")) {
			System.out.println("invalid list of features!");
		} else if ((features.get(3).toString().equals("1"))
				&& (features.get(4).toString().equals("0") && features.get(5).toString().equals("0"))) {
			System.out.println("invalid list of features!");
		} else if (features.get(0).toString().equals("0") && features.get(6).toString().equals("0")) {
			System.out.println("invalid list of features!");
		} else if ((features.get(7).toString().equals("1") || features.get(8).toString().equals("1")
				|| features.get(10).toString().equals("1") || features.get(11).toString().equals("1"))
				&& features.get(6).toString().equals("0")) {
			System.out.println("invalid list of features!");
		} else if ((features.get(7).toString().equals("0") || features.get(8).toString().equals("0")
				|| features.get(10).toString().equals("0") || features.get(11).toString().equals("0"))
				&& features.get(6).toString().equals("1")) {
			System.out.println("invalid list of features!");
		} else if (features.get(9).toString().equals("1") && features.get(8).toString().equals("0")) {
			System.out.println("invalid list of features!");
		} else if (!(features.get(12).toString().equals("1") && features.get(13).toString().equals("0")
				&& features.get(14).toString().equals("0"))
				&& !(features.get(12).toString().equals("0") && features.get(13).toString().equals("1")
						&& Main.features.get(14).toString().equals("0"))
				&& !(features.get(12).toString().equals("0") && features.get(13).toString().equals("0")
						&& features.get(14).toString().equals("1"))) {
			System.out.println("invalid list of features!");
		}
		return features;
	}
}
