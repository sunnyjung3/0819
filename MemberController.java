package board;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	
//	Member loginedMember = null; // 로그인한 유저 저장 변수

	Scanner sc = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();

	// 생성자 = 메서드 (특수한 메서드)
	
	MemberController() { // 생성자 ; 객체가 필요하 값을 초기 세팅
		
		Member member1 = new Member("a","aa","aaa" );
		Member member2 = new Member("b","bb","bbb" );
		Member member3 = new Member("c","cc","ccc" );
		members.add(member1);
		members.add(member2);
		members.add(member3);
	}
	
	void doCommand(String cmd) {
		
		
		if(cmd.equals("signup")) {
			
			Member member = new Member();

			System.out.println("아이디를 입력해주세요");
			member.setLoginId(sc.nextLine());

			System.out.println("비밀번호를 입력해주세요");
			member.setLoginPw(sc.nextLine());
			
			System.out.println("이름을 입력해주세요");
			member.setUserName(sc.nextLine());

			members.add(member);
						
		} else if(cmd.equals("login")) {
			System.out.println("아이디를 입력해주세요.");
			String loginId = sc.nextLine();
			System.out.println("비밀번호를 입력해주세요.");
			String loginPw = sc.nextLine();

	        int targetIndex = getMemberIndexById(loginId);

			if (targetIndex == -1) {
				System.out.println("없는 회원입니다.");
			} else {				
				Member member = members.get(targetIndex);
				if(loginPw.equals(member.getLoginPw())) {
					loginedMember = member;
					System.out.println(member.getUserName() + "님반갑습니다.");
					
					App.loginedMember = member;
					//loginedMember = member;
				}else {
					System.out.println("로그인실패");	
				}		
			}				
		} else if(cmd.equals("logout")) {
			
			if(loginedMember == null) {
				System.out.println("로그인이 필요한 기능입니다.");
			}
			else if(loginedMember != null) {
				System.out.println("로그아웃 되셨습니다.");
				loginedMember = null;
			}				
				
		}
	}
	
	int getMemberIndexById(String loginId) {
		int targetIndex = -1; // 찾는게 없을 때 -1

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getLoginId().equals(loginId)) {
				targetIndex = i;
			}
		}	

		return targetIndex;
	}
	
}	
