package org.example;

import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.Set;

import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallet.Identity;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.hyperledger.fabric_ca.sdk.RegistrationRequest;

public class RegisterUser {

    public static final String IP = "3.231.207.0";
    private static final String URL = String.format("https://%s:7054", IP);
    public static final String CERTIFICADO = "ca.org1.example.com-cert.pem";
    private static final String USER = "ufg";

    static {
        System.setProperty("org.hyperledger.fabric.sdk.service_discovery" +
				".as_localhost", "true");
    }

    public static void main(String[] args) throws Exception {
        HFCAClient caClient = HFUtils.getHfcaClient(CERTIFICADO, URL);

        // Create a wallet for managing identities
        Wallet wallet = Wallet.createFileSystemWallet(Paths.get("wallet"));

        // Check to see if we've already enrolled the user.
        boolean userExists = wallet.exists(USER);
        if (userExists) {
            System.out.printf("An identity for the user \"%s\" already " +
                    "exists in the wallet", USER);
            return;
        }

        userExists = wallet.exists("admin");
        if (!userExists) {
            System.out.println("\"admin\" needs to be enrolled and added to " +
					"the wallet first");
            return;
        }

        Identity adminIdentity = wallet.get("admin");
        User admin = new User() {

            @Override
            public String getName() {
                return "admin";
            }

            @Override
            public Set<String> getRoles() {
                return null;
            }

            @Override
            public String getAccount() {
                return null;
            }

            @Override
            public String getAffiliation() {
                return "org1.department1";
            }

            @Override
            public Enrollment getEnrollment() {
                return new Enrollment() {

                    @Override
                    public PrivateKey getKey() {
                        return adminIdentity.getPrivateKey();
                    }

                    @Override
                    public String getCert() {
                        return adminIdentity.getCertificate();
                    }
                };
            }

            @Override
            public String getMspId() {
                return "Org1MSP";
            }

        };

        // Register the user, enroll the user, and import the new identity
		// into the wallet.
        RegistrationRequest registration = new RegistrationRequest(USER);
        registration.setAffiliation("org1.department1");
        registration.setEnrollmentID(USER);
        String enrollmentSecret = caClient.register(registration, admin);
        Enrollment enrollment = caClient.enroll(USER, enrollmentSecret);
        Identity user = Identity.createIdentity("Org1MSP", enrollment.getCert(), enrollment.getKey());
        wallet.put(USER, user);
        System.out.printf("Successfully enrolled user \"%s\" and " +
                "imported it into the wallet", USER);
    }

}
