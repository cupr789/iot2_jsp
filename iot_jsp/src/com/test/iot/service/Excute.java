package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Excute {
	public static void main(String[] args) {
		Service s = new Service();
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int cinoNum = 0;
		String cidescStr = null;
		
		
/*		System.out.println("몇번 반을 수정하시겠습니까?");
		cinoNum = sc.nextInt();
		sc.nextLine();
		System.out.println(cinoNum + "번 반설명을 뭐라고 수정하시겠습니까?");
		cidescStr = sc.nextLine();

		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
		hm.put("cidesc", cidescStr);
		hm.put("cino", cinoNum);
		result = s.updateClassInfo(hm);
		if (result == 1) {
			System.out.println("업데이트 잘됫음!!");
		}*/
		
		
/*		System.out.println("몇번 학생을 수정하시겠습니까?");
		cinoNum = sc.nextInt();
		sc.nextLine();
		System.out.println(cinoNum + "번 학생이름을 뭐라고 수정하시겠습니까?");
		cidescStr = sc.nextLine();

		LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
		hm.put("cidesc", cidescStr);
		hm.put("cino", cinoNum);
		result = s.updateUserInfo(hm);
		if (result == 1) {
			System.out.println("업데이트 잘됫음!!");
		}*/
		
		

/*		System.out.println("새로 추가할 반이름을 넣어주세요!");
		String cinameStr = sc.nextLine();
		System.out.println("새로 추가할 반인 " + cinameStr + "의 설명을 넣어주세요!");
		cidescStr = sc.nextLine();
		LinkedHashMap<String, Object> hm1 = new LinkedHashMap<String, Object>();
		hm1.put("ciname", cinameStr);
		hm1.put("cidesc", cidescStr);
		result = s.insertClassInfo(hm1);
		if (result == 1) {
			System.out.println("삽입 성공");
		}*/
		
	/*	System.out.println("새로 추가할 학생이름을 넣어주세요!");
		String uinameStr = sc.nextLine();
		System.out.println("새로 추가할 학생나이를 넣어주세요!");
		int uiAge = Integer.parseInt(sc.nextLine());
		System.out.println("새로 추가할 학생아이디를 넣어주세요!");
		String uiIdStr = sc.nextLine();
		System.out.println("새로 추가할 학생비밀번호를 넣어주세요!");
		String uiPwdStr = sc.nextLine();
		System.out.println("새로 추가할 학생수업번호를 넣어주세요!");
		int uiCino = Integer.parseInt(sc.nextLine());
		System.out.println("새로 추가할 학생주소를 넣어주세요!");
		String uiAddress = sc.nextLine();
		LinkedHashMap<String, Object> hm1 = new LinkedHashMap<String, Object>();
		hm1.put("uiname",uinameStr);
		hm1.put("uiage", uiAge);
		hm1.put("uiid",uiIdStr);
		hm1.put("uipwd",uiPwdStr);
		hm1.put("cino",uiCino);
		hm1.put("address",uiAddress);
		result = s.insertUserInfo(hm1);
		if (result == 1) {
			System.out.println("삽입 성공");
		}*/
		
		
		
/*
		System.out.println("몇번 반을 삭제하시겠습니까? ");
		cinoNum = sc.nextInt();
		LinkedHashMap<String, Object> hm2 = new LinkedHashMap<String, Object>();
		hm2.put("cino", cinoNum);
		int deleteResult = s.deleteClassInfo(hm2);
		if (deleteResult == 1) {
			System.out.println("삭제완료");
		}*/
		
		
/*		System.out.println("몇번의 학생을 삭제하시겠습니까? ");
		cinoNum = sc.nextInt();
		LinkedHashMap<String, Object> hm2 = new LinkedHashMap<String, Object>();
		hm2.put("cino", cinoNum);
		int deleteResult = s.deleteUserInfo(hm2);
		if (deleteResult == 1) {
			System.out.println("삭제완료");
		}
*/
		
		
		
/*		LinkedHashMap<String, Object> hm3 = new LinkedHashMap<String, Object>();
		System.out.println("몇번 반을 조회하시겠습니까? , 전체를 조회 하시려면 0번을 입력해주세요");
		cinoNum = sc.nextInt();
		hm3.put("cino", cinoNum);

		ArrayList<HashMap<String, Object>> al1 = s.selectClassInfo(hm3, cinoNum);

		for (HashMap<String, Object> hmm : al1) {
			System.out.println(hmm);

		}*/
		
		
		
		LinkedHashMap<String, Object> hm3 = new LinkedHashMap<String, Object>();
		
		ArrayList<HashMap<String, Object>> al1 = s.selectUserInfo(hm3);
		if(al1.size()==0) {
			System.out.println("해당 검색결과가 없습니다.");
		}
		
		for (HashMap<String, Object> hmm : al1) {
			System.out.println(hmm);
		}

	}
}
