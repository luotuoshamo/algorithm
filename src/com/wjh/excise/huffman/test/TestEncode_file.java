package com.wjh.excise.huffman.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

import com.wjh.excise.huffman.HuffmanEncode;

public class TestEncode_file {
	public static void main(String[] args) throws Exception {
		HuffmanEncode haffmanEncode = new HuffmanEncode();
		// String text = "aaaaaddgggvvvvvv";
		// String text = "aaaabbbccd";
		//
		String text = "";
		FileInputStream fis = new FileInputStream(
				"C:/Users/Administrator/workspace_Helios/augorithm2/src/com/wjh/excise/in.txt");
		FileOutputStream fos = new FileOutputStream(
				"C:/Users/Administrator/workspace_Helios/augorithm2/src/com/wjh/excise/out.txt");

		InputStreamReader isr = new InputStreamReader(fis);
		OutputStreamWriter osw = new OutputStreamWriter(fos);

		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(osw);
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			text += line;
		}
		System.out.println(text);

		Map<Character, String> hfmDictMap = haffmanEncode.getHfmDictMap(text);
		System.out.println("hfm dict£º" + hfmDictMap);
		String newText = haffmanEncode.getNewText(text);
		System.out.println("after encoding£º" + newText);
		System.out.printf("compression radio£º%.2f",
				haffmanEncode.getCompressionRadio(text, newText));

		bw.write(newText);
		//
		fis.close();
		isr.close();
		br.close();
		bw.close();
		osw.close();
		fos.close();

	}
}
