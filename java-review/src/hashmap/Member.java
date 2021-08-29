package hashmap;

public class Member {
	
	private int memberId;
	private String memberName;
	
	public Member() {}
	
	public Member(int id, String name) {
		this.memberId = id;
		this.memberName = name;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		
		return memberId + " - " + memberName;
	}
	
}
