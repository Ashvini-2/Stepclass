package labproblems_week2;
import java.util.*;

public class substring {
    static class EmailInfo {
        String email, username, domain, domainName, extension;
        boolean isValid;

        EmailInfo(String email, String username, String domain, String domainName, String extension, boolean isValid) {
            this.email = email;
            this.username = username;
            this.domain = domain;
            this.domainName = domainName;
            this.extension = extension;
            this.isValid = isValid;
        }
    }

    public static boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        if (at <= 0 || at != lastAt) return false;
        int dot = email.indexOf('.', at);
        if (dot < 0 || dot == at + 1 || dot == email.length() - 1) return false;
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        if (username.isEmpty() || domain.isEmpty()) return false;
        return true;
    }

    public static EmailInfo extractEmailInfo(String email) {
        boolean valid = isValidEmail(email);
        String username = "", domain = "", domainName = "", extension = "";
        if (valid) {
            int at = email.indexOf('@');
            username = email.substring(0, at);
            domain = email.substring(at + 1);
            int dot = domain.lastIndexOf('.');
            if (dot > 0 && dot < domain.length() - 1) {
                domainName = domain.substring(0, dot);
                extension = domain.substring(dot + 1);
            }
        }
        return new EmailInfo(email, username, domain, domainName, extension, valid);
    }

    public static void analyzeEmails(List<EmailInfo> infos) {
        int validCount = 0, invalidCount = 0, totalUsernameLen = 0;
        Map<String, Integer> domainFreq = new HashMap<>();
        for (EmailInfo info : infos) {
            if (info.isValid) {
                validCount++;
                totalUsernameLen += info.username.length();
                domainFreq.put(info.domain, domainFreq.getOrDefault(info.domain, 0) + 1);
            } else {
                invalidCount++;
            }
        }
        String mostCommonDomain = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : domainFreq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostCommonDomain = entry.getKey();
            }
        }
        double avgUsernameLen = validCount > 0 ? (double) totalUsernameLen / validCount : 0;
        System.out.println("\nAnalysis:");
        System.out.println("Total Valid Emails: " + validCount);
        System.out.println("Total Invalid Emails: " + invalidCount);
        System.out.println("Most Common Domain: " + (mostCommonDomain.isEmpty() ? "N/A" : mostCommonDomain));
        System.out.printf("Average Username Length: %.2f\n", avgUsernameLen);
    }

    public static void displayTable(List<EmailInfo> infos) {
        System.out.printf("%-30s %-15s %-25s %-15s %-10s %-10s\n", "Email", "Username", "Domain", "Domain Name", "Extension", "Valid?");
        for (EmailInfo info : infos) {
            System.out.printf("%-30s %-15s %-25s %-15s %-10s %-10s\n",
                    info.email, info.username, info.domain, info.domainName, info.extension, info.isValid ? "Valid" : "Invalid");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<EmailInfo> infos = new ArrayList<>();
        System.out.print("Enter number of emails: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter email #" + (i + 1) + ": ");
            String email = sc.nextLine().trim();
            infos.add(extractEmailInfo(email));
        }
        System.out.println();
        displayTable(infos);
        analyzeEmails(infos);
    }
}
