package com.file.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class textFileReusable {

	private String filePath;
	private File file;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;

	public textFileReusable(String filePath) throws IOException {

		this.filePath = filePath;

		file = new File(filePath);

		if (file.createNewFile()) {
			System.out.println("File is Created ");
		} else {
			System.out.println("File already Exist");
		}

	}

	public void intializeWriteFileVariable() throws IOException {

		fw = new FileWriter(file);
		bw = new BufferedWriter(fw);

	}

	public void intializeReadFileVariable() throws IOException {

		fr = new FileReader(file);
		br = new BufferedReader(fr);

	}

	public void WriteFile(String EnterText) throws IOException {

		intializeWriteFileVariable();

		if (bw != null) {

			bw.write(EnterText);
			bw.flush();
			System.out.println("SUCCESSFULLY WRITEN TEXT FILE");

		} else {
			System.out.println("BUFFTER WRITER IS HOLDING NULL VALUE");
		}
	}

	public String getTextFileData() throws IOException {
		intializeReadFileVariable();
		String data = null;
		if (br != null) {
			data = br.readLine();

		} else {
			System.out.println("BUFFTER READER IS HOLDING NULL VALUE ");
		}
		return data;
	}

	public List getAllTextFileData() throws IOException {
		intializeReadFileVariable();
		String value = null;
		List list = new ArrayList();

		if (br != null) {

			while (br.ready()) {

				value = br.readLine();

				list.add(value);

				if (list.size() == 2) {

					System.out.println("2nd value is " + br.readLine());
				}

			}

		}
		return list;

	}

}
