package managementsystem;

import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "{Policy#: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate + "}";
    }
}

public class InsurancePolicyManagement {
    private final Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private final Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private final TreeMap<LocalDate, List<InsurancePolicy>> policyByExpiry = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);

        policyByExpiry.putIfAbsent(policy.expiryDate, new ArrayList<>());
        policyByExpiry.get(policy.expiryDate).add(policy);
    }

    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringInNext30Days() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        return policyByExpiry.subMap(today, true, next30Days, true)
                .values()
                .stream()
                .flatMap(List::stream)
                .toList();
    }

    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<InsurancePolicy>>> iterator = policyByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<InsurancePolicy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (InsurancePolicy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicyMap.remove(policy.policyNumber);
                }
                iterator.remove();
            } else {
                break;
            }
        }
    }

    public void printAllPolicies() {
        System.out.println("All Policies: " + orderedPolicyMap.values());
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        system.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new InsurancePolicy("P1003", "Alice", LocalDate.now().minusDays(5))); // Expired

        System.out.println("Policy P1001: " + system.getPolicy("P1001"));

        System.out.println("Policies expiring in next 30 days: " + system.getPoliciesExpiringInNext30Days());

        System.out.println("Policies held by Alice: " + system.getPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("After removing expired policies:");
        system.printAllPolicies();
    }
}

