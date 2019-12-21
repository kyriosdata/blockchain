/*
SPDX-License-Identifier: Apache-2.0
*/

package org.example;

import java.nio.file.Paths;

import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallet.Identity;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric_ca.sdk.EnrollmentRequest;
import org.hyperledger.fabric_ca.sdk.HFCAClient;

// TODO certificado copiado do ambiente onde foi gerado
// TODO ips foram atualizados com a versão correta (ambiente de teste)
public class EnrollAdmin {

	public static final String IP = "3.231.207.0";
	public static final String ADMIN = "admin";

	private static final String URL = String.format("https://%s:7054", IP);
	public static final String CERTIFICADO = "ca.org1.example.com-cert.pem";
	private static final String USER = "vitoria";

	static {
		System.setProperty("org.hyperledger.fabric.sdk.service_discovery.as_localhost", "true");
	}

	public static void main(String[] args) throws Exception {

		HFCAClient caClient =
				HFUtils.getHfcaClient(CERTIFICADO, URL);

		// Create a wallet for managing identities
		Wallet wallet = Wallet.createFileSystemWallet(Paths.get("wallet"));

		// Check to see if we've already enrolled the admin user.
		boolean adminExists = wallet.exists(ADMIN);
        if (adminExists) {
            System.out.println("An identity for the admin user \"admin\" already exists in the wallet");
            return;
        }

        // Enroll the admin user, and import the new identity into the wallet.
		final EnrollmentRequest request = getEnrollmentRequest();
		Enrollment enrollment = caClient.enroll(ADMIN, "adminpw", request);
        Identity user = Identity.createIdentity("Org1MSP",
				enrollment.getCert(), enrollment.getKey());
        wallet.put(ADMIN, user);
		System.out.println("Successfully enrolled user \"admin\" and imported it into the wallet");
	}

	public static EnrollmentRequest getEnrollmentRequest() {
		final EnrollmentRequest enrollmentRequestTLS = new EnrollmentRequest();
		enrollmentRequestTLS.addHost(IP);
		enrollmentRequestTLS.setProfile("tls");
		return enrollmentRequestTLS;
	}
}
