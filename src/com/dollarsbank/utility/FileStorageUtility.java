package com.dollarsbank.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorageUtility {

	public int fCount = 0;

	public boolean fSave(String custName, String userText) {
		try {
			++fCount;
			String fName = "Bank stub for user - " + custName + ".txt";
			File myFile = new File(fName);
			if (myFile.createNewFile()) {
				if (!FWriter(fName, userText))
					System.out.println("failed to write to file properly");
				return true;

			} else {
				return false;
			}

		} catch (IOException e) {
			return false;
		}
	}

	private boolean FWriter(String fName, String userText) {

		try {

			FileWriter myWriter = new FileWriter(fName);
			myWriter.write(userText);
			myWriter.close();
			return true;

		} catch (IOException e) {
			return false;
		}
	}

}
