/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.businesslogic;

import java.util.ArrayList;
import library.domain.Member;

/**
 *
 * @author ppthgast
 */
public class MemberAdminManager {

    private ArrayList<Member> members;

    public MemberAdminManager() {
        members = new ArrayList();

        fillTestData();
    }

    private void fillTestData() {
        members.add(new Member(1000, "Pascal", "van Gastel"));
        members.add(new Member(1001, "Erco", "Argante"));
        members.add(new Member(1002, "Marice", "Bastiaense"));
        members.add(new Member(1003, "Tommy", "Heunks")); // Praktijk 7 ********
    }

    public Member findMember(int membershipNumber) {
        Member member = null;

        int index = 0;

        while (member == null && index < members.size()) {
            Member currentMember = members.get(index);

            if (currentMember.getMembershipNumber() == membershipNumber) {
                // Found the member!
                member = currentMember;
            } else {
                // Not the correct member, try the next one in the list.
                index++;
            }
        }

        return member;
    }

    //  Praktijk 6 *************************************************************
    public Member findMemberName(String lastname) {
        Member member = null;

        int index = 0;

        while (member == null && index < members.size()) {
            Member currentMember = members.get(index);

            if (currentMember.getLastname().contains(lastname)) {
                // Found the member!
                member = currentMember;
            } else {
                // Not the correct member, try the next one in the list.
                index++;
            }
        }

        return member;
    }
    //  ************************************************************************

    public boolean removeMember(Member member) {
        boolean result = false;

        if (member.isRemovable()) {
            result = member.remove();
        } else {
            result = false;
        }

        return result;
    }
}
